package com.example.ask.snackbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ask.snackbar.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var tasarim:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

        tasarim.normalBtn.setOnClickListener {view -> // Bu view buttonNormali temsil ediyor.
            Snackbar.make(view,"Merhaba",Snackbar.LENGTH_SHORT).show()
        }
        tasarim.geriDonusBtn.setOnClickListener {view ->
            Snackbar.make(view,"Mesaj Silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){ // Buton ekleme işlemi yapar
                    Snackbar.make(it,"Silindi",Snackbar.LENGTH_SHORT).show()
                }.show()
        }
        tasarim.ozelBtn.setOnClickListener {view ->

            val sb = Snackbar.make(view,"İnternet bağlantınız yok...",Snackbar.LENGTH_SHORT)
            sb.setAction("Tekrar Dene"){}
            sb.setActionTextColor(Color.RED) // Butonun rengini değiştirir
            sb.setTextColor(Color.WHITE) // Mesajın rengini değiştirir
            sb.setBackgroundTint(Color.GRAY) // Arka plan rengini değiştirir
            sb.show()
        }
    }
}