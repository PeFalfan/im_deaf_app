package cl.duoc.im_deaf_app.core.alarm_manager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable

// RECEIVER FOR THE ALARM
class AppAlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        Toast.makeText(context, "ALARMA GATILLADA!!! FUNCIONALIDAD EN CAMINO!", Toast.LENGTH_SHORT).show()
        Log.d("ALARMA", "ALARMA GATILLADA")
    }
}
