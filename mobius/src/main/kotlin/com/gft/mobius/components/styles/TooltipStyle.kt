package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

interface TooltipStyleValues : StyleValues {
    val shape: Shape
    val containerColor: Color
    val contentColor: Color
    val tonalElevation: Dp
    val shadowElevation: Dp
    val pointerSize: DpSize
    val contentTextStyle: TextStyle
    val padding: PaddingValues
    val minWidth: Dp
}

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

@Composable
fun TooltipStyle.resolve() = produceStyleValues { style ->
    object : TooltipStyleValues {
        override val shape = style.shape.resolve()
        override val containerColor = style.containerColor.resolve()
        override val contentColor = style.contentColor.resolve()
        override val tonalElevation = style.tonalElevation.resolve()
        override val shadowElevation = style.shadowElevation.resolve()
        override val pointerSize = style.pointerSize.resolve()
        override val contentTextStyle = style.contentTextStyle.resolve()
        override val padding = style.padding.resolve()
        override val minWidth = style.minWidth.resolve()
    }
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
