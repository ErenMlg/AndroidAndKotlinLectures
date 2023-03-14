package com.example.ask.vertabani

import android.content.ContentValues

class Kisilerdao {

    fun kisiEKle(vt: VeritabaniYardimcisi, ad: String, yas: Int, boy: Double, tel: String) {

        val usedDb = vt.writableDatabase
        //Yazma yetkisi verdik

        val values = ContentValues()

        values.put("kisi_ad", ad)
        values.put("kisi_tel", tel)
        values.put("kisi_yas", yas)
        values.put("kisi_boy", boy)

        usedDb.insertOrThrow("kisiler", null, values)
        usedDb.close()
    }

    fun tumKisiler(vt: VeritabaniYardimcisi): ArrayList<Kisiler> {

        val kisilerList = ArrayList<Kisiler>()
        val usedDb = vt.writableDatabase
        val cursor = usedDb.rawQuery("SELECT * FROM kisiler", null)
        // selectionArgs: Where diyip kişi adı kullanıcaksak arguman olarak ekleyebiliyoruz.

        while (cursor.moveToNext()) {
            val kisi = Kisiler(
                cursor.getInt(cursor.getColumnIndexOrThrow("kisi_no")),
                cursor.getString(cursor.getColumnIndexOrThrow("kisi_ad")),
                cursor.getInt(cursor.getColumnIndexOrThrow("kisi_yas")),
                cursor.getDouble(cursor.getColumnIndexOrThrow("kisi_boy")),
                cursor.getString(cursor.getColumnIndexOrThrow("kisi_tel")))

            kisilerList.add(kisi)
        }
        usedDb.close()
        return kisilerList
    }

    fun kisiAra(vt: VeritabaniYardimcisi, boy:Double): ArrayList<Kisiler> {

        val kisilerList = ArrayList<Kisiler>()
        val usedDb = vt.writableDatabase
        val cursor = usedDb.rawQuery("SELECT * FROM kisiler WHERE kisi_boy<?", arrayOf(boy.toString()))

        while (cursor.moveToNext()) {
            val kisi = Kisiler(
                cursor.getInt(cursor.getColumnIndexOrThrow("kisi_no")),
                cursor.getString(cursor.getColumnIndexOrThrow("kisi_ad")),
                cursor.getInt(cursor.getColumnIndexOrThrow("kisi_yas")),
                cursor.getDouble(cursor.getColumnIndexOrThrow("kisi_boy")),
                cursor.getString(cursor.getColumnIndexOrThrow("kisi_tel")))

            kisilerList.add(kisi)
        }
        usedDb.close()
        return kisilerList
    }

    fun kisiGuncelle(vt:VeritabaniYardimcisi, no:Int, ad: String, yas: Int, boy: Double, tel: String){

        val usedDb = vt.writableDatabase
        val values = ContentValues()

        values.put("kisi_ad", ad)
        values.put("kisi_tel", tel)
        values.put("kisi_yas", yas)
        values.put("kisi_boy", boy)

        usedDb.update("kisiler",values,"kisi_no=?", arrayOf(no.toString()))
        usedDb.close()
    }

    fun kisiSil(vt:VeritabaniYardimcisi, no:Int){
        val usedDb = vt.writableDatabase
        usedDb.delete("kisiler","kisi_no=?", arrayOf(no.toString()))
        usedDb.close()

    }

    fun randomGetir(vt: VeritabaniYardimcisi, limit:Int): ArrayList<Kisiler> {

        val kisilerList = ArrayList<Kisiler>()
        val usedDb = vt.writableDatabase
        val cursor = usedDb.rawQuery("SELECT * FROM kisiler ORDER BY RANDOM() LIMIT ?", arrayOf(limit.toString()))

        while (cursor.moveToNext()) {
            val kisi = Kisiler(
                cursor.getInt(cursor.getColumnIndexOrThrow("kisi_no")),
                cursor.getString(cursor.getColumnIndexOrThrow("kisi_ad")),
                cursor.getInt(cursor.getColumnIndexOrThrow("kisi_yas")),
                cursor.getDouble(cursor.getColumnIndexOrThrow("kisi_boy")),
                cursor.getString(cursor.getColumnIndexOrThrow("kisi_tel")))

            kisilerList.add(kisi)
        }
        usedDb.close()
        return kisilerList
    }

    fun kayitSayisiAra(vt: VeritabaniYardimcisi, ad:String): Int {

        var sonuc = 0
        val usedDb = vt.writableDatabase
        val cursor = usedDb.rawQuery("SELECT COUNT(*) AS Sonuc FROM kisiler WHERE kisi_ad='$ad'", null)

        while (cursor.moveToNext()) {
           sonuc = cursor.getInt(cursor.getColumnIndexOrThrow("Sonuc"))
        }
        usedDb.close()
        return sonuc
    }
}