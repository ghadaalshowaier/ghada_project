package com.Ghada_project;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "DataStore2";

    public databaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    private static final String KEY_FIRSTNAME = "firstName";
    private static final String KEY_LASTNAME = "lastName";
    private static final String KEY_PHONENUMBER = "phoneNumber";
    private static final String KEY_EMAILADDRESS = "emailAddress";
    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_USER_TABLE = "CREATE TABLE User ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "firstName TEXT, "+
                "lastName TEXT,"+
                "phoneNumber TEXT ,"+
                "emailAddress TEXT )";

        // create books table
        db.execSQL(CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS User");

        this.onCreate(db);
    }

}
