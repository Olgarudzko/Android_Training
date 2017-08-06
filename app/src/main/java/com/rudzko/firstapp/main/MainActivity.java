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
import com.rudzko.firstapp.cw_6.CW6_Activity;
import com.rudzko.firstapp.hw_1.hw1_Activity;
import com.rudzko.firstapp.hw_2.hw2_Activity;
import com.rudzko.firstapp.hw_3.hw3_Activity;
import com.rudzko.firstapp.hw_4.HW4_Activity;
import com.rudzko.firstapp.hw_5.HW5_Activity;
import com.rudzko.firstapp.hw_6.HW6_Activity;

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
        createButton(R.id.hw1_button, hw1_Activity.class);
        createButton(R.id.hw2_button, hw2_Activity.class);
        createButton(R.id.hw3_button, hw3_Activity.class);
        createButton(R.id.hw4_button, HW4_Activity.class);
        createButton(R.id.hw5_button, HW5_Activity.class);
        createButton(R.id.hw6_button, HW6_Activity.class);
        createButton(R.id.cw2_button, cw2_Activity.class);
        createButton(R.id.cw3_button, cw3_Activity.class);
        createButton(R.id.cw4_button, CW4_Activity.class);
        createButton(R.id.cw5_button, CW5_Activity.class);
        createButton(R.id.cw6_button, CW6_Activity.class);
    }

    private Button createButton(int link, final Class cls){
        Button newButton= (Button) findViewById(link);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, cls));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        return newButton;
    }
    }
