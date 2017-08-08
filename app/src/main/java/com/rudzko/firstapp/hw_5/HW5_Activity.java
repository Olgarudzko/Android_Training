package com.rudzko.firstapp.hw_5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.rudzko.firstapp.R;


/**
 * @author Olga Rudzko
 */

public class HW5_Activity extends Activity {

    TextView tv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw5);
        tv = (TextView) findViewById(R.id.status);

    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter iF = new IntentFilter();
        iF.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(br, iF);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(br);
    }

    private BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String msg= isConnected() ? getString(R.string.con) : getString(R.string.discon);
            tv.setText(msg);
        }

    };

    private boolean isConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        return ni != null && ni.isConnectedOrConnecting();
    }
}