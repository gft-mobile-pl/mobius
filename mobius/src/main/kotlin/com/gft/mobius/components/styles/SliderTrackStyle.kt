package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.codegen.annotation.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface SliderTrackStyle : Style {
    val activeTrackColor: Token<Color>
    val activeTickColor: Token<Color>
    val inactiveTrackColor: Token<Color>
    val inactiveTickColor: Token<Color>
    val disabledActiveTrackColor: Token<Color>
    val disabledActiveTickColor: Token<Color>
    val disabledInactiveTrackColor: Token<Color>
    val disabledInactiveTickColor: Token<Color>
    val thumbTrackGapSize: Token<Dp>
    val trackInsideCornerSize: Token<Dp>
}

open class DefaultSliderTrackStyle : SliderTrackStyle {
    override val activeTrackColor: Token<Color> = Token { Mobius.colors.primary }
    override val activeTickColor: Token<Color> = Token { Mobius.colors.primaryContainer }
    override val inactiveTrackColor: Token<Color> = Token { Mobius.colors.primaryContainer }
    override val inactiveTickColor: Token<Color> = Token { Mobius.colors.primary }
    override val disabledActiveTrackColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledActiveTickColor: Token<Color> = Token { Mobius.colors.inverseOnSurface.copy(alpha = 0.66f) }
    override val disabledInactiveTrackColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.12f) }
    override val disabledInactiveTickColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val thumbTrackGapSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val trackInsideCornerSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension2)
}
