package com.example.bildiirm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.bildiirm.databinding.ActivityMainBinding
import java.sql.Time
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val istek = PeriodicWorkRequestBuilder<myWorkerNotification>(15, TimeUnit.MINUTES)
                .build()

            WorkManager.getInstance(this).enqueue(istek)
        }
    }
}