package com.gft.mobius.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import com.gft.mobius.components.common.NEGLIGIBLE_NON_ZERO_WEIGHT

@Suppress("UnusedReceiverParameter")
@Composable
fun ScreenScope.Footer(
    modifier: Modifier = Modifier,
    content: @Composable ScreenFooterScope.() -> Unit,
) = Box(
    modifier = modifier
        .fillMaxWidth()
) {
    ScreenFooterScope(this).content()
}

interface ScreenFooterScope : BoxScope

private fun ScreenFooterScope(boxScope: BoxScope) = object : ScreenFooterScope, BoxScope by boxScope {}

@Composable
fun ScreenContentScope.Footer(
    modifier: Modifier = Modifier,
    content: @Composable ScreenContentFooterScope.() -> Unit,
) {
    val footerVisible = LocalFooterVisible.current
    DisposableEffect(footerVisible) {
        footerVisible.value = true
        onDispose { footerVisible.value = false }
    }
    if (footerVisible.value) {
        Spacer(modifier = Modifier.weight(NEGLIGIBLE_NON_ZERO_WEIGHT))
        Box(
            modifier = Modifier
                .padding(top = contentStyle.padding.calculateBottomPadding())
                .fillContentContainerWidth()
                .then(modifier)
        ) {
            ScreenContentFooterScope(this).content()
        }
    }
}

interface ScreenContentFooterScope : BoxScope

private fun ScreenContentFooterScope(boxScope: BoxScope) = object : ScreenContentFooterScope, BoxScope by boxScope {}

@Suppress("UnusedReceiverParameter")
@Composable
fun DialogScreenScope.Footer(
    modifier: Modifier = Modifier,
    content: @Composable DialogScreenFooterScope.() -> Unit,
) = Box(
    modifier = modifier
        .fillMaxWidth()
) {
    DialogScreenFooterScope(this).content()
}

interface DialogScreenFooterScope : BoxScope

private fun DialogScreenFooterScope(boxScope: BoxScope) = object : DialogScreenFooterScope, BoxScope by boxScope {}

@Composable
fun DialogScreenContentScope.Footer(
    modifier: Modifier = Modifier,
    content: @Composable DialogScreenContentFooterScope.() -> Unit,
) {
    val footerVisible = LocalFooterVisible.current
    DisposableEffect(footerVisible) {
        footerVisible.value = true
        onDispose { footerVisible.value = false }
    }
    if (footerVisible.value) {
        Box(
            modifier = Modifier
                .padding(top = contentStyle.padding.calculateBottomPadding())
                .fillContentContainerWidth()
                .then(modifier)
        ) {
            DialogScreenContentFooterScope(this).content()
        }
    }
}

interface DialogScreenContentFooterScope : BoxScope

private fun DialogScreenContentFooterScope(boxScope: BoxScope) =
    object : DialogScreenContentFooterScope, BoxScope by boxScope {}

internal val LocalFooterVisible = compositionLocalOf { mutableStateOf(false) }