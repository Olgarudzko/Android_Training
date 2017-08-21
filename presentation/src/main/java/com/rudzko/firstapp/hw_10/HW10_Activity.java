package com.rudzko.firstapp.hw_10;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.base.BaseActivity;
import com.rudzko.firstapp.databinding.ActivityHw10Binding;

/**
 * @author Olga Rudzko
 */

public class HW10_Activity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ActivityHw10Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_hw10);
        HW10_ViewModel viewModel=new HW10_ViewModel();
        this.viewModel=viewModel;
        binding.setModel(viewModel);
        super.onCreate(savedInstanceState);
    }
}
