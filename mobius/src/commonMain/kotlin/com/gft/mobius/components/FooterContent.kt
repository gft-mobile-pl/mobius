package com.gft.mobius.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ContentStyle
import com.gft.mobius.components.styles.ContentStyleValues
import com.gft.mobius.components.styles.resolve

open class FooterContentScope(contentStyle: ContentStyleValues, boxScope: BoxScope) :
    ContentScope(contentStyle), BoxScope by boxScope

@Composable
fun ScreenFooterScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.footerContentStyle,
    content: @Composable FooterContentScope.() -> Unit,
) = FooterContent(modifier, style, content)

@Composable
fun ScreenContentFooterScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.footerContentStyle,
    content: @Composable FooterContentScope.() -> Unit,
) = FooterContent(modifier, style, content)

@Composable
fun DialogScreenFooterScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.dialogFooterContentStyle,
    content: @Composable FooterContentScope.() -> Unit,
) = FooterContent(modifier, style, content)

@Composable
fun DialogScreenContentFooterScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.dialogFooterContentStyle,
    content: @Composable FooterContentScope.() -> Unit,
) = FooterContent(modifier, style, content)

@Composable
private fun FooterScope.FooterContent(
    modifier: Modifier,
    style: ContentStyle,
    content: @Composable FooterContentScope.() -> Unit,
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
        ) {
            FooterContentScope(styleValues, this).content()
        }
    }
}
