package com.rudzko.firstapp.cw_12;

import android.databinding.ObservableField;
import android.util.Log;

import com.rudzko.firstapp.base.BaseItemViewModel;
import com.rudzko.firstapp.domain.entity.Profile;

/**
 * @author Olga Rudzko
 */

public class ProfileItemViewModel extends BaseItemViewModel<Profile>{

    public ObservableField<String> name=new ObservableField<>("");

    @Override
    public void setItem(Profile item, int position) {
        name.set(item.getName());
        Log.d("SET ITEM "+position, name.get());
    }

    @Override
    public String toString() {
        return "Item ["+name.get()+"]";
    }

    @Override
    public void init() {
        super.init();
    }

}
