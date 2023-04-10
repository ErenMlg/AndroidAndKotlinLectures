package com.example.dagger

import android.util.Log
import javax.inject.Inject

class Internet @Inject constructor(var adres: Adres) {
    //Internet sınıfı da adrese bağlı oldu


    fun basvuruYap(){
        Log.e("Basvuru","Sonucu ${adres.adresBilgisi} adresine gönderildi...")
    }

}