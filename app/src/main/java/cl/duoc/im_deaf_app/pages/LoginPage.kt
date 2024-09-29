package cl.duoc.im_deaf_app.pages

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import cl.duoc.im_deaf_app.R
import cl.duoc.im_deaf_app.core.auth.AuthState
import cl.duoc.im_deaf_app.core.auth.AuthViewModel

@Composable
fun LoginPage(modifier: Modifier = Modifier, navController: NavController, authViewModel: AuthViewModel) {

    // INPUT VARIABLES
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    // CONTEXT AND NAVIGATION VARIABLES
    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value) {
            is AuthState.Authenticated -> navController.navigate("home")
            is AuthState.Error -> Toast.makeText(context, (authState.value as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }

    // INPUTS AND VISUALS
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.kokomi_face),
            contentDescription = "Login image",
            modifier = Modifier.size(250.dp)
        )

        Text(text = "Bienvenido!", fontSize = 32.sp)

        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text(text = "Correo")
            },
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(text = "Contraseña")
            },
        )
        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = {
            authViewModel.login(email, password)
        }) {
            Text(
                text = "Ingresar",
                fontSize = 25.sp,
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        TextButton(onClick = { println("recover password") }) {
            Text(
                text = "Olvidaste tu contraseña?",
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "O")

        Spacer(modifier = Modifier.height(10.dp))


        TextButton(onClick = {
            println("Register")
            navController.navigate("signup")
        }) {
            Text(
                text = "Quiero registrarme!",
                fontSize = 20.sp
            )
        }
    }
}