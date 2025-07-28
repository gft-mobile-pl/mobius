package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface VerticalDividerStyle : Style {
    val thickness: Token<Dp>
    val color: Token<Color>
    val padding: Token<PaddingValues>
}

open class DefaultVerticalDividerStyle : VerticalDividerStyle {
    override val thickness: Token<Dp> = Token(MobiusReferenceDimensions.Dimension1)
    override val color: Token<Color> = Token { Mobius.colors.outlineVariant }
    override val padding: Token<PaddingValues> = Token(PaddingValues(MobiusReferenceDimensions.Dimension0))
}
