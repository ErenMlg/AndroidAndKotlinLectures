package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = DataBindingUtil.setContentView(this,R.layout.activity_main)

        tasarim.toplaButton.setOnClickListener {
            val alinansayi1 = sayi1.text.toString()
            val alinansayi2 = sayi2.text.toString()

            val sayi1= alinansayi1.toInt()
            val sayi2= alinansayi2.toInt()

            val toplam = sayi1+sayi2
            sonuc.text=toplam.toString()
        }

        tasarim.cikarButton.setOnClickListener {
            val alinansayi1 = sayi1.text.toString()
            val alinansayi2 = sayi2.text.toString()

            val sayi1= alinansayi1.toInt()
            val sayi2= alinansayi2.toInt()

            var toplam=0
            if (sayi2>sayi1){
                toplam = sayi2-sayi1
            }else{
                toplam = sayi1-sayi2
            }
            sonuc.text=toplam.toString()
        }

        tasarim.carpButton.setOnClickListener {
            val alinansayi1 = sayi1.text.toString()
            val alinansayi2 = sayi2.text.toString()

            val sayi1= alinansayi1.toInt()
            val sayi2= alinansayi2.toInt()

            val toplam = sayi1*sayi2
            sonuc.text=toplam.toString()
        }

        bolButton.setOnClickListener{
            val alinansayi1 = sayi1.text.toString()
            val alinansayi2 = sayi2.text.toString()

            val sayi1= alinansayi1.toInt()
            val sayi2= alinansayi2.toInt()

            var toplam=0
            if (sayi2>sayi1){
                toplam = sayi2/sayi1
            }else{
                toplam = sayi1/sayi2
            }
            sonuc.text=toplam.toString()
        }

    }
}