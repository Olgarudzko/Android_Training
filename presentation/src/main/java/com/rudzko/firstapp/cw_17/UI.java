package com.rudzko.firstapp.cw_17;

import com.rudzko.firstapp.MyApplication;

import javax.inject.Inject;

/**
 * @author Olga Rudzko
 */

public class UI {

    @Inject  //annotation for variable which should be created by dagger
    UseCase1 useCase1;

    public UI(){
        //required in all classes with annotation Inject
        MyApplication.appComponent.inject(this);
    }
    public void testUseCase1(){
        useCase1.getRestData();
    }
}
