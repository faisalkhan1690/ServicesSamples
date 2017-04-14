package com.example.faisal.servicessamples.foreground_service;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.faisal.servicessamples.R;

/**
 * ForegroundServiceActivity activity to demonstrate how foreground service
 *
 * Here we have two methods to start and stop service. Please check startService() and stopService();
 * and also check ForegroundService class
 *
 * for more details :- https://developer.android.com/guide/components/services.html#Foreground
 *
 * @author Faisal Khan
 *
 */
public class ForegroundServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forground_service);
    }


    /**
     * Method to start foreground service
     * @param view view
     */
    public void startService (View view){
        Intent startIntent = new Intent(ForegroundServiceActivity.this, ForegroundService.class);
        startIntent.setAction(Constants.ACTION.START_FOREGROUND_ACTION);
        startService(startIntent);
    }

    /**
     * Method to stop foreground service
     * @param view view
     */
    public void stopService(View view){
        Intent stopIntent = new Intent(ForegroundServiceActivity.this, ForegroundService.class);
        stopIntent.setAction(Constants.ACTION.STOP_FOREGROUND_ACTION);
        startService(stopIntent);
    }
}
