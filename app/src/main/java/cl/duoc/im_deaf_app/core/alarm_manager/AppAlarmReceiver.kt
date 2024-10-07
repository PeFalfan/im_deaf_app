package cl.duoc.im_deaf_app.core.alarm_manager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.PowerManager
import android.util.Log
import android.widget.Toast

// RECEIVER FOR THE ALARM
class AppAlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val wakeLock : PowerManager.WakeLock = (context?.getSystemService(Context.POWER_SERVICE) as PowerManager).run {
            newWakeLock((PowerManager.PARTIAL_WAKE_LOCK), "MyApp::MyWakelockTag").apply {
                acquire(1*60*1000L /*10 minutes*/)
                try {
                    Toast.makeText(context, "ALARMA GATILLADA!!! FUNCIONALIDAD EN CAMINO!", Toast.LENGTH_SHORT).show()
                    Log.d("ALARMA", "ALARMA GATILLADA CON SCREEN ON!!! FUNCIONALIDAD EN CAMINO!")
                } finally {
//                    Toast.makeText(context, "ALARMA GATILLADA!!! FUNCIONALIDAD EN CAMINO!", Toast.LENGTH_SHORT).show()
                    Log.d("ALARMA", "ESTO NO ES UN FALLO, ES UN FINALLY!")

                }
                release()}
        }

        Toast.makeText(context, "ALARMA GATILLADA!!! FUNCIONALIDAD EN CAMINO!", Toast.LENGTH_SHORT).show()
        Log.d("ALARMA", "ALARMA GATILLADA?????!!! FUNCIONALIDAD EN CAMINO!")
    }
}
