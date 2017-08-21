package com.rudzko.firstapp.hw_10;

import android.databinding.ObservableInt;
import android.databinding.ObservableLong;

import com.rudzko.firstapp.base.BaseViewModel;
import com.rudzko.firstapp.domain.interactions.CounterUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;

/**
 * @author Olga Rudzko
 */

public class HW10_ViewModel implements BaseViewModel {

    public ObservableLong counter=new ObservableLong();
    private CounterUseCase useCase=new CounterUseCase();

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

            useCase.execute(null, new DisposableObserver<Long>() {
                @Override
                public void onNext(@NonNull Long aLong) {
                    counter.set(aLong);
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
    public void pause() {

    }
}
