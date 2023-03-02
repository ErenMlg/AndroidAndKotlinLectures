package com.example.ask.sayibulmacaprof

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ask.sayibulmacaprof.databinding.ActivityMainBinding
import com.example.ask.sayibulmacaprof.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    lateinit var resultDesign:ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultDesign = ActivityResultBinding.inflate(layoutInflater)
        setContentView(resultDesign.root)

        val result = intent.getBooleanExtra("Result",false)
        if (result){
            resultDesign.resultText.text="Winner Winner..."
            resultDesign.resultImage.setImageResource(R.drawable.sucsess_icon)
        }else{
            resultDesign.resultText.text="Lose :("
            resultDesign.resultImage.setImageResource(R.drawable.fail_icon)
        }


        resultDesign.restartBtn.setOnClickListener {
            finish()
            startActivity(Intent(this@ResultActivity,GuessActivity::class.java))
        }
    }
}