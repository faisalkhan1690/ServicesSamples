package com.example.faisal.servicessamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * StartedServiceActivity is here to show how to use Started Service in android project.<br>
 *
 * A service is started when an application component (such as an activity) calls startService().
 * After it's started, a service can run in the background indefinitely, even if the component that started it is destroyed.
 * Usually, a started service performs a single operation and does not return a result to the caller.
 * For example, it can download or upload a file over the network.
 * When the operation is complete, the service should stop itself.
 *
 * For more details follow link :-
 * https://developer.android.com/guide/components/services.html
 * https://developer.android.com/guide/components/services.html#CreatingAService
 *
 * @author Faisal Khan
 */
public class StartedServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_service);
    }

    /**
     * Method to start start Started Service
     * @param view  context of invoking view
     */
    public void startStartedService(View view){

        //context method to start Started Service
        startService(new Intent(getApplicationContext(),StartedService.class));
    }
}
