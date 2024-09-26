package com.gft.mobius.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ContentStyle
import com.gft.mobius.components.styles.resolve

@Suppress("UnusedReceiverParameter")
@Composable
fun ScreenHeaderScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.headerContentStyle,
    content: @Composable BoxScope.() -> Unit,
) = HeaderContent(modifier, style, content)

@Suppress("UnusedReceiverParameter")
@Composable
fun ScreenContentHeaderScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.headerContentStyle,
    content: @Composable BoxScope.() -> Unit,
) = HeaderContent(modifier, style, content)

@Suppress("UnusedReceiverParameter")
@Composable
fun DialogScreenHeaderScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.dialogHeaderContentStyle,
    content: @Composable BoxScope.() -> Unit,
) = HeaderContent(modifier, style, content)

@Suppress("UnusedReceiverParameter")
@Composable
fun DialogScreenContentHeaderScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.dialogHeaderContentStyle,
    content: @Composable BoxScope.() -> Unit,
) = HeaderContent(modifier, style, content)

@Composable
private fun HeaderContent(
    modifier: Modifier,
    style: ContentStyle,
    content: @Composable BoxScope.() -> Unit,
) {
    val styleValues = style.resolve()
    ContentBuilder(
        modifier = modifier,
        scrollState = null,
        styleValues = styleValues,
    ) { contentModifier ->
        Box(
            modifier = contentModifier,
            content = content
        )
    }
}
