package com.example.fragmentlar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentlar.databinding.SecondFragmentBinding

class SecondFragment: Fragment() {

    private lateinit var secondFragmentTasarim: SecondFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        secondFragmentTasarim = SecondFragmentBinding.inflate(inflater,container,false)
        secondFragmentTasarim.textChngBtn.setOnClickListener{
            secondFragmentTasarim.chngText.text="Merhaba"
        }
        return secondFragmentTasarim.root
    }

}