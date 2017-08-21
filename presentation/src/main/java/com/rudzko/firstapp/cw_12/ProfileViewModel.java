package com.rudzko.firstapp.cw_12;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.rudzko.firstapp.base.BaseViewModel;
import com.rudzko.firstapp.domain.entity.Profile;
import com.rudzko.firstapp.domain.entity.ProfileId;
import com.rudzko.firstapp.domain.interactions.GetProfileUseCase;
import com.rudzko.firstapp.domain.interactions.UpdateProfileUseCase;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * @author Olga Rudzko
 */

public class ProfileViewModel implements BaseViewModel{

    public void setId(ProfileId id) {
        this.id = id;
    }

    private ProfileId id;
    public ObservableField<String> name = new ObservableField<>();
    public ObservableInt age=new ObservableInt();
    public ObservableField<String> person=new ObservableField<>();
    private GetProfileUseCase getProfile=new GetProfileUseCase();
    private UpdateProfileUseCase update=new UpdateProfileUseCase();

    @Override
    public void init() {
        getProfile.execute(id, new DisposableObserver<Profile>() {
            @Override
            public void onNext(@NonNull Profile profile) {
                name.set(profile.getName());
                age.set(profile.getAge());
                person.set(name.get()+", "+age.get()+ " y.o.");
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void updateProfile(){
        final Profile profile=new Profile(name.get(), age.get(), id);

        update.execute(profile, new DisposableObserver<Void>() {
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
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }
}
