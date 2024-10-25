package com.gft.mobius.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Spacer
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
import com.gft.mobius.components.common.NEGLIGIBLE_NON_ZERO_WEIGHT
import com.gft.mobius.components.common.isInMainLayoutPass
import com.gft.mobius.components.styles.FooterStyle
import com.gft.mobius.components.styles.resolve

interface FooterScope : BoxScope {
    @Composable
    fun Modifier.fillFooterWidth(): Modifier = modifyIf(isInMainLayoutPass()) { fillMaxWidth() }
}

@Suppress("UnusedReceiverParameter")
@Composable
fun ScreenScope.Footer(
    modifier: Modifier = Modifier,
    style: FooterStyle = Mobius.styles.footerStyle,
    content: @Composable ScreenFooterScope.() -> Unit,
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
            ScreenFooterScope(this).content()
        }
    }
}

interface ScreenFooterScope : FooterScope

private fun ScreenFooterScope(boxScope: BoxScope) = object : ScreenFooterScope, BoxScope by boxScope {}

@Composable
fun ScreenContentScope.Footer(
    modifier: Modifier = Modifier,
    style: FooterStyle = Mobius.styles.footerStyle,
    content: @Composable ScreenContentFooterScope.() -> Unit,
) {
    val styleValues = style.resolve()
    val contentColor = styleValues.contentColor.takeOrElse { LocalContentColor.current }

    val footerVisible = LocalFooterVisible.current
    DisposableEffect(footerVisible) {
        footerVisible.value = true
        onDispose { footerVisible.value = false }
    }
    if (footerVisible.value) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            Spacer(modifier = Modifier.weight(NEGLIGIBLE_NON_ZERO_WEIGHT))
            Box(
                modifier = Modifier
                    .padding(top = contentStyle.padding.calculateBottomPadding())
                    .fillContentContainerWidth(ignorePadding = true)
                    .modifyIf(styleValues.background != null) {
                        background(styleValues.background!!)
                    }
                    .then(modifier)
            ) {
                ScreenContentFooterScope(this).content()
            }
        }
    }
}

interface ScreenContentFooterScope : FooterScope

private fun ScreenContentFooterScope(boxScope: BoxScope) = object : ScreenContentFooterScope, BoxScope by boxScope {}

@Composable
fun DialogScreenScope.Footer(
    modifier: Modifier = Modifier,
    style: FooterStyle = Mobius.styles.dialogFooterStyle,
    content: @Composable DialogScreenFooterScope.() -> Unit,
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
            DialogScreenFooterScope(this).content()
        }
    }
}

interface DialogScreenFooterScope : FooterScope

private fun DialogScreenFooterScope(boxScope: BoxScope) = object : DialogScreenFooterScope, BoxScope by boxScope {}

@Composable
fun DialogScreenContentScope.Footer(
    modifier: Modifier = Modifier,
    style: FooterStyle = Mobius.styles.dialogFooterStyle,
    content: @Composable DialogScreenContentFooterScope.() -> Unit,
) {
    val styleValues = style.resolve()
    val contentColor = styleValues.contentColor.takeOrElse { LocalContentColor.current }

    val footerVisible = LocalFooterVisible.current
    DisposableEffect(footerVisible) {
        footerVisible.value = true
        onDispose { footerVisible.value = false }
    }
    if (footerVisible.value) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            Box(
                modifier = Modifier
                    .padding(top = contentStyle.padding.calculateBottomPadding())
                    .fillContentContainerWidth(ignorePadding = true)
                    .modifyIf(styleValues.background != null) {
                        background(styleValues.background!!)
                    }
                    .then(modifier)
            ) {
                DialogScreenContentFooterScope(this).content()
            }
        }
    }
}

interface DialogScreenContentFooterScope : FooterScope

private fun DialogScreenContentFooterScope(boxScope: BoxScope) =
    object : DialogScreenContentFooterScope, BoxScope by boxScope {}

internal val LocalFooterVisible = compositionLocalOf { mutableStateOf(false) }