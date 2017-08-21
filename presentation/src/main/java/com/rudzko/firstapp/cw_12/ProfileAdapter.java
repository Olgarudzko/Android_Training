package com.rudzko.firstapp.cw_12;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rudzko.firstapp.base.BaseAdapter;
import com.rudzko.firstapp.base.BaseItemViewHolder;
import com.rudzko.firstapp.databinding.ProfileItemBinding;
import com.rudzko.firstapp.domain.entity.Profile;

/**
 * @author Olga Rudzko
 */

public class ProfileAdapter extends BaseAdapter<Profile, ProfileItemViewModel> {

    CW12_ViewModel viewModel;

    public ProfileAdapter(CW12_ViewModel viewModel){
     this.viewModel=viewModel;
    }
    @Override
    public ProfileItemViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
        ProfileItemViewModel model=new ProfileItemViewModel();
        ProfileItemBinding binding = ProfileItemBinding.inflate
                (LayoutInflater.from(parent.getContext()), parent, false);
        return new ProfileItemViewHolder(binding, model);
    }

    @Override
    public void onBindViewHolder(final BaseItemViewHolder<Profile, ProfileItemViewModel, ?> holder, int position) {
        super.onBindViewHolder(holder, position);
        final Profile p=items.get(position);
        holder.itemView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                viewModel.getProfile(p.getId().getId());
            }
        });
    }
}
