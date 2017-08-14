package com.rudzko.firstapp.hw_7;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.rudzko.firstapp.BR;

/**
 * @author Olga Rudzko
 */


public class User extends BaseObservable {

    private String photo;
    private int birthYear;
    private String name;
    private boolean male;

    public User() {
    }

    void setPhoto(String photo) {
        this.photo = photo;
        notifyPropertyChanged(BR.photo);
    }

    void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
        notifyPropertyChanged(BR.birthYear);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    void setMale(boolean male) {
        this.male = male;
        notifyPropertyChanged(BR.male);
    }

    @Bindable
    public String getPhoto() {
        return photo;
    }

    @Bindable
    public int getBirthYear() {
        return birthYear;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public boolean isMale() {
        return male;
    }

    public User(String url, int birthYear, String name, boolean male) {

        this.photo = url;
        this.birthYear = birthYear;
        this.name = name;
        this.male = male;
    }

}
