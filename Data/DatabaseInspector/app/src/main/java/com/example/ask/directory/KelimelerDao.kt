package com.example.ask.directory

import android.provider.ContactsContract.Data

class KelimelerDao {

    fun kelimeleriGetir(dbh: DatabaseHelper):ArrayList<Kelimeler>{
        var KelimeList = ArrayList<Kelimeler>()
        var db = dbh.writableDatabase
        var cursor = db.rawQuery("SELECT * FROM kelimeler",null)
        while (cursor.moveToNext()){
            var kelime = Kelimeler(cursor.getInt(cursor.getColumnIndexOrThrow("kelime_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("ingilizce")),
                cursor.getString(cursor.getColumnIndexOrThrow("turkce")))
            KelimeList.add(kelime)
        }
        return KelimeList
    }


    fun kelimeAra(dbh: DatabaseHelper, aramaKelime:String) : ArrayList<Kelimeler>{
        var KelimeList = ArrayList<Kelimeler>()
        var db = dbh.writableDatabase
        var cursor = db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%$aramaKelime%' OR turkce like '%$aramaKelime%' ",null)
        while (cursor.moveToNext()){
            var kelime = Kelimeler(cursor.getInt(cursor.getColumnIndexOrThrow("kelime_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("ingilizce")),
                cursor.getString(cursor.getColumnIndexOrThrow("turkce")))
            KelimeList.add(kelime)
        }
        return KelimeList
    }

}