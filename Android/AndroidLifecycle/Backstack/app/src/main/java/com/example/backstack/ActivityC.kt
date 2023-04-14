package com.example.backstack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_b.*
import kotlinx.android.synthetic.main.activity_c.*

class ActivityC : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        Siparis1Button.setOnClickListener {
            val intent = Intent(this@ActivityC, ActivityD::class.java)
            startActivity(intent)
        }
    }
}