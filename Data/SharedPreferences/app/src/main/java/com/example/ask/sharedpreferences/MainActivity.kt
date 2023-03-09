package com.example.ask.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ask.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var design:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design= ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)

        val sp = getSharedPreferences("Kişisel Bilgiler", Context.MODE_PRIVATE)
        //Dosya oluşturduk "Dosya Adı",Silinme önceliği(Mode.Private en son sil demek)

        val editor = sp.edit()

        val arkadasListesi = HashSet<String>()
        arkadasListesi.add("Muhammet")
        arkadasListesi.add("Aylin")
        arkadasListesi.add("Şule")
        arkadasListesi.add("Berat")
        arkadasListesi.add("Batuhan")
        arkadasListesi.add("Kadir")
        arkadasListesi.add("Erdem")
        arkadasListesi.add("Eyüp")

        editor.putString("ad","Eren")
        editor.putInt("yas",21)
        editor.putFloat("boy",1.68f)
        editor.putBoolean("bekarMi",false)
        editor.putStringSet("arkadasListesi",arkadasListesi)
        //verileri yollama

        editor.remove("ad")
        //Verileri silme

        editor.commit()
        // Kayıt işlemini gerçekleştiren komut olmazsa veriler kaydolmaz.

        design.git.setOnClickListener {
            startActivity(Intent(this@MainActivity,ActivityB::class.java))
        }
    }
}