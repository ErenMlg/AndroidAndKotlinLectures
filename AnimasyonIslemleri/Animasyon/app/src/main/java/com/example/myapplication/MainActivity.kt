package com.example.myapplication

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.OvershootInterpolator
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        Object Animator sayesinde animasyon işlemlerimizi yaparız.


         */
        binding.btn.setOnClickListener {
            multiAnimation()
            //detayTrasnlationAnimation()
            //translationAnimation()
            //rotateAnimation()
            //scaleAnimation()
            //alphaAnimation()
        }

    }

    fun detayTrasnlationAnimation(){
        val alpha = ObjectAnimator.ofFloat(binding.resim,"translationY",0.0f,100.0f).apply {
            duration = 1000 // 3000 milisaniye = 3sn
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
            /*
            startDelay = 2000 Gecikme Özelliği
            interpolator = OvershootInterpolator() İvme
                OvershootInterpolator salınma özelliği yapıyor
                BounceInterpolator yaylanma etkisi
             */
        }
        alpha.start()
    }

    fun multiAnimation(){
        val alpha = ObjectAnimator.ofFloat(binding.resim,"alpha",1.0f,0.0f)
        val scaleX = ObjectAnimator.ofFloat(binding.resim,"scaleX",1.0f,0.5f)
        val scaleY = ObjectAnimator.ofFloat(binding.resim,"scaleY",1.0f,0.5f)

        val multi = AnimatorSet().apply {
            duration = 1000
            playTogether(alpha,scaleX,scaleY) // Birlikte çalışması için
            //İçindeki sırayla çalışması playSequentially(alpha,scaleX,scaleY)
        }
        multi.start()
    }

    fun alphaAnimation(){
        val alpha = ObjectAnimator.ofFloat(binding.resim,"alpha",1.0f,0.0f).apply {
            duration = 3000 // 3000 milisaniye = 3sn
        }
        alpha.start()
    }

    fun scaleAnimation(){
        // yatayda ise X dikeydeyse Y, 1 kendi boyutu 2kat büyüsün
        val scaleX = ObjectAnimator.ofFloat(binding.resim,"scaleX",1.0f,2.0f).apply {
            duration = 3000 // 3000 milisaniye = 3sn
        }
        val scaleY = ObjectAnimator.ofFloat(binding.resim,"scaleY",1.0f,2.0f).apply {
            duration = 3000 // 3000 milisaniye = 3sn
        }
        scaleX.start()
        scaleY.start()
    }

    fun rotateAnimation(){
        val rotate = ObjectAnimator.ofFloat(binding.resim,"rotation",0.0f,360.0f).apply {
            duration = 1000 // 3000 milisaniye = 3sn
            repeatCount = ObjectAnimator.INFINITE
            repeatMode = ObjectAnimator.REVERSE
        }
        rotate.start()
    }

    fun translationAnimation(){
        val translationX = ObjectAnimator.ofFloat(binding.resim,"translationX",0.0f,50.0f).apply {
            duration = 3000 // 3000 milisaniye = 3sn
        }
        val translationY = ObjectAnimator.ofFloat(binding.resim,"translationY",0.0f,50.0f).apply {
            duration = 3000 // 3000 milisaniye = 3sn
        }
        translationX.start()
        translationY.start()
    }


}