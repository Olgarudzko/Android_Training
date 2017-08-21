package com.rudzko.firstapp.cw_9;

import android.app.Activity;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.rudzko.firstapp.base.BaseViewModel;
import com.rudzko.firstapp.domain.entity.Profile;
import com.rudzko.firstapp.domain.entity.ProfileId;
import com.rudzko.firstapp.domain.interactions.ProfileUseCase;
import com.rudzko.firstapp.domain.interactions.SaveProfile;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

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
    private SaveProfile saveprof=new SaveProfile();

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

        final Profile trial=new Profile("Olga", 29);

        saveprof.execute(trial, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
                Log.d("sent user", trial.getName());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
//        ProfileId pi=new ProfileId();
//        pi.setId(56);
//
//        useCase.execute(pi, new DisposableObserver<Profile>() {
//            @Override
//            public void onNext(@NonNull Profile profile) {
//                name.set(profile.getName());
//                age.set(profile.getAge());
//                state.set(STATE.READY);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//                Log.e("!error!", "error = ", e);
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });

    }

    @Override
    public void pause() {

    }
}
