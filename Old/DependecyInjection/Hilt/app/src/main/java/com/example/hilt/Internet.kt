package com.example.hilt

import android.util.Log
import javax.inject.Inject

class Internet @Inject constructor(var adres:Adres){

    fun internetIslemleri(){
        Log.e("İnternet","işlemleri ${adres.adresDetay} adresinde başarılı...")
    }


}