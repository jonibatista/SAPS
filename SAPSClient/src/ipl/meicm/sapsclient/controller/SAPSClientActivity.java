package ipl.meicm.sapsclient.controller;

import ipl.meicm.sapsclient.R;
import ipl.meicm.sapsclient.controller.ScanService.LocalBinder;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

public class SAPSClientActivity extends Activity {
	ScanService mService;
	boolean mBound = false;
	int i = 0;

	Runnable result = new Runnable() {
		Timer time = new Timer();

		@Override
		public void run() {
			time.schedule(new TimerTask() {

				@Override
				public void run() {
					if (mBound)
						if (mService.isMoving()) {
							Toast.makeText(getApplicationContext(),
									"Device's moving.", Toast.LENGTH_SHORT)
									.show();
						} else {
							Toast.makeText(getApplicationContext(),
									"Device's not moving.", Toast.LENGTH_SHORT)
									.show();
						}
				}

			}, 1000, 5000);
		}
	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	protected void onStart() {
		super.onStart();
		// Bind to LocalService
		Intent intent = new Intent(this, ScanService.class);
		bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
	}

	@Override
	protected void onStop() {
		super.onStop();
		// Unbind from the service
		if (mBound) {
			unbindService(mConnection);
			mBound = false;
		}
	}

	public void clickHandler(View v) {

		if (mService.isMoving()) {
			Toast.makeText(getApplicationContext(), "Device's moving.",
					Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(getApplicationContext(), "Device's not moving.",
					Toast.LENGTH_SHORT).show();
		}
	}

	/** Defines callbacks for service binding, passed to bindService() */
	private ServiceConnection mConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName className, IBinder service) {
			// We've bound to LocalService, cast the IBinder and get
			// LocalService instance
			LocalBinder binder = (LocalBinder) service;
			mService = binder.getService();
			mBound = true;
		}

		@Override
		public void onServiceDisconnected(ComponentName arg0) {
			mBound = false;
		}
	};
}