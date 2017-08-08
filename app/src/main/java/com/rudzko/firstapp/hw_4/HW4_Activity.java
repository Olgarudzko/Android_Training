package com.rudzko.firstapp.hw_4;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.rudzko.firstapp.R;

/**
 * @author Olga Rudzko
 */

public class HW4_Activity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw4);

        ImageView owl = (ImageView) findViewById(R.id.animation);
        ((AnimationDrawable) owl.getBackground()).start();

        Thread thread=new Thread() {
            @Override
            public void run() {

                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            RelativeLayout rl = (RelativeLayout) findViewById(R.id.clock);
                            RunningArrows ra=(RunningArrows)findViewById(R.id.arrows);
                            @Override
                            public void run() {
                                rl.removeView(ra);
                                ra = new RunningArrows(HW4_Activity.this);
                                ra.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                                rl.addView(ra);
                                ra.setId(R.id.arrows);
                            }
                        });
                    }
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
            thread.start();
    }
}
