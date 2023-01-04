package com.stanleyguevara.dustytools.compose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stanleyguevara.dustytools.R
import com.stanleyguevara.dustytools.ui.theme.DustyToolsTheme

@Composable
fun HomeScreen() {
    Surface {
        MessageCard(message = Message.sample())
    }
}

@Composable
fun MessageCard(message: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "${message.author} profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = message.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Surface(
                shape = MaterialTheme.shapes.medium,
                elevation = 1.dp,
            ) {
                Text(
                    text = message.body,
                    modifier = Modifier.padding(all = 4.dp),
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun PreviewMessageCard() {
    DustyToolsTheme {
        Surface {
            MessageCard(message = Message.sample())
        }
    }
}

data class Message(
    val author: String,
    val body: String,
) {
    companion object {
        fun sample() = Message(
            author = "Andrei",
            body = "Hey ho, I'm an iOS dev, but have you checked Jetpack Compose?",
        )
    }
}
