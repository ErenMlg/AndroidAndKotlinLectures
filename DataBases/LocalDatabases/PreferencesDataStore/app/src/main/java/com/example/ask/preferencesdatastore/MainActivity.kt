package com.example.ask.preferencesdatastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // SharedPreferences'in güncel hali jetpack ile geldi.
        val ap = AppPref(this)
        val job = CoroutineScope(Dispatchers.Main).launch {
            ap.kayitAd("Ahmet")
            val gelenAd = ap.okuAd()
            Log.e("gelen ad :",gelenAd)
        }
    }
}