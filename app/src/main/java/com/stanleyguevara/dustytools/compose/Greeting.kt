package com.stanleyguevara.dustytools.compose

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stanleyguevara.dustytools.ui.theme.DustyToolsTheme
import timber.log.Timber

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

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
    names: List<String> = List(100) { "Number $it" },
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
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
        var isExpanded by rememberSaveable { mutableStateOf(false) }

        val extraPadding by animateDpAsState(
            targetValue = if (isExpanded) 128.dp else 56.dp,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioHighBouncy,
                stiffness = Spring.StiffnessMedium,
            )
        )

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)) {
            Column(Modifier
                .weight(1.0f)
                .padding(bottom = extraPadding)
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

/*@Preview(showBackground = true, widthDp = 320)
@Composable
private fun GreetingsPreview() {
    DustyToolsTheme {
        Greetings(modifier = Modifier.fillMaxSize())
    }
}*/

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun GreetingPreview() {
    DustyToolsTheme {
        Greeting(name = "Buddy") {}
    }
}
