package com.example.ask.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ask.sharedpreferences.databinding.ActivityBBinding
import com.example.ask.sharedpreferences.databinding.ActivityMainBinding

class ActivityB : AppCompatActivity() {

    lateinit var designB:ActivityBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        designB= ActivityBBinding.inflate(layoutInflater)
        setContentView(designB.root)

        val sp = getSharedPreferences("Kişisel Bilgiler", Context.MODE_PRIVATE)
        val ad = sp.getString("ad","İsimsiz")
        val yas = sp.getInt("yas",0)
        val boy = sp.getFloat("boy",0.00f)
        val medeniHal = sp.getBoolean("bekarMi",true)
        val arkadasListesi = sp.getStringSet("arkadasListesi",null)
        //Verileri okuma

        Log.e("Bilgilier","$ad $yas $boy $medeniHal")
        if(arkadasListesi != null){
            for (isim in arkadasListesi){
                Log.e("Arakadaş",isim)
            }
        }
    }
}