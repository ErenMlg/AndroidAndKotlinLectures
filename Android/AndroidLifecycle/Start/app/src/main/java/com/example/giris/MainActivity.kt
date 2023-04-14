package com.example.giris

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // 1. Yöntem
    private lateinit var benimTextView:TextView
    private lateinit var benimButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        benimButton = findViewById(R.id.myButton)
        benimTextView = findViewById(R.id.myTextView)

        benimButton.setOnClickListener {
            benimTextView.text="Merhaba"
        }


    }
}