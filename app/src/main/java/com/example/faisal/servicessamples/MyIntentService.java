package com.example.faisal.servicessamples;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by faisal on 12/14/2015.
 */
public class MyIntentService extends IntentService {

    private final String TAG=MyIntentService.class.getSimpleName();
    public MyIntentService() {
        super(MyIntentService.class.getName());

    }

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
