package com.rudzko.firstapp.dagger_injection;

import com.rudzko.firstapp.cw_17.Gson;
import com.rudzko.firstapp.cw_17.OkHttp;
import com.rudzko.firstapp.cw_17.Rest;
import com.rudzko.firstapp.cw_17.SharedPreference;
import com.rudzko.firstapp.cw_17.UseCase1;
import com.rudzko.firstapp.domain.interactions.CounterUseCase;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Olga Rudzko
 */
@Module
public class AppModule {

    @Provides
    public CounterUseCase counterUseCase(){
        return  new CounterUseCase();
    }
    @Provides
    public UseCase1 provideUsCase(Rest rest, SharedPreference sharedPreference){
        return  new UseCase1(rest, sharedPreference);
    }
    @Provides
    @Named("First usecase1") //should be dublicated after inject
    public UseCase1 provideUsCase1(Rest rest, SharedPreference sharedPreference){
        return  new UseCase1(rest, sharedPreference);
    }
    @Provides
    public OkHttp provideOkHttp(){
        return new OkHttp();
    }

    @Provides
    public Gson provideGson(){
        return new Gson();
    }

    @Provides
    @Singleton
    public Rest provideRest(OkHttp okHttp, Gson gson){
        return new Rest(okHttp, gson);
    }

    @Provides
    public SharedPreference sharedPreference(){
        return new SharedPreference();
    }
}
