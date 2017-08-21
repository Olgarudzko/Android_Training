package com.rudzko.firstapp.domain.entity;

/**
 * @author Olga Rudzko
 */

public class Profile implements DomainModel {

    private String name;
    private int age;
    private ProfileId id;

    public Profile(){}

    public Profile(String name, int age){
        this.name = name;
        this.age = age;
        generateId();
    }

    public Profile(String name, int age, ProfileId id) {
        this.name = name;
        this.age = age;
        this.id=id;
    }

    public ProfileId getId() {
        return id;
    }

    public void setId(ProfileId id) {
        this.id = id;
    }

    private void generateId(){
        this.id = new ProfileId(name.hashCode()+((int)(Math.random()*10)*age));
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

    @Override
    public String toString() {
        return "Profile ["+name+", "+age+"]";
    }
}
