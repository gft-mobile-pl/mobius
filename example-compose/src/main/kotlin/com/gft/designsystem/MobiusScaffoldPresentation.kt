package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.gft.mobius.Mobius
import com.gft.mobius.components.FloatingActionButton
import com.gft.mobius.components.Icon
import com.gft.mobius.components.NavigationBar
import com.gft.mobius.components.NavigationBarItem
import com.gft.mobius.components.ScaffoldScreen
import com.gft.mobius.components.Text

@Composable
fun MobiusScaffoldPresentation() {
    Mobius {
        var selectedNavigationItem by remember { mutableIntStateOf(0) }
        ScaffoldScreen(
            floatingActionButton = {
                FloatingActionButton(onClick = { }) {
                    Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null)
                }
            },
            bottomBar = {
                NavigationBar {
                    NavigationBarItem(
                        selected = selectedNavigationItem == 0,
                        onClick = { selectedNavigationItem = 0 },
                        icon = { Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null) },
                        label = { Text("Notifications") }
                    )
                    NavigationBarItem(
                        selected = selectedNavigationItem == 1,
                        onClick = { selectedNavigationItem = 1 },
                        icon = { Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null) },
                        label = { Text("Notifications") }
                    )
                    NavigationBarItem(
                        selected = selectedNavigationItem == 2,
                        onClick = { selectedNavigationItem = 2 },
                        icon = { Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null) },
                        label = { Text("Notifications") }
                    )
                }
            }
        ) {

        }
    }
}
