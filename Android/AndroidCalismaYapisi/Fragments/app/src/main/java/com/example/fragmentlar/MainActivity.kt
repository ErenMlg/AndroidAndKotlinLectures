package com.example.fragmentlar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        val ft = fm.beginTransaction()

        ft.add(R.id.fragment_placeholder1,FirstFragment())
        ft.add(R.id.fragment_placeholder2,SecondFragment())

        ft.commit()

    }
}