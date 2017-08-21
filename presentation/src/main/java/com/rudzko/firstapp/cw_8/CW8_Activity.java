package com.rudzko.firstapp.cw_8;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.rudzko.firstapp.R;
import com.rudzko.firstapp.base.BaseActivity;
import com.rudzko.firstapp.databinding.ActivityCw8Binding;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * @author Olga Rudzko
 */

public class CW8_Activity extends BaseActivity {

    public PublishSubject<String> pS=PublishSubject.create();
    public BehaviorSubject<String> bS=BehaviorSubject.create();
    public ReplaySubject<String> rS=ReplaySubject.create();

    Disposable disposable;

    public static void show (Activity activity){
        Intent intent=new Intent(activity, CW8_Activity.class);
        activity.startActivity(intent);
    } //to jump to this activity

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        CW8_ViewModel viewModel = new CW8_ViewModel(this);
        this.viewModel=viewModel;

        ActivityCw8Binding binding= DataBindingUtil.setContentView(this, R.layout.activity_cw8);
        binding.setViewModel(viewModel);

        super.onCreate(savedInstanceState);

        pS.onNext("One");
        pS.onNext("Two");
        pS.onNext("Three");
        pS.onNext("Four");
        disposable=pS.subscribeWith(new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                Log.e("OnNext publicSubject", s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        pS.onNext("Five");
        pS.onNext("Six");
        pS.onNext("Seven");
        pS.onNext("Eight");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
