package com.jobo.jobotaxi.jobobd.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Chamila on 21/09/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, "db_jabo", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String registerSQL = "CREATE TABLE IF NOT EXISTS tbl_register_info (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "isSynced INTEGER, "
                + "syncedTime Text, "
                + "logPerson Text, "
                + "logEmail Text, "
                + "logPassword Text, "
                + "logMobile Text)";
        sqLiteDatabase.execSQL(registerSQL);

        String hireStatusSQL = "CREATE TABLE IF NOT EXISTS tbl_hire_info (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "isSynced INTEGER, "
                + "syncedTime Text, "
                + "hireStatus Text, "
                + "assignedDriver Text, "
                + "startLat Text, "
                + "startLng Text, "
                + "endLat Text, "
                + "endLng Text)";
        sqLiteDatabase.execSQL(hireStatusSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void saveMobileNo(String mobileNo) {
        long yourmilliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date resultdate = new Date(yourmilliseconds);

        ContentValues c = new ContentValues();
        c.put("syncedTime", sdf.format(resultdate));
        c.put("logMobile", mobileNo);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("tbl_register_info", "", c);
        db.close();
        Log.d("DB", "New Mobile Number Saved");
    }

    public String getMobileNo() {
        String mobileNo = "";
        String countQuery = "SELECT * FROM tbl_register_info";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        if (cursor.moveToFirst()) {
            mobileNo = cursor.getString(cursor.getColumnIndex("logMobile"));
        }
        db.close();
        return mobileNo;

    }


    public void updatePersonalData(String personName, String personEmail, String personPass, String mobileNo) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues c = new ContentValues();
        c.put("logPerson", personName);
        c.put("logEmail", personEmail);
        c.put("logPassword", personPass);
        db.update("tbl_register_info", c, "logMobile =" + mobileNo, null);
        db.close();
    }

    public int getUserRowCount() {
        String countQuery = "SELECT * FROM tbl_register_info WHERE logMobile != '' ";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int cnt = cursor.getCount();
        cursor.close();
        return cnt;
    }


}
