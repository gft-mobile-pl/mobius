package com.gft.mobius.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.takeOrElse
import com.gft.compose.common.modifyIf
import com.gft.mobius.Mobius
import com.gft.mobius.colors.LocalContentColor
import com.gft.mobius.components.styles.ContentStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.contentStyle,
    content: @Composable ColumnScope.() -> Unit,
) = ContentImplementation(modifier, null, style, content)

@Composable
fun ScrollableContent(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    style: ContentStyle = Mobius.styles.scrollableContentStyle,
    content: @Composable ColumnScope.() -> Unit,
) = ContentImplementation(modifier, scrollState, style, content)

@Composable
private fun ContentImplementation(
    modifier: Modifier,
    scrollState: ScrollState?,
    style: ContentStyle = Mobius.styles.contentStyle,
    content: @Composable ColumnScope.() -> Unit,
) {
    val styleValues = style.resolve()
    val contentColor = styleValues.contentColor.takeOrElse { LocalContentColor.current }
    CompositionLocalProvider(
        LocalContentColor provides contentColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .modifyIf(scrollState != null) {
                    verticalScroll(scrollState!!)
                }
                .modifyIf(styleValues.background != null) {
                    background(styleValues.background!!)
                }
                .padding(styleValues.padding)
                .then(modifier),
            verticalArrangement = styleValues.verticalArrangement,
            horizontalAlignment = styleValues.horizontalAlignment,
            content = content
        )
    }
}
