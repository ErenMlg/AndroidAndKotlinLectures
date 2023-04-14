package com.example.finish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finish.databinding.ActivityGameBinding
import com.example.finish.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tasarim.root)
        tasarim.startBtn.setOnClickListener {
            val yeniIntent = Intent(this@MainActivity,GameActivity::class.java)
            startActivity(yeniIntent)
        }

    }
}