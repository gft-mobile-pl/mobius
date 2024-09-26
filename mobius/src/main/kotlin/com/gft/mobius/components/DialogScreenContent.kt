package com.gft.mobius.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
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

open class DialogScreenContentScope(contentStyle: ContentStyleValues, columnScope: ColumnScope) :
    ContentScope(contentStyle), ColumnScope by columnScope

@Composable
fun DialogScreenScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.dialogContentStyle,
    content: @Composable DialogScreenContentScope.() -> Unit,
) = ContentImplementation(
    modifier = modifier,
    scrollState = null,
    style = style,
    content = content
)

@Composable
fun DialogScreenScope.ScrollableContent(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    style: ContentStyle = Mobius.styles.dialogScrollableContentStyle,
    content: @Composable DialogScreenContentScope.() -> Unit,
) = ContentImplementation(
    modifier = modifier,
    scrollState = scrollState,
    style = style,
    content = content
)

@Composable
private fun ColumnScope.ContentImplementation(
    modifier: Modifier,
    scrollState: ScrollState?,
    style: ContentStyle,
    content: @Composable DialogScreenContentScope.() -> Unit,
) {
    val styleValues = style.resolve()
    ContentBuilder(
        modifier = modifier,
        scrollState = scrollState,
        styleValues = styleValues,
    ) { contentModifier ->
        Column(
            modifier = Modifier
                .weight(weight = NEGLIGIBLE_NON_ZERO_WEIGHT, fill = false)
                .then(contentModifier),
            verticalArrangement = styleValues.contentAlignment.resolveVerticalArrangement(),
            horizontalAlignment = styleValues.contentAlignment.resolveHorizontalAlignment()
        ) {
            DialogScreenContentScope(contentStyle = styleValues, columnScope = this).content()
        }
    }
}
