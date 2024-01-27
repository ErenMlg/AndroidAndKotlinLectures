package com.example.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context:Context, workerParms : WorkerParameters) : Worker(context,workerParms){
    override fun doWork(): Result {
        val toplam = 10 + 20
        Log.e("Arkaplan sonucu : ",toplam.toString())
        return Result.success()
    }

}