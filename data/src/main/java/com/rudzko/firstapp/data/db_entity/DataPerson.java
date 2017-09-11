package com.rudzko.firstapp.data.db_entity;

/**
 * @author Olga Rudzko
 */

public class DataPerson {
    private int id;
    private String name;
    private DataMyCountry country;

    public DataPerson() {
    }

    public DataPerson(String name, DataMyCountry country) {
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

    public DataMyCountry getCountry() {
        return country;
    }

    public void setCountry(DataMyCountry country) {
        this.country = country;
    }
}
