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
import com.rudzko.firstapp.cw_3.cw3_Activity;
import com.rudzko.firstapp.cw_4.CW4_Activity;
import com.rudzko.firstapp.cw_5.CW5_Activity;
import com.rudzko.firstapp.hw_1.hw1_Activity;
import com.rudzko.firstapp.hw_2.hw2_Activity;
import com.rudzko.firstapp.hw_3.hw3_Activity;
import com.rudzko.firstapp.hw_4.HW4_Activity;

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
        if (username!=null) {
            String str=getString(R.string.greeting)+" "+username;
            tw.setText(str);
        }
        Button hw1 = (Button) findViewById(R.id.hw1_button);
        hw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { go(hw1_Activity.class);}
        });

        Button hw2=(Button) findViewById(R.id.hw2_button);
        hw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { go(hw2_Activity.class);}
        });

        Button hw3=(Button) findViewById(R.id.hw3_button);
        hw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {go(hw3_Activity.class);  }
        });

        Button hw4=(Button) findViewById(R.id.hw4_button);
        hw4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { go(HW4_Activity.class);}
        });
        Button hw5=(Button) findViewById(R.id.hw5_button);
        hw5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { go(HW4_Activity.class);}
        });
        Button cw2 = (Button) findViewById(R.id.cw2_button);
        cw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { go(cw2_Activity.class);}
        });

        Button cw3 = (Button) findViewById(R.id.cw3_button);
        cw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { go(cw3_Activity.class); }
        });
        Button cw4 = (Button) findViewById(R.id.cw4_button);
        cw4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { go(CW4_Activity.class); }
        });

        Button cw5 = (Button) findViewById(R.id.cw5_button);
        cw5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { go(CW5_Activity.class); }
        });

        Button cw6 = (Button) findViewById(R.id.cw6_button);
        cw6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { go(CW5_Activity.class); }
        });}

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

    private void go(Class cls){
        Intent intent = new Intent(MainActivity.this, cls);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
