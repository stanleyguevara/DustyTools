package com.stanleyguevara.dustytools.compose

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stanleyguevara.dustytools.ui.theme.DustyToolsTheme

@Preview(name = "Light Mode")
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun PreviewOrderMatters() {
    DustyToolsTheme {
        Surface {
            OrderMatters()
        }
    }
}

@Composable
fun OrderMatters() {
    Box(modifier = Modifier
        .size(150.dp)
        .background(Color.White)
        .padding(all = 10.dp)
        .background(Color.Black)
    )
}
