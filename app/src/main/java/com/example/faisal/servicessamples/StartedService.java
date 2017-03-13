package com.example.faisal.servicessamples;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * StartedService class that extends service
 *
 * This service is stick type when event you finish this service it will restart it self again.
 *
 * For more detail about contents link START_STICKY follow link:-
 * https://developer.android.com/reference/android/app/Service.html
 *
 * @author Faisal Khan
 */
public class StartedService extends Service {

    private final String TAG=StartedService.class.getSimpleName();

    /**
     * The system invokes this method to perform one-time setup procedures when the service is initially created
     * (before it calls either onStartCommand() or onBind()).If the service is already running, this method is not called.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreate");

    }

    @Override
    public IBinder onBind(Intent intent) {
        //no use here because this is a started service
        Log.e(TAG,"onCreate");
        return null;
    }

    /**
     * The system invokes this method by calling startService() when another component (such as an activity) requests
     * that the service be started. When this method executes, the service is started and can run in the background
     * indefinitely. If you implement this, it is your responsibility to stop the service when its work is complete
     * by calling stopSelf() or stopService(). If you only want to provide binding, you don't need to implement this method
     *
     * @param intent Intent: The Intent supplied to startService(Intent), as given.
     *               This may be null if the service is being restarted after its process has gone away,
     *               and it had previously returned anything except START_STICKY_COMPATIBILITY.
     * @param flags  Additional data about this start request. Currently either 0, START_FLAG_REDELIVERY, or START_FLAG_RETRY.
     * @param startId A unique integer representing this specific request to start. Use with stopSelfResult(int).
     *
     * @return The return value indicates what semantics the system should use for the service's current started state.
     * It may be one of the constants associated with the START_CONTINUATION_MASK bits.
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG,"onStartCommand");
        Toast.makeText(StartedService.this, "Service Started", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }


    /**
     * The system invokes this method when the service is no longer used and is being destroyed.
     * Your service should implement this to clean up any resources such as threads, registered listeners, or receivers.
     * This is the last call that the service receives.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
        Toast.makeText(StartedService.this, "Service stop", Toast.LENGTH_SHORT).show();
    }
}
