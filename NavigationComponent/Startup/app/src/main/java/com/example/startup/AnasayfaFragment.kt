package com.example.startup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.startup.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var AnasayfaFragmentTasarim:FragmentAnasayfaBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        AnasayfaFragmentTasarim = FragmentAnasayfaBinding.inflate(inflater,container,false)

        AnasayfaFragmentTasarim.baslaBtn.setOnClickListener {
            val kisi1 = Kisiler("Gülçin",21)
            val gecis = AnasayfaFragmentDirections.oyunEkraninaGecis(ad = "Eren", yas = 21, boy = 1.67f, bekarMi = true, nesne = kisi1)
            Navigation.findNavController(it).navigate(gecis)
        }
        return AnasayfaFragmentTasarim.root
    }
}
