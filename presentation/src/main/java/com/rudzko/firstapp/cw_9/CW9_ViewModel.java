package com.rudzko.firstapp.cw_9;

import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.rudzko.firstapp.base.BaseViewModel;
import com.rudzko.firstapp.domain.entity.Profile;
import com.rudzko.firstapp.domain.entity.ProfileId;
import com.rudzko.firstapp.domain.interactions.ProfileUseCase;

/**
 * @author Olga Rudzko
 */

public class CW9_ViewModel implements BaseViewModel {


    public enum STATE {PROGRESS, READY}

    public Activity activity;
    public ObservableField<String> name = new ObservableField<>();
    public ObservableInt age= new ObservableInt();
    public ObservableField<STATE> state= new ObservableField<>(STATE.PROGRESS);

    private ProfileUseCase useCase=new ProfileUseCase();

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        ProfileId pi=new ProfileId();
        pi.setId(56);

        Profile profile = useCase.execute(pi);

        name.set(profile.getName());
        age.set(profile.getAge());

        state.set(STATE.READY);
    }

    @Override
    public void pause() {

    }
}
