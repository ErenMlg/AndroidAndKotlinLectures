package com.example.kisiler.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.kisiler.data.repo.KisilerDaoRepository
import com.example.kisiler.util.gecisYap
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class KisiKayitViewModel @Inject constructor (var krepo : KisilerDaoRepository) : ViewModel() {

    fun kayit(kisi_ad: String, kisi_tel: String) {
        krepo.kisiKayit(kisi_ad,kisi_tel)
    }

}