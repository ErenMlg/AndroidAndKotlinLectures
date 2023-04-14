package com.example.notapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuItem
import com.example.notapp.databinding.ActivityDetayBinding
import com.google.android.material.snackbar.Snackbar

class DetayActivity : AppCompatActivity() {

    lateinit var detayDesign:ActivityDetayBinding
    lateinit var gelenDers:Notlar
    lateinit var vty:VeritabaniYardimcisi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detayDesign = ActivityDetayBinding.inflate(layoutInflater)
        setContentView(detayDesign.root)

        detayDesign.detayTb.title="Not Düzenleme"
        setSupportActionBar(detayDesign.detayTb)

        vty = VeritabaniYardimcisi(this)

        gelenDers = intent.getParcelableExtra<Notlar>("not")!!
        detayDesign.firstNoteInput.setText(gelenDers.not1.toString())
        detayDesign.secondNoteInput.setText(gelenDers.not2.toString())
        detayDesign.nameOfTheLassonInput.setText(gelenDers.ders_adi)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tb_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_sil -> {
                Snackbar.make(detayDesign.detayTb,"Silinsin Mi?",Snackbar.LENGTH_SHORT).setAction("EVET"){
                    NotlarDao().notSil(vty,gelenDers.not_id)
                    val intent = Intent(this@DetayActivity,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }.show()
                return true
            }
            R.id.action_düzenle -> {
                val dersAdi = detayDesign.nameOfTheLassonInput.text.toString().trim()
                val not1 = detayDesign.firstNoteInput.text.toString().trim()
                val not2 = detayDesign.secondNoteInput.text.toString().trim()

                if(TextUtils.isEmpty(dersAdi)){
                    Snackbar.make(detayDesign.detayTb,"Ders Adı Giriniz",Snackbar.LENGTH_SHORT).show()
                    return false
                }
                if(TextUtils.isEmpty(not1)){
                    Snackbar.make(detayDesign.detayTb,"İlk Notu Giriniz",Snackbar.LENGTH_SHORT).show()
                    return false
                }
                if(TextUtils.isEmpty(not2)){
                    Snackbar.make(detayDesign.detayTb,"İkinci Notu Giriniz",Snackbar.LENGTH_SHORT).show()
                    return false
                }

                NotlarDao().notDuzenle(vty,gelenDers.not_id,dersAdi,not1.toInt(),not2.toInt())

                val intent = Intent(this@DetayActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
                return true
            }
            else -> return false
        }
    }

}