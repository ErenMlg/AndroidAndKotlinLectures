package com.example.ask.toolbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ask.toolbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var design:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        design = ActivityMainBinding.inflate(layoutInflater)
        setContentView(design.root)

        design.toolbar.title = "Özel Toolbar Başlığı"
        design.toolbar.subtitle = "Özel Toolbar AltBaşlığı"
        design.toolbar.setLogo(R.drawable.resim)
        design.toolbar.setTitleTextColor(resources.getColor(R.color.purple_700))
        // resources.getColor Fonksiyonu color dosyasına erişmemizi sağlıyor.

        setSupportActionBar(design.toolbar)
    }
}