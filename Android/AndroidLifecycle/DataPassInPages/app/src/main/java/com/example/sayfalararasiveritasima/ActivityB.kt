package com.example.sayfalararasiveritasima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val gelenMesaj = intent.getStringExtra("mesaj")
        val gelenMesaj2 = intent.getStringExtra("girdi")
        val gelenYas = intent.getIntExtra("yas",0)
        val gelenBoy = intent.getDoubleExtra("boy",0.0)

        textView2.text = gelenMesaj2

        Log.e("MESAJ",gelenMesaj!!)
        Log.e("YAŞ",gelenYas.toString())
        Log.e("BOY",gelenBoy.toString())

    }
}