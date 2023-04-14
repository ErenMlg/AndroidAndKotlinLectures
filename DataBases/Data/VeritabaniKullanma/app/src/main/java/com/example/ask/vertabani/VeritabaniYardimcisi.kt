package com.example.ask.vertabani

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi(context:Context) : SQLiteOpenHelper(context,"rehber",null,1) {
    //Contextimiz, vt ismi, Qursor sınıfı(null = Varsayılan), versiyon numarası
    //Qursor veritabanından verileri okurken kullanılan bir yapı

    override fun onCreate(db: SQLiteDatabase?) {
        //Veritabanındaki tablolarımızı tanımladığımızi oluşturduğumuz yer

        db?.execSQL("CREATE TABLE kisiler " +
                "(kisi_no INTEGER PRIMARY KEY AUTOINCREMENT," +
                "kisi_ad TEXT," +
                "kisi_yas INTEGER," +
                "kisi_tel INTEGER," +
                "kisi_boy DOUBLE);")
        //Hata varsa çalışma (?)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        //Veritabanınad sorun olursa güncelleme yapacağımız yer

        db?.execSQL("DROP TABLE IF EXISTS kisiler")
        //Var olan tabloları sil tekrardan oluştur.
        onCreate(db)
    }

}