package com.gft.mobius.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ContentStyle
import com.gft.mobius.components.styles.resolve


interface ScreenContentScope : ContentScope

private fun ScreenContentScope(contentScope: ContentScope) = object : ScreenContentScope, ContentScope by contentScope {}

@Composable
fun ScreenScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.contentStyle,
    content: @Composable ScreenContentScope.() -> Unit,
) {
    val styleValues = style.resolve()
    Content(
        modifier = modifier,
        fillMaxSize = true,
        scrollState = null,
        styleValues = styleValues,
    ) {
        ScreenContentScope(ContentScopeImpl(this, styleValues, LocalLayoutDirection.current)).content()
    }
}

@Composable
fun ScreenScope.ScrollableContent(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    style: ContentStyle = Mobius.styles.scrollableContentStyle,
    content: @Composable ScreenContentScope.() -> Unit,
) {
    val styleValues = style.resolve()
    Content(
        modifier = modifier,
        fillMaxSize = true,
        scrollState = scrollState,
        styleValues = styleValues,
    ) {
        ScreenContentScope(ContentScopeImpl(this, styleValues, LocalLayoutDirection.current)).content()
    }
}