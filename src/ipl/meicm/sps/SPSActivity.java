package ipl.meicm.sps;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SPSActivity extends Activity {
	private WifiManager wifi;
	private int i = 0, count = 0;
	private static final int NUMBER_SCAN = 5;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);

	}

	public void clickHandler(View v) {

		if (v.getId() == R.id.button1) {
			for (i = 1; i < NUMBER_SCAN + 1; i++) 
				rescan();
		}
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

			for (ScanResult scanR : wifi.getScanResults()) {
				if (scanR.SSID.equals("DLink-B6EE0F")) {
					count += scanR.level;
					if ((i >= NUMBER_SCAN) && (i % NUMBER_SCAN == 0)) {
						((TextView) findViewById(R.id.textView1))
								.setText(((TextView) findViewById(R.id.textView1))
										.getText() + "\n"
										+ count / NUMBER_SCAN + "\r\n");
						count = 0;
					}
				}

			}

		} else {
			Toast.makeText(getApplicationContext(), "Please turn on the WiFi",
					Toast.LENGTH_SHORT).cancel();
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
}