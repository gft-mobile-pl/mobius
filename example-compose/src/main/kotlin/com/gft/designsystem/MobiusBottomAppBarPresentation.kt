package com.gft.designsystem

import androidx.compose.foundation.layout.ColumnScope
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
import com.gft.mobius.components.BottomAppBar
import com.gft.mobius.components.BottomAppBarScope
import com.gft.mobius.components.BottomAppBarScrollType
import com.gft.mobius.components.Button
import com.gft.mobius.components.Content
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.FloatingActionButton
import com.gft.mobius.components.Icon
import com.gft.mobius.components.IconButton
import com.gft.mobius.components.Label
import com.gft.mobius.components.RadioButton
import com.gft.mobius.components.Scaffold
import com.gft.mobius.components.Screen
import com.gft.mobius.components.ScreenScope
import com.gft.mobius.components.Text
import com.gft.mobius.components.TopAppBar
import com.gft.mobius.components.TopAppBarScope
import com.gft.mobius.components.TopAppBarScrollType
import com.gft.mobius.components.bottomAppBarScope
import com.gft.mobius.components.topAppBarScope

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
                text = { Text(text = "Pinned") },
                onClick = { scrollType.value = Pinned }
            ) {
                RadioButton(
                    selected = scrollType.value == Pinned,
                )
            }
            Label(
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
                text = { Text(text = "with BottomAppBarScope component") },
                onClick = { usage.value = WithBottomAppBarScopeComponent }
            ) {
                RadioButton(
                    selected = usage.value == WithBottomAppBarScopeComponent
                )
            }
            Label(
                text = { Text(text = "with bottomAppBarScope modifier") },
                onClick = { usage.value = WithBottomAppBarScopeModifier }
            ) {
                RadioButton(
                    selected = usage.value == WithBottomAppBarScopeModifier
                )
            }
            ElementSpacer()
            MenuItem(text = "Show sample", onClick = { controller.navigate(sampleDestination) })
        }
    }
}

@Composable
private fun ColumnScope.MenuItem(
    onClick: () -> Unit,
    text: String,
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick
    ) {
        Text(text = text)
    }
    ElementSpacer()
}

@Composable
private fun BottomAppBarSampleScreen(
    presentationScrollType: BottomAppBarPresentationScrollType,
    usage: BottomAppBarPresentationUsage
) {
    val scrollType = when (presentationScrollType) {
        Pinned -> BottomAppBarScrollType.pinned()
        ShowOrHideOnScroll -> BottomAppBarScrollType.showOrHideOnScroll()
    }
    Screen {
        when (usage) {
            WithBottomAppBarScopeComponent ->
                TopAppBarScope(scrollType = TopAppBarScrollType.showOrHideOnScroll()) {
                    BottomAppBarScope(
                        scrollType = scrollType
                    ) {
                        ScreenContent()
                    }
                }

            WithBottomAppBarScopeModifier ->
                ScreenContent(
                    modifier = Modifier
                        .bottomAppBarScope(scrollType = scrollType)
                        .topAppBarScope(scrollType = TopAppBarScrollType.showOrHideOnScroll())
                )
        }
    }
}

@Composable
private fun ScreenScope.ScreenContent(
    modifier: Modifier = Modifier
) {
    Scaffold(
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
