package com.rudzko.firstapp;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * @author Olga Rudzko
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
