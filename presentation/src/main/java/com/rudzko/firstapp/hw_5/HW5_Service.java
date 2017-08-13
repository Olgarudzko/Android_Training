package com.rudzko.firstapp.hw_5;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * @author Olga Rudzko
 */

public class HW5_Service extends Service {

    BroadcastReceiver connectCheck = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = cm.getActiveNetworkInfo();
            String msg = (ni != null && ni.isConnectedOrConnecting()) ? "ON" : "OFF";
            Intent reply = new Intent(HW5_Service.this, HW5_Activity.class);
            reply.putExtra(HW5_Activity.STATUS, msg);
            startActivity(reply);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        IntentFilter iF = new IntentFilter();
        iF.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(connectCheck, iF);
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        unregisterReceiver(connectCheck);
        return super.onUnbind(intent);
    }
}
