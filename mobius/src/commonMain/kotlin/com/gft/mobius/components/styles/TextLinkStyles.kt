package com.gft.mobius.components.styles

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.style.TextDecoration
import com.gft.designsystem.Token
import com.gft.mobius.Mobius

val DefaultTextLinkStyles = Token {
    TextLinkStyles(
        style = SpanStyle(
            color = Mobius.colors.primary,
            textDecoration = TextDecoration.Underline
        ),
        pressedStyle = SpanStyle(
            textDecoration = TextDecoration.Underline
        )
    )
}

val LocalTextLinkStyles = compositionLocalOf { TextLinkStyles() }
