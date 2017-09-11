package com.rudzko.firstapp.hw_14;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.base.BaseActivity;
import com.rudzko.firstapp.databinding.ActivityHw14Binding;

/**
 * @author Olga Rudzko
 */

public class HW14_Activity extends BaseActivity {

    ActivityHw14Binding binding;
    MySpinnerAdapter adapter=new MySpinnerAdapter();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ViewModel_HW14 model = new ViewModel_HW14(this);
        this.viewModel = model;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_hw14);
        binding.setModel(model);
        super.onCreate(savedInstanceState);
        adapter.setList(model.codes);
        binding.worldSpinner.setAdapter(adapter);
    }
}
