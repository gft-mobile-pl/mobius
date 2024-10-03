package com.gft.designsystem

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gft.designsystem.TopAppBarPresentationScrollType.ShowOrHideOnScroll
import com.gft.designsystem.TopAppBarPresentationScrollType.ScrollWithContent
import com.gft.designsystem.TopAppBarPresentationScrollType.Pinned
import com.gft.designsystem.TopAppBarPresentationStyle.Default
import com.gft.designsystem.TopAppBarPresentationStyle.Variant
import com.gft.designsystem.TopAppBarPresentationUsage.WithTopAppBarScopeComponent
import com.gft.designsystem.TopAppBarPresentationUsage.WithTopAppBarScopeModifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.Content
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.Icon
import com.gft.mobius.components.IconButton
import com.gft.mobius.components.RadioButton
import com.gft.mobius.components.Scaffold
import com.gft.mobius.components.Screen
import com.gft.mobius.components.ScreenScope
import com.gft.mobius.components.Text
import com.gft.mobius.components.TopAppBar
import com.gft.mobius.components.TopAppBarScope
import com.gft.mobius.components.TopAppBarScrollType
import com.gft.mobius.components.styles.TopAppBarStyle
import com.gft.mobius.components.topAppBarScope

private const val menuDestination = "menuDestination"
private const val sampleDestination = "sampleDestination"

@Composable
fun MobiusTopAppBarPresentation() {
    Mobius {
        val navController = rememberNavController()
        val topAppBarStyle = remember { mutableStateOf(Default) }
        val scrollType = remember { mutableStateOf(Pinned) }
        val usage = remember { mutableStateOf(WithTopAppBarScopeComponent) }

        NavHost(navController = navController, startDestination = menuDestination) {
            composable(menuDestination) {
                Menu(topAppBarStyle, scrollType, usage, navController)
            }
            composable(sampleDestination) {
                TopAppBarSampleScreen(
                    presentationStyle = topAppBarStyle.value,
                    presentationScrollType = scrollType.value,
                    usage = usage.value
                )
            }
        }
    }
}

@Composable
private fun Menu(
    topAppBarStyle: MutableState<TopAppBarPresentationStyle>,
    scrollType: MutableState<TopAppBarPresentationScrollType>,
    usage: MutableState<TopAppBarPresentationUsage>,
    controller: NavController
) {
    Screen {
        Content {
            Text("TopAppBarStyle:")
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = topAppBarStyle.value == Default,
                    onClick = { topAppBarStyle.value = Default }
                )
                Text(text = "Default")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = topAppBarStyle.value == Variant,
                    onClick = { topAppBarStyle.value = Variant }
                )
                Text(text = "Variant")
            }
            ElementSpacer()
            Text("Top appbar scroll type:")
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = scrollType.value == Pinned,
                    onClick = { scrollType.value = Pinned }
                )
                Text(text = "Pinned")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = scrollType.value == ShowOrHideOnScroll,
                    onClick = { scrollType.value = ShowOrHideOnScroll }
                )
                Text(text = "ShowOrHideOnScroll")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = scrollType.value == ScrollWithContent,
                    onClick = { scrollType.value = ScrollWithContent }
                )
                Text(text = "ScrollWithContent")
            }
            ElementSpacer()
            Text("Usage type:")
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = usage.value == WithTopAppBarScopeComponent,
                    onClick = { usage.value = WithTopAppBarScopeComponent }
                )
                Text(text = "with TopAppBarScope component")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = usage.value == WithTopAppBarScopeModifier,
                    onClick = { usage.value = WithTopAppBarScopeModifier }
                )
                Text(text = "with topAppBarScope modifier")
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
private fun TopAppBarSampleScreen(
    presentationStyle: TopAppBarPresentationStyle,
    presentationScrollType: TopAppBarPresentationScrollType,
    usage: TopAppBarPresentationUsage
) {
    val topAppBarStyle = when (presentationStyle) {
        Default -> Mobius.styles.topAppBarStyle
        Variant -> Mobius.styles.topAppBarVariantStyle
    }
    val scrollType = when (presentationScrollType) {
        Pinned -> TopAppBarScrollType.pinned()
        ShowOrHideOnScroll -> TopAppBarScrollType.showOrHideOnScroll()
        ScrollWithContent -> TopAppBarScrollType.scrollWithContent()
    }
    Screen {
        when (usage) {
            WithTopAppBarScopeComponent ->
                TopAppBarScope(
                    scrollType = scrollType
                ) {
                    ScreenContent(
                        style = topAppBarStyle
                    )
                }

            WithTopAppBarScopeModifier ->
                ScreenContent(
                    style = topAppBarStyle, modifier = Modifier.topAppBarScope(
                        scrollType = scrollType,
                    )
                )
        }
    }
}

@Composable
private fun ScreenScope.ScreenContent(
    style: TopAppBarStyle,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                style = style,
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
