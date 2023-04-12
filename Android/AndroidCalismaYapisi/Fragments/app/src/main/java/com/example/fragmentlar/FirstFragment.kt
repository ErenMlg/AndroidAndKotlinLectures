package com.example.fragmentlar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragmentlar.databinding.FirstFragmentBinding

class FirstFragment : Fragment() {

    private lateinit var firstFragmentTasarim: FirstFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        firstFragmentTasarim = FirstFragmentBinding.inflate(inflater,container,false)
        //inflater: tasarımı, container:kodsal olarak yazılımı, false ise başka tasarım eklenip eklenmeyeceğini söyler

        firstFragmentTasarim.toastBtn.setOnClickListener {
            Toast.makeText(activity,"Merhaba",Toast.LENGTH_SHORT).show()
        }
        return firstFragmentTasarim.root
    }

}