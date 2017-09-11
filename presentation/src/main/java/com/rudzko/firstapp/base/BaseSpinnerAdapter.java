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

public abstract class BaseSpinnerAdapter<MyClass> extends android.widget.BaseAdapter
        implements AdapterView.OnItemSelectedListener {

    protected List<MyClass> list = new ArrayList<>();

    public MyClass getChosen() {
        if (chosen != null) {
            Log.d("Got country", chosen.toString());
        } else {
            Log.d("Error", "Country is not chosen");
        }
        return chosen;
    }

    public void setChosen(MyClass chosen) {
        this.chosen = chosen;
    }

    private MyClass chosen;

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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        chosen = list.get(position);
        Log.d("onItemSelected", "selected " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        chosen = list.get(0);
    }
}
