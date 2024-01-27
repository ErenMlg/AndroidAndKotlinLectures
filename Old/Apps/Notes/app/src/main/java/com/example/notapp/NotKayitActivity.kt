package com.example.notapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import com.example.notapp.databinding.ActivityNotKayitBinding
import com.google.android.material.snackbar.Snackbar

class NotKayitActivity : AppCompatActivity() {

    lateinit var kayitDesign:ActivityNotKayitBinding
    lateinit var vty: VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kayitDesign = ActivityNotKayitBinding.inflate(layoutInflater)
        setContentView(kayitDesign.root)

        vty = VeritabaniYardimcisi(this)
        kayitDesign.kayitTb.title="Not Kayıt"

        kayitDesign.submitBtn.setOnClickListener {
            val dersAdi = kayitDesign.nameOfTheLassonInput.text.toString().trim()
            val not1 = kayitDesign.firstNoteInput.text.toString().trim()
            val not2 = kayitDesign.secondNoteInput.text.toString().trim()

            if(TextUtils.isEmpty(dersAdi)){
                Snackbar.make(kayitDesign.kayitTb,"Ders Adı Giriniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(not1)){
                Snackbar.make(kayitDesign.kayitTb,"İlk Notu Giriniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(TextUtils.isEmpty(not2)){
                Snackbar.make(kayitDesign.kayitTb,"İkinci Notu Giriniz",Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            NotlarDao().notEKle(vty,dersAdi,not1.toInt(),not2.toInt())

            val intent = Intent(this@NotKayitActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}