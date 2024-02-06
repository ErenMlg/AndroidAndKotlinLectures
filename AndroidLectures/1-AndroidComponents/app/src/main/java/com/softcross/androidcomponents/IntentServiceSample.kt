package com.softcross.androidcomponents

import android.app.IntentService
import android.content.Intent
import android.util.Log


class IntentServiceSample : IntentService("IntentServiceSample") {

    @Deprecated("Deprecated in Java")
    override fun onHandleIntent(intent: Intent?) {
        log("IntentTaskService is on a mission to conquer a task!")
        performLongTask()
    }

    private fun performLongTask() {
        // Imagine doing something that takes a long time here
        Thread.sleep(5000)
    }

    @Deprecated("Deprecated in Java")
    override fun onDestroy() {
        super.onDestroy()
        log("IntentTaskService says farewell!")
    }

    fun log(str:String){
        Log.d("TAG", "log: $str")
    }
}