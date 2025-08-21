package com.gft.mobius.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.Content
import com.gft.mobius.components.Drawer
import com.gft.mobius.components.DrawerState.Closed
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.Icon
import com.gft.mobius.components.Item
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Text
import com.gft.mobius.components.VerticalNavigation
import com.gft.mobius.components.rememberDrawerController
import com.gft.mobius.components.styles.DrawerStyle
import kotlinx.coroutines.launch
import mobius.example_shared.generated.resources.Res
import mobius.example_shared.generated.resources.ic_notifications

private const val menuDestination = "menuDestination"
private const val overlayDrawerDestination = "overlayDrawerDestination"
private const val slideDrawerDestination = "slideDrawerDestination"

@Composable
internal fun MobiusNavigationDrawerPresentation(
    onBack: () -> Unit,
) {
    val currentDestination = remember { mutableStateOf(menuDestination) }

    Mobius {
        AnimatedContent(
            targetState = currentDestination.value,
            transitionSpec = {
                fadeIn() togetherWith fadeOut()
            }
        ) { destination ->
            Box(modifier = Modifier.fillMaxSize()) {
                when (destination) {
                    menuDestination -> Screen {
                        MobiusPresentationNavigationBar(
                            title = "Navigation drawer",
                            onBack = onBack,
                        )
                        Content {
                            Button(onClick = { currentDestination.value = overlayDrawerDestination }) {
                                Text("Overlay drawer")
                            }
                            ElementSpacer()
                            Button(onClick = { currentDestination.value = slideDrawerDestination }) {
                                Text("Slide drawer")
                            }
                        }
                    }

                    overlayDrawerDestination -> NavigationDrawerSampleScreen(
                        drawerStyle = Mobius.styles.drawerStyle,
                        title = "Overlay drawer",
                        onBack = { currentDestination.value = menuDestination },
                    )

                    slideDrawerDestination -> NavigationDrawerSampleScreen(
                        drawerStyle = Mobius.styles.drawerStyleVariant,
                        title = "Slide drawer",
                        onBack = { currentDestination.value = menuDestination },
                    )
                }
            }
        }
    }
}

@Composable
private fun NavigationDrawerSampleScreen(
    drawerStyle: DrawerStyle,
    title: String,
    onBack: () -> Unit,
) {
    Screen {
        val scope = rememberCoroutineScope()
        val controller = rememberDrawerController(initialState = Closed)
        var selectedItem by remember { mutableIntStateOf(0) }
        Drawer(
            style = drawerStyle,
            drawerController = controller,
            drawerContent = {
                VerticalNavigation {
                    Item(
                        label = { Text(text = "Item 1") },
                        icon = { Icon(drawableResource = Res.drawable.ic_notifications, contentDescription = null) },
                        selected = selectedItem == 0,
                        onClick = {
                            selectedItem = 0
                            scope.launch { controller.close() }
                        }
                    )
                    Item(
                        label = { Text(text = "Item 2") },
                        icon = { Icon(drawableResource = Res.drawable.ic_notifications, contentDescription = null) },
                        selected = selectedItem == 1,
                        onClick = {
                            selectedItem = 1
                            scope.launch { controller.close() }
                        }
                    )
                    Item(
                        label = { Text(text = "Item 3") },
                        icon = { Icon(drawableResource = Res.drawable.ic_notifications, contentDescription = null) },
                        badge = { Text(text = "10") },
                        selected = selectedItem == 2,
                        onClick = {
                            selectedItem = 2
                            scope.launch { controller.close() }
                        }
                    )
                }
            },
        ) {
            Column {
                MobiusPresentationNavigationBar(
                    title = title,
                    onBack = onBack,
                )
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Button(onClick = {
                        scope.launch { controller.open() }
                    }) {
                        Text(text = "Click to open drawer")
                    }
                }
            }
        }
    }
}
