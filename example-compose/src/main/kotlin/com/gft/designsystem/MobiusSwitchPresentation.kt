package com.gft.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Icon
import com.gft.mobius.components.Switch
import com.gft.mobius.components.styles.DefaultSwitchStyle

@Composable
fun MobiusSwitchPresentation() {
    Mobius {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically),
        ) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                var switchTurnedOn by remember { mutableStateOf(false) }
                val noIconSwitchStyle = NoIconSwitchStyle()
                Switch(
                    checked = switchTurnedOn,
                    onCheckedChange = { switchTurnedOn = !switchTurnedOn },
                    style = noIconSwitchStyle
                )

                Switch(
                    checked = true,
                    enabled = false,
                    onCheckedChange = {},
                    style = noIconSwitchStyle
                )

                Switch(
                    checked = false,
                    enabled = false,
                    onCheckedChange = {},
                    style = noIconSwitchStyle
                )
            }

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                var switchTurnedOn by remember { mutableStateOf(false) }
                Switch(
                    checked = switchTurnedOn,
                    onCheckedChange = { switchTurnedOn = !switchTurnedOn },
                )

                Switch(
                    checked = true,
                    enabled = false,
                    onCheckedChange = {},
                )

                Switch(
                    checked = false,
                    enabled = false,
                    onCheckedChange = {},
                )
            }

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                var switchTurnedOn by remember { mutableStateOf(false) }
                Switch(
                    checked = switchTurnedOn,
                    thumbContent = { Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null) },
                    onCheckedChange = { switchTurnedOn = !switchTurnedOn },
                )

                Switch(
                    checked = true,
                    enabled = false,
                    thumbContent = { Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null) },
                    onCheckedChange = {},
                )

                Switch(
                    checked = false,
                    enabled = false,
                    thumbContent = { Icon(drawableResId = R.drawable.ic_notifications, contentDescription = null) },
                    onCheckedChange = {},
                )
            }
        }
    }
}

private class NoIconSwitchStyle : DefaultSwitchStyle() {
    override val thumbIconOff: Token<Painter?> = Token(null)
    override val thumbIconOn: Token<Painter?> = Token(null)
}
