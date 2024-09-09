package com.gft.mobius.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ContentStyle
import com.gft.mobius.components.styles.resolve


interface DialogScreenContentScope : ContentScope

private fun DialogScreenContentScope(contentScope: ContentScope) =
    object : DialogScreenContentScope, ContentScope by contentScope {}

@Composable
fun DialogScreenScope.Content(
    modifier: Modifier = Modifier,
    style: ContentStyle = Mobius.styles.dialogContentStyle,
    content: @Composable DialogScreenContentScope.() -> Unit,
) {
    val styleValues = style.resolve()
    Content(
        modifier = modifier,
        fillMaxSize = false,
        scrollState = null,
        styleValues = styleValues,
    ) {
        DialogScreenContentScope(ContentScopeImpl(this, styleValues, LocalLayoutDirection.current)).content()
    }
}

@Composable
fun DialogScreenScope.ScrollableContent(
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState(),
    style: ContentStyle = Mobius.styles.dialogScrollableContentStyle,
    content: @Composable DialogScreenContentScope.() -> Unit,
) {
    val styleValues = style.resolve()
    Content(
        modifier = modifier,
        fillMaxSize = false,
        scrollState = scrollState,
        styleValues = styleValues,
    ) {
        DialogScreenContentScope(ContentScopeImpl(this, styleValues, LocalLayoutDirection.current)).content()
    }
}