package com.example.internettabanlibildirim

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MessageService : FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)

        val baslik = message.notification?.title
        val icerik = message.notification?.body

        Log.e("Başlık",baslik ?: "null")
        Log.e("icerik",icerik ?: "null")

        bildirimOlustur(baslik,icerik)
    }

    fun bildirimOlustur(baslik:String?, body:String?) {
        val builder: NotificationCompat.Builder
        val bildirimYoneticisi =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(this, MainActivity::class.java)
        val gidilecekIntent = PendingIntent.getActivity(
            this,
            1,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val kanalID = "kanalid"
            val kanalDesc = "kanalaciklama"
            val kanalName = "kanalad"
            val kanalPriority = NotificationManager.IMPORTANCE_HIGH

            var kanal : NotificationChannel? = bildirimYoneticisi.getNotificationChannel(kanalID)

            if(kanal == null){
                kanal = NotificationChannel(kanalID,kanalName,kanalPriority)
                kanal.description = kanalDesc
                bildirimYoneticisi.createNotificationChannel(kanal)
            }

            builder = NotificationCompat.Builder(this,kanalID)
            builder.setContentTitle(baslik)
                .setContentText(body)
                .setSmallIcon(R.drawable.resim)
                .setContentIntent(gidilecekIntent)
                .setAutoCancel(true)
        }else{
            builder = NotificationCompat.Builder(this)

            builder.setContentTitle(baslik)
                .setContentText(body)
                .setSmallIcon(R.drawable.resim)
                .setContentIntent(gidilecekIntent)
                .setAutoCancel(true)
                .priority = Notification.PRIORITY_HIGH
        }
            bildirimYoneticisi.notify(1,builder.build())
    }

}