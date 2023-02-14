package com.example.startup

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.startup.databinding.FragmentAnasayfaBinding
import com.example.startup.databinding.FragmentOyunEkraniBinding


class OyunEkraniFragment : Fragment() {
    private lateinit var OyunEkraniFragmentTasarim: FragmentOyunEkraniBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        OyunEkraniFragmentTasarim = FragmentOyunEkraniBinding.inflate(inflater,container,false)


        val bundle:OyunEkraniFragmentArgs by navArgs()
        val gelenAd = bundle.ad
        val gelenYas = bundle.yas
        val gelenBoy = bundle.boy
        val gelenBekarMi = bundle.bekarMi
        val gelenKisi = bundle.nesne

        Log.e("gelen veriler:", "$gelenAd $gelenYas $gelenBoy $gelenBekarMi $gelenKisi")

        OyunEkraniFragmentTasarim.bitirBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.sonucEkraninaGecis)
        }

        return OyunEkraniFragmentTasarim.root
    }
}