package com.softcross.androidcomponents

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ServiceSample : Service() {

    override fun onBind(intent: Intent?): IBinder? {
        // Nah, not today. No binding here!
        return null
    }

    override fun onCreate() {
        super.onCreate()
        log("ServiceSample is ready to conquer!")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        log("ServiceSample is performing a task! Don't disturb, please!")
        performLongTask()
        return START_STICKY // If the service is killed, it will be automatically restarted
    }

    private fun performLongTask() {
        // Imagine doing something that takes a long time here
        Thread.sleep(5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        log("ServiceSample says goodbye!")
    }

    fun log(str: String) {
        Log.d("TAG", "log: $str")
    }

}