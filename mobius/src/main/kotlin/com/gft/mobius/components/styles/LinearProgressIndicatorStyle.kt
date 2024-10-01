package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

interface LinearProgressIndicatorStyleValues : StyleValues {
    val width: Dp
    val height: Dp
    val color: Color
    val trackColor: Color
    val strokeCap: StrokeCap
    val gapSize: Dp
}

interface LinearProgressIndicatorStyle : Style {
    val width: Token<Dp>
    val height: Token<Dp>
    val color: Token<Color>
    val trackColor: Token<Color>
    val strokeCap: Token<StrokeCap>
    val gapSize: Token<Dp>
}

@Composable
fun LinearProgressIndicatorStyle.resolve() = produceStyleValues { style ->
    object : LinearProgressIndicatorStyleValues {
        override val width = style.width.resolve()
        override val height = style.height.resolve()
        override val color = style.color.resolve()
        override val trackColor = style.trackColor.resolve()
        override val strokeCap = style.strokeCap.resolve()
        override val gapSize = style.gapSize.resolve()
    }
}

open class DefaultLinearProgressIndicatorStyle : LinearProgressIndicatorStyle {
    override val width = Token(240.dp)
    override val height = Token(MobiusReferenceDimensions.Dimension4)
    override val color = Token { Mobius.colors.primary }
    override val trackColor = Token { Mobius.colors.primaryContainer }
    override val strokeCap = Token(StrokeCap.Round)
    override val gapSize = Token(MobiusReferenceDimensions.Dimension4)
}
