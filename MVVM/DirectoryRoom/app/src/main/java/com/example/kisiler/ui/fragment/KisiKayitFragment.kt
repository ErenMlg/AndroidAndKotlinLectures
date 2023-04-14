package com.example.kisiler.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.kisiler.R
import com.example.kisiler.databinding.FragmentKisiKayitBinding
import com.example.kisiler.ui.viewModel.AnasayfaViewModel
import com.example.kisiler.ui.viewModel.KisiKayitViewModel
import com.example.kisiler.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiKayitFragment : Fragment() {

    private lateinit var binding: FragmentKisiKayitBinding
    private lateinit var viewModel: KisiKayitViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kisi_kayit, container, false)

        with(binding) {
            kisiKayitToolbarBaslik="Kişi Kayıt"
            kisiKayitFragment = this@KisiKayitFragment
            return root
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KisiKayitViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun btnKaydet(kisi_ad: String, kisi_tel: String) {
        viewModel.kayit(kisi_ad,kisi_tel)
    }


}