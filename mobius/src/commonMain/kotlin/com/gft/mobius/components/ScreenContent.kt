package com.gft.mobius.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.common.NEGLIGIBLE_NON_ZERO_WEIGHT
import com.gft.mobius.components.common.resolveHorizontalAlignment
import com.gft.mobius.components.common.resolveVerticalArrangement
import com.gft.mobius.components.styles.ContentStyle
import com.gft.mobius.components.styles.ContentStyleValues
import com.gft.mobius.components.styles.resolve

open class ScreenContentScope(contentStyle: ContentStyleValues, columnScope: ColumnScope) :
    ContentScope(contentStyle), ColumnScope by columnScope

@Composable
fun ScreenScope.Content(
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    isScrollable: Boolean = true,
    style: ContentStyle = if (isScrollable) Mobius.styles.scrollableContentStyle else Mobius.styles.contentStyle,
    content: @Composable ScreenContentScope.() -> Unit,
) = ContentImplementation(
    modifier = modifier,
    wrapper = wrapper,
    scrollState = if (isScrollable) rememberScrollState() else null,
    style = style,
    content = content
)

@Composable
fun ScreenScope.Content(
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    scrollState: ScrollState,
    style: ContentStyle = Mobius.styles.scrollableContentStyle,
    content: @Composable ScreenContentScope.() -> Unit,
) = ContentImplementation(
    modifier = modifier,
    wrapper = wrapper,
    scrollState = scrollState,
    style = style,
    content = content
)

@Composable
private fun ColumnScope.ContentImplementation(
    modifier: Modifier,
    wrapper: Modifier,
    scrollState: ScrollState?,
    style: ContentStyle,
    content: @Composable ScreenContentScope.() -> Unit,
) {
    val styleValues = style.resolve()
    ContentBuilder(
        modifier = modifier,
        wrapper = wrapper,
        scrollState = scrollState,
        styleValues = styleValues,
    ) { contentModifier ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(weight = NEGLIGIBLE_NON_ZERO_WEIGHT, fill = true)
                .then(contentModifier),
            verticalArrangement = styleValues.contentAlignment.resolveVerticalArrangement(),
            horizontalAlignment = styleValues.contentAlignment.resolveHorizontalAlignment()
        ) {
            ScreenContentScope(contentStyle = styleValues, columnScope = this).content()
        }
    }
}
