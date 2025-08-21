package com.gft.mobius.presentation

import androidx.compose.runtime.Composable
import com.gft.mobius.Mobius
import com.gft.mobius.components.Content
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.FloatingActionButton
import com.gft.mobius.components.Icon
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.ScaffoldScreen
import com.gft.mobius.components.Text
import mobius.example_shared.generated.resources.Res
import mobius.example_shared.generated.resources.ic_notifications

@Composable
internal fun MobiusFloatingActionButtonPresentation(
    onBack: () -> Unit,
) {
    Mobius {
        ScaffoldScreen(
            topBar = { MobiusPresentationNavigationBar(
                title = "Floating action button",
                onBack = onBack,
            ) },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {}
                ) {
                    Icon(drawableResource = Res.drawable.ic_notifications, contentDescription = null)
                }
            }
        ) {
            Content {
                FloatingActionButton(
                    style = Mobius.styles.secondaryFloatingActionButtonStyle,
                    onClick = {}
                ) {
                    Icon(drawableResource = Res.drawable.ic_notifications, contentDescription = null)
                }
                ElementSpacer()

                FloatingActionButton(
                    text = { Text(text = "Notifications") },
                    style = Mobius.styles.secondaryFloatingActionButtonStyle,
                    onClick = {}
                ) {
                    Icon(drawableResource = Res.drawable.ic_notifications, contentDescription = null)
                }
                ElementSpacer()

                FloatingActionButton(
                    onClick = {}
                ) {
                    Icon(drawableResource = Res.drawable.ic_notifications, contentDescription = null)
                }
                ElementSpacer()

                FloatingActionButton(
                    text = { Text(text = "Notifications") },
                    onClick = { }
                ) {
                    Icon(drawableResource = Res.drawable.ic_notifications, contentDescription = null)
                }
                ElementSpacer()

                FloatingActionButton(
                    style = Mobius.styles.prominentFloatingActionButtonStyle,
                    onClick = {}
                ) {
                    Icon(drawableResource = Res.drawable.ic_notifications, contentDescription = null)
                }
                ElementSpacer()

                FloatingActionButton(
                    text = { Text(text = "Notifications") },
                    style = Mobius.styles.prominentFloatingActionButtonStyle,
                    onClick = {}
                ) {
                    Icon(drawableResource = Res.drawable.ic_notifications, contentDescription = null)
                }
                ElementSpacer()
            }
        }
    }
}
