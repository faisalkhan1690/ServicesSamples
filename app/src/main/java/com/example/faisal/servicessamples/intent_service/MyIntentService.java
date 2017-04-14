package com.example.faisal.servicessamples.intent_service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


/**
 * MyIntentService class extends IntentService<p>
 *
 * Main task of this service is to hold request for 10 seconds and the process.
 *
 * for more details follow link :-
 * https://developer.android.com/reference/android/app/IntentService.html
 * @author Faisal Khan
 */
public class MyIntentService extends IntentService {

    private final String TAG=MyIntentService.class.getSimpleName();
    public MyIntentService() {
        super(MyIntentService.class.getName());

    }

    /**
     * This method is invoked on the worker thread with a request to process.
     * Only one Intent is processed at a time, but the processing happens on a worker thread that runs independently
     * from other application logic. So, if this code takes a long time, it will hold up other requests to the same
     * IntentService, but it will not hold up anything else. When all requests have been handled, the IntentService
     * stops itself, so you should not call stopSelf().
     *
     * @param intent The value passed to startService(Intent). This may be null if the service is
     *               being restarted after its process has gone away; see onStartCommand(Intent, int, int) for details.
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG,"Start onHandle = "+ intent.getStringExtra(IntentServiceActivity.INTENT_TAG));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d(TAG,"Stop onHandle = "+ intent.getStringExtra(IntentServiceActivity.INTENT_TAG));

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(MyIntentService.this, "stop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "stop");

    }
}
