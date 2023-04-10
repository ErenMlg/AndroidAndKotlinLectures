package com.example.mvvmkullanimi

import androidx.lifecycle.MutableLiveData

class MatematikselRepo {
    var matematikselSonuc = MutableLiveData<String>()

    init {
        matematikselSonuc = MutableLiveData<String>("0")
    }

    fun sonucGetir(): MutableLiveData<String> {
        return matematikselSonuc
    }

    fun topla(sayi1: String, sayi2: String) {
        val toplam = sayi1.toInt() + sayi2.toInt()
        matematikselSonuc.value = toplam.toString()
    }

    fun carp(sayi1: String, sayi2: String) {
        val carpim = sayi1.toInt() * sayi2.toInt()
        matematikselSonuc.value = carpim.toString()
    }
}