package com.rudzko.firstapp.domain.entity;

/**
 * @author Olga Rudzko
 */

public class AvatarId implements DomainModel {
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
