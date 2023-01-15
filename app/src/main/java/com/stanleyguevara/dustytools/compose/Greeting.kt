package com.stanleyguevara.dustytools.compose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stanleyguevara.dustytools.ui.theme.DustyToolsTheme
import timber.log.Timber

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
) {
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    if (shouldShowOnboarding) {
        OnboardingScreen(
            modifier = modifier,
            onContinueClicked = { shouldShowOnboarding = false }
        )
    } else {
        Greetings(modifier = modifier)
    }
}

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = listOf("World", "Compose"),
) {
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names) {
            Greeting(name = name) { Timber.d("Button clicked") }
        }
    }
}

@Composable
private fun Greeting(name: String, onClick: () -> Unit) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        var isExpanded by remember { mutableStateOf(false) }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)) {
            Column(Modifier
                .weight(1.0f)
                .padding(bottom = if (isExpanded) 56.dp else 0.dp)
            ) {
                Text(text = "Hello")
                Text(text = name)
            }
            ElevatedButton(onClick = {
                isExpanded = isExpanded.not()
                onClick.invoke()
            }) {
                Text(text = if (isExpanded) "Show less" else "Show more")
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun GreetingPreview() {
    DustyToolsTheme {
        MyApp(modifier = Modifier.fillMaxSize())
    }
}
