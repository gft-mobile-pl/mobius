package com.gft.mobius.components.styles

import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.codegen.annotation.GenerateStyleValues
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface IconSizeStyle : Style {
    val smallIconSize: Token<Dp>
    val mediumIconSize: Token<Dp>
    val largeIconSize: Token<Dp>
    val extraLargeIconSize: Token<Dp>
}

class DefaultIconSizeStyle : IconSizeStyle {
    override val smallIconSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension16)
    override val mediumIconSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension24)
    override val largeIconSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension40)
    override val extraLargeIconSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension64)
}
