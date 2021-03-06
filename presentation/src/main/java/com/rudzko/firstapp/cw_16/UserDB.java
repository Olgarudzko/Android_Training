package com.rudzko.firstapp.cw_16;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * @author Olga Rudzko
 */

public class UserDB extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;

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
}
