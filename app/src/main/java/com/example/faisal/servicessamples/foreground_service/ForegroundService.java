package com.example.faisal.servicessamples.foreground_service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.faisal.servicessamples.R;

/**
 * ForegroundService class to demonstrate foreground service and Service class
 *
 * A foreground service is a service that the user is actively aware of and is not a candidate
 * for the system to kill when low on memory. A foreground service must provide a notification for
 * the status bar, which is placed under the Ongoing heading. This means that the notification cannot
 * be dismissed unless the service is either stopped or removed from the foreground.
 *
 * For more details :- https://developer.android.com/guide/components/services.html#Foreground
 *
 * @author Faisal Khan
 */

public class ForegroundService extends Service {

    private final String TAG = ForegroundService.class.getSimpleName();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent.getAction().equals(Constants.ACTION.START_FOREGROUND_ACTION)) {
            Log.d(TAG, "Received Start Foreground Intent ");

            //intent to redirect to activity when user click on notification
            Intent notificationIntent = new Intent(this, ForegroundServiceActivity.class);
            notificationIntent.setAction(Constants.ACTION.MAIN_ACTION);
            notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

            //intent to next click
            Intent previousIntent = new Intent(this, ForegroundService.class);
            previousIntent.setAction(Constants.ACTION.PREV_ACTION);
            PendingIntent previousClickIntent = PendingIntent.getService(this, 0, previousIntent, 0);

            //intent to play click
            Intent playIntent = new Intent(this, ForegroundService.class);
            playIntent.setAction(Constants.ACTION.PLAY_ACTION);
            PendingIntent playClickIntent = PendingIntent.getService(this, 0, playIntent, 0);

            // intent to next click
            Intent nextIntent = new Intent(this, ForegroundService.class);
            nextIntent.setAction(Constants.ACTION.NEXT_ACTION);
            PendingIntent nextClickIntent = PendingIntent.getService(this, 0, nextIntent, 0);

            Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

            //build notification and start service with in foregrund
            Notification notification = new NotificationCompat.Builder(this)
                    .setContentTitle("Custom Music Player").setTicker("Custom Music Player")
                    .setContentText("My Custom Music").setSmallIcon(R.mipmap.ic_launcher)
                    .setLargeIcon(Bitmap.createScaledBitmap(icon, 128, 128, false))
                    .setContentIntent(pendingIntent).setOngoing(true)
                    .addAction(android.R.drawable.ic_media_previous, "Previous", previousClickIntent)
                    .addAction(android.R.drawable.ic_media_play, "Play", playClickIntent)
                    .addAction(android.R.drawable.ic_media_next, "Next", nextClickIntent)
                    .build();

            startForeground(Constants.NOTIFICATION_ID.FOREGROUND_SERVICE, notification);

        } else if (intent.getAction().equals(Constants.ACTION.PREV_ACTION)) {
            Log.d(TAG, "Clicked Previous");
        } else if (intent.getAction().equals(Constants.ACTION.PLAY_ACTION)) {
            Log.d(TAG, "Clicked Play");
        } else if (intent.getAction().equals(Constants.ACTION.NEXT_ACTION)) {
            Log.d(TAG, "Clicked Next");
        } else if (intent.getAction().equals(Constants.ACTION.STOP_FOREGROUND_ACTION)) {
            Log.d(TAG, "Received Stop Foreground Intent");
            stopForeground(true);
            stopSelf();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "In onDestroy");
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}