package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private val database = FirebaseDatabase.getInstance()
    private val refKisiler = database.getReference("kisiler")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* kisiEkle("Gülçin",21)
        kisiEkle("Muhammet",22)
        kisiEkle("Aylin",21)
        kisiEkle("Ceren",12)
        kisiEkle("Çiğdem",42) */

        //kisiSil("-NSIEdT8WrjDdGheOgBL")

        //kisiGuncelle("-NSIEI8MWruZJ5n9zj-M")

    }

    fun kisiEkle(ad:String, yas:Int){
        val kisi = Kisiler(ad,yas)
        refKisiler.push().setValue(kisi)
    }

    fun kisiSil(key:String){
        refKisiler.child(key).removeValue()
    }

    fun kisiGuncelle(key:String){
        val updateInfo = HashMap<String,Any>()
        updateInfo["kisi_ad"]="Çiğdem Oğurlu"
        updateInfo["kisi_yas"]=43
        refKisiler.child(key).updateChildren(updateInfo)
    }

}