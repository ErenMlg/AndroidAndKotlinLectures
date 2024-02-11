package com.softcross.viewbinding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.softcross.viewbinding.databinding.FragmentBlankBinding


class BlankFragment : Fragment() {

    private lateinit var binding: FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBlankBinding.inflate(layoutInflater, container, false)
        // or binding = FragmentBlankBinding.inflate(layoutInflater)
        return binding.root

        binding.button2.text = "Fragment Button"
    }
}