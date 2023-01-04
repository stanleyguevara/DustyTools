package com.stanleyguevara.dustytools.compose

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen() {
    Text(modifier = Modifier.wrapContentSize(), text = "Home screen")
}
