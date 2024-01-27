package com.example.notapp

import android.content.ContentValues

class NotlarDao {

    fun notEKle(vty:VeritabaniYardimcisi, ders_adi:String, not1:Int, not2:Int){
        val db = vty.writableDatabase
        val values = ContentValues()
        values.put("ders_adi",ders_adi)
        values.put("not1",not1)
        values.put("not2",not2)
        db.insertOrThrow("notlar",null,values)
        db.close()
    }

    fun notDuzenle(vty:VeritabaniYardimcisi, not_id:Int, ders_adi:String, not1:Int, not2:Int){
        val db = vty.writableDatabase
        val values = ContentValues()
        values.put("ders_adi",ders_adi)
        values.put("not1",not1)
        values.put("not2",not2)
        db.update("notlar",values,"not_id=?", arrayOf(not_id.toString()))
        db.close()
    }

    fun notSil(vty:VeritabaniYardimcisi, not_id:Int){
        val db = vty.writableDatabase
        db.delete("notlar","not_id=?", arrayOf(not_id.toString()))
        db.close()
    }

    fun notGetir(vty:VeritabaniYardimcisi) : ArrayList<Notlar>{
        val not_listesi = ArrayList<Notlar>()
        val db = vty.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM notlar",null)

        while (cursor.moveToNext()){
            val ders = Notlar(cursor.getInt(cursor.getColumnIndexOrThrow("not_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("ders_adi")),
                cursor.getInt(cursor.getColumnIndexOrThrow("not1")),
                cursor.getInt(cursor.getColumnIndexOrThrow("not2")))
            not_listesi.add(ders)
        }
        return not_listesi
    }
}