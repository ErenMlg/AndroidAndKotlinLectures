package com.example.mvvmkullanimi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    var sonuc = MutableLiveData<String>()
    var mtsnc = MatematikselRepo()

    init {
        sonuc = mtsnc.sonucGetir()
    }

    fun toplamaYap(sayi1:String, sayi2:String){
        mtsnc.topla(sayi1,sayi2)
    }

    fun carpmaYap(sayi1:String, sayi2:String){
        mtsnc.carp(sayi1,sayi2)
    }
}