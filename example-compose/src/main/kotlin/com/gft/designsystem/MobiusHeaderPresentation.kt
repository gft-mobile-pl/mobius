package com.gft.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import androidx.navigation.compose.rememberNavController
import com.gft.designsystem.HeaderPresentationContentLength.EXPANDING
import com.gft.designsystem.HeaderPresentationContentLength.LONG
import com.gft.designsystem.HeaderPresentationContentLength.SHORT
import com.gft.designsystem.utils.randomColor
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.Checkbox
import com.gft.mobius.components.Content
import com.gft.mobius.components.DialogScreen
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.Header
import com.gft.mobius.components.RadioButton
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Text

private const val menuDestination = "menuDestination"
private const val screenWithFixedHeaderDestination = "screenWithFixedHeaderDestination"
private const val screenWithInContentHeader = "screenWithInContentHeader"
private const val dialogScreenWithFixedHeaderDestination = "dialogScreenWithFixedHeaderDestination"
private const val dialogScreenWithInContentHeader = "dialogScreenWithInContentHeader"


@Composable
fun MobiusHeaderPresentation() {
    val useScrollableContainer = remember {
        mutableStateOf(true)
    }
    val contentLength = remember {
        mutableStateOf(LONG)
    }
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = menuDestination
    ) {
        composable(menuDestination) {
            Menu(useScrollableContainer, contentLength, navController)
        }
        composable(screenWithFixedHeaderDestination) {
            ScreenWithFixedHeaderDestination(useScrollableContainer.value, contentLength.value)
        }
        composable(screenWithInContentHeader) {
            ScreenWithInContentHeaderDestination(useScrollableContainer.value, contentLength.value)
        }

        dialog(dialogScreenWithFixedHeaderDestination) {
            DialogWithFixedHeaderDestination(useScrollableContainer.value, contentLength.value)
        }

        dialog(dialogScreenWithInContentHeader) {
            DialogWithInContentHeaderDestination(useScrollableContainer.value, contentLength.value)
        }
    }
}

@Composable
private fun Menu(
    useScrollableContainer: MutableState<Boolean>,
    contentLength: MutableState<HeaderPresentationContentLength>,
    navController: NavController,
) {
    Screen {
        Content {
            Text(text = "Content length:")
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = contentLength.value == SHORT,
                    onClick = { contentLength.value = SHORT }
                )
                Text(text = "Short ")
                RadioButton(
                    selected = contentLength.value == LONG,
                    onClick = { contentLength.value = LONG }
                )
                Text(text = "Long ")
                RadioButton(
                    selected = contentLength.value == EXPANDING,
                    onClick = { contentLength.value = EXPANDING }
                )
                Text(text = "Expanding ")
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
                onClick = { navController.navigate(screenWithFixedHeaderDestination) }
            ) {
                Text(text = "Screen with fixed header")
            }
            ElementSpacer()
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(screenWithInContentHeader) }
            ) {
                Text(text = "Screen with in-content header")
            }
            ElementSpacer()
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(dialogScreenWithFixedHeaderDestination) }
            ) {
                Text(text = "Dialog with fixed header")
            }
            ElementSpacer()
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navController.navigate(dialogScreenWithInContentHeader) }
            ) {
                Text(text = "Dialog with in-content header")
            }

        }
    }
}


@Composable
private fun DialogWithFixedHeaderDestination(
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
                    Brush.verticalGradient(
                        0.0f to Mobius.colors.primary,
                        1.0f to Mobius.colors.tertiary
                    )
                )
        ) {
            Text(
                text = "Custom in-box placement",
                style = Mobius.typography.labelSmall,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset((-2).dp, (-2).dp),
                color = Mobius.colors.onPrimary,
            )
            Content(
                modifier = Modifier.fillMaxWidth()
            ) {
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
        Content(isScrollable = useScrollableContainer) { SampleContent(contentLength) }
    }
}


@Composable
private fun DialogWithInContentHeaderDestination(
    useScrollableContainer: Boolean,
    contentLength: HeaderPresentationContentLength,
) {
    DialogScreen(
        modifier = Modifier
            .heightIn(0.dp, 600.dp)
    ) {
        Content(
            isScrollable = useScrollableContainer
        ) {
            Header(
                modifier = Modifier
                    .background(
                        Brush.verticalGradient(
                            0.0f to Mobius.colors.primary,
                            1.0f to Mobius.colors.tertiary
                        )
                    )
            ) {
                Text(
                    text = "Custom in-box placement",
                    style = Mobius.typography.labelSmall,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset((-2).dp, (-2).dp),
                    color = Mobius.colors.onPrimary,
                )
                Content(
                    modifier = Modifier.fillMaxWidth()
                ) {
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
            SampleContent(contentLength)
        }
    }
}

@Composable
private fun ScreenWithFixedHeaderDestination(
    useScrollableContainer: Boolean,
    contentLength: HeaderPresentationContentLength,
) {
    Screen {
        Header(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        0.0f to Mobius.colors.primary,
                        1.0f to Mobius.colors.tertiary
                    )
                )
        ) {
            Text(
                text = "Custom in-box placement",
                style = Mobius.typography.labelSmall,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset((-2).dp, (-2).dp),
                color = Mobius.colors.onPrimary,
            )
            Content(
                modifier = Modifier.fillMaxWidth()
            ) {
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
        Content(isScrollable = useScrollableContainer) { SampleContent(contentLength) }
    }
}

@Composable
private fun ScreenWithInContentHeaderDestination(
    useScrollableContainer: Boolean,
    contentLength: HeaderPresentationContentLength,
) {
    Screen {
        Content(
            isScrollable = useScrollableContainer
        ) {
            Header(
                modifier = Modifier
                    .background(
                        Brush.verticalGradient(
                            0.0f to Mobius.colors.primary,
                            1.0f to Mobius.colors.tertiary
                        )
                    )
            ) {
                Text(
                    text = "Custom in-box placement",
                    style = Mobius.typography.labelSmall,
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset((-2).dp, (-2).dp),
                    color = Mobius.colors.onPrimary,
                )
                Content(
                    modifier = Modifier.fillMaxWidth()
                ) {
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