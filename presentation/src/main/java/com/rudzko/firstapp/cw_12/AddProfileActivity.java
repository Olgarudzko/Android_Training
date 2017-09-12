package com.rudzko.firstapp.cw_12;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.View;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.base.BaseActivity;
import com.rudzko.firstapp.databinding.AddProfileBinding;

/**
 * @author Olga Rudzko
 */

public class AddProfileActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final AddProfileViewModel model = new AddProfileViewModel();
        this.viewModel = model;
        final AddProfileBinding binding = DataBindingUtil.setContentView(this, R.layout.add_profile);
        binding.setForm(model);
        super.onCreate(savedInstanceState);
        binding.addProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable name_input = binding.name.getText();
                Editable age_input = binding.age.getText();
                if (!(name_input == null) && !(age_input == null)) {
                    model.name.set(name_input.toString());
                    model.age.set(Integer.valueOf(age_input.toString()));
                    model.saveProfile();
                    Intent intent = new Intent(AddProfileActivity.this, CW12_Activity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
