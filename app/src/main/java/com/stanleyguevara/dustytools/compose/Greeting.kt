package com.stanleyguevara.dustytools.compose

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stanleyguevara.dustytools.R
import com.stanleyguevara.dustytools.ui.theme.DustyToolsTheme
import kotlinx.coroutines.launch

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
            GreetingsScreen(modifier = modifier)
        }
    }
}

@Composable
fun GreetingsScreen(modifier: Modifier = Modifier) {
    val snackState = remember { SnackbarHostState() }
    val snackScope = rememberCoroutineScope()

    Box(modifier = modifier) {
        Greetings(
            modifier = modifier,
            onClickGreeting = {
                snackScope.launch {
                    snackState.showSnackbar("Sup? Here's some snacks.")
                }
            },
        )
        SnackbarHost(
            modifier = Modifier.align(Alignment.BottomCenter),
            hostState = snackState,
        )
    }
}

@Composable
fun Greetings(
    modifier: Modifier = Modifier,
    names: List<String> = List(100) { "Number $it" },
    onClickGreeting: () -> Unit,
) {
    LazyColumn(modifier = modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name) { onClickGreeting() }
        }
    }
}

@Composable
private fun Greeting(name: String, onClick: () -> Unit) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
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
                    if (isExpanded) {
                        Text(
                            text = ("Composem ipsum color sit lazy, \n" +
                                    "padding theme elit, sed do bouncy. \n").repeat(4),
                        )
                    }
                }
                IconButton(onClick = {
                    isExpanded = isExpanded.not()
                    onClick.invoke()
                }) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = if (isExpanded) "Show less" else "Show more",
                        tint = MaterialTheme.colorScheme.primary,
                    )
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
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier.animateContentSize(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioLowBouncy,
                stiffness = Spring.StiffnessMedium,
            )
        )
    ) {
        content.invoke(this)
        AnimatedVisibility(
            modifier = Modifier.align(Alignment.BottomCenter),
            visible = isExpanded,
            enter = scaleIn(animationSpec = tween(durationMillis = 100, delayMillis = 200)),
            exit = scaleOut(animationSpec = tween(durationMillis = 100, delayMillis = 0)),
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
