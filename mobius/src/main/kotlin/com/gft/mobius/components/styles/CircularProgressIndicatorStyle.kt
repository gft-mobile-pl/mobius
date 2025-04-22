package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface CircularProgressIndicatorStyle : Style {
    val size: Token<Dp>
    val color: Token<Color>
    val trackColor: Token<Color>
    val strokeWidth: Token<Dp>
    val strokeCap: Token<StrokeCap>
    val gapSize: Token<Dp>
}

open class DefaultCircularProgressIndicatorStyle : CircularProgressIndicatorStyle {
    override val size: Token<Dp> = Token(MobiusReferenceDimensions.Dimension48)
    override val color: Token<Color> = Token { Mobius.colors.primary }
    override val trackColor: Token<Color> = Token { Mobius.colors.primaryContainer }
    override val strokeWidth: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val strokeCap: Token<StrokeCap> = Token(StrokeCap.Round)
    override val gapSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
}

open class IndeterminateCircularProgressIndicatorStyle : CircularProgressIndicatorStyle {
    override val size: Token<Dp> = Token(MobiusReferenceDimensions.Dimension48)
    override val color: Token<Color> = Token { Mobius.colors.primary }
    override val trackColor: Token<Color> = Token(Color.Transparent)
    override val strokeWidth: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val strokeCap: Token<StrokeCap> = Token(StrokeCap.Round)
    override val gapSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
}
