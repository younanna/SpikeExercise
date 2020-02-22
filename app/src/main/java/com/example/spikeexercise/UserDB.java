package com.example.spikeexercise;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.util.Log;
import android.widget.Toast;

public class UserDB extends SQLiteOpenHelper {

    private static final String USERID ="id";
    private static final String USERPW ="pw";
    private static final String USERNAME ="username";
    private static final String USERINTRO ="intro";

    private static final String TABLENAME = "myUsers";
    private static final int VERSION = 1;

    SQLiteDatabase mainDB;
    Cursor cursor;

//    public UserDB (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name. factory, version);
//    }


    public UserDB (Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /* executed only when there is no table */
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("tag", "CREATE DB");
        this.mainDB = db;
        createTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    /* create user table */
    public void createTable() {
        try {
            String sql = "CREATE TABLE " + TABLENAME + "(id text PRIMARY KEY, pw text, username text, intro text)";
            mainDB.execSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* insert id and password into the main database */
    public void insertSignin(String id, String pw, String username, String intro) {
        Log.i("tag", "INSERT USER");
        getReadableDatabase().beginTransaction();
        try {
            String sql = "INSERT INTO " + TABLENAME + " (id, pw, username, intro) " +
                        "VALUES('" + id + "','" + pw + "','" + username + "','" + intro + "');";
            mainDB.execSQL(sql);
            mainDB.setTransactionSuccessful();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            mainDB.endTransaction();
        }
    }

    /* bring database to write on it */
    public Cursor getCursor(String sql) {
        // get database
        mainDB = this.getWritableDatabase();

        try{
            // store the result of executing sql parameter
            cursor = mainDB.rawQuery(sql, null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return cursor;
    }

    /* getter methods */


    public static String getTableName() {return TABLENAME; }
    public static int getVersion() {
        return VERSION;
    }

    /* check if id exist in database */
    public boolean checkID(String id) {
        String sql = "SELECT id FROM " + TABLENAME + " WHERE id = '" + id + "'";
        cursor = getCursor(sql);

        if (cursor.getCount() != 1) {
            return false;
        }

        // there is matching id
        return true;
    }

    /* check if password for corresponding id is correct */
    public boolean checkPW(String id, String pw) {
        String sql = "SELECT pw FROM " + TABLENAME + " WHERE id = '" + id + "'";

        cursor = getCursor(sql);
        cursor.moveToNext();

        if (!pw.equals(cursor.getString(0))) {
            return false;
        }

        // password is correct
        return true;
    }

    /* check if id and/or pw is empty or not */
    public boolean checkEmptyIDandPW (String id, String pw) {
        if(id.length() == 0 || pw.length() == 0) {
            return false;
        }
        // one of id&pw is or both are empty
        return true;
    }


    /* use to login */
    public boolean checkLogin (Context context, String id, String pw) {
        // there is no id or password entered from user
        if(!checkEmptyIDandPW(id, pw)) {
            Toast.makeText(context,
                    "LoginError\nPlease enter ID or password.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // user entered ID does not exist in database
        if(!checkID(id)) {
            Toast.makeText(context,
                    "LoginError\nID does not exist.", Toast.LENGTH_SHORT).show();
            return false;
        }

        // user entered wrong password
        if(!checkPW(id,pw)) {
            Toast.makeText(context,
                    "LoginError\nWrong password.", Toast.LENGTH_SHORT).show();
            return false;
        }

        cursor.close();
        // login success
        return true;
    }

    /* Signin checking */
    public boolean checkSignin(Context context, String id, String pw, String username, String intro) {
        if(id.length() == 0 && pw.length() == 0 && username.length() == 0 && intro.length() == 0) {
            Toast.makeText(context,
                    "SignInError\nPlease enter all the user information.", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(checkID(id)) {
            Toast.makeText(context,
                    "SignInError\nEntered ID already exists.", Toast.LENGTH_SHORT).show();
            return false;
        }

        cursor.close();

        insertSignin(id,pw,username, intro);

        // success to sign in
        return true;
    }


    /* update profile */
    public boolean checkUpdateProfile(Context context, String id, String username, String intro, String updatedPW) {

        if(username.length() == 0 || intro.length() == 0 || updatedPW.length() == 0) {
            Toast.makeText(context, "UpdateError\nPlease fill in all the  blank.", Toast.LENGTH_SHORT).show();
            return false;
        }


        cursor.close();

        update(id, username, intro, updatedPW);



        // update profile
        return true;

    }


    /* update value */

    public void update(String id, String username, String intro, String updatePW) {

        Log.i("tag", "UPDATE USER");
        getReadableDatabase().beginTransaction();
        try {
            String sql = "UPDATE " + TABLENAME + " SET username = '" + username + "', intro = '"
                    + intro + "', pw = '" + updatePW + "' WHERE id = '" + id + "';";
            mainDB.execSQL(sql);
            mainDB.setTransactionSuccessful();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            mainDB.endTransaction();
        }

    }


    /* get profile information */

    public String[] getProfile(String id) {

        String sql = "SELECT * FROM " + TABLENAME + " WHERE id = '" + id + "'";
        cursor = mainDB.rawQuery(sql, null);

        String[] profile = new String[4];
        if(cursor.getCount()>0){
            while(cursor.moveToNext()){

                profile[0] = cursor.getString(0);
                profile[1] = cursor.getString(1);
                profile[2] = cursor.getString(2);
                profile[3] = cursor.getString(3);

            }
        }


        // there is matching id
        return profile;

    }








}
