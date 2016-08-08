package com.tydc.tigerschool.core;

import android.app.Application;

/**
 * Created by liwei on 16/7/31.
 */
public class ApplicationCache extends Application {

    public static ApplicationCache applicationContext;
    public static ApplicationCache getInstance() {
        return applicationContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
