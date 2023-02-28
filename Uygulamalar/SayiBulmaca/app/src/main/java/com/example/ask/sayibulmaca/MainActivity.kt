package com.example.ask.sayibulmaca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.ask.sayibulmaca.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainDesign:ActivityMainBinding
    var guessValue=0
    var right = 5;
    var randomInt = (0..100).random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainDesign = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainDesign.root)

        mainDesign.tahminBtn.setOnClickListener {
            guessValue = mainDesign.sayiGirisi.text.toString().toInt()
            if((right-1)!=0){
                if(randomInt>guessValue){
                    mainDesign.kontrolText.text="Arttır"
                    mainDesign.kontrolText.setTextColor(ContextCompat.getColor(this,R.color.upColor))
                    right--
                    mainDesign.hakSayisi.text="Kalan Hak $right"
                }else if(randomInt<guessValue){
                    mainDesign.kontrolText.text="Azalt"
                    mainDesign.kontrolText.setTextColor(ContextCompat.getColor(this,R.color.downColor))
                    right--
                    mainDesign.hakSayisi.text="Kalan Hak $right"
                }else{
                    mainDesign.kontrolText.text="Doğru Bildiniz Tebriklerr..."
                    mainDesign.kontrolText.setTextColor(ContextCompat.getColor(this,R.color.PrimaryColor))
                }
            }else{
                mainDesign.hakSayisi.text="Kalan Hak 0"
                mainDesign.kontrolText.text="Bilemediniz...\nDoğru cevap = $randomInt"
                mainDesign.kontrolText.setTextColor(ContextCompat.getColor(this,R.color.PrimaryColor))
                mainDesign.restartBtn.isVisible=true
                mainDesign.textView3.isVisible=false
            }
        }

        mainDesign.restartBtn.setOnClickListener {
            finish()
            startActivity(intent)
        }

    }
}