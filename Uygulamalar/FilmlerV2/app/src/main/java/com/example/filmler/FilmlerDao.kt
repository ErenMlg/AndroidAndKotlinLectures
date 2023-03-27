package com.example.filmler

class FilmlerDao {

    fun kategoriyeGoreFilmler(vt: VeritabaniYardimcisi, kategori: Kategoriler?): ArrayList<Filmler> {
        val db = vt.writableDatabase
        val filmlerList = ArrayList<Filmler>()
        val cursor =
            db.rawQuery("SELECT * FROM filmler,yonetmenler WHERE filmler.kategori_id=${kategori?.kategori_id} AND filmler.yonetmen_id=yonetmenler.yonetmen_id", null)
        while (cursor.moveToNext()) {
            var yonetmen = Yonetmenler(
                cursor.getInt(cursor.getColumnIndexOrThrow("yonetmen_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("yonetmen_ad"))
            )

            var film = Filmler(
                cursor.getInt(cursor.getColumnIndexOrThrow("film_id")),
                cursor.getString(cursor.getColumnIndexOrThrow("film_ad")),
                cursor.getInt(cursor.getColumnIndexOrThrow("film_yil")),
                cursor.getString(cursor.getColumnIndexOrThrow("film_resim")),
                kategori,
                yonetmen,
            )

            filmlerList.add(film)
        }
        cursor.close()
        db.close()
        return filmlerList
    }

}