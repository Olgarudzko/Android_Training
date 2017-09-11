package com.rudzko.firstapp.hw_14;

/**
 * @author Olga Rudzko
 */

public class Person {

    private int id;
    private String name;
    private MyCountry country;

    public Person() {
    }

    public Person(String name, MyCountry country) {
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyCountry getCountry() {
        return country;
    }

    public void setCountry(MyCountry country) {
        this.country = country;
    }
}
