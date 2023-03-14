package com.example.ask.hazirveritabanikullanma

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        copyDB()
        // Eklediğimiz veritabanını cihaza kopyaladığımız işlem
        val dbHelper = DataBaseHelper(this)
        val kategoriListesi = kategorilerdao().tumKategoriler(dbHelper)
        for (kategori in kategoriListesi){
            Log.e("kategori Ad  ",kategori.kategori_ad)
        }
        val filmlerListesi = filmlerdao().tumFilmler(dbHelper)
        for (film in filmlerListesi){
            Log.e("Film adı ",film.film_ad)
            Log.e("Film yılı ",film.film_yıl.toString())
            Log.e("Film resmi ",film.film_resim)
            Log.e("Film kategorisi ",film.kategori.kategori_ad)
            Log.e("Film yonetmeni ",film.yonetmen.yonetmen_ad)
        }

    }
    fun copyDB(){
        val dbch = DatabaseCopyHelper(this)
        try{
            dbch.createDataBase() // VT oluşturmak
            dbch.openDataBase() // VT açmak
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}