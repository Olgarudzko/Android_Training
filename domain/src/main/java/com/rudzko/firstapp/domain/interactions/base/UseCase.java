package com.rudzko.firstapp.domain.interactions.base;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Olga Rudzko
 */

public abstract class UseCase<InParam, OutParam> {

    private Disposable disposable;

    protected abstract Observable<OutParam> buildUseCase(InParam param);

    public void execute (InParam param, DisposableObserver<OutParam> dispObs){
        disposable=buildUseCase(param).observeOn(AndroidSchedulers.mainThread()) //response to Activity in UI thread
                .subscribeOn(Schedulers.newThread())            //request to Data in other thread
                .subscribeWith(dispObs);
    }

    public void dispose(){
        if(!disposable.isDisposed()){
            disposable.dispose();
        }
    }
}
