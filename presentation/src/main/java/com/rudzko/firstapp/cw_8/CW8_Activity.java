package com.rudzko.firstapp.cw_8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.base.BaseActivity;
import com.rudzko.firstapp.databinding.ActivityCw8Binding;

/**
 * @author Olga Rudzko
 */

public class CW8_Activity extends BaseActivity {

    public static void show (Activity activity){
        Intent intent=new Intent(activity, CW8_Activity.class);
        activity.startActivity(intent);
    } //to jump to this activity

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        CW8_ViewModel viewModel = new CW8_ViewModel(this);
        this.viewModel=viewModel;

        ActivityCw8Binding binding= DataBindingUtil.setContentView(this, R.layout.activity_cw8);
        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);
    }
}
