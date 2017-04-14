package com.example.faisal.servicessamples.job_scheduler;


import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import static com.example.faisal.servicessamples.job_scheduler.JobSchedulerActivity.MESSENGER_INTENT_KEY;
import static com.example.faisal.servicessamples.job_scheduler.JobSchedulerActivity.MSG_COLOR_START;
import static com.example.faisal.servicessamples.job_scheduler.JobSchedulerActivity.MSG_COLOR_STOP;
import static com.example.faisal.servicessamples.job_scheduler.JobSchedulerActivity.WORK_DURATION_KEY;

/**
 * MyJobService extends JobService to provide a service that will handle by job
 * scheduler to handle specific task with specific constraint. this service runs a task for given time.
 * That will pass by activity and notify back to activity status of task.
 *
 * for more info :- https://developer.android.com/reference/android/app/job/JobService.html
 *
 *
 * @author Faisal Khan
 */
public class MyJobService extends JobService {

    private static final String TAG = MyJobService.class.getSimpleName();

    private Messenger mActivityMessenger;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "Service created");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "Service destroyed");
    }

    /**
     * When the app's MainActivity is created, it starts this service. This is so that the
     * activity and this service can communicate back and forth. See "setUiCallback()"
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mActivityMessenger = intent.getParcelableExtra(MESSENGER_INTENT_KEY);
        return START_NOT_STICKY;
    }

    @Override
    public boolean onStartJob(final JobParameters params) {
        sendMessage(MSG_COLOR_START, params.getJobId());

        // get work duration key passed from activity
        long duration = params.getExtras().getLong(WORK_DURATION_KEY);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                sendMessage(MSG_COLOR_STOP, params.getJobId());
                jobFinished(params, false);
            }
        }, duration);
        Log.i(TAG, "on start job: " + params.getJobId());

        // Return true as there's more work to be done with this job.
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        // Stop tracking these job parameters, as we've 'finished' executing.
        sendMessage(MSG_COLOR_STOP, params.getJobId());
        Log.i(TAG, "on stop job: " + params.getJobId());

        // Return false to drop the job.
        return false;
    }

    private void sendMessage(int messageID,Object params) {
        // If this service is launched by the JobScheduler, there's no callback Messenger. It
        // only exists when the MainActivity calls startService() with the callback in the Intent.
        if (mActivityMessenger == null) {
            Log.d(TAG, "Service is bound, not started. There's no callback to send a message to.");
            return;
        }
        Message m = Message.obtain();
        m.what = messageID;
        m.obj = params;
        try {
            mActivityMessenger.send(m);
        } catch (RemoteException e) {
            Log.e(TAG, "Error passing service object back to activity.");
        }
    }
}