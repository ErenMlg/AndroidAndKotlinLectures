package com.example.ask.hazirveritabanikullanma

class filmlerdao {

    fun tumFilmler(dbH:DataBaseHelper):ArrayList<filmler>{

        var filmlerListesi = ArrayList<filmler>()
        val db = dbH.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM filmler,kategoriler,yonetmenler WHERE filmler.kategori_id = " +
                "kategoriler.kategori_id AND filmler.yonetmen_id = yonetmenler.yonetmen_id",null)
        while(cursor.moveToNext()){
            var yonetmen = yonetmenler(cursor.getInt(cursor.getColumnIndexOrThrow("yonetmen_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("yonetmen_ad")))

            var kategori = kategoriler(cursor.getInt(cursor.getColumnIndexOrThrow("kategori_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("kategori_ad")))

            var film = filmler(cursor.getInt(cursor.getColumnIndexOrThrow("film_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("film_ad")),
                cursor.getInt(cursor.getColumnIndexOrThrow("film_yil")),
                cursor.getString(cursor.getColumnIndexOrThrow("film_resim")),
                kategori,yonetmen)

            filmlerListesi.add(film)
        }
        return filmlerListesi
    }

}