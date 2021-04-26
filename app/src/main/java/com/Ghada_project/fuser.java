package com.Ghada_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class fuser  {

    private databaseHelper SQLitedb;
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;


    public fuser(Context context){
        SQLitedb=new databaseHelper(context);
    }


    public fuser(String firstName, String lastName,String phoneNumber,String emailAddress,Context context) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;

        SQLitedb=new databaseHelper(context);
    }
    public String toString() {
        return "FavoriteAnnouncement [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" +phoneNumber +",emailAddress=" + emailAddress +"]";
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    private static final String TABLE_User = "User";



    private static final String KEY_ID = "id";
    private static final String KEY_FIRSTNAME = "firstName";
    private static final String KEY_LASTNAME = "lastName";
    private static final String KEY_PHONENUMBER = "phoneNumber";
    private static final String KEY_EMAILADDRESS = "emailAddress";
    private static final String[] COLUMNS = {KEY_ID,KEY_FIRSTNAME,KEY_LASTNAME,KEY_PHONENUMBER,KEY_EMAILADDRESS};



    public void addFavoriteUser(fuser favoriteUser){
        SQLiteDatabase db = SQLitedb.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FIRSTNAME, favoriteUser.getFirstName());
        values.put(KEY_LASTNAME, favoriteUser.getLastName());
        values.put(KEY_PHONENUMBER, favoriteUser.getPhoneNumber());
        values.put(KEY_EMAILADDRESS, favoriteUser.getEmailAddress());

        db.insert(TABLE_User, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        db.close();
    }


    public ArrayList<fuser> getAllfavoriteUsers(Context context) {
        ArrayList<fuser> favoriteUsers = new ArrayList<fuser>();

        String query = "SELECT  * FROM " + TABLE_User;
        SQLiteDatabase db = SQLitedb.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        fuser favoriteUser = null;
        if (cursor.moveToFirst()) {
            do {
                favoriteUser = new fuser(context);
                favoriteUser.setId(Integer.parseInt(cursor.getString(0)));
                favoriteUser.setFirstName(cursor.getString(1));
                favoriteUser.setLastName(cursor.getString(2));
                favoriteUser.setPhoneNumber(cursor.getString(3));
                favoriteUser.setEmailAddress(cursor.getString(4));

                favoriteUsers.add(favoriteUser);
            } while (cursor.moveToNext());
        }
        return favoriteUsers;
    }





    public void deleteBook(fuser favoriteUser) {

        SQLiteDatabase db = SQLitedb.getWritableDatabase();

        db.delete(TABLE_User,
                KEY_ID+" = ?",
                new String[] { String.valueOf(favoriteUser.getId()) });

        db.close();
    }

    public int updateUser(fuser favoriteUser, int userId) {

        SQLiteDatabase db = SQLitedb.getWritableDatabase();

        ContentValues values = new ContentValues();



        values.put("firstName", favoriteUser.getFirstName());
        values.put("lastName", favoriteUser.getLastName());
        values.put("phoneNumber", favoriteUser.getPhoneNumber());
        values.put("emailAddress", favoriteUser.getEmailAddress());

        int i = db.update(TABLE_User, //table
                values, // column/value
                KEY_ID+" = ?", // selections
                new String[] { String.valueOf(userId) }); //selection args

        db.close();
        return i;
    }


}