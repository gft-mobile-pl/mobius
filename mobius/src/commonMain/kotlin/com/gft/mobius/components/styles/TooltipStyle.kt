package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface TooltipStyle : Style {
    val shape: Token<Shape>
    val containerColor: Token<Color>
    val contentColor: Token<Color>
    val tonalElevation: Token<Dp>
    val shadowElevation: Token<Dp>
    val pointerSize: Token<DpSize>
    val contentTextStyle: Token<TextStyle>
    val padding: Token<PaddingValues>
    val minWidth: Token<Dp>
}

open class DefaultTooltipStyle : TooltipStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension4))
    override val containerColor: Token<Color> = Token { Mobius.colors.inverseSurface }
    override val contentColor: Token<Color> = Token { Mobius.colors.inverseOnSurface }
    override val tonalElevation: Token<Dp> = Token(MobiusReferenceDimensions.Dimension0)
    override val shadowElevation: Token<Dp> = Token(MobiusReferenceDimensions.Dimension0)
    override val pointerSize: Token<DpSize> = Token(DpSize.Unspecified)
    override val contentTextStyle: Token<TextStyle> = Token { Mobius.typography.bodySmall }
    override val padding: Token<PaddingValues> = Token(PaddingValues(MobiusReferenceDimensions.Dimension0))
    override val minWidth: Token<Dp> = Token(Dp.Unspecified)
}
