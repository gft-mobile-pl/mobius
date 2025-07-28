package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.SliderThumbStyle
import com.gft.mobius.components.styles.SliderThumbStyleValues
import com.gft.mobius.components.styles.resolve

@Composable
fun SliderThumb(
    tooltip: String?,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource,
    style: SliderThumbStyle = Mobius.styles.sliderThumbStyle
) {
    val styleValues = style.resolve()
    if (tooltip != null) {
        TooltipPositioner(
            visibilityPolicy = TooltipVisibilityPolicy.OnInteraction(interactionSource),
            tooltip = {
                Tooltip(message = tooltip, style = styleValues.tooltipStyle)
            },
        ) {
            SliderThumb(styleValues = styleValues, enabled = enabled, interactionSource = interactionSource)
        }
    } else {
        SliderThumb(styleValues = styleValues, enabled = enabled, interactionSource = interactionSource)
    }
}

@Composable
private fun SliderThumb(
    interactionSource: MutableInteractionSource,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    styleValues: SliderThumbStyleValues
) {
    SliderDefaults.Thumb(
        interactionSource = interactionSource,
        modifier = modifier,
        colors = SliderDefaults.colors(
            thumbColor = styleValues.color,
            disabledThumbColor = styleValues.disabledColor
        ),
        enabled = enabled,
        thumbSize = DpSize(styleValues.width, styleValues.height)
    )
}
