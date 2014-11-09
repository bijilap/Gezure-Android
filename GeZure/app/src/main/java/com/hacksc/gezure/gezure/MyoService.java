package com.hacksc.gezure.gezure;

import com.thalmic.myo.AbstractDeviceListener;
import com.thalmic.myo.DeviceListener;
import com.thalmic.myo.Hub;
import com.thalmic.myo.Myo;
import com.thalmic.myo.Pose;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyoService extends Service {

	private DeviceListener MyoListener = new AbstractDeviceListener() {
		@Override
		public void onConnect(Myo myo, long timestamp) {
			Log.d("SERVICE", "MYO CONNECTED! YAYYYYY!!!");
		}

		@Override
		public void onDisconnect(Myo myo, long timestamp) {
			Log.d("SERVICE", "MYO DISCONNECTED! BOOO!!!");
		}

		// onPose() is called whenever the Myo detects that the person wearing
		// it has changed their pose, for example,
		// making a fist, or not making a fist anymore.
		@Override
		public void onPose(Myo myo, long timestamp, Pose pose) {
			// Show the name of the pose in a toast.
			Log.d("SERVICE", "POSE: " + pose.toString());
            switch(pose){
                case WAVE_IN:
                    break;
                case FINGERS_SPREAD:
                    break;
                case FIST:
                    break;
                default:
                    break;
            }
		}
	};

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("SERVICE", "service started");
		Hub hub = Hub.getInstance();

		if (!hub.init(this, getPackageName())) {
			System.err.println("Could not create a hub");
			stopSelf();
		}

		hub.addListener(MyoListener);

		hub.pairWithAdjacentMyo();
		Log.d("SERVICE", "myo should be connected now");
	}

	@Override
	public void onDestroy() {
		Hub.getInstance().removeListener(MyoListener);

		Hub.getInstance().shutdown();

	}
}
