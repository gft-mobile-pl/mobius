package com.gft.designsystem

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.Content
import com.gft.mobius.components.Label
import com.gft.mobius.components.LabelPlacement.Start
import com.gft.mobius.components.RadioButton
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Text

@Composable
fun MobiusRadioButtonsPresentation() {
    Mobius {
        Screen {
            Content {
                var selectedRadioButtonId by remember { mutableStateOf(0) }

                repeat(2) { radioButtonId ->
                    Label(
                        modifier = Modifier.fillMaxWidth(),
                        text = { Text("Radio Button with label") },
                        onClick = { selectedRadioButtonId = radioButtonId }
                    ) {
                        RadioButton(selected = radioButtonId == selectedRadioButtonId)
                    }
                }

                repeat(2) { radioButtonId ->
                    Label(
                        modifier = Modifier.fillMaxWidth(),
                        text = { Text("Radio Button with label") },
                        labelPlacement = Start.CenterVertically,
                        onClick = { selectedRadioButtonId = radioButtonId }
                    ) {
                        RadioButton(
                            selected = radioButtonId == selectedRadioButtonId,
                            onClick = { selectedRadioButtonId = radioButtonId }
                        )
                    }
                }

                RadioButton(
                    selected = true,
                    enabled = false,
                    onClick = { }
                )

                RadioButton(
                    selected = false,
                    enabled = false,
                    onClick = { }
                )
            }
        }
    }
}
