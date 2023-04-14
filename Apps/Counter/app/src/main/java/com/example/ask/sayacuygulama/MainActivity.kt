package com.example.ask.sayacuygulama

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ask.sayacuygulama.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var design: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design= ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)

        val sp = getSharedPreferences("GirisSayici", Context.MODE_PRIVATE)
        var sayac = sp.getInt("sayac",0)
        val editor = sp.edit()
        editor.putInt("sayac",++sayac);
        editor.commit()
        design.textView.text="Açılış Sayısı : $sayac"



    }
}