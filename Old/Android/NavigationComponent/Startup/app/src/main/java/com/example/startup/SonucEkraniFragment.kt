package com.example.startup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.startup.databinding.FragmentAnasayfaBinding
import com.example.startup.databinding.FragmentSonucEkraniBinding

class SonucEkraniFragment : Fragment() {
    private lateinit var SonucEkraniFragmentTasarim: FragmentSonucEkraniBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        SonucEkraniFragmentTasarim = FragmentSonucEkraniBinding.inflate(inflater,container,false)
        return SonucEkraniFragmentTasarim.root
    }
}