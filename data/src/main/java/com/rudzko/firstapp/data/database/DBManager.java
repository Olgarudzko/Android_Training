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
        Log.d("Method called", "Data addPerson");
        Log.d(person.getName(), person.getCountry().getName());
        int id = 0;
        DataMyCountry country = null;
        List<DataMyCountry> list = getAllCountries();
        if (list != null || !list.isEmpty()) {
            for (DataMyCountry c : list) {
                if (c.getName().equals(person.getCountry().getName())) {
                    id = c.getId();
                    Log.d("Found country", country.getName());
                }
            }
            if (country == null) {
                addMyCountry(person.getCountry());
                Log.d("No such country in DB", "creating...");
                country = person.getCountry();
                id = list.size() + 1;
            }

        } else {
            addMyCountry(person.getCountry());
            Log.d("DB is empty", "creating country");
            country = person.getCountry();
            id = 1;
        }
//        if ((country = getCountryByCode(person.getCountry().getCode())) != null) {
//            id = country.getId();
//            Log.d("Country found in DB", country.getName() + ", id=" + country.getId());
//        } else {
//            addMyCountry(person.getCountry());
//            country = getCountryByCode(person.getCountry().getCode());
//            id = country.getId();
//            Log.d("Country created", country.getName() + ", id=" + country.getId());
//        }
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

    public List<DataMyCountry> getAllCountries() {
        Log.d("Method called", "Data getAllCountries");
        List<DataMyCountry> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM MyCountry", new String[]{});
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                DataMyCountry country = new DataMyCountry();
                country.setId(cursor.getInt(0));
                country.setName(cursor.getString(1));
                country.setCode(cursor.getString(2));
                list.add(country);
                Log.d("Country in DB", cursor.getString(1) + ", id=" + cursor.getInt(0));
            }
        } else {
            return null;
        }
        cursor.close();
        return list;
    }

    public DataMyCountry getCountryByCode(String code) {
        Log.d("Method called", "Data getCountryByCOde");
        Cursor cursor = null;
        DataMyCountry country = null;
        try {
            //cursor = database.rawQuery("SELECT * FROM MyCountry WHERE code=?", new String[]{code});
            cursor = database.rawQuery("SELECT * FROM MyCountry WHERE code='" + code + "'", new String[]{});
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                country = new DataMyCountry(cursor.getString(1), cursor.getString(2));
                country.setId(cursor.getInt(0));
                Log.d("Country from database", String.valueOf(country.getId()));
            } else {
                return null;
            }
        } catch (Exception e) {
            Log.e("Bad trial", e.toString());
        } finally {
            if (cursor != null) {
                cursor.close();
                Log.d("Country", country.getName() + ", " + country.getId());

            }
        }
        return country;
    }

    public List<DataPerson> getPersons() {
        Log.d("Method called", "Data getPersons");
        List<DataPerson> list = new ArrayList<>();
        Cursor cursor = null;
        try {
            cursor = database.rawQuery("SELECT * FROM person INNER JOIN MyCountry ON person.countryId=MyCountry.id", new String[]{});
            //  cursor = database.rawQuery("SELECT * FROM person", new String[]{});

            DataPerson person;
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    person = new DataPerson(cursor.getString(1), new DataMyCountry(cursor.getString(4), cursor.getString(5)));
//                    person = new DataPerson();
//                    person.setName(cursor.getString(1));
//                    person.setCountry(new DataMyCountry("Trial", "TR"));

                    person.setId(cursor.getInt(0));
                    list.add(person);
                    Log.d("Person found", cursor.getString(1)
                            + " from " + cursor.getString(4)
                    );
                    Log.d(person.getName(), person.getCountry().getName());
                }
            } else {
                Log.e("Tried to get Persons", "cursor is empty");
            }
        } finally {
            if (cursor != null) cursor.close();
        }

        database.rawQuery("DROP TABLE country", new String[]{});
        database.rawQuery("DROP TABLE person", new String[]{});

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
        } finally {
            if (cursor != null) cursor.close();
        }
        return null;
    }

    public void updateUser(User user) {

    }
}
