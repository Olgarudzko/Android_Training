package com.rudzko.firstapp.dagger_injection;

import com.rudzko.firstapp.cw_17.UseCase1;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Olga Rudzko
 */
@Module
public class AppModule {

    @Provides
    @Singleton
    public UseCase1 provideUsCase(){
        return  new UseCase1();
    }
}
