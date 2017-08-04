package com.rudzko.firstapp.hw_5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.rudzko.firstapp.R;


/**
 * @author Olga Rudzko
 */

public class HW5_Activity extends Activity {

    TextView tw;

    private BroadcastReceiver br= new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //tw.setText();
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw5);
        tw=(TextView) findViewById(R.id.status);
    }
}
