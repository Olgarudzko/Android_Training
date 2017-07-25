package com.rudzko.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {


    private Button button1;
    private int i;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate()");

        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText("button" + i++);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop()");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MainActivity", "onDestroy()");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause()");

    }
}
