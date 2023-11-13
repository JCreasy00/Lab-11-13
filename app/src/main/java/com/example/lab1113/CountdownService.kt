package com.example.lab1113

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.*

class CountdownService : Service() {

    private val serviceScope = CoroutineScope(Dispatchers.Main)

    override fun onBind(intent: Intent?): IBinder? {
        return null // Not a Bound Service
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val countdownValue = intent.getIntExtra("COUNTDOWN_VALUE", 0)
        startCountdown(countdownValue)
        return START_NOT_STICKY
    }

    private fun startCountdown(timeInSeconds: Int) {
        serviceScope.launch {
            for (i in timeInSeconds downTo 1) {
                Log.d("CountdownService", "Countdown: $i")
                delay(1000)
            }
            Log.d("CountdownService", "Countdown finished.")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        serviceScope.cancel()
    }
}