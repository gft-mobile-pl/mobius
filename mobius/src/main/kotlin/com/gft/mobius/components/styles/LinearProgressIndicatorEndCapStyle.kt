package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.common.SizeFactor

interface LinearProgressIndicatorEndCapStyleValues : StyleValues {
    val color: Color
    val strokeCap: StrokeCap
    val sizeFactor: SizeFactor
}

interface LinearProgressIndicatorEndCapStyle : Style {
    val color: Token<Color>
    val strokeCap: Token<StrokeCap>
    val sizeFactor: Token<SizeFactor>
}

@Composable
fun LinearProgressIndicatorEndCapStyle.resolve() = produceStyleValues { style ->
    object : LinearProgressIndicatorEndCapStyleValues {
        override val color = style.color.resolve()
        override val strokeCap = style.strokeCap.resolve()
        override val sizeFactor = style.sizeFactor.resolve()
    }
}

open class DefaultLinearProgressIndicatorEndCapStyle : LinearProgressIndicatorEndCapStyle {
    override val color = Token { Mobius.colors.primary }
    override val strokeCap = Token(StrokeCap.Round)
    override val sizeFactor = Token(SizeFactor(1f))
}
