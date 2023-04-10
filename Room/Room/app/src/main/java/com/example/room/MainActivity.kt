package com.example.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var vt: Veritabani
    private lateinit var kdao: KisilerDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vt = Veritabani.veritabaniErisim(this)!!
        kdao = vt.getKisilerDao()

        // kisiEkle()
        // kisiGuncelle()
        //kisiSil()
        //kisileriYukle()
        kisiAra()
    }

    fun kisileriYukle() {
        val scope = CoroutineScope(Dispatchers.Main).launch {
            val gelenListe = kdao.tumKisiler()

            for (k in gelenListe) {
                Log.e("Kisi ID", k.kisi_id.toString())
                Log.e("Kisi AD", k.kisi_ad)
                Log.e("Kisi YAS", k.kisi_yas.toString())
            }
        }
    }

    fun kisiEkle() {
        val scope = CoroutineScope(Dispatchers.Main).launch {
            val yeniKisi = Kisiler(0, "Eren", 25)
            //IDnin önemi yok otomatik arttığından dolayı
            kdao.kisiEkle(yeniKisi)
        }
    }

    fun kisiGuncelle() {
        val scope = CoroutineScope(Dispatchers.Main).launch {
            val guncellenecekKisi = Kisiler(2, "Gülçin", 22)
            //ID önemli güncelleme için
            kdao.kisiGuncelle(guncellenecekKisi)
        }
    }

    fun kisiSil() {
        val scope = CoroutineScope(Dispatchers.Main).launch {
            val silinecekKisi = Kisiler(4, "", 0)
            //Diğer boşlukların önemi yok ID önemli
            kdao.kisiSil(silinecekKisi)
        }
    }

    fun kisiAra() {
        val scope = CoroutineScope(Dispatchers.Main).launch {
            var gelenListe = kdao.kisiAra("e")

            for (k in gelenListe) {
                Log.e("Kisi ID", k.kisi_id.toString())
                Log.e("Kisi AD", k.kisi_ad)
                Log.e("Kisi YAS", k.kisi_yas.toString())
            }
        }
    }
}