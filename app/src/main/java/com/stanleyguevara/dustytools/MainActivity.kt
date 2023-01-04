package com.stanleyguevara.dustytools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stanleyguevara.dustytools.compose.HomeScreen
import com.stanleyguevara.dustytools.compose.LoginScreen
import com.stanleyguevara.dustytools.ui.theme.DustyToolsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DustyToolsTheme {
                MainScreen()
            }
        }
    }
}

@Composable
private fun MainScreen() {
    val navController = rememberNavController()
    NavGraph(navController)
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable(route = "login") {
            LoginScreen(navController)
        }
        composable(route = "home") {
            HomeScreen()
        }
    }
}
