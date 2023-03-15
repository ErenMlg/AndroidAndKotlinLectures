package com.example.ask.bayrakquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ask.bayrakquiz.databinding.ActivityMainBinding
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {

    lateinit var mainDesign:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainDesign = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainDesign.root)
        veritabaniKopyala()

        mainDesign.startBtn.setOnClickListener{
            startActivity(Intent(this@MainActivity,QuizActivity::class.java))
            finish()
        }

    }

    fun veritabaniKopyala(){
        val copyHelper = DatabaseCopyHelper(this)
        try {

            copyHelper.createDataBase()
            copyHelper.openDataBase()

        }catch (e:java.lang.Exception){
            e.printStackTrace()
        }
    }

}