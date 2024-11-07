package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

interface CircularProgressIndicatorStyleValues : StyleValues {
    val size: Dp
    val color: Color
    val trackColor: Color
    val strokeWidth: Dp
    val strokeCap: StrokeCap
    val gapSize: Dp
}

interface CircularProgressIndicatorStyle : Style {
    val size: Token<Dp>
    val color: Token<Color>
    val trackColor: Token<Color>
    val strokeWidth: Token<Dp>
    val strokeCap: Token<StrokeCap>
    val gapSize: Token<Dp>
}

@Composable
fun CircularProgressIndicatorStyle.resolve() = produceStyleValues { style ->
    object : CircularProgressIndicatorStyleValues {
        override val size = style.size.resolve()
        override val color = style.color.resolve()
        override val trackColor = style.trackColor.resolve()
        override val strokeWidth = style.strokeWidth.resolve()
        override val strokeCap = style.strokeCap.resolve()
        override val gapSize = style.gapSize.resolve()
    }
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
