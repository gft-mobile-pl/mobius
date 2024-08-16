package com.gft.mobius.components

import android.text.format.DateFormat.is24HourFormat
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

@Composable
fun rememberTimeInputState(
    initialHour: Int = 0,
    initialMinute: Int = 0,
    is24Hour: Boolean = is24HourFormat(LocalContext.current),
): TimeInputState {
    @OptIn(ExperimentalMaterial3Api::class)
    val state = rememberTimePickerState(
        initialHour = initialHour,
        initialMinute = initialMinute,
        is24Hour = is24Hour
    )
    @OptIn(ExperimentalMaterial3Api::class)
    return remember(state) {
        TimeInputState(state)
    }
}

@Stable
class TimeInputState(
    @OptIn(ExperimentalMaterial3Api::class)
    internal val material3State: androidx.compose.material3.TimePickerState
) {
    val hour: Int
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return material3State.hour
        }
    val minute: Int
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return material3State.minute
        }
    val is24Hour: Boolean
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return material3State.is24hour
        }
}
