package com.gft.mobius.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ContentStyle
import com.gft.mobius.components.styles.ContentStyleValues
import com.gft.mobius.components.styles.resolve

open class HeaderContentScope(contentStyle: ContentStyleValues, boxScope: BoxScope) :
    ContentScope(contentStyle), BoxScope by boxScope

@Composable
fun ScreenHeaderScope.Content(
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.headerContentStyle,
    content: @Composable HeaderContentScope.() -> Unit,
) = HeaderContent(modifier, wrapper, style, content)

@Composable
fun ScreenContentHeaderScope.Content(
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.headerContentStyle,
    content: @Composable HeaderContentScope.() -> Unit,
) = HeaderContent(modifier, wrapper, style, content)

@Composable
fun DialogScreenHeaderScope.Content(
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.dialogHeaderContentStyle,
    content: @Composable HeaderContentScope.() -> Unit,
) = HeaderContent(modifier, wrapper, style, content)

@Composable
fun DialogScreenContentHeaderScope.Content(
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.dialogHeaderContentStyle,
    content: @Composable HeaderContentScope.() -> Unit,
) = HeaderContent(modifier, wrapper, style, content)

@Composable
private fun HeaderScope.HeaderContent(
    modifier: Modifier,
    wrapper: Modifier,
    style: ContentStyle,
    content: @Composable HeaderContentScope.() -> Unit,
) {
    val styleValues = style.resolve()
    ContentBuilder(
        modifier = Modifier
            .fillHeaderWidth()
            .then(modifier),
        wrapper = wrapper,
        scrollState = null,
        styleValues = styleValues,
    ) { contentModifier ->
        Box(
            modifier = contentModifier,
        ) {
            HeaderContentScope(styleValues, this).content()
        }
    }
}
