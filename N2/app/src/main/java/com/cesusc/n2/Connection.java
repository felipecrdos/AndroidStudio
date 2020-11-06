package com.cesusc.n2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class Connection extends SQLiteOpenHelper {

    private static final String name = "banco.db";
    private static final int version = 1;

    public Connection(Context context) {
        super(context, name, null, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table model(" +
                "id integer primary key autoincrement, " +
                "name varchar(50) not null, " +
                "diameter integer not null, " +
                "distance varchar(50) not null, " +
                "finder varchar(50) not null)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
