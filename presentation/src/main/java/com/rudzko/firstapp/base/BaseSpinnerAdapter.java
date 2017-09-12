package com.rudzko.firstapp.base;

import android.databinding.ViewDataBinding;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olga Rudzko
 */

public abstract class BaseSpinnerAdapter<MyClass> extends android.widget.BaseAdapter {

    protected List<MyClass> list = new ArrayList<>();

    public void setList(List<MyClass> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

}
