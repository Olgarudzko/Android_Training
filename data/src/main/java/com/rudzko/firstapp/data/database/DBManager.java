package com.rudzko.firstapp.data.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.rudzko.firstapp.data.db_entity.Country;
import com.rudzko.firstapp.data.db_entity.DataMyCountry;
import com.rudzko.firstapp.data.db_entity.DataPerson;
import com.rudzko.firstapp.data.db_entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Olga Rudzko
 */

public class DBManager {

    private Context context;
    private DBHelper helper;
    private SQLiteDatabase database;

    public DBManager(Context context) {
        this.context = context;
        helper = new DBHelper(context);
    }

    public void openDB(boolean isWritable) {
        if (isWritable) database = helper.getWritableDatabase();
        else database = helper.getReadableDatabase();
    }

    public void closeDB() {
        if (database != null) {
            database.close();
        }
    }

    public void addUser(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO user ('name', 'age', 'countryId') ")
                .append("VALUES ('")
                .append(user.getName()).append("', ")
                .append(user.getAge()).append(", ")
                .append(user.getCountry().getId()).append(")");

        Log.d("InsertSQL", sb.toString());
        database.execSQL(sb.toString());
    }

    public void addPerson(DataPerson person) {

        int id = 0;
        DataMyCountry country;
        if ((country=getCountryByCode(person.getCountry().getCode()))!=null){
            id=country.getId();
        } else {
            addMyCountry(person.getCountry());
            country=getCountryByCode(person.getCountry().getCode());
            id=country.getId();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO person ('name', 'countryId') VALUES ('").append(person.getName())
                .append("', ").append(id).append(")");
        database.execSQL(sb.toString());
        Log.d("Adding person", sb.toString());
    }

    public void addMyCountry(DataMyCountry country) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO MyCountry ('name', 'code') VALUES ('").append(country.getName()).
                append("', '").append(country.getCode()).append("')");
        database.execSQL(sb.toString());
        Log.d("Adding country", sb.toString());
    }

    public DataMyCountry getCountryByCode(String code) {
        Cursor cursor = null;
        DataMyCountry country=null;
        try {
            cursor = database.rawQuery("SELECT * FROM MyCountry WHERE code=?", new String[]{code});
            if (cursor!=null){
                cursor.moveToFirst();
                country=new DataMyCountry(cursor.getString(1), cursor.getString(2));
                country.setId(cursor.getInt(0));
            } else {
                return null;
            }
        } finally {
            if (cursor != null) cursor.close();
        }
        return country;
    }

    public List<DataPerson> getPersons() {
        List<DataPerson> list = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = database.rawQuery("SELECT * FROM person INNER JOIN MyCountry ON person.countryId=MyCountry.id", new String[]{});
            DataPerson person;
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    person = new DataPerson(cursor.getString(1), new DataMyCountry(cursor.getString(3), cursor.getString(4)));
                    person.setId(cursor.getInt(0));
                    list.add(person);
                    Log.d("Person found", cursor.getString(1) + " from " + cursor.getString(3));
                }
            } else {
                Log.e("Tried to get Persons", "cursor is null");
            }
        } finally{
            if (cursor != null) cursor.close();
        }
        return list;
    }

    public User getUserById(int id) {
        Cursor cursor = null;
              try {
                  cursor = database.rawQuery("SELECT * FROM user INNER JOIN country ON " +
                          "user.countryId = country.id WHERE id=?", new String[]{String.valueOf(id)});
                  if (cursor != null) {
                      User user = new User();

                      cursor.moveToFirst();
                      int userId = cursor.getInt(0);
                      String name = cursor.getString(1);
                      int age = cursor.getInt(2);
                      int countryId = cursor.getInt(3);
                      String country = cursor.getString(4);

                      user.setName(name);
                      user.setAge(age);
                      user.setId(userId);
                      user.setCountry(new Country(countryId, country));
                      return user;
                  } else {
                      Log.e("ERROR", "CURSOR IS NULL");
                  }
              }finally {
                  if (cursor != null)  cursor.close();
              }
        return null;
    }

    public void updateUser(User user) {

    }
}
