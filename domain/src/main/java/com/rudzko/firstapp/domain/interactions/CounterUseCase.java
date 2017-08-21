package com.rudzko.firstapp.domain.interactions;

import com.rudzko.firstapp.domain.interactions.base.UseCase;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Predicate;

/**
 * @author Olga Rudzko
 */

public class CounterUseCase extends UseCase<Void, Long> {

    @Override
    protected Observable<Long> buildUseCase(Void aVoid) {
        return Observable.interval(1, TimeUnit.SECONDS)
                .filter(new Predicate<Long>() {
                    @Override
                    public boolean test(@NonNull Long aLong) throws Exception {
                        return aLong%2==0;
                    }
                })
                ;
    }
}
