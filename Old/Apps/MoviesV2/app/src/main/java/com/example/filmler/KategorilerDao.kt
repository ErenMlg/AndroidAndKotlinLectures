package com.example.filmler

class KategorilerDao {

    fun tumKategoriler(vt: VeritabaniYardimcisi): ArrayList<Kategoriler> {
        val db = vt.writableDatabase
        val kategoriList = ArrayList<Kategoriler>()
        val cursor = db.rawQuery("SELECT * FROM kategoriler", null)
        while (cursor.moveToNext()) {
            val kategori = Kategoriler(
                cursor.getInt(cursor.getColumnIndexOrThrow("kategori_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("kategori_ad"))
            )
            kategoriList.add(kategori)
        }
        cursor.close()
        db.close()
        return kategoriList
    }

}