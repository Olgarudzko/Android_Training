package com.rudzko.firstapp.cw_12;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.rudzko.firstapp.base.BaseViewModel;
import com.rudzko.firstapp.domain.entity.Profile;
import com.rudzko.firstapp.domain.interactions.SaveProfile;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * @author Olga Rudzko
 */

public class AddProfileViewModel implements BaseViewModel {

    public ObservableField<String> name=new ObservableField<>();
    public ObservableInt age=new ObservableInt();
    private SaveProfile save=new SaveProfile();

    public void saveProfile(){
        final Profile profile=new Profile(name.get(), age.get());

        save.execute(profile, new DisposableObserver<Void>() {
            @Override
            public void onNext(@NonNull Void aVoid) {
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
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
