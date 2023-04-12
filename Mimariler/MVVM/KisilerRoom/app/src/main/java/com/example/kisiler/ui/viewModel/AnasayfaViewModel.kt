package com.example.kisiler.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisiler.data.entity.Kisiler
import com.example.kisiler.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor (var krepo : KisilerDaoRepository) : ViewModel() {

    /*
    Anasayfa fragment oluşturulduğunda viewModel sınıfı tetiklenicek ardından bu sınıftaki
    init çalışıcak ve kisileriYukle fonksiyonunu çalıştıracak,
    kisileriYukle fonksiyonu da kisilerDaoRepostorydeki tum kisileri al methodunu çalıştırıp
    verilerin livedataya yüklenmesini sağlayacak ardından kisiler listesi değişkenine krepodaki
    kiisleri getir fonksiyonu liste ile verileri döndürücek
     */

    var kisilerListesi = MutableLiveData<List<Kisiler>>()

    init {
        kisileriYukle()
        kisilerListesi = krepo.kisileriGetir()
    }

    fun ara(key: String) {
        krepo.kisiAra(key)
    }

    fun sil(kisi_id:Int){
        krepo.kisiSil(kisi_id)
    }

    fun kisileriYukle(){
        krepo.tumKisileriAl()
    }
}