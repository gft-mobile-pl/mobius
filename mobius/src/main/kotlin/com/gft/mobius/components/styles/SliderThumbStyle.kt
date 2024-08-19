package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

interface SliderThumbStyleValues : StyleValues {
    val color: Color
    val disabledColor: Color
    val height: Dp
    val width: Dp
    val tooltipStyle: TooltipStyle
}

interface SliderThumbStyle : Style {
    val color: Token<Color>
    val disabledColor: Token<Color>
    val height: Token<Dp>
    val width: Token<Dp>
    val tooltipStyle: Token<TooltipStyle>
}

@Composable
fun SliderThumbStyle.resolve() = produceStyleValues { style ->
    object : SliderThumbStyleValues {
        override val color = style.color.resolve()
        override val disabledColor = style.disabledColor.resolve()
        override val height = style.height.resolve()
        override val width = style.width.resolve()
        override val tooltipStyle = style.tooltipStyle.resolve()
    }
}

open class DefaultSliderThumbStyle : SliderThumbStyle {
    override val color = Token { Mobius.colors.primary }
    override val disabledColor = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val height = Token(MobiusReferenceDimensions.Dimension40)
    override val width = Token(MobiusReferenceDimensions.Dimension4)
    override val tooltipStyle = Token { Mobius.styles.sliderTooltipStyle }
}

open class SliderTooltipStyle : TooltipStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension32))
    override val containerColor = TokenReference { Mobius.styles.tooltipStyle.containerColor }
    override val contentColor = TokenReference { Mobius.styles.tooltipStyle.contentColor }
    override val tonalElevation = TokenReference { Mobius.styles.tooltipStyle.tonalElevation }
    override val shadowElevation = TokenReference { Mobius.styles.tooltipStyle.shadowElevation }
    override val pointerSize = TokenReference { Mobius.styles.tooltipStyle.pointerSize }
    override val contentTextStyle = Token { Mobius.typography.labelLarge }
    override val padding = Token(
            PaddingValues(
                vertical = MobiusReferenceDimensions.Dimension12
            )
        )
    override val minWidth = Token(MobiusReferenceDimensions.Dimension48)
}
