package com.softcross.diceapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.softcross.diceapp.databinding.FragmentGameBinding
import java.util.Timer
import java.util.TimerTask


class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private var randomInt: Int = 1
    private var oldRandomInt: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRollDice.setOnClickListener {
            randomInt = (1..6).random()
            while (randomInt == oldRandomInt){
                randomInt = (1..6).random()
            }
            binding.imageView.setImageResource(getDrawable(randomInt))
            binding.txtInfo.text = getTextFromRandom(randomInt)
            oldRandomInt = randomInt
        }
    }

    private fun getDrawable(random: Int): Int {
        return when (random) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            6 -> R.drawable.dice6
            else -> R.drawable.error
        }
    }

    private fun getTextFromRandom(random: Int): String {
        return when (random) {
            1 -> "Bir"
            2 -> "İki"
            3 -> "Üç"
            4 -> "Dört"
            5 -> "Beş"
            6 -> "Altı"
            else -> "Error"
        }
    }
}