package com.example.notapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi(context:Context) : SQLiteOpenHelper(context,"notlar",null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE notlar" +
                "(not_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "ders_adi TEXT," +
                "not1 INTEGER," +
                "not2 INTEGER);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS notlar")
        onCreate(db)
    }
}