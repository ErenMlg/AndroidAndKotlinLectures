package com.example.myapplication

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import java.util.Objects

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var fabDurum = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabClock.scaleX = 0.0f
        binding.fabClock.scaleY = 0.0f
        binding.fabPhoto.scaleX = 0.0f
        binding.fabPhoto.scaleY = 0.0f

        binding.fabAdd.setOnClickListener {
            if (fabDurum){
                val rotateFabAdd = ObjectAnimator.ofFloat(binding.fabAdd,"rotation",45.0f,0.0f)
                val scaleFabClockX = ObjectAnimator.ofFloat(binding.fabClock,"scaleX",1.0f,0.0f)
                val scaleFabClockY = ObjectAnimator.ofFloat(binding.fabClock,"scaleY",1.0f,0.0f)
                val scaleFabPhotoX = ObjectAnimator.ofFloat(binding.fabPhoto,"scaleX",1.0f,0.0f)
                val scaleFabPhotoY = ObjectAnimator.ofFloat(binding.fabPhoto,"scaleY",1.0f,0.0f)

                val multiAnimation = AnimatorSet().apply {
                    duration = 500
                    playTogether(rotateFabAdd,scaleFabClockX,scaleFabClockY,scaleFabPhotoX,scaleFabPhotoY)
                }
                multiAnimation.start()
                fabDurum = false

            }else{
                val rotateFabAdd = ObjectAnimator.ofFloat(binding.fabAdd,"rotation",0.0f,45.0f)
                val scaleFabClockX = ObjectAnimator.ofFloat(binding.fabClock,"scaleX",0.0f,1.0f)
                val scaleFabClockY = ObjectAnimator.ofFloat(binding.fabClock,"scaleY",0.0f,1.0f)
                val scaleFabPhotoX = ObjectAnimator.ofFloat(binding.fabPhoto,"scaleX",0.0f,1.0f)
                val scaleFabPhotoY = ObjectAnimator.ofFloat(binding.fabPhoto,"scaleY",0.0f,1.0f)

                val multiAnimation = AnimatorSet().apply {
                    duration = 500
                    playTogether(rotateFabAdd,scaleFabClockX,scaleFabClockY,scaleFabPhotoX,scaleFabPhotoY)
                }
                multiAnimation.start()
                fabDurum = true
            }
        }

    }
}