package com.example.ask.hazirveritabanikullanma

import android.content.Context

class kategorilerdao {

    fun tumKategoriler(dbH:DataBaseHelper):ArrayList<kategoriler>{

        var kategoriListesi = ArrayList<kategoriler>()
        val db = dbH.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM kategoriler",null)
        while(cursor.moveToNext()){
            var kategori = kategoriler(cursor.getInt(cursor.getColumnIndexOrThrow("kategori_id")),cursor.getString(cursor.getColumnIndexOrThrow("kategori_ad")))
            kategoriListesi.add(kategori)
        }
        return kategoriListesi
    }

}