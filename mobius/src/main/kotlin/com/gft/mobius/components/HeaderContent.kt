package com.gft.mobius.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ContentStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun ScreenHeaderScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.headerContentStyle,
    content: @Composable ColumnScope.() -> Unit,
) = HeaderContent(modifier, style, content)

@Composable
fun ScreenContentHeaderScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.headerContentStyle,
    content: @Composable ColumnScope.() -> Unit,
) = HeaderContent(modifier, style, content)

@Composable
private fun HeaderContent(
    modifier: Modifier,
    style: ContentStyle,
    content: @Composable ColumnScope.() -> Unit,
) {
    val styleValues = style.resolve()
    Content(
        modifier = modifier,
        fillMaxSize = false,
        scrollState = null,
        styleValues = styleValues,
        content = content
    )
}

@Composable
fun DialogScreenHeaderScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.dialogHeaderContentStyle,
    content: @Composable ColumnScope.() -> Unit,
) = DialogHeaderContent(modifier, style, content)

@Composable
fun DialogScreenContentHeaderScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.dialogHeaderContentStyle,
    content: @Composable ColumnScope.() -> Unit,
) = DialogHeaderContent(modifier, style, content)

@Composable
private fun DialogHeaderContent(
    modifier: Modifier,
    style: ContentStyle,
    content: @Composable ColumnScope.() -> Unit,
) {
    val styleValues = style.resolve()
    Content(
        modifier = modifier,
        fillMaxSize = false,
        scrollState = null,
        styleValues = styleValues,
        content = content
    )
}
