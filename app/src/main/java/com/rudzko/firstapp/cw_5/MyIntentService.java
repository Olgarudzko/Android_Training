package com.rudzko.firstapp.cw_5;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author Olga Rudzko
 */

public class MyIntentService extends IntentService {

    public static final String KEY_ACTION="KEY_ACTION";
    public static final String MY_ACTION="com.rudzko.firstapp.cw_5.MY_ACTION";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        String action=intent.getStringExtra(KEY_ACTION);
//        Log.e("msg_handle_intent", "onHandleIntent: ----" + action);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Intent intentReceiver=new Intent(MY_ACTION);
        sendBroadcast(intentReceiver);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("msg_destroy_intent", "onDestroy");
    }
}
