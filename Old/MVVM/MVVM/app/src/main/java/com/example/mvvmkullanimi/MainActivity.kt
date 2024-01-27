package com.example.mvvmkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.mvvmkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainActivity = this

        viewModel.sonuc.observe(this) { s ->
            binding.hesapSonuc = "Sonuc $s"
        }
    }

    //Event Handle
    fun toplaBtn(sayi1: String, sayi2: String) {
        viewModel.toplamaYap(sayi1, sayi2)
    }

    fun carpBtn(sayi1: String, sayi2: String) {
        viewModel.carpmaYap(sayi1, sayi2)
    }


}