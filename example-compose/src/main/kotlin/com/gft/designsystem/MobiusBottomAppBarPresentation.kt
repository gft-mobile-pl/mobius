package com.gft.designsystem

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gft.designsystem.BottomAppBarPresentationScrollType.Pinned
import com.gft.designsystem.BottomAppBarPresentationScrollType.ShowOrHideOnScroll
import com.gft.designsystem.BottomAppBarPresentationUsage.WithBottomAppBarScopeComponent
import com.gft.designsystem.BottomAppBarPresentationUsage.WithBottomAppBarScopeModifier
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
import com.gft.mobius.components.RadioButton
import com.gft.mobius.components.ScaffoldScreen
import com.gft.mobius.components.Screen
import com.gft.mobius.components.ScreenScope
import com.gft.mobius.components.Text
import com.gft.mobius.components.TopAppBar
import com.gft.mobius.components.appBarsScope

private const val menuDestination = "menuDestination"
private const val sampleDestination = "sampleDestination"

@Composable
fun MobiusBottomAppBarPresentation() {
    Mobius {
        val navController = rememberNavController()
        val scrollType = remember { mutableStateOf(Pinned) }
        val usage = remember { mutableStateOf(WithBottomAppBarScopeComponent) }

        NavHost(navController = navController, startDestination = menuDestination) {
            composable(menuDestination) {
                Menu(scrollType, usage, navController)
            }
            composable(sampleDestination) {
                BottomAppBarSampleScreen(
                    presentationScrollType = scrollType.value,
                    usage = usage.value
                )
            }
        }
    }
}

@Composable
private fun Menu(
    scrollType: MutableState<BottomAppBarPresentationScrollType>,
    usage: MutableState<BottomAppBarPresentationUsage>,
    controller: NavController
) {
    Screen {
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
                onClick = { controller.navigate(sampleDestination) }
            ) {
                Text(text = "Show sample")
            }
        }
    }
}

@Composable
private fun BottomAppBarSampleScreen(
    presentationScrollType: BottomAppBarPresentationScrollType,
    usage: BottomAppBarPresentationUsage
) {
    val scrollType = when (presentationScrollType) {
        Pinned -> BottomAppBar.ScrollType.pinned()
        ShowOrHideOnScroll -> BottomAppBar.ScrollType.showOrHideOnScroll()
    }
    Screen {
        when (usage) {
            WithBottomAppBarScopeComponent ->
                AppBarsScope(
                    topAppBarScrollConfig = TopAppBar.scrollConfig(scrollType = TopAppBar.ScrollType.showOrHideOnScroll()),
                    bottomAppBarScrollConfig = BottomAppBar.scrollConfig(scrollType = scrollType)
                ) {
                    ScreenContent()
                }

            WithBottomAppBarScopeModifier ->
                ScreenContent(
                    modifier = Modifier
                        .appBarsScope(
                            topAppBarScrollConfig = TopAppBar.scrollConfig(scrollType = TopAppBar.ScrollType.showOrHideOnScroll()),
                            bottomAppBarScrollConfig = BottomAppBar.scrollConfig(scrollType = scrollType)
                        )
                )
        }
    }
}

@Composable
private fun ScreenScope.ScreenContent(
    modifier: Modifier = Modifier
) {
    ScaffoldScreen(
        modifier = modifier,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(drawableResId = R.drawable.ic_menu, contentDescription = null)
                    }
                },
                title = { Text(text = "Title") },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(drawableResId = R.drawable.ic_account, contentDescription = null)
                    }
                    IconButton(onClick = { }) {
                        Icon(drawableResId = R.drawable.ic_settings, contentDescription = null)
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                actions = {
                    IconButton(onClick = { }) {
                        Icon(drawableResId = R.drawable.ic_account, contentDescription = null)
                    }
                    IconButton(onClick = { }) {
                        Icon(drawableResId = R.drawable.ic_settings, contentDescription = null)
                    }
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = {}) {
                        Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null)
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
