package com.gft.mobius.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ContentStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun ScreenFooterScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.footerContentStyle,
    content: @Composable BoxScope.() -> Unit,
) = FooterContent(modifier, style, content)

@Composable
fun ScreenContentFooterScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.footerContentStyle,
    content: @Composable BoxScope.() -> Unit,
) = FooterContent(modifier, style, content)

@Composable
fun DialogScreenFooterScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.dialogFooterContentStyle,
    content: @Composable BoxScope.() -> Unit,
) = FooterContent(modifier, style, content)

@Composable
fun DialogScreenContentFooterScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.dialogFooterContentStyle,
    content: @Composable BoxScope.() -> Unit,
) = FooterContent(modifier, style, content)

@Composable
private fun FooterScope.FooterContent(
    modifier: Modifier,
    style: ContentStyle,
    content: @Composable BoxScope.() -> Unit,
) {
    val styleValues = style.resolve()
    ContentBuilder(
        modifier = Modifier
            .fillFooterWidth()
            .then(modifier),
        scrollState = null,
        styleValues = styleValues,
    ) { contentModifier ->
        Box(
            modifier = contentModifier,
            content = content
        )
    }
}
