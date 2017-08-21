package com.rudzko.firstapp.base;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

/**
 * @author Olga Rudzko
 */

public abstract class BaseItemViewHolder
        <Model, ViewModel extends BaseItemViewModel<Model>, DataBinding extends ViewDataBinding>
        extends RecyclerView.ViewHolder{


    private DataBinding dataBinding;
    private ViewModel viewModel;


    public BaseItemViewHolder(DataBinding db, ViewModel vm) {
        super(db.getRoot());
        this.viewModel=vm;
        this.dataBinding=db;
        vm.init();
        Log.d("Ready to hold", vm.toString());
    }

    public void bindTo(Model item, int position){
        viewModel.setItem(item, position);
        dataBinding.executePendingBindings();
        Log.d("!!!GOT NEW LINE", viewModel.toString());
    }

    public void release(){
        viewModel.release();
    }
}
