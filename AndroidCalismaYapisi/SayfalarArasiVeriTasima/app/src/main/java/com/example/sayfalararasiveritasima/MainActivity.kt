package com.example.sayfalararasiveritasima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val kisi = Kisiler(999999,"Eren",1.67)
        sendButton.setOnClickListener {
            val yeniIntent = Intent(this@MainActivity,ActivityB::class.java)

            yeniIntent.putExtra("mesaj","merhaba")
            yeniIntent.putExtra("yas",21)
            yeniIntent.putExtra("boy",1.67)
            yeniIntent.putExtra("kisi1",kisi)

            startActivity(yeniIntent)
        }
    }
}