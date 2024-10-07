package cl.duoc.im_deaf_app.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import cl.duoc.im_deaf_app.core.auth.AuthViewModel

@Composable
fun TimerPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("FUNCIONALIDADES EN CAMINO!")
    }

}