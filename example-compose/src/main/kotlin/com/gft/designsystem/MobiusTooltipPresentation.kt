package com.gft.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.InfoBox
import com.gft.mobius.components.InfoBoxPositionProvider
import com.gft.mobius.components.InfoBoxPositioner
import com.gft.mobius.components.InfoBoxButton
import com.gft.mobius.components.Text
import com.gft.mobius.components.Tooltip
import com.gft.mobius.components.TooltipPositioner
import com.gft.mobius.components.TooltipVisibilityPolicy
import com.gft.mobius.components.rememberInfoBoxState

@Composable
fun MobiusTooltipPresentation() {
    Mobius {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically),
        ) {
            TooltipPositioner(
                visibilityPolicy = TooltipVisibilityPolicy.Static(true),
                tooltip = "This is static always visible tooltip"
            ) {
                Button(onClick = { }) {
                    Text(text = "Button with visible tooltip")
                }
            }

            TooltipPositioner(
                visibilityPolicy = TooltipVisibilityPolicy.OnInteraction(),
                tooltip = {
                    Tooltip(message = "This is a tooltip that disappears if button is not pressed")
                }
            ) { interactionSource ->
                Button(interactionSource = interactionSource, onClick = { }) {
                    Text(text = "Press to show tooltip")
                }
            }

            InfoBoxPositioner(
                infoBox = {
                    InfoBox(title = "Button info", message = "This is a button", buttons = listOf(
                        InfoBoxButton("Learn more") {

                        }
                    ))
                }
            ) {
                Button(onClick = { }) {
                    Text(text = "Long press to show centered infobox")
                }
            }

            InfoBoxPositioner(
                positionProvider = InfoBoxPositionProvider.StartOrEnd(),
                infoBox = {
                    InfoBox(title = "Button info", message = "This is a button", buttons = listOf(
                        InfoBoxButton("Learn more") {

                        }
                    ))
                }
            ) {
                Button(onClick = { }) {
                    Text(text = "Long press to show start-or-end infobox")
                }
            }

            val infoboxState = rememberInfoBoxState(isPersistent = true)
            InfoBoxPositioner(
                state = infoboxState,
                infoBox = {
                    InfoBox {
                        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text(text = "This is a custom content with custom button")
                            Button(onClick = {
                                infoboxState.dismiss()
                                infoboxState.onDispose()
                            }) {
                                Text(text = "Button")
                            }
                        }
                    }
                }
            ) {
                Button(onClick = { }) {
                    Text(text = "Long press to show custom infobox")
                }
            }
        }
    }
}
