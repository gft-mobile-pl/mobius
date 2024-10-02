package com.gft.mobius.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier

@Suppress("UnusedReceiverParameter")
@Composable
fun ScreenScope.Header(
    modifier: Modifier = Modifier,
    content: @Composable ScreenHeaderScope.() -> Unit,
) = Box(
    modifier = modifier
        .fillMaxWidth()
) {
    ScreenHeaderScope(this).content()
}

interface ScreenHeaderScope : BoxScope

private fun ScreenHeaderScope(boxScope: BoxScope) = object : ScreenHeaderScope, BoxScope by boxScope {}

@Composable
fun ScreenContentScope.Header(
    modifier: Modifier = Modifier,
    content: @Composable ScreenContentHeaderScope.() -> Unit,
) {
    val headerVisible = LocalContentHeaderVisible.current
    DisposableEffect(headerVisible) {
        headerVisible.value = true
        onDispose { headerVisible.value = false }
    }
    if (headerVisible.value) {
        Box(
            modifier = Modifier
                .padding(bottom = contentStyle.padding.calculateTopPadding())
                .fillContentContainerWidth()
                .then(modifier)
        ) {
            ScreenContentHeaderScope(this).content()
        }
    }
}

interface ScreenContentHeaderScope : BoxScope

private fun ScreenContentHeaderScope(boxScope: BoxScope) = object : ScreenContentHeaderScope, BoxScope by boxScope {}

@Suppress("UnusedReceiverParameter")
@Composable
fun DialogScreenScope.Header(
    modifier: Modifier = Modifier,
    content: @Composable DialogScreenHeaderScope.() -> Unit,
) = Box(
    modifier = modifier
        .fillMaxWidth()
) {
    DialogScreenHeaderScope(this).content()
}

interface DialogScreenHeaderScope : BoxScope

private fun DialogScreenHeaderScope(boxScope: BoxScope) = object : DialogScreenHeaderScope, BoxScope by boxScope {}

@Composable
fun DialogScreenContentScope.Header(
    modifier: Modifier = Modifier,
    content: @Composable DialogScreenContentHeaderScope.() -> Unit,
) {
    val headerVisible = LocalContentHeaderVisible.current
    DisposableEffect(headerVisible) {
        headerVisible.value = true
        onDispose { headerVisible.value = false }
    }
    if (headerVisible.value) {
        Box(
            modifier = Modifier
                .padding(bottom = contentStyle.padding.calculateTopPadding())
                .fillContentContainerWidth()
                .then(modifier)
        ) {
            DialogScreenContentHeaderScope(this).content()
        }
    }
}

interface DialogScreenContentHeaderScope : BoxScope

private fun DialogScreenContentHeaderScope(boxScope: BoxScope) =
    object : DialogScreenContentHeaderScope, BoxScope by boxScope {}

internal val LocalContentHeaderVisible = compositionLocalOf { mutableStateOf(false) }
