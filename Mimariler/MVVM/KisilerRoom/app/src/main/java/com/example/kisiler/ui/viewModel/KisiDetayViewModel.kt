package com.example.kisiler.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.kisiler.data.repo.KisilerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel @Inject constructor (var krepo : KisilerDaoRepository) : ViewModel() {

    fun guncelle(kisi_id:Int, kisi_ad:String, kisi_tel:String){
        krepo.kisiGuncelle(kisi_id,kisi_ad,kisi_tel)
    }

}