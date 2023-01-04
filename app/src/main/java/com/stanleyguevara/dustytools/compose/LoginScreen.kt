package com.stanleyguevara.dustytools.compose

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.stanleyguevara.dustytools.ui.theme.DustyToolsTheme
import timber.log.Timber

@Composable
fun LoginScreen(navController: NavHostController) {
    LoginButton { navController.navigate("home") }
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
