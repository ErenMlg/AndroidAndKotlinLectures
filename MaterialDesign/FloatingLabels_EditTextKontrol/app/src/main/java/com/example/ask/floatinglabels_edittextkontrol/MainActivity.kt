package com.example.ask.floatinglabels_edittextkontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.example.ask.floatinglabels_edittextkontrol.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var design:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)

        design.button.setOnClickListener {

            val ad = design.adTxt.text.toString().trim()
            val tel = design.telTxt.text.toString().trim()

            if(TextUtils.isEmpty(ad)){
                Toast.makeText(this@MainActivity,"Ad Boş",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(tel)){
                Toast.makeText(this@MainActivity,"Tel Boş",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(tel.length<6){
                Toast.makeText(this@MainActivity,"Tel 6 haneden çok olmalıdır",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(this@MainActivity,"Adınız: $ad\nTeliniz: $tel",Toast.LENGTH_SHORT).show()

        }
    }
}