package com.rudzko.firstapp.cw_12;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.util.Log;

import com.rudzko.firstapp.base.BaseViewModel;
import com.rudzko.firstapp.domain.entity.Profile;
import com.rudzko.firstapp.domain.entity.ProfileId;
import com.rudzko.firstapp.domain.interactions.GetProfileListUseCase;

import java.util.List;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * @author Olga Rudzko
 */

public class CW12_ViewModel implements BaseViewModel {

    public enum STATE {PROGRESS, READY}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    private GetProfileListUseCase getPrListCase=new GetProfileListUseCase();
    private Activity activity;
    public CW12_ViewModel(Activity activity) {
        this.activity = activity;
    }
    public ProfileAdapter adapter=new ProfileAdapter(this);

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {
        getPrListCase.execute(null, new DisposableObserver<List<Profile>>() {
            @Override
            public void onNext(@NonNull List<Profile> profiles) {
                adapter.setItems(profiles);

                state.set(STATE.READY);

                for (int i=0; i<profiles.size(); i++) {
                    Log.d("Got from domain", profiles.get(i).toString());
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    public void getProfile(int id){
    Intent intent=new Intent(activity, ProfileActivity.class);
        intent.putExtra(ProfileActivity.PROFILE_ID, id);
        activity.startActivity(intent);
        activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
    @Override
    public void pause() {

    }
}
