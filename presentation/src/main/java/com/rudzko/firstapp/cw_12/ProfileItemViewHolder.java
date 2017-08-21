package com.rudzko.firstapp.cw_12;

import android.util.Log;

import com.rudzko.firstapp.base.BaseItemViewHolder;
import com.rudzko.firstapp.databinding.ProfileItemBinding;
import com.rudzko.firstapp.domain.entity.Profile;

/**
 * @author Olga Rudzko
 */

public class ProfileItemViewHolder extends BaseItemViewHolder<Profile, ProfileItemViewModel, ProfileItemBinding> {

    public ProfileItemViewHolder(ProfileItemBinding dataBinding, ProfileItemViewModel viewModel) {

        super(dataBinding, viewModel);
        dataBinding.setViewModel(viewModel);
        Log.d("MESSAGE", "New ViewHolder created");
    }
}



