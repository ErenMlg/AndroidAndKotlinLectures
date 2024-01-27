package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
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
        //tumKisiler()
        kisiAra()
    }

    fun kisiEkle(ad: String, yas: Int) {
        val kisi = Kisiler(ad, yas)
        refKisiler.push().setValue(kisi)
    }

    fun kisiSil(key: String) {
        refKisiler.child(key).removeValue()
    }

    fun kisiGuncelle(key: String) {
        val updateInfo = HashMap<String, Any>()
        updateInfo["kisi_ad"] = "Çiğdem Oğurlu"
        updateInfo["kisi_yas"] = 43
        refKisiler.child(key).updateChildren(updateInfo)
    }

    fun tumKisiler() {
        refKisiler.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (kisiler in snapshot.children) {
                    val kisi = kisiler.getValue(Kisiler::class.java)
                    if (kisi != null) {
                        val key = kisiler.key // Elemanın keyini aldığımız kodlama
                        Log.e("Kişi :", "${kisi.kisi_ad} Yaş :${kisi.kisi_yas}")
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    private fun kisiAra() {

        // var sorgu = refKisiler.limitToFirst(1) -> Sınırlı sayıda veri almak için
        // var sorgu = refKisiler.limitToLast(2) -> Sondan iki veriyi getirir
        // var sorgu = refKisiler.orderByChild("kisi_yas").startAt(30.0).endAt(50.0) -> yaşı 30 ile 50 olan kişiler

        var sorgu = refKisiler.orderByChild("kisi_ad").equalTo("Eren")
        sorgu.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (gelenVeri in snapshot.children) {
                    val veri = gelenVeri.getValue(Kisiler::class.java)
                    if (veri != null) {
                        Log.e("Kişi :", "${veri.kisi_ad} Yaş :${veri.kisi_yas}")
                    } else {
                        Log.e("Hata", "Null")
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {}

        })
    }

}