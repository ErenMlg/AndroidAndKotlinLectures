package com.example.ask.loginscreensharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ask.loginscreensharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var design: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        design= ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)
        val sp = getSharedPreferences("LoginInfo", Context.MODE_PRIVATE)
        val edit = sp.edit()



        design.loginBtn.setOnClickListener {
            val userName = design.userNameTxt.text.toString()
            val password = design.passTxt.text.toString()
            if(userName == "Eren" && password == "cerenimo12"){
                edit.putString("UserName",userName)
                edit.putString("Password",password)
                edit.commit()

                finish()
                startActivity(Intent(this@MainActivity,ActivityB::class.java))
            }else{
                Toast.makeText(this@MainActivity,"Hatalı Giriş.",Toast.LENGTH_SHORT).show()
            }
        }
    }
}