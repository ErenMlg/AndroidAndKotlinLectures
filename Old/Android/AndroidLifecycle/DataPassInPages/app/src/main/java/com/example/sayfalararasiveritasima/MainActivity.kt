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
            val input = input.text.toString()
            val newIntent = Intent(this@MainActivity,ActivityB::class.java)
            newIntent.putExtra("mesaj","merhaba")
            newIntent.putExtra("girdi",input)
            newIntent.putExtra("yas",21)
            newIntent.putExtra("boy",1.67)

            startActivity(newIntent)
        }
    }
}