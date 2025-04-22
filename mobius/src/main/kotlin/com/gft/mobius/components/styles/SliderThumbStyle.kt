package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface SliderThumbStyle : Style {
    val color: Token<Color>
    val disabledColor: Token<Color>
    val height: Token<Dp>
    val width: Token<Dp>
    val tooltipStyle: Token<TooltipStyle>
}

open class DefaultSliderThumbStyle : SliderThumbStyle {
    override val color: Token<Color> = Token { Mobius.colors.primary }
    override val disabledColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val height: Token<Dp> = Token(MobiusReferenceDimensions.Dimension40)
    override val width: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val tooltipStyle: Token<TooltipStyle> = Token { Mobius.styles.sliderTooltipStyle }
}

open class SliderTooltipStyle : TooltipStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension32))
    override val containerColor: Token<Color> = TokenReference { Mobius.styles.tooltipStyle.containerColor }
    override val contentColor: Token<Color> = TokenReference { Mobius.styles.tooltipStyle.contentColor }
    override val tonalElevation: Token<Dp> = TokenReference { Mobius.styles.tooltipStyle.tonalElevation }
    override val shadowElevation: Token<Dp> = TokenReference { Mobius.styles.tooltipStyle.shadowElevation }
    override val pointerSize: Token<DpSize> = TokenReference { Mobius.styles.tooltipStyle.pointerSize }
    override val contentTextStyle: Token<TextStyle> = Token { Mobius.typography.labelLarge }
    override val padding: Token<PaddingValues> = Token(
        PaddingValues(
            vertical = MobiusReferenceDimensions.Dimension12
        )
    )
    override val minWidth: Token<Dp> = Token(MobiusReferenceDimensions.Dimension48)
}
