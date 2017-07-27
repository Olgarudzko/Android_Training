package com.rudzko.firstapp.hw_2;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rudzko.firstapp.R;

/**
 * @author Olga Rudzko
 */

public class hw2_Activity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw2);

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
