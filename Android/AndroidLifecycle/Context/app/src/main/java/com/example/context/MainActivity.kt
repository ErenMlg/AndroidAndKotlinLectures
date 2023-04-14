package com.example.context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.context.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainTasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainTasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainTasarim.root)

        mainTasarim.button.setOnClickListener {

            Toast.makeText(this,"Merhaba",Toast.LENGTH_SHORT).show()
            //Toast.makeText(this@MainActivity,"Merhaba",Toast.LENGTH_SHORT).show()
            //Toast.makeText(applicationContext,"Merhaba",Toast.LENGTH_SHORT).show()

        }
    }
}