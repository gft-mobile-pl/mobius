package com.gft.mobius.components

import android.text.format.DateFormat.is24HourFormat
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.TimePickerStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun TimePicker(
    state: TimePickerState,
    modifier: Modifier = Modifier,
    style: TimePickerStyle = Mobius.styles.timePickerStyle
) {
    val styleValues = style.resolve()
    @OptIn(ExperimentalMaterial3Api::class)
    androidx.compose.material3.TimePicker(
        state = state.material3State,
        modifier = modifier,
        colors = TimePickerColors(
            clockDialColor = styleValues.clockDialColor,
            clockDialSelectedContentColor = styleValues.clockDialSelectedContentColor,
            clockDialUnselectedContentColor = styleValues.clockDialUnselectedContentColor,
            selectorColor = styleValues.selectorColor,
            containerColor = styleValues.clockDialColor,
            periodSelectorBorderColor = styleValues.periodSelectorBorderColor,
            periodSelectorSelectedContainerColor = styleValues.periodSelectorSelectedContainerColor,
            periodSelectorUnselectedContainerColor = styleValues.periodSelectorUnselectedContainerColor,
            periodSelectorSelectedContentColor = styleValues.periodSelectorSelectedContentColor,
            periodSelectorUnselectedContentColor = styleValues.periodSelectorUnselectedContentColor,
            timeSelectorSelectedContainerColor = styleValues.timeSelectorSelectedContainerColor,
            timeSelectorUnselectedContainerColor = styleValues.timeSelectorUnselectedContainerColor,
            timeSelectorSelectedContentColor = styleValues.timeSelectorSelectedContentColor,
            timeSelectorUnselectedContentColor = styleValues.timeSelectorUnselectedContentColor,
        ),
        layoutType = styleValues.layoutType.toMaterial3()
    )
}

@Composable
fun rememberTimePickerState(
    initialHour: Int = 0,
    initialMinute: Int = 0,
    is24Hour: Boolean = is24HourFormat(LocalContext.current),
): TimePickerState {
    @OptIn(ExperimentalMaterial3Api::class)
    val state = rememberTimePickerState(
        initialHour = initialHour,
        initialMinute = initialMinute,
        is24Hour = is24Hour
    )
    @OptIn(ExperimentalMaterial3Api::class)
    return remember(state) {
        TimePickerState(state)
    }
}

@Stable
class TimePickerState(
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

enum class TimePickerLayoutType {
    Vertical, Horizontal, Sensor;

    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    internal fun toMaterial3() =
        when (this) {
            Vertical -> androidx.compose.material3.TimePickerLayoutType.Vertical
            Horizontal -> androidx.compose.material3.TimePickerLayoutType.Horizontal
            Sensor -> TimePickerDefaults.layoutType()
        }
}
