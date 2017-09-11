package com.rudzko.firstapp.cw_17;

/**
 * @author Olga Rudzko
 */

public class UseCase2 {

    private Rest rest;
    public UseCase2() {
        rest = new Rest(new OkHttp(), new Gson());
    }
    public String getRestData(){
        return "";
    }
}
