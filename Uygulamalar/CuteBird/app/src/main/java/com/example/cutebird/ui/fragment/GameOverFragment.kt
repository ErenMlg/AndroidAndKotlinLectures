package com.example.cutebird.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.cutebird.R
import com.example.cutebird.databinding.FragmentGameOverBinding
import com.example.cutebird.databinding.FragmentGameStartBinding
import com.example.cutebird.util.gecisYap

class GameOverFragment : Fragment() {

    private lateinit var binding: FragmentGameOverBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game_over,container,false)
        binding.gameOverFragment = this@GameOverFragment
        return binding.root
    }

    fun restart(it:View){
        Navigation.gecisYap(it,R.id.restartToGame)
    }

}