package com.example.cutebird.ui.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.cutebird.R
import com.example.cutebird.databinding.FragmentGameOverBinding
import com.example.cutebird.util.gecisYap

class GameOverFragment : Fragment() {

    private lateinit var binding: FragmentGameOverBinding


    private var enYuksekSkor= 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_game_over,container,false)
        binding.gameOverFragment = this@GameOverFragment

        val sp = this.activity?.getSharedPreferences("Skor",Context.MODE_PRIVATE)
        enYuksekSkor = sp?.getInt("enYuksekSkor",0) ?: 0

        val gelenSkor = getArguments()?.getInt("skor")
        val skor = gelenSkor ?: 0
        Log.e("Skor",skor.toString())
        if(enYuksekSkor < skor){
            val editor = sp?.edit()
            editor?.putInt("enYuksekSkor",skor)
            editor?.commit()
            binding.topSkorTxt.text = skor.toString()
        }else{
            binding.topSkorTxt.text = enYuksekSkor.toString()
        }
        binding.toplamSkorTxt.text = skor.toString()

        binding.btnTekrarBasla.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.restartToGame)
        }

        return binding.root
    }

    fun restart(it:View){
        Navigation.gecisYap(it,R.id.restartToGame)
    }

}