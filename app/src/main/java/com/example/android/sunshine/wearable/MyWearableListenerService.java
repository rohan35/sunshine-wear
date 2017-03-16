package com.example.android.sunshine.wearable;

import com.example.android.sunshine.sync.SunshineSyncTask;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

/**
 * Created by SONY on 17-03-2017.
 */

public class MyWearableListenerService extends WearableListenerService
        implements DataApi.DataListener {
    private static final String TAG = "Wearable_Listener_Service";

    private static final String KEY_PATH = "/wearable";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        String path = messageEvent.getPath();

        // Check to see if the message is to start an activity
        if (path.equals(KEY_PATH)) {
            // start the service sending the updated weather data to the wearable
            SunshineSyncTask.syncWeather(getApplicationContext());
        }
    }
}