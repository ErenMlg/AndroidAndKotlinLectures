package com.example.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.workmanager.databinding.ActivityMainBinding
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            // Bu koşul sağlandığında çalışır
            // koşul sağlanmıyorken çalışmaz, koşul gerçekleştiği an çalışır
            val calismaKosulu =
                Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
            // setRequiresDeviceIdle() Ekran kapandığında

            val istek = OneTimeWorkRequestBuilder<MyWorker>() // Tek seferde çalışır
                .setInitialDelay(10, TimeUnit.SECONDS) // Gecikmeli olarak çalışır
                .setConstraints(calismaKosulu)
                .build()

            WorkManager.getInstance(this).enqueue(istek)
            // İşelmin durumunu öğrenmek için gereken kodlama
            WorkManager.getInstance(this).getWorkInfoByIdLiveData(istek.id).observe(this) {
                val durum = it.state.name
                Log.e("Durum", durum)
            }
        }
        /*
        Arka planda işlemler yapmamızı sağlayan bir yapıdır.
        arka planda sadece mesajlaşma ve bildirim işlemleri yapabiliriz.
        2ye ayrılır;
        uygulamanın tamamen kapandığı durum : Sadece mesajlaşma ve bildirim işlemleri
        uygulamanın çoklu ekran sekmesinde açıldığı durum : birçok işlemi yapabiliriz
        */

    }
}