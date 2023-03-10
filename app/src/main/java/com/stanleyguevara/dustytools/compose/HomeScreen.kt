package com.stanleyguevara.dustytools.compose

import android.content.res.Configuration
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.stanleyguevara.dustytools.R
import com.stanleyguevara.dustytools.ui.theme.DustyToolsTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    Surface(modifier = modifier) {
        Conversation(messages = Message.sampleListLong())
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
                .border(1.5.dp, MaterialTheme.colorScheme.secondary, CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = message.author,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleSmall,
            )
            Spacer(modifier = Modifier.height(4.dp))

            var isExpanded by remember { mutableStateOf(false) }
            val surfaceColor by animateColorAsState(
                if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface
            )

            Surface(
                shape = MaterialTheme.shapes.medium,
                tonalElevation = 1.dp,
                color = surfaceColor,
                modifier = Modifier
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = MaterialTheme.shapes.large)
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = message.body,
                    modifier = Modifier
                        .clickable { isExpanded = !isExpanded }
                        .padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.bodySmall,
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

        fun sampleList(): List<Message> {
            return listOf(
                Message.sample(),
                Message("Chomik", "Przechodzi??em obok kiosku ruchu i mi si?? skojarzy??o z ruchaniem, hehe"),
                Message("Maciej", "Przesta?? si?? opierdala??, wyjd?? ze strefy komfortu"),
                Message("Grzesiek", "Elo ziomie lecimy gdzie?? na misj??"),
                Message("Wojtek", "Makitka najlepsza!"),
                Message("Stachu", "Wojtek powiedz co?? po designerowemu"),
                Message("Wojtek",
                    "Lorem ipsum dolor sit amet consectetur adipiscing elit sed eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor reprehenderit voluptate velit esse cillum dolore eu fugiat nulla pariatur Excepteur sint occaecat cupidatat non proident sunt culpa qui officia deserunt mollit anim est laborum"),
            )
        }

        fun sampleListLong(): List<Message> = sampleList() + sampleList()
    }
}
