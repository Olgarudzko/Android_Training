package com.rudzko.firstapp.domain.entity;

/**
 * @author Olga Rudzko
 */

public class MyCountry {
    private int id;
    private String name;
    private String code;

    public MyCountry(){}
    public MyCountry(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
