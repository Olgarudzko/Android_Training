package com.rudzko.firstapp.cw_7;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.databinding.ActivityCw7Binding;

/**
 * @author Olga Rudzko
 */

public class CW7_Activity extends Activity {
//
//    public ObservableField<String> myText= new ObservableField<>("It works");
//    private Thread thread;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        ActivityCw7Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_cw7);
//        binding.setActivity(this);
//
//        binding.msg.setText("");
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        thread=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0; i<3; i++){
//                    final int a=i;
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            myText.set(String.valueOf(a));
//                        }
//                    });
//                }
//            }
//        });
//        thread.start();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//    }

}
