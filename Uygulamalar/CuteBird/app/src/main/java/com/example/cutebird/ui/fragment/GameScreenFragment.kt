package com.example.cutebird.ui.fragment

import android.database.DatabaseUtils
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.cutebird.R
import com.example.cutebird.databinding.FragmentGameScreenBinding

class GameScreenFragment : Fragment() {

    private lateinit var binding: FragmentGameScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_game_screen, container, false)

        binding.cl.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if (event?.action == MotionEvent.ACTION_DOWN) {
                    Log.e("Ekrana", "Tıklandı")
                } else if (event?.action == MotionEvent.ACTION_UP) {
                    Log.e("Ekrandan", "Çekildi")
                }
                return true
            }
        })

        return binding.root
    }
}