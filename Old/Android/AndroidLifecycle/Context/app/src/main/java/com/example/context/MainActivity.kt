package com.example.context

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.context.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Context indicates location...

        binding.button.setOnClickListener {
            Toast.makeText(this,"Hi",Toast.LENGTH_SHORT).show()
            //Toast.makeText(this@MainActivity,"Hi",Toast.LENGTH_SHORT).show()
            //Toast.makeText(applicationContext,"Hi",Toast.LENGTH_SHORT).show()

        }
    }
}