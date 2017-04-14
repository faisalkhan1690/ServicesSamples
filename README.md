# Sample for all kind of services in android
--------------
This project is a sample for how to use all kinds of services in andorid like 
- Started service
- Bound service
- Intent service
- Foreground Service
- Job Scheduler


Pre-requisites for run this sample 
--------------

- Android SDK v23
- Android Build Tools v23.0.2
- Android Support repository(Available In Extra in SDK Manager)


Started service
--------------
A Service is an application component that can perform long-running operations in the background, and it does not provide a user interface. Another application component can start a service, and it continues to run in the background even if the user switches to another application. Additionally, a component can bind to a service to interact with it and even perform interprocess communication (IPC). For example, a service can handle network transactions, play music, perform file I/O, or interact with a content provider, all from the background.

Link :- https://developer.android.com/guide/components/services.html
 
Bound service
--------------
A bound service is the server in a client-server interface. It allows components (such as activities) to bind to the service, send requests, receive responses, and perform interprocess communication (IPC). A bound service typically lives only while it serves another application component and does not run in the background indefinitely.

Link :-https://developer.android.com/guide/components/bound-services.html
 
Intent service
--------------
IntentService is a base class for Services that handle asynchronous requests (expressed as Intents) on demand. Clients send requests through startService(Intent) calls; the service is started as needed, handles each Intent in turn using a worker thread, and stops itself when it runs out of work.

This "work queue processor" pattern is commonly used to offload tasks from an application's main thread. The IntentService class exists to simplify this pattern and take care of the mechanics. To use it, extend IntentService and implement onHandleIntent(Intent). IntentService will receive the Intents, launch a worker thread, and stop the service as appropriate.

All requests are handled on a single worker thread -- they may take as long as necessary (and will not block the application's main loop), but only one request will be processed at a time.

Link :- https://developer.android.com/reference/android/app/IntentService.html
 
Foreground Service
--------------
A foreground service is a service that the user is actively aware of and is not a candidate for the system to kill when low on memory. A foreground service must provide a notification for the status bar, which is placed under the Ongoing heading. This means that the notification cannot be dismissed unless the service is either stopped or removed from the foreground.

Link :- https://developer.android.com/guide/components/services.html#Foreground
 
Job Scheduler
--------------
This is an API for scheduling various types of jobs against the framework that will be executed in your application's own process.
The framework will be intelligent about when you receive your callbacks, and attempt to batch and defer them as much as possible. Typically if you don't specify a deadline on your job, it can be run at any moment depending on the current state of the JobScheduler's internal queue, however it might be deferred as long as until the next time the device is connected to a power source.

Link :- 
https://developer.android.com/reference/android/app/job/JobScheduler.html
https://developer.android.com/reference/android/app/job/JobInfo.html
https://developer.android.com/reference/android/app/job/JobService.html


 

Screenshots
--------------

![screenshot_1492168149](https://cloud.githubusercontent.com/assets/7554816/25042073/c1784878-2132-11e7-8859-da6103b4e206.png)
![screenshot_1492168153](https://cloud.githubusercontent.com/assets/7554816/25042069/c175a028-2132-11e7-9b71-0ca71829f549.png)
![screenshot_1492168161](https://cloud.githubusercontent.com/assets/7554816/25042071/c1769ac8-2132-11e7-93b9-39f69b29c2eb.png)
![screenshot_1492168164](https://cloud.githubusercontent.com/assets/7554816/25042070/c1767bc4-2132-11e7-9f20-102149fc4b41.png)
![screenshot_1492168168](https://cloud.githubusercontent.com/assets/7554816/25042072/c177cc0e-2132-11e7-8d44-fd9c83657377.png)
![screenshot_1492168172](https://cloud.githubusercontent.com/assets/7554816/25042074/c17b29ee-2132-11e7-84d3-426bfb60082e.png)




