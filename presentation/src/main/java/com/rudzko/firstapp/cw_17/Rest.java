package com.rudzko.firstapp.cw_17;

/**
 * @author Olga Rudzko
 */

public class Rest {
    private OkHttp okHttp;
    private Gson gson;

    public Rest(OkHttp okHttp, Gson gson) {
        this.okHttp = okHttp;
        this.gson = gson;
    }
}
