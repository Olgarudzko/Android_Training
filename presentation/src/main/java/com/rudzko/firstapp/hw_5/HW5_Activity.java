package com.rudzko.firstapp.hw_5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.main.MainActivity;


/**
 * @author Olga Rudzko
 */

public class HW5_Activity extends Activity {

    TextView tv;
    public static final String STATUS = "CONNECTION_STATUS";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw5);
        tv = (TextView) findViewById(R.id.status);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindService(new Intent(this, HW5_Service.class), connection, BIND_AUTO_CREATE);
        String answ = getIntent().getStringExtra(STATUS);
        tv.setText("Internet is " + answ);
    }

    @Override
    protected void onStop() {
        unbindService(connection);
        super.onStop();
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    };

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, MainActivity.class));
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}