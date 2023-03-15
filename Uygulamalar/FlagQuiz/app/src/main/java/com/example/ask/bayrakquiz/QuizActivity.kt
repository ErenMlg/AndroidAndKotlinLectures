package com.example.ask.bayrakquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.ask.bayrakquiz.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {

    lateinit var quizDesign:ActivityQuizBinding
    private lateinit var sorular:ArrayList<Bayraklar>
    private lateinit var yanlisSecenekler:ArrayList<Bayraklar>
    private lateinit var dogruSoru:Bayraklar
    private lateinit var tumSecenekler:HashSet<Bayraklar>
    private lateinit var vtHelper:VeritabaniYardimcisi

    private var soruSayac = 0
    private var dogruSayac = 0
    private var yanlisSayac = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        quizDesign = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(quizDesign.root)

        vtHelper = VeritabaniYardimcisi(this@QuizActivity)
        sorular = Bayraklardao().rastgele10BayrakGetir(vtHelper)
        soruYukle()

        quizDesign.cevapBtn1.setOnClickListener {
            cevapKontrol(quizDesign.cevapBtn1)
            soruSayacKontrol()
        }
        quizDesign.cevapBtn2.setOnClickListener {
            cevapKontrol(quizDesign.cevapBtn2)
            soruSayacKontrol()
        }
        quizDesign.cevapBtn3.setOnClickListener {
            cevapKontrol(quizDesign.cevapBtn3)
            soruSayacKontrol()
        }
        quizDesign.cevapBtn4.setOnClickListener {
            cevapKontrol(quizDesign.cevapBtn4)
            soruSayacKontrol()
        }
    }

    fun soruYukle(){
        quizDesign.soruSayisiTxt.text = "${soruSayac+1}."
        dogruSoru = sorular.get(soruSayac)
        quizDesign.bayrakImg.setImageResource(applicationContext.resources.getIdentifier(dogruSoru.bayrak_resim,"drawable",applicationContext.packageName))
        yanlisSecenekler = Bayraklardao().rastgele3YanlisSecenekGetir(vtHelper,dogruSoru.bayrak_id)

        tumSecenekler = HashSet()
        tumSecenekler.add(dogruSoru)
        tumSecenekler.add(yanlisSecenekler.get(0))
        tumSecenekler.add(yanlisSecenekler.get(1))
        tumSecenekler.add(yanlisSecenekler.get(2))

        quizDesign.cevapBtn1.text = tumSecenekler.elementAt(0).bayrak_ulke
        quizDesign.cevapBtn2.text = tumSecenekler.elementAt(1).bayrak_ulke
        quizDesign.cevapBtn3.text = tumSecenekler.elementAt(2).bayrak_ulke
        quizDesign.cevapBtn4.text = tumSecenekler.elementAt(3).bayrak_ulke
        Log.e("Ad",dogruSoru.bayrak_resim)
    }

    fun cevapKontrol(basilanButon:Button){
        if (basilanButon.text.toString() == dogruSoru.bayrak_ulke){
            dogruSayac++
        }else{
            yanlisSayac++
        }
        quizDesign.dogruTxt.text = dogruSayac.toString()
        quizDesign.yanlSTxt.text = yanlisSayac.toString()
    }

    fun soruSayacKontrol(){
        soruSayac++
        if(soruSayac != 10){
            soruYukle()
        }else{
            var intent = Intent(this@QuizActivity,SonucActivity::class.java)
            intent.putExtra("dogruSayisi",dogruSayac)
            intent.putExtra("yanlisSayisi",yanlisSayac)
            startActivity(intent)
            finish()
        }
    }

}