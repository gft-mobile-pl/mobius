package com.gft.mobius.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.PlainTooltip
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ProvideTextStyle
import com.gft.mobius.components.styles.TooltipStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun TooltipScope.Tooltip(
    modifier: Modifier = Modifier,
    message: String,
    style: TooltipStyle = Mobius.styles.tooltipStyle
) {
    val styleValues = style.resolve()
    @OptIn(ExperimentalMaterial3Api::class)
    with(scope) {
        PlainTooltip(
            modifier = modifier,
            caretSize = styleValues.pointerSize,
            shape = styleValues.shape,
            contentColor = styleValues.contentColor,
            containerColor = styleValues.containerColor,
            tonalElevation = styleValues.tonalElevation,
            shadowElevation = styleValues.shadowElevation,
        ) {
            ProvideTextStyle(style = styleValues.contentTextStyle) {
                Text(message)
            }
        }
    }
}
