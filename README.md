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


How to install DataBinding In your Project
--------------
1. To get started with Data Binding, download the library from the Support repository in the Android SDK manager.
2. To configure your app to use data binding, add the dataBinding element to your build.gradle file in the app module.
3. Add following in build.gradle project file classpath 
  - **classpath 'com.android.tools.build:gradle:1.5.0'**
  - **classpath 'com.android.databinding:dataBinder:1.+'**
4. Add following in build.gradle app file <br>
 - **apply plugin: 'com.android.databinding'**

By default, a Binding class will be generated based on the name of the layout file, cnverting it to Pascal case suffixing “Binding” to it.
 

Screenshots
--------------
![screenshot_1492168149](https://cloud.githubusercontent.com/assets/7554816/25041990/1eaf519a-2132-11e7-87ca-dc8a6402763c.png)
![screenshot_1492168153](https://cloud.githubusercontent.com/assets/7554816/25041992/1eb2edc8-2132-11e7-9fb5-b60c7d4b8f2b.png)
![screenshot_1492168161](https://cloud.githubusercontent.com/assets/7554816/25041993/1eb4f118-2132-11e7-9946-d52019e9b594.png)
![screenshot_1492168164](https://cloud.githubusercontent.com/assets/7554816/25041991/1eb2f886-2132-11e7-84da-14de16797231.png)
![screenshot_1492168168](https://cloud.githubusercontent.com/assets/7554816/25041994/1eb52c50-2132-11e7-9179-d889f86b4284.png)
![screenshot_1492168172](https://cloud.githubusercontent.com/assets/7554816/25041995/1eb6a86e-2132-11e7-9294-cdbf5dcca814.png)

