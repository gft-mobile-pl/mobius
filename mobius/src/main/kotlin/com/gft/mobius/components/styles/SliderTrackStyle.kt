package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

interface SliderTrackStyleValues : StyleValues {
    val activeTrackColor: Color
    val activeTickColor: Color
    val inactiveTrackColor: Color
    val inactiveTickColor: Color
    val disabledActiveTrackColor: Color
    val disabledActiveTickColor: Color
    val disabledInactiveTrackColor: Color
    val disabledInactiveTickColor: Color
    val thumbTrackGapSize: Dp
    val trackInsideCornerSize: Dp
}

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

@Composable
fun SliderTrackStyle.resolve() = produceStyleValues { style ->
    object : SliderTrackStyleValues {
        override val activeTrackColor = style.activeTrackColor.resolve()
        override val activeTickColor = style.activeTickColor.resolve()
        override val inactiveTrackColor = style.inactiveTrackColor.resolve()
        override val inactiveTickColor = style.inactiveTickColor.resolve()
        override val disabledActiveTrackColor = style.disabledActiveTrackColor.resolve()
        override val disabledActiveTickColor = style.disabledActiveTickColor.resolve()
        override val disabledInactiveTrackColor = style.disabledInactiveTrackColor.resolve()
        override val disabledInactiveTickColor = style.disabledInactiveTickColor.resolve()
        override val thumbTrackGapSize = style.thumbTrackGapSize.resolve()
        override val trackInsideCornerSize = style.trackInsideCornerSize.resolve()
    }
}

open class DefaultSliderTrackStyle : SliderTrackStyle {
    override val activeTrackColor = Token { Mobius.colors.primary}
    override val activeTickColor = Token { Mobius.colors.primaryContainer }
    override val inactiveTrackColor = Token { Mobius.colors.primaryContainer }
    override val inactiveTickColor = Token { Mobius.colors.primary }
    override val disabledActiveTrackColor = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledActiveTickColor = Token { Mobius.colors.inverseOnSurface.copy(alpha = 0.66f) }
    override val disabledInactiveTrackColor = Token { Mobius.colors.onSurface.copy(alpha = 0.12f) }
    override val disabledInactiveTickColor = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val thumbTrackGapSize = Token(MobiusReferenceDimensions.Dimension4)
    override val trackInsideCornerSize = Token(MobiusReferenceDimensions.Dimension2)
}
