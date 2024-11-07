package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.references.MobiusReferenceDimensions

interface IconSizeValues : StyleValues {
    val smallIconSize: Dp
    val mediumIconSize: Dp
    val largeIconSize: Dp
    val extraLargeIconSize: Dp
}

interface IconSizeStyle : Style {
    val smallIconSize: Token<Dp>
    val mediumIconSize: Token<Dp>
    val largeIconSize: Token<Dp>
    val extraLargeIconSize: Token<Dp>
}

@Composable
fun IconSizeStyle.resolve() = produceStyleValues { style ->
    object : IconSizeValues {
        override val smallIconSize = style.smallIconSize.resolve()
        override val mediumIconSize = style.mediumIconSize.resolve()
        override val largeIconSize = style.largeIconSize.resolve()
        override val extraLargeIconSize = style.extraLargeIconSize.resolve()
    }
}

class DefaultIconSizeStyle : IconSizeStyle {
    override val smallIconSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension16)
    override val mediumIconSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension24)
    override val largeIconSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension40)
    override val extraLargeIconSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension64)
}
