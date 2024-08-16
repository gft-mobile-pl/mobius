package com.gft.mobius.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.TimeInputStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun TimeInput(
    state: TimeInputState,
    modifier: Modifier = Modifier,
    style: TimeInputStyle = Mobius.styles.timeInputStyle
) {
    val styleValues = style.resolve()
    @OptIn(ExperimentalMaterial3Api::class)
    androidx.compose.material3.TimeInput(
        state = state.material3State,
        modifier = modifier,
        colors = TimePickerColors(
            clockDialColor = Color.Transparent,
            clockDialSelectedContentColor = Color.Transparent,
            clockDialUnselectedContentColor = Color.Transparent,
            selectorColor = Color.Transparent,
            containerColor = Color.Transparent,
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
    )
}
