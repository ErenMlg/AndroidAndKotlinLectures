package com.example.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var kargo: Kargo

    @Inject
    lateinit var internet: Internet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Dependecy Enjection Sınıflarımızın bağımlılıklarını kontrol eder,
        bir sınıfın başka sınıftan bir nesne veya değişken varsa bunlar bağımlılık denir.
        Bunları kolayca kullanmayı sağlayan kütüphane daggerdır.
         */

        DaggerAppComponent.builder().build().inject(this)

        //internet=Internet()
        //kargo=Kargo()

        internet.basvuruYap()
        kargo.gonder()

    }
}