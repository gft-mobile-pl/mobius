package com.gft.mobius.components

import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import com.gft.mobius.utils.is24HourFormat

@Composable
fun rememberTimeInputState(
    initialHour: Int = 0,
    initialMinute: Int = 0,
    is24Hour: Boolean = is24HourFormat(),
): TimeInputState {
    val state = rememberTimePickerState(
        initialHour = initialHour,
        initialMinute = initialMinute,
        is24Hour = is24Hour
    )
    return remember(state) {
        TimeInputState(state)
    }
}

@Stable
class TimeInputState(
    internal val material3State: androidx.compose.material3.TimePickerState
) {
    val hour: Int
        get() {
            return material3State.hour
        }
    val minute: Int
        get() {
            return material3State.minute
        }
    val is24Hour: Boolean
        get() {
            return material3State.is24hour
        }
}
