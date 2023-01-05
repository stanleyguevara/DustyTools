package com.stanleyguevara.dustytools.compose

import android.content.res.Configuration
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.stanleyguevara.dustytools.ui.theme.DustyToolsTheme


@Preview(name = "Light Mode")
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Composable
fun PreviewConversation() {
    DustyToolsTheme {
        Surface {
            Conversation(
                messages = listOf(
                    Message.sample(),
                    Message("Chomik", "Przechodziłem obok kiosku ruchu i mi się skojarzyło z ruchaniem, hehe"),
                    Message("Maciej", "Przestań się opierdalać, wyjdź ze strefy komfortu"),
                    Message("Grzesiek", "Elo ziomie lecimy gdzieś na misję"),
                    Message("Wojtek", "Makitka najlepsza!"),
                    Message("Stachu", "Wojtek powiedz coś po designerowemu"),
                    Message("Wojtek", "Lorem ipsum dolor sit amet consectetur adipiscing elit sed eiusmod tempor incididunt ut labore et dolore magna aliqua Ut enim ad minim veniam quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat Duis aute irure dolor reprehenderit voluptate velit esse cillum dolore eu fugiat nulla pariatur Excepteur sint occaecat cupidatat non proident sunt culpa qui officia deserunt mollit anim est laborum"),
                )
            )
        }
    }
}

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message ->
            MessageCard(message = message)
        }
    }
}
