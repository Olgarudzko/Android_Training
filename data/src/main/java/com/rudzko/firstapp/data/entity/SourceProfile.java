package com.rudzko.firstapp.data.entity;

import com.google.gson.annotations.SerializedName;

/**
 * @author Olga Rudzko
 */

public class SourceProfile implements DataModel {

    @SerializedName("name")
    private String name;

    @SerializedName("age")
    private int age;

    @SerializedName("id")
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public int getAge() {
        return age;
    }
}
