package com.example.faisal.servicessamples;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


/**
 * BoundServicesActivity is here to show how to use Bound Services in android project.<br>
 *
 * A service is bound when an application component binds to it by calling bindService().
 * A bound service offers a client-server interface that allows components to interact with the service,
 * send requests, receive results, and even do so across processes with inter process communication (IPC).
 * A bound service runs only as long as another application component is bound to it.
 * Multiple components can bind to the service at once, but when all of them unbind, the service is destroyed.
 *
 *
 * For more details follow link :-
 * https://developer.android.com/guide/components/services.html
 * https://developer.android.com/guide/components/services.html#CreatingBoundService
 *
 * @author Faisal Khan
 *
 */
public class BoundServicesActivity extends AppCompatActivity {


    private boolean mIsServiceRunning =false;
    private BoundService mBoundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_services);

    }

    /**
     * Method to start bound service
     * @param view current invoking view
     */
    public void startService(View view){
        Intent intent = new Intent(BoundServicesActivity.this, BoundService.class);
        startService(intent);
        if(!mIsServiceRunning){
            bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
        }else{
            Toast.makeText(BoundServicesActivity.this, "Service is already running", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Method to stop bound service
     * @param view current invoking view
     */
    public void stopService(View view){
        if(mIsServiceRunning){
            unbindService(mServiceConnection);
        }else{
            Toast.makeText(BoundServicesActivity.this, "Please start Service first", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Method to get time stamp from service
     * @param view current invoking view
     */
    public void getStatusOfService(View view){
        TextView tvStatus = (TextView) findViewById(R.id.tv_status);
        if(mIsServiceRunning){
            tvStatus.setText(mBoundService.getTimestamp());
        }else{
            tvStatus.setText("Service is not running");
        }
    }


    /**
     * Service connection to communicate with bound service
     */
    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIsServiceRunning = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyCustomBinder myBinder = (BoundService.MyCustomBinder) service;
            mBoundService = myBinder.getService();
            mIsServiceRunning = true;
        }
    };


}
