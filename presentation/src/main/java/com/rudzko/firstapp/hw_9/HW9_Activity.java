package com.rudzko.firstapp.hw_9;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.base.BaseActivity;
import com.rudzko.firstapp.databinding.ActivityHw9Binding;

/**
 * @author Olga Rudzko
 */

public class HW9_Activity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        ActivityHw9Binding binding= DataBindingUtil.setContentView(this, R.layout.activity_hw9);
        HW9_ViewModel viewModel=new HW9_ViewModel();
        this.viewModel=viewModel;
        binding.setModel(viewModel);
        super.onCreate(savedInstanceState);
    }

    @BindingAdapter({"bind:adapter"})
    public static void setAdapter(RecyclerView view, ItemViewModel[] items){
        view.setLayoutManager(new GridLayoutManager(view.getContext(), 2));
        view.setAdapter(new GalleryAdapter(items));
    }

}
