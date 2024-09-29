package cl.duoc.im_deaf_app.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.duoc.im_deaf_app.core.auth.AuthViewModel
import cl.duoc.im_deaf_app.pages.HomePage
import cl.duoc.im_deaf_app.pages.LoginPage
import cl.duoc.im_deaf_app.pages.SignUpPage

@Composable
fun MyNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login") {
            LoginPage(modifier, navController, authViewModel)
        }
        composable("signup") {
            SignUpPage(modifier, navController, authViewModel)
        }
        composable("home") {
            HomePage(modifier, navController, authViewModel)
        }
    })
}