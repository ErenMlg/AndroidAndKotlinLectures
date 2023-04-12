package com.example.sarjseviyekontrolu

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class SarjSeviyesiKontrol: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context,"Sarjınız bitmek üzere..",Toast.LENGTH_SHORT).show()
    }

}