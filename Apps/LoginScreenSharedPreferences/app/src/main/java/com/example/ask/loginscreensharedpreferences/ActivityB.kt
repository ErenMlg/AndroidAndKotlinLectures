package com.example.ask.loginscreensharedpreferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ask.loginscreensharedpreferences.databinding.ActivityBBinding
import com.example.ask.loginscreensharedpreferences.databinding.ActivityMainBinding

class ActivityB : AppCompatActivity() {

    lateinit var designB: ActivityBBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        designB= ActivityBBinding.inflate(layoutInflater)
        setContentView(designB.root)

        val sp = getSharedPreferences("LoginInfo", Context.MODE_PRIVATE)
        val usrNm = sp.getString("UserName","Null")
        val psswrd = sp.getString("Password","Null")

        designB.infoTxt.text = "Kullanıcı adı : $usrNm\nŞifre : $psswrd"

    }
}