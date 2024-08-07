package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.SwitchColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.SwitchStyle
import com.gft.mobius.components.styles.SwitchStyleValues
import com.gft.mobius.components.styles.resolve

@Composable
fun Switch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit),
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: SwitchStyle = Mobius.styles.switchStyle,
) {
    val styleValues = style.resolve()
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        thumbContent = {
            val iconResId = if (checked) styleValues.thumbIconOn?.resId else styleValues.thumbIconOff?.resId
            if (iconResId != null) {
                Icon(iconResId, contentDescription = null)
            }
        },
        enabled = enabled,
        interactionSource = interactionSource,
        styleValues = styleValues
    )
}

@Composable
fun Switch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit),
    modifier: Modifier = Modifier,
    thumbContent: @Composable () -> Unit,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: SwitchStyle = Mobius.styles.switchStyle,
) {
    val styleValues = style.resolve()
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        thumbContent = thumbContent,
        enabled = enabled,
        interactionSource = interactionSource,
        styleValues = styleValues,
    )
}

@Composable
private fun Switch(
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit),
    modifier: Modifier,
    thumbContent: @Composable () -> Unit,
    enabled: Boolean,
    interactionSource: MutableInteractionSource,
    styleValues: SwitchStyleValues,
) {
    val rippleColor = if (checked) styleValues.checkedRippleColor else styleValues.uncheckedRippleColor
    CompositionLocalProvider(
        LocalIconSize provides styleValues.thumbIconSize,
        LocalContentColor provides rippleColor,
    ) {
        androidx.compose.material3.Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = modifier,
            thumbContent = thumbContent,
            enabled = enabled,
            colors = SwitchColors(
                checkedThumbColor = checkedThumbColor(interactionSource, styleValues.checkedThumbColor, styleValues.checkedPressedThumbColor),
                checkedTrackColor = styleValues.checkedTrackColor,
                checkedBorderColor = Color.Transparent,
                checkedIconColor = styleValues.checkedThumbIconColor,
                uncheckedThumbColor = styleValues.uncheckedThumbColor,
                uncheckedTrackColor = styleValues.uncheckedTrackColor,
                uncheckedBorderColor = styleValues.uncheckedBorderColor,
                uncheckedIconColor = styleValues.uncheckedThumbIconColor,
                disabledCheckedThumbColor = styleValues.disabledCheckedThumbColor,
                disabledCheckedTrackColor = styleValues.disabledCheckedTrackColor,
                disabledCheckedBorderColor = Color.Transparent,
                disabledCheckedIconColor = styleValues.disabledCheckedIconColor,
                disabledUncheckedThumbColor = styleValues.disabledUncheckedThumbColor,
                disabledUncheckedTrackColor = styleValues.disabledUncheckedTrackColor,
                disabledUncheckedBorderColor = styleValues.disabledUncheckedBorderColor,
                disabledUncheckedIconColor = styleValues.disabledUncheckedIconColor,
            ),
            interactionSource = interactionSource,
        )
    }
}

@Composable
private fun checkedThumbColor(
    interactionSource: MutableInteractionSource,
    checkedThumbColor: Color,
    checkedPressedThumbColor: Color,
): Color {
    val isPressed by interactionSource.collectIsPressedAsState()
    val isFocused by interactionSource.collectIsFocusedAsState()
    val isHovered by interactionSource.collectIsHoveredAsState()
    return if (isPressed || isFocused || isHovered) checkedPressedThumbColor else checkedThumbColor
}
