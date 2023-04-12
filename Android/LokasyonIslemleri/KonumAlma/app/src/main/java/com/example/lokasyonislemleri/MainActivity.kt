package com.example.lokasyonislemleri

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.lokasyonislemleri.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.Task
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var izinKontrol = 0

    private lateinit var flpc: FusedLocationProviderClient
    private lateinit var locationTask: Task<Location>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        flpc = LocationServices.getFusedLocationProviderClient(this)

        binding.btnKonumAl.setOnClickListener {
            izinKontrol = ContextCompat.checkSelfPermission(
                this@MainActivity,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            )
            if (izinKontrol != PackageManager.PERMISSION_GRANTED) { //İzin onaylanmamışsa çalışır
                ActivityCompat.requestPermissions( // İzin istediğimiz yapı
                    this@MainActivity,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                    100
                )
            } else { //İzin onaylanmışsa çalışır
                locationTask = flpc.lastLocation
                konumAl()
            }
        }
    }

    @SuppressLint("MissingSuperCall")
    override fun onRequestPermissionsResult( // İzin istenilen ekran çıktıktan sonraki kontrol işlemleri
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == 100) {
            if (grantResults.size > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Arrayin içerisinde bir izin var mı ve izin verilmiş mi
                izinKontrol = ContextCompat.checkSelfPermission(
                    this@MainActivity,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
                Toast.makeText(applicationContext, "İZİN VERİLDİ", Toast.LENGTH_SHORT).show()
                locationTask = flpc.lastLocation
                konumAl()
            } else {
                Toast.makeText(applicationContext, "İZİN VERİLMEDİ", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun konumAl() {
        locationTask.addOnSuccessListener {
            if (it != null) {
                binding.textViewEnlem.text = "Enlem : ${it.latitude}"
                binding.textViewBoylam.text = "Boylam : ${it.longitude}"
            }else{
                binding.textViewEnlem.text = "Enlem : Alınamadı"
                binding.textViewBoylam.text = "Boylam : Alınamadı"
            }
        }
    }

}