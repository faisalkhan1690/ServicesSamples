package com.example.faisal.servicessamples;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BoundServicesActivity extends AppCompatActivity {

    private Button btnStartServcie;
    private Button btnStopServcie;
    private Button btnStatusServcie;
    private TextView tvStatus;

    private boolean mServiceBound=false;
    private BoundService mBoundService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_services);

        btnStartServcie=(Button)findViewById(R.id.btn_start_service);
        btnStopServcie=(Button)findViewById(R.id.btn_stop_service);
        btnStatusServcie=(Button)findViewById(R.id.btn_status_service);
        tvStatus=(TextView)findViewById(R.id.tv_status);

        btnStartServcie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoundServicesActivity.this, BoundService.class);
                startService(intent);
                if(!mServiceBound){
                    bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
                }else{
                    Toast.makeText(BoundServicesActivity.this, "Service is already running", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnStopServcie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mServiceBound){
                    unbindService(mServiceConnection);
                }else{
                    Toast.makeText(BoundServicesActivity.this, "Please start Service first", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnStatusServcie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mServiceBound){
                    tvStatus.setText(mBoundService.getTimestamp());
                }else{
                    tvStatus.setText("Service is not running");
                }
            }
        });
    }



    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyCustomBinder myBinder = (BoundService.MyCustomBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }
    };


}
