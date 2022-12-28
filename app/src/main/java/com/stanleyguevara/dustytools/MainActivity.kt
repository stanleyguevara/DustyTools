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
import com.stanleyguevara.dustytools.ui.theme.DustyToolsTheme
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DustyToolsTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    NextScreenButton { Timber.d("I was clicked") }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun NextScreenButton(onClick: () -> Unit) {
    Button(modifier = Modifier.wrapContentSize(), onClick = onClick) {
        Text(text = "I'm a button")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DustyToolsTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun NextScreenButtonPreview() {
    DustyToolsTheme {
        NextScreenButton { Timber.d("I was clicked") }
    }
}
