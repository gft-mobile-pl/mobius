package com.gft.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.RadioButton

@Composable
fun MobiusRadioButtonsPresentation() {
    Mobius {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically)
        ) {
            var selectedRadioButtonId by remember { mutableStateOf(0) }

            repeat(2) { radioButtonId ->
                RadioButton(
                    selected = radioButtonId == selectedRadioButtonId,
                    onClick = { selectedRadioButtonId = radioButtonId }
                )
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
