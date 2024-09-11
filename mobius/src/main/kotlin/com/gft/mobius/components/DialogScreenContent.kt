package com.gft.mobius.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import com.gft.mobius.Mobius
import com.gft.mobius.components.common.resolveHorizontalAlignment
import com.gft.mobius.components.common.resolveVerticalArrangement
import com.gft.mobius.components.styles.ContentStyle
import com.gft.mobius.components.styles.resolve


interface DialogScreenContentScope : ColumnContentScope

private fun DialogScreenContentScope(contentScope: ColumnContentScope) =
    object : DialogScreenContentScope, ColumnContentScope by contentScope {}

@Suppress("UnusedReceiverParameter")
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

@Suppress("UnusedReceiverParameter")
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
private fun ContentImplementation(
    modifier: Modifier,
    scrollState: ScrollState?,
    style: ContentStyle,
    content: @Composable DialogScreenContentScope.() -> Unit,
) {
    val styleValues = style.resolve()
    ContentBuilder(
        modifier = modifier,
        fillMaxSize = false,
        scrollState = scrollState,
        styleValues = styleValues,
    ) { contentModifier ->
        Column(
            modifier = contentModifier,
            verticalArrangement = styleValues.contentAlignment.resolveVerticalArrangement(),
            horizontalAlignment = styleValues.contentAlignment.resolveHorizontalAlignment()
        ) {
            DialogScreenContentScope(
                ColumnContentScope(
                    columnScope = this,
                    contentScope = ContentScope(styleValues, LocalLayoutDirection.current)
                )
            ).content()
        }
    }
}