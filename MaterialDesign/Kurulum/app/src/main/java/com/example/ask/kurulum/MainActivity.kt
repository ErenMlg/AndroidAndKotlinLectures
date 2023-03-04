package com.example.ask.kurulum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ask.kurulum.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var design:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design= ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)
        design.fab.setOnClickListener{
            Toast.makeText(this@MainActivity,"Selam",Toast.LENGTH_SHORT).show()
        }
    }
}