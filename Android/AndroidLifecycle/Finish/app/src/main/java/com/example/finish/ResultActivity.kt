package com.example.finish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finish.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityResultBinding.inflate(layoutInflater)
        setContentView(tasarim.root)
    }
}