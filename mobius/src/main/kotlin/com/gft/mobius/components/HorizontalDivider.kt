package com.gft.mobius.components

import androidx.compose.foundation.layout.padding
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
        modifier = Modifier.padding(styleValues.padding) then modifier,
        thickness = styleValues.thickness,
        color = styleValues.color
    )
}
