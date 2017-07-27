package com.rudzko.firstapp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.cw_2.cw2_Activity;
import com.rudzko.firstapp.hw_1.hw1_Activity;
import com.rudzko.firstapp.hw_2.hw2_Activity;

/**
 * @author Olga Rudzko
 */

public class MainActivity extends Activity {

    public static final String KEY_USERNAME = "KEY_USERNAME";
    public static final String KEY_PASSWORD = "KEY_PASSWORD";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String username = getIntent().getStringExtra(KEY_USERNAME);
        String password = getIntent().getStringExtra(KEY_PASSWORD);
        TextView tw = (TextView)findViewById(R.id.greeting) ;
        if (username!=null) tw.setText("glad to see you, "+username);
        Button hw1 = (Button) findViewById(R.id.hw1_button);
        hw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, hw1_Activity.class);
                startActivity(intent);
            }
        });

        Button cw2 = (Button) findViewById(R.id.cw2_button);
        cw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, cw2_Activity.class);
                startActivity(intent);
            }
        });

        Button hw2=(Button) findViewById(R.id.hw2_button);
        hw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, hw2_Activity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
