package com.gft.designsystem

import androidx.compose.runtime.Composable
import com.gft.mobius.Mobius
import com.gft.mobius.components.Content
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.FloatingActionButton
import com.gft.mobius.components.Icon
import com.gft.mobius.components.ScaffoldScreen
import com.gft.mobius.components.Text

@Composable
fun MobiusFloatingActionButtonPresentation() {
    Mobius {
        ScaffoldScreen(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {}
                ) {
                    Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null)
                }
            }
        ) {
            Content {
                FloatingActionButton(
                    style = Mobius.styles.secondaryFloatingActionButtonStyle,
                    onClick = {}
                ) {
                    Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null)
                }
                ElementSpacer()

                FloatingActionButton(
                    text = { Text(text = "Notifications") },
                    style = Mobius.styles.secondaryFloatingActionButtonStyle,
                    onClick = {}
                ) {
                    Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null)
                }
                ElementSpacer()

                FloatingActionButton(
                    onClick = {}
                ) {
                    Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null)
                }
                ElementSpacer()

                FloatingActionButton(
                    text = { Text(text = "Notifications") },
                    onClick = { }
                ) {
                    Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null)
                }
                ElementSpacer()

                FloatingActionButton(
                    style = Mobius.styles.prominentFloatingActionButtonStyle,
                    onClick = {}
                ) {
                    Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null)
                }
                ElementSpacer()

                FloatingActionButton(
                    text = { Text(text = "Notifications") },
                    style = Mobius.styles.prominentFloatingActionButtonStyle,
                    onClick = {}
                ) {
                    Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null)
                }
                ElementSpacer()
            }
        }
    }
}
