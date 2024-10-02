package com.gft.designsystem

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.Drawer
import com.gft.mobius.components.DrawerState.Closed
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.Icon
import com.gft.mobius.components.Item
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Content
import com.gft.mobius.components.Text
import com.gft.mobius.components.VerticalNavigation
import com.gft.mobius.components.rememberDrawerController
import com.gft.mobius.components.styles.DrawerStyle
import kotlinx.coroutines.launch

private const val menuDestination = "menuDestination"
private const val overlayDrawerDestination = "overlayDrawerDestination"
private const val slideDrawerDestination = "slideDrawerDestination"

@Composable
fun MobiusNavigationDrawerPresentation() {
    val navController = rememberNavController()
    Mobius {
        NavHost(
            navController = navController,
            startDestination = menuDestination
        ) {
            composable(menuDestination) {
                Screen {
                    Content {
                        Button(onClick = { navController.navigate(overlayDrawerDestination) }) {
                            Text("Overlay drawer")
                        }
                        ElementSpacer()
                        Button(onClick = { navController.navigate(slideDrawerDestination) }) {
                            Text("Slide drawer")
                        }
                    }
                }
            }

            composable(overlayDrawerDestination) {
                NavigationDrawerSampleScreen(
                    drawerStyle = Mobius.styles.drawerStyle,
                    handlePredictiveBack = true
                )
            }

            composable(slideDrawerDestination) {
                NavigationDrawerSampleScreen(
                    drawerStyle = Mobius.styles.drawerStyleVariant,
                    handlePredictiveBack = false
                )
            }
        }
    }
}

@Composable
private fun NavigationDrawerSampleScreen(
    drawerStyle: DrawerStyle,
    handlePredictiveBack: Boolean,
) {
    Screen {
        val scope = rememberCoroutineScope()
        val controller = rememberDrawerController(initialState = Closed)
        var selectedItem by remember { mutableIntStateOf(0) }
        Drawer(
            style = drawerStyle,
            drawerController = controller,
            handlePredictiveBack = handlePredictiveBack,
            drawerContent = {
                VerticalNavigation {
                    Item(
                        label = { Text(text = "Item 1") },
                        icon = { Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null) },
                        selected = selectedItem == 0,
                        onClick = {
                            selectedItem = 0
                            scope.launch { controller.close() }
                        }
                    )
                    Item(
                        label = { Text(text = "Item 2") },
                        icon = { Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null) },
                        selected = selectedItem == 1,
                        onClick = {
                            selectedItem = 1
                            scope.launch { controller.close() }
                        }
                    )
                    Item(
                        label = { Text(text = "Item 3") },
                        icon = { Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null) },
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
