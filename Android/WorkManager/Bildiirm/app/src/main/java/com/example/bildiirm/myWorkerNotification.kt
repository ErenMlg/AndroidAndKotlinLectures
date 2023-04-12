package com.example.bildiirm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.sql.ResultSet

class myWorkerNotification(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        bildirimOlustur()
        return Result.success()
    }

    fun bildirimOlustur() {
        val builder: NotificationCompat.Builder
        val bildirimYonetici =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(applicationContext, MainActivity::class.java)
        val gidilecekIntent = PendingIntent.getActivity(
            applicationContext,
            1,
            intent,
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val kanalID = "kanalID"
            val kanalAD = "kanalAD"
            val kanalDesc = "kanalDesc"
            val kanalPrior = NotificationManager.IMPORTANCE_HIGH

            var kanal: NotificationChannel? = bildirimYonetici.getNotificationChannel(kanalID)

            if (kanal == null) {
                kanal = NotificationChannel(kanalID, kanalAD, kanalPrior)
                kanal.description = kanalDesc
                bildirimYonetici.createNotificationChannel(kanal)
            }
            builder = NotificationCompat.Builder(applicationContext, kanalID)
            builder.setContentTitle("Başlık")
                .setContentText("Selam")
                .setSmallIcon(R.drawable.resim)
                .setContentIntent(gidilecekIntent)
                .setAutoCancel(true)

        } else {
            builder = NotificationCompat.Builder(applicationContext)
            builder.setContentTitle("Başlık")
                .setContentText("Selam")
                .setSmallIcon(R.drawable.resim)
                .setContentIntent(gidilecekIntent)
                .setAutoCancel(true)
                .priority = Notification.PRIORITY_HIGH
        }
        bildirimYonetici.notify(1, builder.build())
    }
}