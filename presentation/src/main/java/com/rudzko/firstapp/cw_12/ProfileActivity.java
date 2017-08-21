package com.rudzko.firstapp.cw_12;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.View;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.base.BaseActivity;
import com.rudzko.firstapp.databinding.ProfileCw12Binding;
import com.rudzko.firstapp.domain.entity.ProfileId;
import com.rudzko.firstapp.main.MainActivity;

/**
 * @author Olga Rudzko
 */

public class ProfileActivity extends BaseActivity{

    public static final String PROFILE_ID="PROFILE_ID";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        final ProfileViewModel viewModel=new ProfileViewModel();
        this.viewModel=viewModel;
        final ProfileCw12Binding binding= DataBindingUtil.setContentView(this, R.layout.profile_cw12);
        binding.setProfile(viewModel);
        viewModel.setId(new ProfileId(getIntent().getIntExtra(PROFILE_ID, 0)));
        super.onCreate(savedInstanceState);
        binding.editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable new_name=binding.nameEdit.getText();
                Editable new_age=binding.ageEdit.getText();
                if(!(new_name==null)&&!(new_age==null)){
                    viewModel.name.set(new_name.toString());
                    viewModel.age.set(Integer.valueOf(new_age.toString()));
                    viewModel.updateProfile();
                    binding.setProfile(viewModel);
                }
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
