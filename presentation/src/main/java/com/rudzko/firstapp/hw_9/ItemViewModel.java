package com.rudzko.firstapp.hw_9;

import android.databinding.ObservableField;

import com.rudzko.firstapp.base.BaseViewModel;

/**
 * @author Olga Rudzko
 */

public class ItemViewModel implements BaseViewModel {

    public ObservableField<String> url=new ObservableField<>();

    ItemViewModel(String url) {
        this.url.set(url);
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

}
