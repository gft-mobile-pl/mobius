package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.common.SizeFraction

@GenerateStyleValues
interface LinearProgressIndicatorEndCapStyle : Style {
    val color: Token<Color>
    val strokeCap: Token<StrokeCap>
    val sizeFraction: Token<SizeFraction>
}

open class DefaultLinearProgressIndicatorEndCapStyle : LinearProgressIndicatorEndCapStyle {
    override val color: Token<Color> = Token { Mobius.colors.primary }
    override val strokeCap: Token<StrokeCap> = Token(StrokeCap.Round)
    override val sizeFraction: Token<SizeFraction> = Token(SizeFraction(1f))
}
