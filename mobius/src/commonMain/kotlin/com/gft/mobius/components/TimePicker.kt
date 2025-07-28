package com.gft.mobius.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerColors
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.TimePickerStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun TimePicker(
    state: TimeInputState,
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
