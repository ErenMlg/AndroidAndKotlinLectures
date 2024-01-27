package com.example.hilt

import android.util.Log
import javax.inject.Inject

class Kargo @Inject constructor(var adres:Adres){

    fun kargola(){
        Log.e("Kargo","${adres.adresDetay} adresine yola çıkmıştır...")
    }

}