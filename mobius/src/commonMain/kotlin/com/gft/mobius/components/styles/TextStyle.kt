package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Token
import com.gft.mobius.Mobius

val DefaultTextStyle = Token { Mobius.typography.bodyLarge }

val LocalTextStyle = androidx.compose.material3.LocalTextStyle

@Composable
fun ProvideTextStyle(style: TextStyle, content: @Composable () -> Unit) {
    androidx.compose.material3.ProvideTextStyle(
        value = style,
        content = content
    )
}
