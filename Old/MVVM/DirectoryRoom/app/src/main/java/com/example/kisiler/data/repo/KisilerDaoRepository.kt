package com.example.kisiler.data.repo

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.kisiler.data.entity.Kisiler
import com.example.kisiler.room.KisilerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisilerDaoRepository(var kdao:KisilerDao) {
    var kisilerListesi : MutableLiveData<List<Kisiler>>

    init {
        kisilerListesi = MutableLiveData()
    }

    fun kisiKayit(kisi_ad: String, kisi_tel: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val eklenecekKisi = Kisiler(0,kisi_ad,kisi_tel)
            kdao.kisiEkle(eklenecekKisi)
        }
    }

    fun kisiGuncelle(kisi_id:Int, kisi_ad:String, kisi_tel:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenecekKisi = Kisiler(kisi_id,kisi_ad,kisi_tel)
            kdao.kisiGuncelle(guncellenecekKisi)
        }
    }

    fun kisiAra(key: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kdao.kisiAra(key)
        }
    }

    fun kisiSil(kisi_id: Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinecekKisi = Kisiler(kisi_id,"","")
            kdao.kisiSil(silinecekKisi)
            tumKisileriAl()
        }
    }

    fun tumKisileriAl(){
        // Coroutine ile asenkron çalışmasını sağlıyor
        val job = CoroutineScope(Dispatchers.Main).launch {
            kisilerListesi.value = kdao.tumKisiler()
        }
    }

    fun kisileriGetir() : MutableLiveData<List<Kisiler>>{
        return kisilerListesi
    }

}