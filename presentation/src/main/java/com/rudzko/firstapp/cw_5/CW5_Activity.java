package com.rudzko.firstapp.cw_5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.rudzko.firstapp.R;

/**
 * @author Olga Rudzko
 */

public class CW5_Activity extends Activity {

    private TextView tw;
    int i;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw5);
        tw=(TextView) findViewById(R.id.text_cw5);
        Intent intent=new Intent(this, MyIntentService.class);
        intent.putExtra(MyIntentService.KEY_ACTION, "Task 1");
        startService(intent);
        Intent intent2=new Intent(this, MyIntentService.class);
        intent2.putExtra(MyIntentService.KEY_ACTION, "Task 2");
        startService(intent2);
        Intent intent3=new Intent(this, MyIntentService.class);
        intent3.putExtra(MyIntentService.KEY_ACTION, "Task 3");
        startService(intent3);
//        startService(new Intent(this, MyService.class));
        tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                stopService(new Intent (CW5_Activity.this, MyService.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter iF = new IntentFilter();
        iF.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(receiver, iF);
        iF.addAction(MyIntentService.MY_ACTION);
        bindService(new Intent(this, MyService.class), sC, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(receiver);
        unbindService(sC);
    }

    private ServiceConnection sC=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("msg_serv_connected", "onServiceConnected");

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("msg_serv_disconnected", "onServiceDisconnected");
        }
    };

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            tw.setText("Connection state was changed: " + i++);
        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
