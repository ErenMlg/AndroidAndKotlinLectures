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
            val newIntent = Intent(this@GameActivity, ResultActivity::class.java)
//Finish remove this page on backstack when you press back button next activity return to start activity
            finish()
            startActivity(newIntent)
        }
    }
}