package cl.duoc.im_deaf_app.core.alarm_manager

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class AppAlarmService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d("ALARMA", "ALARMA RECIVIDA")
        return super.onStartCommand(intent, flags, startId)
    }
}