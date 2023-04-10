package com.example.dagger

import android.util.Log
import javax.inject.Inject

class Kargo @Inject constructor(var adres: Adres) {
    //Kargo sınıfı Adres'e bağımlı oldu

    fun gonder(){
        Log.e("Sonuc","Kargo ${adres.adresBilgisi} adresine gönderildi...")
    }

}