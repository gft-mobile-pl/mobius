package com.gft.mobius.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.takeOrElse
import com.gft.compose.common.modifyIf
import com.gft.mobius.Mobius
import com.gft.mobius.colors.LocalContentColor
import com.gft.mobius.components.common.isInMainLayoutPass
import com.gft.mobius.components.styles.HeaderStyle
import com.gft.mobius.components.styles.resolve

interface HeaderScope : BoxScope {
    @Composable
    fun Modifier.fillHeaderWidth(): Modifier = modifyIf(isInMainLayoutPass()) { fillMaxWidth() }
}

@Suppress("UnusedReceiverParameter")
@Composable
fun ScreenScope.Header(
    modifier: Modifier = Modifier,
    style: HeaderStyle = Mobius.styles.headerStyle,
    content: @Composable ScreenHeaderScope.() -> Unit,
) {
    val styleValues = style.resolve()
    val contentColor = styleValues.contentColor.takeOrElse { LocalContentColor.current }

    CompositionLocalProvider(LocalContentColor provides contentColor) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .modifyIf(styleValues.background != null) {
                    background(styleValues.background!!)
                }
                .then(modifier)
        ) {
            ScreenHeaderScope(this).content()
        }
    }
}

interface ScreenHeaderScope : HeaderScope

private fun ScreenHeaderScope(boxScope: BoxScope) = object : ScreenHeaderScope, BoxScope by boxScope {}

@Composable
fun ScreenContentScope.Header(
    modifier: Modifier = Modifier,
    style: HeaderStyle = Mobius.styles.headerStyle,
    content: @Composable ScreenContentHeaderScope.() -> Unit,
) {
    val styleValues = style.resolve()
    val contentColor = styleValues.contentColor.takeOrElse { LocalContentColor.current }

    val headerVisible = LocalContentHeaderVisible.current
    DisposableEffect(headerVisible) {
        headerVisible.value = true
        onDispose { headerVisible.value = false }
    }
    if (headerVisible.value) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            Box(
                modifier = Modifier
                    .padding(bottom = contentStyle.padding.calculateTopPadding())
                    .fillContentContainerWidth(ignorePadding = true)
                    .modifyIf(styleValues.background != null) {
                        background(styleValues.background!!)
                    }
                    .then(modifier)
            ) {
                ScreenContentHeaderScope(this).content()
            }
        }
    }
}

interface ScreenContentHeaderScope : HeaderScope

private fun ScreenContentHeaderScope(boxScope: BoxScope) = object : ScreenContentHeaderScope, BoxScope by boxScope {}

@Composable
fun DialogScreenScope.Header(
    modifier: Modifier = Modifier,
    style: HeaderStyle = Mobius.styles.dialogHeaderStyle,
    content: @Composable DialogScreenHeaderScope.() -> Unit,
) {
    val styleValues = style.resolve()
    val contentColor = styleValues.contentColor.takeOrElse { LocalContentColor.current }

    CompositionLocalProvider(LocalContentColor provides contentColor) {
        Box(
            modifier = Modifier
                .fillDialogWidth()
                .modifyIf(styleValues.background != null) {
                    background(styleValues.background!!)
                }
                .then(modifier)
        ) {
            DialogScreenHeaderScope(this).content()
        }
    }
}

interface DialogScreenHeaderScope : HeaderScope

private fun DialogScreenHeaderScope(boxScope: BoxScope) = object : DialogScreenHeaderScope, BoxScope by boxScope {}

@Composable
fun DialogScreenContentScope.Header(
    modifier: Modifier = Modifier,
    style: HeaderStyle = Mobius.styles.headerStyle,
    content: @Composable DialogScreenContentHeaderScope.() -> Unit,
) {
    val styleValues = style.resolve()
    val contentColor = styleValues.contentColor.takeOrElse { LocalContentColor.current }

    val headerVisible = LocalContentHeaderVisible.current
    DisposableEffect(headerVisible) {
        headerVisible.value = true
        onDispose { headerVisible.value = false }
    }
    if (headerVisible.value) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            Box(
                modifier = Modifier
                    .padding(bottom = contentStyle.padding.calculateTopPadding())
                    .fillContentContainerWidth(ignorePadding = true)
                    .modifyIf(styleValues.background != null) {
                        background(styleValues.background!!)
                    }
                    .then(modifier)
            ) {
                DialogScreenContentHeaderScope(this).content()
            }
        }
    }
}

interface DialogScreenContentHeaderScope : HeaderScope

private fun DialogScreenContentHeaderScope(boxScope: BoxScope) =
    object : DialogScreenContentHeaderScope, BoxScope by boxScope {}

internal val LocalContentHeaderVisible = compositionLocalOf { mutableStateOf(false) }
