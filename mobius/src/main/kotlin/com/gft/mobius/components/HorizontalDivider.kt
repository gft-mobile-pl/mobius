package com.gft.mobius.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.HorizontalDividerStyle
import com.gft.mobius.components.styles.resolve


@Composable
fun HorizontalDivider(
    modifier: Modifier = Modifier,
    style: HorizontalDividerStyle = Mobius.styles.horizontalDivider,
) {
    val styleValues = style.resolve()
    androidx.compose.material3.HorizontalDivider(
        modifier = modifier,
        thickness = styleValues.thickness,
        color = styleValues.color
    )
}
