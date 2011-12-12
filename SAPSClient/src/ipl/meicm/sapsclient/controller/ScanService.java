package ipl.meicm.sapsclient.controller;

import ipl.meicm.sapsclient.model.CalculatePosition;
import ipl.meicm.sapsclient.model.RestComunication;
import ipl.meicm.sapsclient.model.entity.AccessPoint;
import ipl.meicm.sapsclient.model.entity.Device;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ScanService extends Service {
	private static final long UPDATE_TIMER = 4000;
	private static final int NUMBER_SCAN = 5;
	private static final String SSID = "saps";// "Thomson5682BF"; //
	// "DLink-B6EE0F";
	private static final String WS_URL = "http://192.168.1.107:8080/SAPSWebService/resources/generic";

	private Timer time;
	private WifiManager wifi;
	private int i = 0;
	private boolean isFirstScan = true, isMoving;
	private Device device;
	private List<AccessPoint> currentScanRound;
	private List<AccessPoint> previousScanRound = null;
	private CalculatePosition calculatePos;
	private RestComunication com;

	// Binder given to clients
	private final IBinder mBinder = new LocalBinder();

	@Override
	public void onCreate() {

		// set the device identification
		device = new Device(Build.BRAND, Build.MODEL, Build.MANUFACTURER);

		currentScanRound = new ArrayList<AccessPoint>();

		calculatePos = new CalculatePosition();

		// get the wifi manager
		wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);

		time = new Timer();

		time.schedule(new TimerTask() {

			@Override
			public void run() {
				updateTimeTask();
			}

		}, 0, UPDATE_TIMER);
	}

	/**
	 * Class used for the client Binder. Because we know this service always
	 * runs in the same process as its clients, we don't need to deal with IPC.
	 */
	public class LocalBinder extends Binder {
		ScanService getService() {
			// Return this instance of LocalService so clients can call public
			// methods
			return ScanService.this;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}

	@Override
	public void onDestroy() {
		time.cancel();
	}

	/**
	 * <p>
	 * Search for APs and save the information
	 * </p>
	 */
	public void rescan() {

		if (isConnected()) {

			// refresh the scanResults
			wifi.startScan();

			// get results
			for (ScanResult scanR : wifi.getScanResults()) {

				if (isFirstScan && scanR.SSID.equals(SSID)) {

					// it's the first time of this round
					currentScanRound.add(new AccessPoint(scanR.BSSID,
							scanR.level, scanR.SSID));

				} else {

					// traced spot access points
					for (AccessPoint ap : currentScanRound) {

						// match the scan result to the respective access point
						// in
						// this round list
						if (ap.getBssid().equals(scanR.BSSID)
								&& scanR.SSID.equals(SSID)) {

							// add the scan level
							ap.setRssi(ap.getRssi() + scanR.level);

							if (i % NUMBER_SCAN == 0) {

								// is the last scan of this round
								// it's time to calculate the RSSI AVG of this
								// scans round
								ap.setRssi(ap.getRssi() / NUMBER_SCAN);
							}

							break;
						}
					}
				}
			}

		} else {
			Toast.makeText(getApplicationContext(), "Please turn on the WiFi",
					Toast.LENGTH_SHORT).cancel();
		}
	}

	private void updateTimeTask() {
		for (i = 1; i <= NUMBER_SCAN; i++) {
			rescan();

			if (i == NUMBER_SCAN) {
				// the next updateTimeTask() will be the first scan of the new
				// round
				// it's time to calculate the position of this round

				device.setCurrentScan(new ArrayList<AccessPoint>(
						currentScanRound));

				if (previousScanRound == null) {
					// is the first time. We need the second scan to know if the
					// device is moving or not...
					isMoving = false;
					previousScanRound = new ArrayList<AccessPoint>(
							currentScanRound);
				} else {
					isMoving = calculatePos.isMoving(currentScanRound,
							previousScanRound);
				}

				if (isMoving) {
					try {

						Type collectionType = new TypeToken<ArrayList<AccessPoint>>() {
						}.getType();
						String gsonAps = new Gson().toJson(currentScanRound,
								collectionType);

						Log.i("GSON STRING", currentScanRound.size() + "\n"
								+ gsonAps);

						com = new RestComunication(WS_URL);

						String result = com.webInvoke(gsonAps);

						Log.i("RESULT", result);
					} catch (Exception e) {
						Log.e(ScanService.class.getName(), e.toString());
					}
				}

//				Log.e("################", isMoving + "");
//
//				for (AccessPoint last : currentScanRound) {
//					for (AccessPoint prev : previousScanRound) {
//						if (last.equals(prev)) {
//							Log.e("PREVIOUS AP", "" + prev.getRssi());
//							Log.e("LAST AP", "" + last.getRssi());
//						}
//					}
//				}

				previousScanRound = new ArrayList<AccessPoint>(currentScanRound);

				currentScanRound.clear();

				isFirstScan = true;
			} else {
				isFirstScan = false;
			}
		}
	}

	/**
	 * <p>
	 * Check if the Wi-Fi device is enabled
	 * </p>
	 * 
	 * @return true if the wi-fi device is enabled, false if not
	 */
	private boolean isConnected() {

		try {
			ConnectivityManager connectivityManager = (ConnectivityManager) this
					.getApplicationContext().getSystemService(
							Context.CONNECTIVITY_SERVICE);

			return connectivityManager.getActiveNetworkInfo()
					.isConnectedOrConnecting();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * <p>
	 * Allow us to know if the device is moving.
	 * </p>
	 * 
	 * @return true if the device's moving, false if not
	 */
	public boolean isMoving() {
		return isMoving;
	}

}
