package com.example.ask.sayibulmacaprof

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ask.sayibulmacaprof.databinding.ActivityGuessBinding
import com.example.ask.sayibulmacaprof.databinding.ActivityMainBinding

class GuessActivity : AppCompatActivity() {

    lateinit var guessDesign:ActivityGuessBinding
    private var randomInt = 0
    private var right = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        guessDesign = ActivityGuessBinding.inflate(layoutInflater)
        setContentView(guessDesign.root)

        randomInt = (0..100).random()
        Log.e("Rastgele Sayı ",randomInt.toString())

        guessDesign.guessBtn.setOnClickListener {
            right-=1;
            val guess = guessDesign.sayiGirisi.text.toString().toInt()
            val intent = Intent(this@GuessActivity,ResultActivity::class.java)

            if(right==0){
                intent.putExtra("Result",false)
                finish()
                startActivity(intent)
                return@setOnClickListener
            }
            if(guess>randomInt){
                guessDesign.kontrolText.text="Decrease"
                guessDesign.hakSayisi.text="Remain Right $right"

            }
            if(guess<randomInt){
                guessDesign.kontrolText.text="Increase"
                guessDesign.hakSayisi.text="Remain Right $right"

            }
            if(guess==randomInt){
                intent.putExtra("Result",true)
                finish()
                startActivity(intent)
            }



        }
    }
}