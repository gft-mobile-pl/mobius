package com.gft.mobius.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.takeOrElse
import com.gft.compose.common.modifyIf
import com.gft.mobius.Mobius
import com.gft.mobius.colors.LocalContentColor
import com.gft.mobius.components.common.resolveHorizontalAlignment
import com.gft.mobius.components.common.resolveVerticalArrangement
import com.gft.mobius.components.styles.GroupStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun Group(
    modifier: Modifier = Modifier,
    style: GroupStyle = Mobius.styles.groupStyle,
    content: @Composable ColumnScope.() -> Unit,
) {
    val styleValues = style.resolve()
    val contentColor = styleValues.contentColor.takeOrElse { LocalContentColor.current }
    CompositionLocalProvider(
        LocalContentColor provides contentColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .modifyIf(styleValues.shape != null) {
                    clip(styleValues.shape!!)
                }
                .modifyIf(styleValues.background != null) {
                    background(styleValues.background!!)
                }
                .padding(styleValues.padding)
                .then(modifier),
            verticalArrangement = styleValues.contentAlignment.resolveVerticalArrangement(),
            horizontalAlignment = styleValues.contentAlignment.resolveHorizontalAlignment(),
            content = content
        )
    }
}
