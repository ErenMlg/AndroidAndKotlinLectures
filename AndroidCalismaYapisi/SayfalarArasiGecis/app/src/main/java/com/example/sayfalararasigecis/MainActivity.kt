package com.example.sayfalararasigecis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goToBButton.setOnClickListener {

            val yeniIntent = Intent(this@MainActivity,ActivityB::class.java)
            startActivity(yeniIntent)

        }

    }
}