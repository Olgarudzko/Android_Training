package com.rudzko.firstapp.domain.entity;

/**
 * @author Olga Rudzko
 */

public class ProfileId implements DomainModel {
    private int id;
    public ProfileId() {
    }
    public ProfileId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

}
