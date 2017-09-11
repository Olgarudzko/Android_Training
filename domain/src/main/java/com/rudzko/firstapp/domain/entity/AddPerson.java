package com.rudzko.firstapp.domain.entity;

import android.content.Context;

/**
 * @author Olga Rudzko
 */

public class AddPerson {

    private Context context;
    private Person person;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
