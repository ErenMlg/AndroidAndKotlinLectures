package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toplaButton.setOnClickListener {
            val alinansayi1 = sayi1.text.toString()
            val alinansayi2 = sayi2.text.toString()

            val sayi1= alinansayi1.toInt()
            val sayi2= alinansayi2.toInt()

            val toplam = sayi1+sayi2
            sonuc.text=toplam.toString()
        }

        cikarButton.setOnClickListener {
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

        carpButton.setOnClickListener {
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