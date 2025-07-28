package com.gft.mobius.components.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection

@Composable
fun <T> T.ReverseLayout(
    content: @Composable T.() -> Unit,
) = CompositionLocalProvider(
    LocalLayoutDirection provides when (LocalLayoutDirection.current) {
        LayoutDirection.Ltr -> LayoutDirection.Rtl
        LayoutDirection.Rtl -> LayoutDirection.Ltr
    }
) {
    content()
}

@Composable
fun ReverseLayout(
    content: @Composable () -> Unit,
) = CompositionLocalProvider(
    value = LocalLayoutDirection provides when (LocalLayoutDirection.current) {
        LayoutDirection.Ltr -> LayoutDirection.Rtl
        LayoutDirection.Rtl -> LayoutDirection.Ltr
    },
    content = content
)

@Composable
fun ReverseLayoutConditionally(
    condition: Boolean,
    content: @Composable () -> Unit,
) {
    if (condition) ReverseLayout(content)
    else content()
}
