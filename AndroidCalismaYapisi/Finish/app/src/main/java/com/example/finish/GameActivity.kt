package com.example.finish

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.finish.databinding.ActivityGameBinding

class GameActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivityGameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityGameBinding.inflate(layoutInflater)
        setContentView(tasarim.root)
        tasarim.finishBtn.setOnClickListener {
            val yeniIntent = Intent(this@GameActivity,ResultActivity::class.java)
            finish()
            startActivity(yeniIntent)
        }
    }
}