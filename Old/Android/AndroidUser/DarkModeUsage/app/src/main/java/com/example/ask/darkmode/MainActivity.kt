package com.example.ask.darkmode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.ask.darkmode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim= ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)
        tasarim.aydinlikBtn.setOnClickListener{
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        }
        tasarim.karanlikBtn.setOnClickListener {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
        }
    }
}