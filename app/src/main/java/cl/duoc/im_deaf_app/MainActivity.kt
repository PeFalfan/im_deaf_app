package cl.duoc.im_deaf_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import cl.duoc.im_deaf_app.core.MyNavigation
import cl.duoc.im_deaf_app.core.auth.AuthViewModel
import cl.duoc.im_deaf_app.ui.theme.Im_deaf_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel  : AuthViewModel by viewModels()
        setContent {
            Im_deaf_appTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyNavigation(modifier = Modifier, authViewModel = authViewModel)
                }
            }
        }
    }
}
