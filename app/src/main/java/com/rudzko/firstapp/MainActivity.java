package com.rudzko.firstapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {


    private Button button;
    private TextView text1;
    private TextView text2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate()");

        button = (Button) findViewById(R.id.button_switch);
        text1 = (TextView) findViewById(R.id.text1);
        text1.setOnClickListener(this);
        text2 = (TextView) findViewById(R.id.text2);
        OnClickListener inst = new OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence buffer = text1.getText();
                text1.setText(text2.getText());
                text2.setText(buffer);
            }
        };
        button.setOnClickListener(inst);
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

    @Override
    public void onClick(View v) {
        CharSequence buffer = text1.getText();
        text1.setText(text2.getText());
        text2.setText(buffer);
    }
}
