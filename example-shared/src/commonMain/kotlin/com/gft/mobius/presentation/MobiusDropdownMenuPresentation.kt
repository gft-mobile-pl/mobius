package com.gft.mobius.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.Content
import com.gft.mobius.components.DropdownMenu
import com.gft.mobius.components.DropdownMenuItem
import com.gft.mobius.components.Icon
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Text
import mobius.example_shared.generated.resources.Res
import mobius.example_shared.generated.resources.ic_home
import mobius.example_shared.generated.resources.ic_notifications
import mobius.example_shared.generated.resources.ic_settings

@Composable
internal fun MobiusDropdownMenuPresentation(
    onBack: () -> Unit,
) {
    Mobius {
        Screen {
            MobiusPresentationNavigationBar(
                title = "Dropdown menu",
                onBack = onBack,
            )
            Content {
                Box {
                    val menuVisible = remember { mutableStateOf(false) }
                    Button(onClick = {
                        menuVisible.value = !menuVisible.value
                    }) {
                        Text(text = "Show dropdown menu")
                    }
                    DropdownMenu(
                        expanded = menuVisible.value,
                        onDismissRequest = { menuVisible.value = !menuVisible.value }
                    ) {
                        DropdownMenuItem(text = { Text("Item 1") }, onClick = { })
                        DropdownMenuItem(
                            text = { Text("Item 2") },
                            leadingIcon = { Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null) },
                            onClick = { }
                        )
                        DropdownMenuItem(
                            text = { Text("Item 3") },
                            leadingIcon = { Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null) },
                            onClick = { }
                        )
                        DropdownMenuItem(
                            text = { Text("Item 4") },
                            trailingIcon = { Icon(drawableResource = Res.drawable.ic_notifications, contentDescription = null) },
                            onClick = { }
                        )
                        DropdownMenuItem(
                            text = { Text("Item 5") },
                            enabled = false,
                            trailingIcon = { Icon(drawableResource = Res.drawable.ic_home, contentDescription = null) },
                            onClick = { }
                        )
                    }
                }
            }
        }
    }
}
