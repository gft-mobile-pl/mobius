package com.gft.designsystem

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Text

@Composable
fun MobiusContainersPresentation() {
    Mobius {
        Screen {
            Text(text = "Some Header", style = Mobius.typography.titleMedium)
            Button(onClick = { }) {
                Text(text = "Some button")
            }
            Spacer(modifier = Modifier.weight(1.0f))
            Button(onClick = {  }) {
                Text(text = "Bottom button")
            }
        }
    }
}