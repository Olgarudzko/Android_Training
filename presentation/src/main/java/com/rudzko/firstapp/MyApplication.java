package com.rudzko.firstapp;

import android.app.Application;

import com.rudzko.firstapp.dagger_injection.AppComponent;
import com.rudzko.firstapp.dagger_injection.AppModule;
import com.rudzko.firstapp.dagger_injection.DaggerAppComponent;
import com.squareup.leakcanary.LeakCanary;

import io.realm.Realm;

/**
 * @author Olga Rudzko
 */

public class MyApplication extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        Realm.init(this);
        appComponent = DaggerAppComponent.builder().appModule(new AppModule()).build();
    }
}
