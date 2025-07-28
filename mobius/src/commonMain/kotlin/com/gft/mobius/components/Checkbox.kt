package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.state.ToggleableState.Indeterminate
import androidx.compose.ui.state.ToggleableState.On
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.CheckboxStyle
import com.gft.mobius.components.styles.CheckboxStyleValues
import com.gft.mobius.components.styles.resolve

@Composable
fun Checkbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isError: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: CheckboxStyle = Mobius.styles.checkboxStyle,
) {
    val styleValues = style.resolve()
    val rippleColor = when {
        isError -> styleValues.errorRippleColor
        checked -> styleValues.checkedRippleColor
        else -> styleValues.uncheckedRippleColor
    }
    CompositionLocalProvider(LocalContentColor provides rippleColor) {
        androidx.compose.material3.Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = modifier,
            enabled = enabled,
            colors = checkboxColors(isError, styleValues),
            interactionSource = interactionSource,
        )
    }
}

@Composable
fun Checkbox(
    state: ToggleableState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    isError: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: CheckboxStyle = Mobius.styles.checkboxStyle,
) {
    val styleValues = style.resolve()
    val rippleColor = when {
        isError -> styleValues.errorRippleColor
        state == On || state == Indeterminate -> styleValues.checkedRippleColor
        else -> styleValues.uncheckedRippleColor
    }
    CompositionLocalProvider(LocalContentColor provides rippleColor) {
        androidx.compose.material3.TriStateCheckbox(
            state = state,
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            colors = checkboxColors(isError, styleValues),
            interactionSource = interactionSource,
        )
    }
}


@Composable
private fun checkboxColors(
    isError: Boolean,
    styleValues: CheckboxStyleValues
) = CheckboxColors(
    checkedCheckmarkColor = if (isError) styleValues.errorCheckmarkColor else styleValues.checkedCheckmarkColor,
    checkedBoxColor = if (isError) styleValues.errorCheckedBoxColor else styleValues.checkedBoxColor,
    checkedBorderColor = if (isError) styleValues.errorBorderColor else styleValues.checkedBorderColor,
    uncheckedCheckmarkColor = styleValues.uncheckedCheckmarkColor,
    uncheckedBoxColor = if (isError) styleValues.errorUncheckedBoxColor else styleValues.uncheckedBoxColor,
    uncheckedBorderColor = if (isError) styleValues.errorBorderColor else styleValues.uncheckedBorderColor,
    disabledCheckedBoxColor = styleValues.disabledCheckedBoxColor,
    disabledUncheckedBoxColor = styleValues.disabledUncheckedBoxColor,
    disabledIndeterminateBoxColor = styleValues.disabledIndeterminateBoxColor,
    disabledBorderColor = styleValues.disabledBorderColor,
    disabledUncheckedBorderColor = styleValues.disabledUncheckedBorderColor,
    disabledIndeterminateBorderColor = styleValues.disabledIndeterminateBorderColor,
)
