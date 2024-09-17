package com.gft.mobius.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.HorizontalDividerStyle
import com.gft.mobius.components.styles.VerticalDividerStyle
import com.gft.mobius.components.styles.resolve


@Composable
fun VerticalDivider(
    modifier: Modifier = Modifier,
    style: VerticalDividerStyle = Mobius.styles.verticalDivider,
) {
    val styleValues = style.resolve()
    androidx.compose.material3.VerticalDivider(
        modifier = modifier,
        thickness = styleValues.thickness,
        color = styleValues.color
    )
}
