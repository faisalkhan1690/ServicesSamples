package com.example.faisal.servicessamples.foreground_service;

/**
 * Constants  class to define constants related to foreground service
 *
 * @author Faisal Khan
 */
class Constants {
    /**
     * Contains all action related to notification
     */
    interface ACTION {
        String MAIN_ACTION = "com.faisal.khan.action.main";
        String PREV_ACTION = "com.faisal.khan.action.prev";
        String PLAY_ACTION = "com.faisal.khan.action.play";
        String NEXT_ACTION = "com.faisal.khan.action.next";
        String START_FOREGROUND_ACTION = "com.faisal.khan.action.startforeground";
        String STOP_FOREGROUND_ACTION = "com.faisal.khan.action.stopforeground";
    }

    /**
     * Contains unique notification id
     */
    interface NOTIFICATION_ID {
        int FOREGROUND_SERVICE = 101;
    }
}