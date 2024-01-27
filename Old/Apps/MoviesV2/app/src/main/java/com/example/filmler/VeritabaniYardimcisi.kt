package com.example.filmler

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi(context: Context) :
    SQLiteOpenHelper(context, "filmler.sqlite", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "CREATE TABLE IF NOT EXISTS \"filmler\" (\n" +
                    "\t`film_id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "\t`film_ad`\tTEXT,\n" +
                    "\t`film_yil`\tINTEGER,\n" +
                    "\t`film_resim`\tTEXT,\n" +
                    "\t`kategori_id`\tINTEGER,\n" +
                    "\t`yonetmen_id`\tINTEGER,\n" +
                    "\tFOREIGN KEY(`kategori_id`) REFERENCES `kategoriler`(`kategoril_id`),\n" +
                    "\tFOREIGN KEY(`yonetmen_id`) REFERENCES `yonetmenler`(`yonetmen_id`)\n" +
                    ")"
        )
        db?.execSQL(
            "CREATE TABLE IF NOT EXISTS kategoriler  (\n" +
                    "kategori_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "kategori_ad TEXT\n" +
                    ")"
        )
        db?.execSQL(
            "CREATE TABLE IF NOT EXISTS yonetmenler  (\n" +
                    "yonetmen_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "yonetmen_ad TEXT\n" +
                    ")"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS filmler")
        db?.execSQL("DROP TABLE IF EXISTS kategoriler")
        db?.execSQL("DROP TABLE IF EXISTS yonetmenler")
        onCreate(db)

    }
}