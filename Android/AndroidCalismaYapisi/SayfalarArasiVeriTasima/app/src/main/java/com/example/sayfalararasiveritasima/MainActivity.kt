package com.example.sayfalararasiveritasima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sendButton.setOnClickListener {
            val girdi = girdiText.text.toString()
            val yeniIntent = Intent(this@MainActivity,ActivityB::class.java)
            yeniIntent.putExtra("mesaj","merhaba")
            yeniIntent.putExtra("girdi",girdi)
            yeniIntent.putExtra("yas",21)
            yeniIntent.putExtra("boy",1.67)

            startActivity(yeniIntent)
        }
    }
}