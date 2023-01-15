package com.stanleyguevara.dustytools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stanleyguevara.dustytools.compose.HomeScreen
import com.stanleyguevara.dustytools.compose.LoginScreen
import com.stanleyguevara.dustytools.compose.MyApp
import com.stanleyguevara.dustytools.ui.theme.DustyToolsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DustyToolsTheme {
                MyApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
private fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavGraph(modifier = modifier, navController)
}

@Composable
fun NavGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable(route = "login") {
            LoginScreen(modifier = modifier, navController)
        }
        composable(route = "home") {
            HomeScreen(modifier = modifier, navController)
        }
    }
}
