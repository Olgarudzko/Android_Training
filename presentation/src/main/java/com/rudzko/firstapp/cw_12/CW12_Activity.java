package com.rudzko.firstapp.cw_12;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.base.BaseActivity;
import com.rudzko.firstapp.databinding.ActivityCw12Binding;
import com.rudzko.firstapp.main.MainActivity;

/**
 * @author Olga Rudzko
 */

public class CW12_Activity extends BaseActivity {

    public static void show(Activity activity){
        Intent intent=new Intent(activity, CW12_Activity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        CW12_ViewModel model = new CW12_ViewModel(this);
        this.viewModel = model;
        ActivityCw12Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_cw12);
        binding.setModel(model);
        super.onCreate(savedInstanceState);
        binding.usersList.setLayoutManager(new LinearLayoutManager(this));
        binding.usersList.setAdapter(model.adapter);
        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CW12_Activity.this, AddProfileActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
