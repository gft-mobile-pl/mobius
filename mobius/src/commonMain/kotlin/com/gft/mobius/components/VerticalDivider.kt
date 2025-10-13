package com.gft.mobius.components

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.VerticalDividerStyle
import com.gft.mobius.components.styles.resolve


@Composable
fun VerticalDivider(
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    style: VerticalDividerStyle = Mobius.styles.verticalDivider,
) {
    val styleValues = style.resolve()
    androidx.compose.material3.VerticalDivider(
        modifier = wrapper.padding(styleValues.padding) then modifier,
        thickness = styleValues.thickness,
        color = styleValues.color
    )
}
