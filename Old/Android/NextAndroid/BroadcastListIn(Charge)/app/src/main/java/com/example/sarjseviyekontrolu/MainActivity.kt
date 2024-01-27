package com.example.sarjseviyekontrolu

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

private lateinit var sarjSeviyesiKontrol: SarjSeviyesiKontrol

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sarjSeviyesiKontrol = SarjSeviyesiKontrol()
    }

    override fun onResume() {
        super.onResume()

        val filter = IntentFilter()
        filter.addAction("android.intent.action.BATTERY_LOW")

        registerReceiver(sarjSeviyesiKontrol,filter)

    }

    override fun onStop() {
        super.onStop()

        unregisterReceiver(sarjSeviyesiKontrol)
    }
}