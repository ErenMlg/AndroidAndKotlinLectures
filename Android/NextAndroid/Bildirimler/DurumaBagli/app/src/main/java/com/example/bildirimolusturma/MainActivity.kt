package com.example.bildirimolusturma

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.bildirimolusturma.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

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
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val kanalID = "kanalID"
                val kanalAd = "kanalAd"
                val kanalAciklama = "kanalAciklama"
                val kanalOncelik = NotificationManager.IMPORTANCE_HIGH
                var kanal: NotificationChannel? = bildirimYoneticisi.getNotificationChannel(kanalID)
                if (kanal == null) {
                    kanal = NotificationChannel(kanalID, kanalAd, kanalOncelik)
                    kanal.description = kanalAciklama
                    bildirimYoneticisi.createNotificationChannel(kanal)
                }
                builder = NotificationCompat.Builder(this,kanalID)
                builder.setContentTitle("Başlık")
                    .setContentText("Gövde")
                    .setSmallIcon(R.drawable.resim)
                    .setContentIntent(gidilecekIntent)
                    .setAutoCancel(true) // Basıldıktan sonra kaybolması
            } else {
                builder = NotificationCompat.Builder(this)

                builder.setContentTitle("Başlık")
                    .setContentText("Gövde")
                    .setSmallIcon(R.drawable.resim)
                    .setContentIntent(gidilecekIntent)
                    .setAutoCancel(true) // Basıldıktan sonra kaybolması
                    .priority = Notification.PRIORITY_HIGH
            }

            bildirimYoneticisi.notify(1,builder.build())

        }
    }
}