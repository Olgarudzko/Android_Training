package com.rudzko.firstapp.hw_4;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.rudzko.firstapp.R;

/**
 * @author Olga Rudzko
 */

public class HW4_Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw4);

        ImageView owl= (ImageView)findViewById(R.id.animation);
        ((AnimationDrawable)owl.getBackground()).start();



    }
}
