package com.gft.mobius.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.gft.mobius.Mobius
import com.gft.mobius.colors.LocalContentColor
import com.gft.mobius.components.Button
import com.gft.mobius.components.Checkbox
import com.gft.mobius.components.Content
import com.gft.mobius.components.DialogScreen
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.Header
import com.gft.mobius.components.Label
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.RadioButton
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Text
import com.gft.mobius.presentation.HeaderPresentationContentLength.EXPANDING
import com.gft.mobius.presentation.HeaderPresentationContentLength.LONG
import com.gft.mobius.presentation.HeaderPresentationContentLength.SHORT
import com.gft.mobius.utils.randomColor

private const val menuDestination = "menuDestination"
private const val screenWithFixedHeaderDestination = "screenWithFixedHeaderDestination"
private const val screenWithInContentHeader = "screenWithInContentHeader"
private const val dialogScreenWithFixedHeaderDestination = "dialogScreenWithFixedHeaderDestination"
private const val dialogScreenWithInContentHeader = "dialogScreenWithInContentHeader"

@Composable
internal fun MobiusHeaderPresentation(
    onBack: () -> Unit,
) {
    val currentDestination = remember { mutableStateOf(menuDestination) }

    Mobius {
        val useScrollableContainer = remember {
            mutableStateOf(true)
        }
        val contentLength = remember {
            mutableStateOf(LONG)
        }
        AnimatedContent(
            targetState = currentDestination.value,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            }
        ) { destination ->
            Box(modifier = Modifier.fillMaxSize()) {
                when (destination) {
                    menuDestination -> Menu(useScrollableContainer, contentLength, onBack) { targetDestination ->
                        currentDestination.value = targetDestination
                    }

                    screenWithFixedHeaderDestination -> ScreenWithFixedHeader(useScrollableContainer.value, contentLength.value) {
                        currentDestination.value = menuDestination
                    }

                    screenWithInContentHeader -> ScreenWithInContentHeader(useScrollableContainer.value, contentLength.value) {
                        currentDestination.value = menuDestination
                    }

                    dialogScreenWithFixedHeaderDestination -> Dialog(
                        onDismissRequest = { currentDestination.value = menuDestination }
                    ) {
                        DialogWithFixedHeader(useScrollableContainer.value, contentLength.value)
                    }

                    dialogScreenWithInContentHeader -> Dialog(
                        onDismissRequest = { currentDestination.value = menuDestination }
                    ) {
                        DialogWithInContentHeader(useScrollableContainer.value, contentLength.value)
                    }
                }
            }
        }
    }
}

@Composable
private fun Menu(
    useScrollableContainer: MutableState<Boolean>,
    contentLength: MutableState<HeaderPresentationContentLength>,
    onBack: () -> Unit,
    onNavigateToDestination: (String) -> Unit,
) {
    Screen {
        MobiusPresentationNavigationBar(
            title = "Header",
            onBack = onBack,
        )
        Content {
            Text(text = "Content length:")
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Label(
                    text = { Text(text = "Short ") },
                    onClick = { contentLength.value = SHORT }
                ) {
                    RadioButton(selected = contentLength.value == SHORT)
                }
                Label(
                    text = { Text(text = "Long ") },
                    onClick = { contentLength.value = LONG }
                ) {
                    RadioButton(selected = contentLength.value == LONG)
                }
                Label(
                    text = { Text(text = "Expanding ") },
                    onClick = { contentLength.value = EXPANDING }
                ) {
                    RadioButton(selected = contentLength.value == EXPANDING)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.Left,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Content scrollable:")
                Checkbox(
                    checked = useScrollableContainer.value,
                    onCheckedChange = {
                        useScrollableContainer.value = it
                    }
                )
            }
            ElementSpacer()
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onNavigateToDestination(screenWithFixedHeaderDestination)
                }
            ) {
                Text(text = "Screen with fixed header")
            }
            ElementSpacer()
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onNavigateToDestination(screenWithInContentHeader)
                }
            ) {
                Text(text = "Screen with in-content header")
            }
            ElementSpacer()
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onNavigateToDestination(dialogScreenWithFixedHeaderDestination)
                }
            ) {
                Text(text = "Dialog with fixed header")
            }
            ElementSpacer()
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onNavigateToDestination(dialogScreenWithInContentHeader)
                }
            ) {
                Text(text = "Dialog with in-content header")
            }

        }
    }
}

@Composable
private fun DialogWithFixedHeader(
    useScrollableContainer: Boolean,
    contentLength: HeaderPresentationContentLength,
) {
    DialogScreen(
        modifier = Modifier
            .heightIn(0.dp, 600.dp)
    ) {
        Header(
            modifier = Modifier
                .background(
                    // Note: prefer using style than hardcoding background like this
                    Brush.verticalGradient(
                        0.0f to Mobius.colors.primary,
                        1.0f to Mobius.colors.tertiary
                    )
                )
        ) {
            CompositionLocalProvider(LocalContentColor provides Mobius.colors.onPrimary) {
                Text(
                    text = "Custom in-box placement",
                    style = Mobius.typography.labelSmall,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset((-2).dp, (-2).dp),
                )
                Content {
                    Text(
                        text = "This is title",
                        style = Mobius.typography.titleLarge
                    )
                    Text(
                        text = "Content padded",
                        style = Mobius.typography.labelSmall,
                        modifier = Modifier.align(Alignment.TopEnd)
                    )
                }
            }
        }
        Content(
            modifier = Modifier.width(IntrinsicSize.Max),
            isScrollable = useScrollableContainer
        ) { SampleContent(contentLength) }
    }
}

@Composable
private fun DialogWithInContentHeader(
    useScrollableContainer: Boolean,
    contentLength: HeaderPresentationContentLength,
) {
    DialogScreen(
        modifier = Modifier
            .heightIn(0.dp, 600.dp)
    ) {
        Content(
            modifier = Modifier.width(IntrinsicSize.Max),
            isScrollable = useScrollableContainer
        ) {
            Header(
                modifier = Modifier
                    .background(
                        // Note: prefer using style than hardcoding background like this
                        Brush.verticalGradient(
                            0.0f to Mobius.colors.primary,
                            1.0f to Mobius.colors.tertiary
                        )
                    )
            ) {
                CompositionLocalProvider(LocalContentColor provides Mobius.colors.onPrimary) {
                    Text(
                        text = "Custom in-box placement",
                        style = Mobius.typography.labelSmall,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset((-2).dp, (-2).dp),
                    )
                    Content {
                        Text(
                            text = "This is title",
                            style = Mobius.typography.titleLarge
                        )
                        Text(
                            text = "Content padded",
                            style = Mobius.typography.labelSmall,
                            modifier = Modifier.align(Alignment.TopEnd)
                        )
                    }
                }
            }
            SampleContent(contentLength)
        }
    }
}

@Composable
private fun ScreenWithFixedHeader(
    useScrollableContainer: Boolean,
    contentLength: HeaderPresentationContentLength,
    onBack: () -> Unit,
) {
    Screen {
        MobiusPresentationNavigationBar(
            title = "Fixed header",
            onBack = onBack,
        )
        Header(
            modifier = Modifier
                .background(
                    // Note: prefer using style than hardcoding background like this
                    Brush.verticalGradient(
                        0.0f to Mobius.colors.primary,
                        1.0f to Mobius.colors.tertiary
                    )
                )
        ) {
            CompositionLocalProvider(LocalContentColor provides Mobius.colors.onPrimary) {
                Text(
                    text = "Custom in-box placement",
                    style = Mobius.typography.labelSmall,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset((-2).dp, (-2).dp),
                )
                Content {
                    Text(
                        text = "This is title",
                        style = Mobius.typography.titleLarge
                    )
                    Text(
                        text = "Content padded",
                        style = Mobius.typography.labelSmall,
                        modifier = Modifier.align(Alignment.TopEnd)
                    )
                }
            }
        }
        Content(isScrollable = useScrollableContainer) { SampleContent(contentLength) }
    }
}

@Composable
private fun ScreenWithInContentHeader(
    useScrollableContainer: Boolean,
    contentLength: HeaderPresentationContentLength,
    onBack: () -> Unit,
) {
    Screen {
        MobiusPresentationNavigationBar(
            title = "In content header",
            onBack = onBack,
        )
        Content(
            isScrollable = useScrollableContainer
        ) {
            Header(
                modifier = Modifier
                    .background(
                        // Note: prefer using style than hardcoding background like this
                        Brush.verticalGradient(
                            0.0f to Mobius.colors.primary,
                            1.0f to Mobius.colors.tertiary
                        )
                    )
            ) {
                CompositionLocalProvider(LocalContentColor provides Mobius.colors.onPrimary) {
                    Text(
                        text = "Custom in-box placement",
                        style = Mobius.typography.labelSmall,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset((-2).dp, (-2).dp),
                    )
                    Content {
                        Text(
                            text = "This is title",
                            style = Mobius.typography.titleLarge
                        )
                        Text(
                            text = "Content padded",
                            style = Mobius.typography.labelSmall,
                            modifier = Modifier.align(Alignment.TopEnd)
                        )
                    }
                }
            }
            SampleContent(contentLength)
        }
    }
}

@Composable
private fun ColumnScope.SampleContent(contentLength: HeaderPresentationContentLength) {
    when (contentLength) {
        SHORT -> ShortContent()
        LONG -> LongContent()
        EXPANDING -> ExpandingContent()
    }
}

@Composable
private fun ColumnScope.LongContent() {
    Text(text = "This is some short sample text.")
    ElementSpacer()
    repeat(30) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(randomColor())
        )
    }
    ElementSpacer()
    Text(
        text = "Last content item",
        modifier = Modifier
            .background(Mobius.colors.primary),
        color = Mobius.colors.onPrimary
    )
}

@Composable
private fun ColumnScope.ShortContent() {
    Text(text = "This is some short sample text.")
    ElementSpacer()
    repeat(5) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(randomColor())
        )
    }
    ElementSpacer()
    Text(
        text = "Last content item",
        modifier = Modifier
            .background(Mobius.colors.primary),
        color = Mobius.colors.onPrimary
    )
}

@Composable
private fun ColumnScope.ExpandingContent() {
    Text(text = "This is some short sample text.")
    ElementSpacer()
    repeat(5) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
                .background(randomColor())
        )
    }
    Column(
        modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color(0xffffff80))
            .border(1.dp, Color(0xffffd0d0)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "This item consumes\nall available height.\nIt uses Modifier.weight(1f)")
    }
    Text(
        text = "Last content item",
        modifier = Modifier
            .background(Mobius.colors.primary),
        color = Mobius.colors.onPrimary
    )
}

private enum class HeaderPresentationContentLength {
    SHORT,
    LONG,
    EXPANDING
}
