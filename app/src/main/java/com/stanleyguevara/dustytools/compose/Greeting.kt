package com.stanleyguevara.dustytools.compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stanleyguevara.dustytools.R
import com.stanleyguevara.dustytools.ui.theme.DustyToolsTheme
import timber.log.Timber

@Composable
fun MyApp(
    modifier: Modifier = Modifier,
) {
    var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }

    Surface(modifier) {
        if (shouldShowOnboarding) {
            OnboardingScreen(
                modifier = modifier,
                onContinueClicked = { shouldShowOnboarding = false }
            )
        } else {
            Greetings(modifier = modifier)
        }
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
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {

        var isExpanded by rememberSaveable { mutableStateOf(false) }

        Collapser(
            isExpanded = isExpanded,
            onClick = { isExpanded = isExpanded.not() },
        ) {
            Row(
                modifier = Modifier.padding(24.dp)
            ) {
                Column(Modifier.weight(1.0f)) {
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
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun Collapser(
    isExpanded: Boolean,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {

    val extraPadding by animateDpAsState(
        targetValue = if (isExpanded) 128.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMedium,
        )
    )

    Box(
        contentAlignment = Alignment.TopCenter,
    ) {
        content.invoke(this)
        AnimatedVisibility(
            visible = isExpanded,
            enter = scaleIn(animationSpec = tween(durationMillis = 100, delayMillis = 200)),
            exit = scaleOut(animationSpec = tween(durationMillis = 100, delayMillis = 0)),
            modifier = Modifier.padding(top = extraPadding)
        ) {
            IconButton(onClick = {
                onClick.invoke()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_chevron_up),
                    contentDescription = "Collapse icon",
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun CollapserPreview() {
    DustyToolsTheme {
        Surface {
            Collapser(isExpanded = true, onClick = { }) {
                Greeting(name = "Buddy") {}
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
private fun GreetingPreviewLight() {
    DustyToolsTheme {
        Surface {
            Greeting(name = "Buddy") {}
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES, widthDp = 320)
@Composable
private fun GreetingPreviewDark() {
    DustyToolsTheme {
        Surface {
            Greeting(name = "Buddy") {}
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
