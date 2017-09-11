package com.rudzko.firstapp.cw_13;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.rudzko.firstapp.R;


/**
 * @author Olga Rudzko
 */

public class CW13_Activity extends FragmentActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cw13);
        //when creating static method fragment manager should be used as parameter!

        if (savedInstanceState==null){
            showFragment(getSupportFragmentManager(), new CW13_Fragment(), false);
        }

        findViewById(R.id.button_f1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(getSupportFragmentManager(),
                        CW13_Fragment.newInstance(getSupportFragmentManager(), "Hidden Message"), true);
            }
        });

        findViewById(R.id.button_f2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(getSupportFragmentManager(), new CW13_Fragment2(), true);
            }
        });
    }

    public static void showFragment(FragmentManager fm, Fragment fragment, boolean addToBackStack){
        FragmentTransaction transaction=fm.beginTransaction();
        //transaction.add()
        transaction.replace(R.id.container, fragment, fragment.getClass().getName());
        if (addToBackStack) transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

}


//fragmentManager should be got from parent; if fragment is inside another fragment  ypu should use getChildFragmentManager