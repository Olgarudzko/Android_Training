package com.rudzko.firstapp.cw_9;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.base.BaseActivity;
import com.rudzko.firstapp.databinding.ActivityCw9Binding;

/**
 * @author Olga Rudzko
 */

public class CW9_Activity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        CW9_ViewModel viewModel = new CW9_ViewModel();
        this.viewModel = viewModel;

        ActivityCw9Binding binding = DataBindingUtil.setContentView(this, R.layout.activity_cw9);
        binding.setViewModel(viewModel);
        super.onCreate(savedInstanceState);
    }

}


//see CW8 for PublicSubject, BehaviorSubject, ReplaySubject