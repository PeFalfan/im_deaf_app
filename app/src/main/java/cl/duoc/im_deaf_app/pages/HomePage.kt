package cl.duoc.im_deaf_app.pages

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.duoc.im_deaf_app.core.alarm_manager.AppAlarmManager
import cl.duoc.im_deaf_app.core.auth.AuthState
import cl.duoc.im_deaf_app.core.auth.AuthViewModel
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.Calendar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {


    // alarm manager instance
    val alarmManager = AppAlarmManager(context = LocalContext.current)

    val authState = authViewModel.authState.observeAsState()

    val currentTime = Calendar.getInstance()

    val timePickerState = rememberTimePickerState(
        initialHour = currentTime.get(Calendar.HOUR_OF_DAY),
        initialMinute = currentTime.get(Calendar.MINUTE),
        is24Hour = true,
    )

    // auth validation, send back to login if Unauthenticated
    LaunchedEffect(authState.value) {
        when(authState.value) {
            is AuthState.Unauthenticated -> navController.navigate("login")
            else -> Unit
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("HOME", textAlign = TextAlign.Center)
                },
            )
        },
        modifier = Modifier.fillMaxSize()) {
        innerPadding -> Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TimePicker(
            state = timePickerState,
        )
        Button({
            alarmManager.cancelAlarm()
        }) {
            Text("Cancelar alarma")
        }
        Button({
            val calendar : Calendar = Calendar.getInstance()
            calendar.set(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE),
                timePickerState.hour,
                timePickerState.minute,
                0
            )

            Log.d("ALARMA TIMEINMILLIS", calendar.timeInMillis.toString())

            Log.d("CURRENT TIME", System.currentTimeMillis().toString())

            alarmManager.scheduleAlarm(
                calendar.timeInMillis,
                isRepeating = false
            )
        }) {
            Text("Confirmar hora")
        }

        Spacer(modifier = Modifier.height(150.dp))

        TextButton(onClick = {
            authViewModel.logOut()
        }) {
            Text(
                text = "Cerrar sesión!",
                fontSize = 20.sp
                )
            }
        }
    }
}