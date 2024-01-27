package com.example.sayfalararasiveritasima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_b.*

class ActivityB : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val receivedMessage = intent.getStringExtra("mesaj")
        val receivedMessage2 = intent.getStringExtra("girdi")
        val receivedAge = intent.getIntExtra("yas",0)
        val receivedTall = intent.getDoubleExtra("boy",0.0)

        message.text = receivedMessage2

        Log.e("MESAJ",receivedMessage!!)
        Log.e("YAŞ",receivedAge.toString())
        Log.e("BOY",receivedTall.toString())

    }
}