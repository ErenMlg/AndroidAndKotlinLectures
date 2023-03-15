package com.example.ask.bayrakquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ask.bayrakquiz.databinding.ActivitySonucBinding

class SonucActivity : AppCompatActivity() {

    lateinit var sonucDesign:ActivitySonucBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sonucDesign = ActivitySonucBinding.inflate(layoutInflater)
        setContentView(sonucDesign.root)

        val dogruSayisi = intent.getIntExtra("dogruSayisi",0)
        val yanlisSayisi = intent.getIntExtra("yanlisSayisi",0)
        val yuzde = dogruSayisi*100/10

        sonucDesign.yuzdeSonucTxt.text = "%$yuzde Başarı"
        sonucDesign.sonucTxt.text="$dogruSayisi Doğru $yanlisSayisi Yanlış"

        if(yuzde >= 50){
            sonucDesign.resultImg.setImageResource(R.drawable.win_icon)
            sonucDesign.gameSonucTxt.text = "Kazandınız"
        }else{
            sonucDesign.resultImg.setImageResource(R.drawable.lose_icon)
            sonucDesign.gameSonucTxt.text = "Kaybettiniz"
        }

        sonucDesign.restartBtn.setOnClickListener {
            startActivity(Intent(this@SonucActivity,QuizActivity::class.java))
            finish()
        }

    }
}