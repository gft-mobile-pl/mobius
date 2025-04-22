package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface LinearProgressIndicatorStyle : Style {
    val width: Token<Dp>
    val height: Token<Dp>
    val color: Token<Color>
    val trackColor: Token<Color>
    val strokeCap: Token<StrokeCap>
    val gapSize: Token<Dp>
}

open class DefaultLinearProgressIndicatorStyle : LinearProgressIndicatorStyle {
    override val width: Token<Dp> = Token(240.dp)
    override val height: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val color: Token<Color> = Token { Mobius.colors.primary }
    override val trackColor: Token<Color> = Token { Mobius.colors.primaryContainer }
    override val strokeCap: Token<StrokeCap> = Token(StrokeCap.Round)
    override val gapSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
}
