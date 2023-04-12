package com.example.cutebird.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.cutebird.R
import com.example.cutebird.databinding.FragmentGameStartBinding
import com.example.cutebird.util.gecisYap

class GameStartFragment : Fragment() {

    private lateinit var binding:FragmentGameStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game_start,container,false)

        binding.gameStartFragment = this@GameStartFragment

        return binding.root
    }

    fun start(it:View){
        Navigation.gecisYap(it,R.id.startToGame)
    }

}