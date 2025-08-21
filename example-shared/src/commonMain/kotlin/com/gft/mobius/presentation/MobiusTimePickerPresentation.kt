package com.gft.mobius.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.Text
import com.gft.mobius.components.TimeInputState
import com.gft.mobius.components.TimePicker
import com.gft.mobius.components.rememberTimeInputState

@Composable
internal fun MobiusTimePickerPresentation(
    onBack: () -> Unit,
) {
    Mobius {
        Column {
            MobiusPresentationNavigationBar(
                title = "Time picker",
                onBack = onBack,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val timeInputState = rememberTimeInputState(is24Hour = true)
                TimePicker(state = timeInputState)
                Text(text = "Selected time is: ${timeInputState.getFormattedTime()}")

                val timeInput12HState = rememberTimeInputState(is24Hour = false)
                TimePicker(state = timeInput12HState)
                Text(text = "Selected time is: ${timeInput12HState.getFormattedTime()}")
            }
        }
    }
}

private fun TimeInputState.getFormattedTime() = "${hour.toString().padStart(2, '0')}:${minute.toString().padStart(2, '0')}"
