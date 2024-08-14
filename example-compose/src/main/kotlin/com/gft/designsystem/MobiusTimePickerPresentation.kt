package com.gft.designsystem

import android.annotation.SuppressLint
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
import com.gft.mobius.components.Text
import com.gft.mobius.components.TimePicker
import com.gft.mobius.components.TimePickerState
import com.gft.mobius.components.rememberTimePickerState

@Composable
fun MobiusTimePickerPresentation() {
    Mobius {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val timePickerState = rememberTimePickerState()
            TimePicker(state = timePickerState)
            Text(text = "Selected time is: ${timePickerState.getFormattedTime()}")

            val timePicker12HState = rememberTimePickerState(is24Hour = false)
            TimePicker(state = timePicker12HState)
            Text(text = "Selected time is: ${timePicker12HState.getFormattedTime()}")
        }
    }
}

@SuppressLint("DefaultLocale")
private fun TimePickerState.getFormattedTime() = String.format("%02d:%02d", hour, minute)
