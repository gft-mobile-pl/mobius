package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.common.SizeFraction

interface LinearProgressIndicatorEndCapStyleValues : StyleValues {
    val color: Color
    val strokeCap: StrokeCap
    val sizeFraction: SizeFraction
}

interface LinearProgressIndicatorEndCapStyle : Style {
    val color: Token<Color>
    val strokeCap: Token<StrokeCap>
    val sizeFraction: Token<SizeFraction>
}

@Composable
fun LinearProgressIndicatorEndCapStyle.resolve() = produceStyleValues { style ->
    object : LinearProgressIndicatorEndCapStyleValues {
        override val color = style.color.resolve()
        override val strokeCap = style.strokeCap.resolve()
        override val sizeFraction = style.sizeFraction.resolve()
    }
}

open class DefaultLinearProgressIndicatorEndCapStyle : LinearProgressIndicatorEndCapStyle {
    override val color: Token<Color> = Token { Mobius.colors.primary }
    override val strokeCap: Token<StrokeCap> = Token(StrokeCap.Round)
    override val sizeFraction: Token<SizeFraction> = Token(SizeFraction(1f))
}
