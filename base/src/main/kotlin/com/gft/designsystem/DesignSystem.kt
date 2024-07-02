package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.NonSkippableComposable
import androidx.compose.runtime.remember

@Composable
@NonSkippableComposable
fun DesignSystem(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalStylesCache provides StylesCache(),
        content = content
    )
}
