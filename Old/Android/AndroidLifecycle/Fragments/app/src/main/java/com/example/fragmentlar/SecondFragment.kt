package com.example.fragmentlar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentlar.databinding.SecondFragmentBinding

class SecondFragment: Fragment() {

    private lateinit var binding: SecondFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = SecondFragmentBinding.inflate(inflater,container,false)
        binding.textChngBtn.setOnClickListener{
            binding.chngText.text="Merhaba"
        }
        return binding.root
    }

}