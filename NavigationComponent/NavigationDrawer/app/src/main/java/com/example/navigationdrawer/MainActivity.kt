package com.example.navigationdrawer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.navigationdrawer.databinding.ActivityMainBinding
import com.example.navigationdrawer.databinding.NavBaslikBinding

class MainActivity : AppCompatActivity() {
    private lateinit var MainActivityTasarim:ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityTasarim = ActivityMainBinding.inflate(layoutInflater)
        setContentView(MainActivityTasarim.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        NavigationUI.setupWithNavController(MainActivityTasarim.navigationView, navHostFragment.navController)
        // Üstteki kodlama navigation view ile navhostfragmentin birlikte çalışmasını sağlar

        MainActivityTasarim.toolbar.title = "Başlık"
        // Toolbara müdahale etmek için

        val toogle = ActionBarDrawerToggle(this,MainActivityTasarim.drawer,MainActivityTasarim.toolbar
            ,0,0)
        // Toolbar üzerindeki butona basıp çalışmasını sağlayan kodlama, drawer ile toolbarı birleştirir, 0,0 ise
        // offset değerleridir açılır ve kapalırken kaymaları ayarlar.

        MainActivityTasarim.drawer.addDrawerListener(toogle)
        toogle.syncState()


        val baslik = NavBaslikBinding.bind(MainActivityTasarim.navigationView.inflateHeaderView(R.layout.nav_baslik))
        //Navigation içine oluşturduğumuz baslik sayfasını birleştiriyor.
        baslik.textViewBaslik.text = "Selam Eren"
        //Navigation içindeki başlık sayfasındaki texte erişip içeriğini değiştiriyor.
    }

    override fun onBackPressed() {
        if(MainActivityTasarim.drawer.isDrawerOpen(GravityCompat.START)){
            MainActivityTasarim.drawer.closeDrawer(GravityCompat.START)
            //Yandan menü açık ise geri tuşuna bastığımızda menünün kapanmasını sağlıyor
        }else{
            super.onBackPressed()
        }
    }
}