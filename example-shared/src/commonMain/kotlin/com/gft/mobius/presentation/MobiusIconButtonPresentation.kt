package com.gft.mobius.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.gft.mobius.Mobius
import com.gft.mobius.components.Content
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.FilledIconButton
import com.gft.mobius.components.FilledTonalIconButton
import com.gft.mobius.components.Icon
import com.gft.mobius.components.IconButton
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.OutlinedIconButton
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Text
import mobius.example_shared.generated.resources.Res
import mobius.example_shared.generated.resources.ic_settings

@Composable
internal fun MobiusIconButtonPresentation(
    onBack: () -> Unit,
) {
    Mobius {
        Screen {
            MobiusPresentationNavigationBar(
                title = "Icon button",
                onBack = onBack,
            )
            Content {
                Text(text = "Icon Buttons")
                ElementSpacer()

                // Enabled icon buttons

                IconButton(onClick = {}) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                FilledIconButton(onClick = {}) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                FilledTonalIconButton(onClick = {}) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                OutlinedIconButton(onClick = {}) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                // Disabled icon buttons

                IconButton(
                    onClick = {},
                    enabled = false,
                ) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                FilledIconButton(
                    onClick = {},
                    enabled = false,
                ) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                FilledTonalIconButton(
                    onClick = {},
                    enabled = false,
                ) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                OutlinedIconButton(
                    onClick = {},
                    enabled = false,
                ) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                Text(text = "Icon Toggle Buttons")
                ElementSpacer()

                // Enabled icon toggle buttons

                var checked by remember { mutableStateOf(false) }
                IconButton(
                    checked = checked,
                    onCheckedChange = { checked = !checked },
                ) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                FilledIconButton(
                    checked = checked,
                    onCheckedChange = { checked = !checked },
                ) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                FilledTonalIconButton(
                    checked = checked,
                    onCheckedChange = { checked = !checked },
                ) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                OutlinedIconButton(
                    checked = checked,
                    onCheckedChange = { checked = !checked },
                ) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                // Disabled icon toggle buttons

                IconButton(
                    checked = checked,
                    onCheckedChange = { checked = !checked },
                    enabled = false,
                ) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                FilledIconButton(
                    checked = checked,
                    onCheckedChange = { checked = !checked },
                    enabled = false,
                ) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                FilledTonalIconButton(
                    checked = checked,
                    onCheckedChange = { checked = !checked },
                    enabled = false,
                ) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()

                OutlinedIconButton(
                    checked = checked,
                    onCheckedChange = { checked = !checked },
                    enabled = false,
                ) {
                    Icon(drawableResource = Res.drawable.ic_settings, contentDescription = null)
                }
                ElementSpacer()
            }
        }
    }
}
