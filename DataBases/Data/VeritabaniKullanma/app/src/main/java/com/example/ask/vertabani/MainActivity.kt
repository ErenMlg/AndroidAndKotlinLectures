package com.example.ask.vertabani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vt = VeritabaniYardimcisi(this@MainActivity)

        //Kisilerdao().kisiEKle(vt,"Eren",21,1.67,9999999)
        //Kisilerdao().kisiGuncelle(vt,1,"Yeni Eren",12,1.78,"1111111")
        //Kisilerdao().kisiSil(vt,1)


        /*Kisilerdao().kisiEKle(vt,"Eren",21,1.67,"9999999")
        Kisilerdao().kisiEKle(vt,"Gülçin",21,1.64,"1111111")
        Kisilerdao().kisiEKle(vt,"Mami",23,1.69,"00000000")
        Kisilerdao().kisiEKle(vt,"Aylin",21,1.65,"00000000")*/

        //val kisilerListesi = Kisilerdao().tumKisiler(vt)
        //val kisilerListesi = Kisilerdao().kisiAra(vt,1.60)
        val kisilerListesi = Kisilerdao().randomGetir(vt,2)

        if (!kisilerListesi.isEmpty()){
            for(kisi in kisilerListesi){
                Log.e("Kisi no:",kisi.no.toString())
                Log.e("Kisi ad:",kisi.ad.toString())
                Log.e("Kisi yas:",kisi.yas.toString())
                Log.e("Kisi boy:",kisi.boy.toString())
                Log.e("Kisi tel:",kisi.tel.toString())
            }
        }else{
            Log.e("Hata","Liste Boş")
        }

        Log.e("Sayı: ",Kisilerdao().kayitSayisiAra(vt,"Eren").toString())
    }
}