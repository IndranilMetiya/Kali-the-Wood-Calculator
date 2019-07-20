package com.example.indra.woodcalculator;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.jar.Attributes;

public class UserdbHelper extends SQLiteOpenHelper {

    private static  final  String DB_NAME="mywbut";
    private static final int DB_VERSION=1;

    private  static final String TABLE_NAME="users";

    private  static final String FIRST_COL="name";
    private  static final String SECOND_COL="email";
    private  static final String THIRD_COL="phone";
    private  static final String FORTH_COL="phone1";
    private  static final String FIFTH_COL="phone2";
    private  static final String SIXTH_COL="phone3";
    private  static final String SEVENTH_COL="phone4";


    private  static final  String CREATE_QUERY="CREATE TABLE " + TABLE_NAME + "(" + FIRST_COL
            + " text, " + SECOND_COL + " text, " + THIRD_COL + "  text, " + FORTH_COL + "  text, " + FIFTH_COL + "  text, " + SIXTH_COL + "  text, " + SEVENTH_COL + "  text);";


    public UserdbHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
        Log.i("DB Message","Data base create ho gaya");

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.i("DB Message","Table create ho gaya");

    }
    public void inertData(String input1, String input2, String input3,String input4,String input5, String input6, String input7,
                          SQLiteDatabase db)
    {

        ContentValues content=new ContentValues();
        content.put(FIRST_COL, input1);
        content.put(SECOND_COL, input2);
        content.put(THIRD_COL, input3);
        content.put(FORTH_COL, input4);
        content.put(FIFTH_COL, input5);
        content.put(SIXTH_COL, input6);
        content.put(SEVENTH_COL, input7);

        db.insert(TABLE_NAME,null,content);
        Log.i("DB Message","row inserted");
    }

    public Cursor viewData(SQLiteDatabase db)
    {
        Cursor c=db.rawQuery("SELECT * FROM " + TABLE_NAME,null);

        return c;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}