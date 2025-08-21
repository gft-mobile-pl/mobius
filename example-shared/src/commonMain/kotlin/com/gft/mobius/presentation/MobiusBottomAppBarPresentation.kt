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
import com.gft.mobius.components.BottomAppBar
import com.gft.mobius.components.Button
import com.gft.mobius.components.Content
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.FloatingActionButton
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
import com.gft.mobius.presentation.BottomAppBarPresentationScrollType.Pinned
import com.gft.mobius.presentation.BottomAppBarPresentationScrollType.ShowOrHideOnScroll
import com.gft.mobius.presentation.BottomAppBarPresentationUsage.WithBottomAppBarScopeComponent
import com.gft.mobius.presentation.BottomAppBarPresentationUsage.WithBottomAppBarScopeModifier
import mobius.example_shared.generated.resources.Res
import mobius.example_shared.generated.resources.ic_account
import mobius.example_shared.generated.resources.ic_back
import mobius.example_shared.generated.resources.ic_menu
import mobius.example_shared.generated.resources.ic_notifications
import mobius.example_shared.generated.resources.ic_settings
import org.jetbrains.compose.resources.painterResource

private const val menuDestination = "menuDestination"
private const val sampleDestination = "sampleDestination"

@Composable
internal fun MobiusBottomAppBarPresentation(
    onBack: () -> Unit,
) {
    val currentDestination = remember { mutableStateOf(menuDestination) }

    Mobius {
        val scrollType = remember { mutableStateOf(Pinned) }
        val usage = remember { mutableStateOf(WithBottomAppBarScopeComponent) }

        AnimatedContent(
            targetState = currentDestination.value,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            }
        ) { destination ->
            Box(modifier = Modifier.fillMaxSize()) {
                when (destination) {
                    menuDestination -> Menu(scrollType, usage, onBack) {
                        currentDestination.value = sampleDestination
                    }

                    sampleDestination -> BottomAppBarSampleScreen(
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
    scrollType: MutableState<BottomAppBarPresentationScrollType>,
    usage: MutableState<BottomAppBarPresentationUsage>,
    onBack: () -> Unit,
    onNavigateToSample: () -> Unit,
) {

    Screen {
        MobiusPresentationNavigationBar(
            title = "Bottom app bar",
            onBack = onBack,
        )
        Content {
            Text("Bottom appbar scroll type:")
            Label(
                modifier = Modifier.fillMaxWidth(),
                text = { Text(text = "Pinned") },
                onClick = { scrollType.value = Pinned }
            ) {
                RadioButton(
                    selected = scrollType.value == Pinned,
                )
            }
            Label(
                modifier = Modifier.fillMaxWidth(),
                text = { Text(text = "ShowOrHideOnScroll") },
                onClick = { scrollType.value = ShowOrHideOnScroll }
            ) {
                RadioButton(
                    selected = scrollType.value == ShowOrHideOnScroll,
                )
            }
            ElementSpacer()
            Text("Usage type:")
            Label(
                modifier = Modifier.fillMaxWidth(),
                text = { Text(text = "with BottomAppBarScope component") },
                onClick = { usage.value = WithBottomAppBarScopeComponent }
            ) {
                RadioButton(
                    selected = usage.value == WithBottomAppBarScopeComponent
                )
            }
            Label(
                modifier = Modifier.fillMaxWidth(),
                text = { Text(text = "with bottomAppBarScope modifier") },
                onClick = { usage.value = WithBottomAppBarScopeModifier }
            ) {
                RadioButton(
                    selected = usage.value == WithBottomAppBarScopeModifier
                )
            }
            ElementSpacer()
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onNavigateToSample() }
            ) {
                Text(text = "Show sample")
            }
        }
    }
}

@Composable
private fun BottomAppBarSampleScreen(
    presentationScrollType: BottomAppBarPresentationScrollType,
    usage: BottomAppBarPresentationUsage,
    onBack: () -> Unit,
) {
    val scrollType = when (presentationScrollType) {
        Pinned -> BottomAppBar.ScrollType.pinned()
        ShowOrHideOnScroll -> BottomAppBar.ScrollType.showOrHideOnScroll()
    }
    when (usage) {
        WithBottomAppBarScopeComponent ->
            AppBarsScope(
                topAppBarScrollConfig = TopAppBar.scrollConfig(scrollType = TopAppBar.ScrollType.showOrHideOnScroll()),
                bottomAppBarScrollConfig = BottomAppBar.scrollConfig(scrollType = scrollType)
            ) {
                ScreenContent(onBack = onBack)
            }

        WithBottomAppBarScopeModifier ->
            ScreenContent(
                modifier = Modifier
                    .appBarsScope(
                        topAppBarScrollConfig = TopAppBar.scrollConfig(scrollType = TopAppBar.ScrollType.showOrHideOnScroll()),
                        bottomAppBarScrollConfig = BottomAppBar.scrollConfig(scrollType = scrollType)
                    ),
                onBack = onBack,
            )
    }
}

@Composable
private fun ScreenContent(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
) {
    ScaffoldScreen(
        modifier = modifier,
        topBar = {
            TopAppBar(
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
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { }) {
                        Icon(drawableResource = Res.drawable.ic_account, contentDescription = null)
                    }
                    IconButton(onClick = { }) {
                        Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {}) {
                        Icon(drawableResource = Res.drawable.ic_notifications, contentDescription = null)
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

private enum class BottomAppBarPresentationScrollType {
    Pinned, ShowOrHideOnScroll
}

private enum class BottomAppBarPresentationUsage {
    WithBottomAppBarScopeModifier, WithBottomAppBarScopeComponent
}
