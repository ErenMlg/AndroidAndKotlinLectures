package com.example.ask.sayac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ask.sayac.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var desingBase:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        desingBase = ActivityMainBinding.inflate(layoutInflater)
        setContentView(desingBase.root)

        val ap = AppPref(this)
        val job = CoroutineScope(Dispatchers.Main).launch {
            var sayacSayisi = ap.sayacOku()
            ap.sayacEkle(++sayacSayisi)
            desingBase.sayacTxt.text = "Giriş Sayısı : $sayacSayisi"
        }

    }
}