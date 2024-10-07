package cl.duoc.im_deaf_app.core

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.duoc.im_deaf_app.core.auth.AuthViewModel
import cl.duoc.im_deaf_app.model.BottomNavigationItemModel
import cl.duoc.im_deaf_app.pages.AlarmHistoryPage
import cl.duoc.im_deaf_app.pages.HomePage
import cl.duoc.im_deaf_app.pages.LoginPage
import cl.duoc.im_deaf_app.pages.SignUpPage
import cl.duoc.im_deaf_app.pages.TimerPage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    val items = listOf(
        BottomNavigationItemModel(
            "CUENTA ATRAS",
            selectedIcon = Icons.Filled.ArrowDropDown,
            unselectedIcon = Icons.Outlined.ArrowDropDown,
            navigationPath = "timerPage"
        ),
        BottomNavigationItemModel(
            "HOME",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            navigationPath = "home"
        ),
        BottomNavigationItemModel(
            "HISTORIAL",
            selectedIcon = Icons.Filled.AccountBox,
            unselectedIcon = Icons.Outlined.AccountBox,
            navigationPath = "historyPage"
        ),
    )

    var selectedItemIndex by rememberSaveable {
        mutableStateOf(1)
    }


    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login") {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text("REGISTRO")
                        },
                    )
                }
            ) { innerPadding ->
                LoginPage(modifier.padding(innerPadding), navController, authViewModel)
            }

        }
        composable("signup") {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text("INGRESO", textAlign = TextAlign.Center)
                        },
                    )
                }
            ) { innerPadding ->
                SignUpPage(modifier.padding(innerPadding), navController, authViewModel)
            }

        }
        composable("home") {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text("HOME", textAlign = TextAlign.Center)
                        },
                    )
                },
                bottomBar = {
                    NavigationBar {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                    navController.navigate(item.navigationPath)
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) item.selectedIcon
                                        else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            )
                        }
                    }
                }
            ) { innerPadding ->
                HomePage(modifier.padding(innerPadding), navController, authViewModel)
            }
        }
        composable("historyPage") {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text("Hitorial de alarmas", textAlign = TextAlign.Center)
                        },
                    )
                },
                bottomBar = {
                    NavigationBar {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                    navController.navigate(item.navigationPath)
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) item.selectedIcon
                                        else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            )
                        }
                    }
                }
            ) { innerPadding ->
                AlarmHistoryPage(modifier.padding(innerPadding))
            }
        }
        composable("timerPage") {
            Scaffold(
                topBar = {
                    CenterAlignedTopAppBar(
                        title = {
                            Text("Cuenta atrás", textAlign = TextAlign.Center)
                        },
                    )
                },
                bottomBar = {
                    NavigationBar {
                        items.forEachIndexed { index, item ->
                            NavigationBarItem(
                                selected = selectedItemIndex == index,
                                onClick = {
                                    selectedItemIndex = index
                                    navController.navigate(item.navigationPath)
                                },
                                icon = {
                                    Icon(
                                        imageVector = if (index == selectedItemIndex) item.selectedIcon
                                        else item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                                }
                            )
                        }
                    }
                }
            ) { innerPadding ->
                TimerPage(modifier.padding(innerPadding), navController, authViewModel)
            }
        }
    })
}