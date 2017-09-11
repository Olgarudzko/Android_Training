package com.rudzko.firstapp.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * @author Olga Rudzko
 */

class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="TEST";
    private static final int VERSION=1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        Log.d("DBhElper", "onCreate");
        database.execSQL("CREATE TABLE IF NOT EXISTS user ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'name' TEXT, 'age' INTEGER, 'countryId' INTEGER)");
        database.execSQL("CREATE TABLE IF NOT EXISTS country ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' TEXT)");
        database.execSQL("CREATE TABLE IF NOT EXISTS person ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'name' TEXT, 'countryId' INTEGER)");
        database.execSQL("CREATE TABLE IF NOT EXISTS MyCountry ('id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'name' TEXT, 'code' TEXT)");
//        database.beginTransaction();
//                the block which should be executed entirely or not executed at all
//        database.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.d("DBhElper", "onUpgrade");

    }
}
