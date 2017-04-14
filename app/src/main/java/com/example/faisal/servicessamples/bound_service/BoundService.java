package com.example.faisal.servicessamples.bound_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Chronometer;

/**
 * BoundService class extends service to show how to use Bound service in android
 *
 * This service runs a timer in background that can be accessed by caller  activity any time.
 *
 * For more details follow link :-
 * https://developer.android.com/guide/components/services.html#CreatingBoundService
 * https://developer.android.com/guide/components/bound-services.html
 *
 * @author Faisal Khan
 *
 */
public class BoundService extends Service{

    private static String TAG = "BoundService";
    private IBinder mBinder = new MyCustomBinder();
    private Chronometer mChronometer;


    /**
     * The system invokes this method to perform one-time setup procedures when the service is initially created
     * (before it calls either onStartCommand() or onBind()).If the service is already running, this method is not called.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreate");

        mChronometer = new Chronometer(this);
        mChronometer.setBase(SystemClock.elapsedRealtime());
        mChronometer.start();
    }

    /**
     * The system invokes this method by calling bindService() when another component wants to bind with the
     * service (such as to perform RPC). In your implementation of this method, you must provide an interface that
     * clients use to communicate with the service by returning an IBinder. You must always implement this method;
     * however, if you don't want to allow binding, you should return null.
     * @param intent intent
     * @return binder
     */
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG,"onBind");
        return mBinder;
    }

    /**
     * The Intent that was used to bind to this service, as given to Context.bindService.
     * Note that any extras that were included with the Intent at that point will not be seen here.
     * @param intent intent
     * @return Return true if you would like to have the service's onRebind(Intent) method later called when new clients bind to it.
     */
    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG,"onUnbind");
        return true;
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
        mChronometer.stop();
    }

    /**
     * Method to get timer time
     * @return time
     */
    public String getTimestamp() {
        Log.e(TAG,"onDestgetTimestamproy");
        long elapsedMillis = SystemClock.elapsedRealtime() - mChronometer.getBase();
        int hours = (int) (elapsedMillis / 3600000);
        int minutes = (int) (elapsedMillis - hours * 3600000) / 60000;
        int seconds = (int) (elapsedMillis - hours * 3600000 - minutes * 60000) / 1000;
        int millis = (int) (elapsedMillis - hours * 3600000 - minutes * 60000 - seconds * 1000);
        return hours + ":" + minutes + ":" + seconds + ":" + millis;
    }


    /**
     * Binder class for bound service
     */
    class MyCustomBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }

    }
}
