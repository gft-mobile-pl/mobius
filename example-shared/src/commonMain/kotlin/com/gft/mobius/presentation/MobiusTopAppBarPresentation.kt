package com.gft.mobius.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.AppBarsScope
import com.gft.mobius.components.Button
import com.gft.mobius.components.Content
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.Icon
import com.gft.mobius.components.IconButton
import com.gft.mobius.components.Label
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.RadioButton
import com.gft.mobius.components.ScaffoldScreen
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Text
import com.gft.mobius.components.TopAppBar
import com.gft.mobius.components.appBarsScope
import com.gft.mobius.components.styles.TopAppBarStyle
import com.gft.mobius.presentation.TopAppBarPresentationScrollType.Pinned
import com.gft.mobius.presentation.TopAppBarPresentationScrollType.ScrollWithContent
import com.gft.mobius.presentation.TopAppBarPresentationScrollType.ShowOrHideOnScroll
import com.gft.mobius.presentation.TopAppBarPresentationStyle.Default
import com.gft.mobius.presentation.TopAppBarPresentationStyle.Variant
import com.gft.mobius.presentation.TopAppBarPresentationUsage.WithTopAppBarScopeComponent
import com.gft.mobius.presentation.TopAppBarPresentationUsage.WithTopAppBarScopeModifier
import mobius.example_shared.generated.resources.Res
import mobius.example_shared.generated.resources.ic_account
import mobius.example_shared.generated.resources.ic_back
import mobius.example_shared.generated.resources.ic_menu
import mobius.example_shared.generated.resources.ic_settings

private const val menuDestination = "menuDestination"
private const val sampleDestination = "sampleDestination"

@Composable
internal fun MobiusTopAppBarPresentation(
    onBack: () -> Unit,
) {
    val currentDestination = remember { mutableStateOf(menuDestination) }

    Mobius {
        val topAppBarStyle = remember { mutableStateOf(Default) }
        val scrollType = remember { mutableStateOf(Pinned) }
        val usage = remember { mutableStateOf(WithTopAppBarScopeComponent) }

        AnimatedContent(
            targetState = currentDestination.value,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            }
        ) { destination ->
            Box(modifier = Modifier.fillMaxSize()) {
                when (destination) {
                    menuDestination -> Menu(topAppBarStyle, scrollType, usage, onBack) {
                        currentDestination.value = sampleDestination
                    }

                    sampleDestination -> TopAppBarSampleScreen(
                        presentationStyle = topAppBarStyle.value,
                        presentationScrollType = scrollType.value,
                        usage = usage.value,
                        onBack = { currentDestination.value = menuDestination }
                    )
                }
            }
        }
    }
}

@Composable
private fun Menu(
    topAppBarStyle: MutableState<TopAppBarPresentationStyle>,
    scrollType: MutableState<TopAppBarPresentationScrollType>,
    usage: MutableState<TopAppBarPresentationUsage>,
    onBack: () -> Unit,
    onNavigateToSample: () -> Unit,
) {
    Screen {
        MobiusPresentationNavigationBar(
            title = "Top app bar",
            onBack = onBack,
        )
        Content {
            Text("TopAppBarStyle:")
            Label(
                modifier = Modifier.fillMaxWidth(),
                text = { Text(text = "Default") },
                onClick = { topAppBarStyle.value = Default }
            ) {
                RadioButton(
                    selected = topAppBarStyle.value == Default
                )
            }
            Label(
                modifier = Modifier.fillMaxWidth(),
                text = { Text(text = "Variant") },
                onClick = { topAppBarStyle.value = Variant }
            ) {
                RadioButton(
                    selected = topAppBarStyle.value == Variant
                )
            }
            ElementSpacer()
            Text("Top appbar scroll type:")
            Label(
                modifier = Modifier.fillMaxWidth(),
                text = { Text(text = "Pinned") },
                onClick = { scrollType.value = Pinned }
            ) {
                RadioButton(
                    selected = scrollType.value == Pinned
                )
            }
            Label(
                modifier = Modifier.fillMaxWidth(),
                text = { Text(text = "ShowOrHideOnScroll") },
                onClick = { scrollType.value = ShowOrHideOnScroll }
            ) {
                RadioButton(
                    selected = scrollType.value == ShowOrHideOnScroll
                )
            }
            Label(
                modifier = Modifier.fillMaxWidth(),
                text = { Text(text = "ScrollWithContent") },
                onClick = { scrollType.value = ScrollWithContent }
            ) {
                RadioButton(
                    selected = scrollType.value == ScrollWithContent
                )
            }
            ElementSpacer()
            Text("Usage type:")
            Label(
                modifier = Modifier.fillMaxWidth(),
                text = { Text(text = "with TopAppBarScope component") },
                onClick = { usage.value = WithTopAppBarScopeComponent }
            ) {
                RadioButton(
                    selected = usage.value == WithTopAppBarScopeComponent
                )
            }
            Label(
                modifier = Modifier.fillMaxWidth(),
                text = { Text(text = "with topAppBarScope modifier") },
                onClick = { usage.value = WithTopAppBarScopeModifier }
            ) {
                RadioButton(
                    selected = usage.value == WithTopAppBarScopeModifier
                )
            }
            ElementSpacer()
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onNavigateToSample,
            ) {
                Text(text = "Show sample")
            }
        }
    }
}

@Composable
private fun TopAppBarSampleScreen(
    presentationStyle: TopAppBarPresentationStyle,
    presentationScrollType: TopAppBarPresentationScrollType,
    usage: TopAppBarPresentationUsage,
    onBack: () -> Unit,
) {
    val topAppBarStyle = when (presentationStyle) {
        Default -> Mobius.styles.topAppBarStyle
        Variant -> Mobius.styles.topAppBarVariantStyle
    }
    val scrollType = when (presentationScrollType) {
        Pinned -> TopAppBar.ScrollType.pinned()
        ShowOrHideOnScroll -> TopAppBar.ScrollType.showOrHideOnScroll()
        ScrollWithContent -> TopAppBar.ScrollType.scrollWithContent()
    }
    when (usage) {
        WithTopAppBarScopeComponent ->
            AppBarsScope(
                topAppBarScrollConfig = TopAppBar.scrollConfig(scrollType = scrollType),
            ) {
                ScreenContent(
                    style = topAppBarStyle,
                    onBack = onBack,
                )
            }

        WithTopAppBarScopeModifier ->
            ScreenContent(
                style = topAppBarStyle,
                modifier = Modifier.appBarsScope(
                    topAppBarScrollConfig = TopAppBar.scrollConfig(scrollType = scrollType)
                ),
                onBack = onBack,
            )
    }
}

@Composable
private fun ScreenContent(
    style: TopAppBarStyle,
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    ScaffoldScreen(
        modifier = modifier,
        topBar = {
            TopAppBar(
                style = style,
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(drawableResource = Res.drawable.ic_back, contentDescription = null)
                    }
                },
                title = { Text(text = "Title") },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(drawableResource = Res.drawable.ic_account, contentDescription = null)
                    }
                    IconButton(onClick = { }) {
                        Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                    }
                }
            )
        }) { innerPadding ->
        Content(Modifier.padding(innerPadding)) {
            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
        }
    }
}

private enum class TopAppBarPresentationStyle {
    Default, Variant
}

private enum class TopAppBarPresentationScrollType {
    Pinned, ShowOrHideOnScroll, ScrollWithContent
}

private enum class TopAppBarPresentationUsage {
    WithTopAppBarScopeModifier, WithTopAppBarScopeComponent
}
