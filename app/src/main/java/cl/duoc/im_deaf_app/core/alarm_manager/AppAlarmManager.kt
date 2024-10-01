package cl.duoc.im_deaf_app.core.alarm_manager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

// HERE, WE WANT TO MANAGE THE ALARM SYSTEM, SCHEDULE AND BASIC SETTINGS
class AppAlarmManager(private val context: Context)  {

    // WE CREATE THE ALARM MANAGER
    private val alarmManager =
        context.getSystemService(Context.ALARM_SERVICE) as AlarmManager

    // WE CREATE A FUNCTION TO SCHEDULE AN ALARM
    // we need the time for the alarm, in miliseconds.
    fun scheduleAlarm(expectedTime: Long, isRepeating : Boolean) {

        val pendingIntent = PendingIntent.getBroadcast(
            context,
            1,
            Intent(context, AppAlarmReceiver::class.java),
            PendingIntent.FLAG_IMMUTABLE,
        )

        alarmManager.setExactAndAllowWhileIdle(
            AlarmManager.RTC_WAKEUP,
            expectedTime,
            pendingIntent
        )

        if (isRepeating) {
            alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                expectedTime,
                1000*60,
                pendingIntent
            )
        }

    }

    fun cancelAlarm() {
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            1,
            Intent(context, AppAlarmReceiver::class.java),
            PendingIntent.FLAG_IMMUTABLE,
        )

        alarmManager.cancel(pendingIntent)
    }
}