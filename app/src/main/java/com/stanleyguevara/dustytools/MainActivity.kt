package com.stanleyguevara.dustytools

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stanleyguevara.dustytools.ui.theme.DustyToolsTheme
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DustyToolsTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MainScreen()
                }
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
private fun LoginScreen(navController: NavHostController) {
    LoginButton { navController.navigate("home") }
}

@Composable
private fun HomeScreen() {
    Text(modifier = Modifier.wrapContentSize(), text = "Home screen")
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

@Composable
fun LoginButton(onClick: () -> Unit) {
    Button(modifier = Modifier.wrapContentSize(), onClick = onClick) {
        Text(text = "Login button")
    }
}

@Preview(showBackground = true)
@Composable
fun NextScreenButtonPreview() {
    DustyToolsTheme {
        LoginButton { Timber.d("I was clicked") }
    }
}
