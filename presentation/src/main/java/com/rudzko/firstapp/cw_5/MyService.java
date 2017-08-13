package com.rudzko.firstapp.cw_5;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * @author Olga Rudzko
 */

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        Log.e("message bind", "onBind");
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("message create", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("message start", "onStart");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("message destroy", "onDestroy");

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("message unbind", "onUnbind");

        return super.onUnbind(intent);
    }
}
