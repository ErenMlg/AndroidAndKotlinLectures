package com.example.counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            //Sınıf oluşturarak nesne oluşturduk.
            val counter = object : CountDownTimer(30000,1000){
                //30.000 den başlayark 1000er azalıcak.
                override fun onFinish() {
                    binding.textView.text = "Bitti!"
                    //Sayma bittiğinde
                }

                override fun onTick(millisUntilFinished: Long) {
                    binding.textView.text = "Süre : ${millisUntilFinished/1000}"
                    //Her bir azaldığında
                }
            }
            counter.start()
        }
    }
}