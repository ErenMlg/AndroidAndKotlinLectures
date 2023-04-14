package com.example.smsyakalama

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.telephony.SmsMessage
import android.widget.Toast

class SmsYakalayici : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val b = intent?.extras

        if (b!=null){
            val pdusObject = b.get("pdus") as Array<Any>

            for(i in pdusObject.indices){ // İçindeki elemanın rangini verir
                val guncelMesaj:SmsMessage
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    val format = b.getString("format")
                    guncelMesaj = SmsMessage.createFromPdu(pdusObject[i] as ByteArray,format)
                }else{
                    guncelMesaj = SmsMessage.createFromPdu(pdusObject[i] as ByteArray)
                }
                val telNo = guncelMesaj.displayOriginatingAddress//SMS Numarası
                val message = guncelMesaj.displayMessageBody//İçerik
                Toast.makeText(context,"$telNo Numarasından '$message' mesajını aldınız",Toast.LENGTH_SHORT).show()
            }
        }
    }
}