package cl.duoc.im_deaf_app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

//import cl.duoc.im_deaf_app.core.database.RealtimeManager

@Composable
fun AlarmHistoryPage(modifier: Modifier = Modifier){

//    val realtime = RealtimeManager()

//    val alarms by realtime.getAlarms().collectAsState(emptyList())

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Text("EN CAMINO!")

        AlertItem("LAVADORA!", "12:30")
        AlertItem("MICROONDAS!", "09:30")
        AlertItem("BREAK!", "14:30")
        AlertItem("A ESTUDIAR!", "15:30")
        AlertItem("COLGAR LA ROPA!", "10:30")
        AlertItem("SACAR LA BASURA!", "05:30")
        AlertItem("PASEAR AL PERRO!", "20:30")

    }

}

@Composable
fun AlertItem( title: String,  time: String){
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, textAlign = TextAlign.Start)
        Spacer(modifier = Modifier.width(40.dp))
        Text(time)
    }
}