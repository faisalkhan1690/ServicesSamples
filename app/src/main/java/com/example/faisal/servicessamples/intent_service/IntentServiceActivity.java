package com.example.faisal.servicessamples.intent_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.faisal.servicessamples.R;

/**
 * IntentServiceActivity class to show how to user intent service in android.<p>
 *
 * IntentService is a base class for Services that handle asynchronous requests (expressed as Intents) on demand.
 * Clients send requests through startService(Intent) calls; the service is started as needed, handles each Intent in
 * turn using a worker thread, and stops itself when it runs out of work.
 * This "work queue processor" pattern is commonly used to offload tasks from an application's main thread.
 * The IntentService class exists to simplify this pattern and take care of the mechanics. To use it, extend IntentService
 * and implement onHandleIntent(Intent). IntentService will receive the Intents, launch a worker thread, and stop the service
 * as appropriate.All requests are handled on a single worker thread -- they may take as long as necessary
 * (and will not block the application's main loop), but only one request will be processed at a time.

 * for more details follow link :-
 * https://developer.android.com/reference/android/app/IntentService.html
 *
 * @author Faisal Khan
 */
public class IntentServiceActivity extends AppCompatActivity {

    private int intentNumber=0;

    public static final String INTENT_TAG="DATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);
    }

    /**
     * Method to start intent service
     * @param view current invoking view
     */
    public void startIntentService(View view){
        intentNumber++;
        Intent intent=new Intent(Intent.ACTION_SYNC, null,this, MyIntentService.class);
        intent.putExtra(INTENT_TAG,intentNumber+"");
        startService(intent);
    }
}
