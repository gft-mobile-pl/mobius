package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.RadioButtonStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun RadioButton(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: RadioButtonStyle = Mobius.styles.radioButtonStyle,
) {
    RadioButtonImplementation(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        wrapper = wrapper,
        enabled = enabled,
        interactionSource = interactionSource,
        style = style
    )
}

@Composable
fun ClickableLabelScope.RadioButton(
    selected: Boolean,
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    enabled: Boolean = true,
    style: RadioButtonStyle = Mobius.styles.radioButtonStyle,
) {
    RadioButtonImplementation(
        selected = selected,
        onClick = null,
        modifier = modifier,
        wrapper = wrapper,
        enabled = enabled,
        interactionSource = null,
        style = style
    )
}

@Composable
private fun RadioButtonImplementation(
    selected: Boolean,
    onClick: (() -> Unit)?,
    modifier: Modifier,
    wrapper: Modifier,
    enabled: Boolean,
    interactionSource: MutableInteractionSource?,
    style: RadioButtonStyle,
) {
    val styleValues = style.resolve()
    val rippleColor = if (selected) styleValues.selectedRippleColor else styleValues.unselectedRippleColor

    CompositionLocalProvider(LocalContentColor provides rippleColor) {
        androidx.compose.material3.RadioButton(
            selected = selected,
            modifier = wrapper.minimumInteractiveComponentSize() then modifier,
            onClick = onClick,
            enabled = enabled,
            colors = RadioButtonColors(
                selectedColor = styleValues.selectedColor,
                unselectedColor = styleValues.unselectedColor,
                disabledSelectedColor = styleValues.disabledSelectedColor,
                disabledUnselectedColor = styleValues.disabledUnselectedColor,
            ),
            interactionSource = interactionSource,
        )
    }
}
