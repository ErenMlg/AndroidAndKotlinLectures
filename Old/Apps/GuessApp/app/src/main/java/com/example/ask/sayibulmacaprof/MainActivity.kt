package com.example.ask.sayibulmacaprof

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ask.sayibulmacaprof.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var mainDesign:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainDesign = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainDesign.root)


        mainDesign.startBtn.setOnClickListener {
            startActivity(Intent(this@MainActivity,GuessActivity::class.java))
        }
    }
}