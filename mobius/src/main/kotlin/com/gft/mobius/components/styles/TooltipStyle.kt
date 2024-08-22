package com.gft.mobius.components.styles

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius

interface TooltipStyleValues : StyleValues {
    val shape: CornerBasedShape
    val containerColor: Color
    val contentColor: Color
    val tonalElevation: Dp
    val shadowElevation: Dp
    val pointerSize: DpSize
    val contentTextStyle: TextStyle
}

interface TooltipStyle : Style {
    val shape: Token<CornerBasedShape>
    val containerColor: Token<Color>
    val contentColor: Token<Color>
    val tonalElevation: Token<Dp>
    val shadowElevation: Token<Dp>
    val pointerSize: Token<DpSize>
    val contentTextStyle: Token<TextStyle>
}

@Composable
fun TooltipStyle.resolve() = produceStyleValues { style ->
    object : TooltipStyleValues {
        override val shape = style.shape.resolve()
        override val containerColor = style.containerColor.resolve()
        override val contentColor = style.contentColor.resolve()
        override val tonalElevation = style.tonalElevation.resolve()
        override val shadowElevation = style.shadowElevation.resolve()
        override val pointerSize = style.pointerSize.resolve()
        override val contentTextStyle = style.contentTextStyle.resolve()
    }
}

open class DefaultTooltipStyle : TooltipStyle {
    override val shape = Token { ShapeDefaults.ExtraSmall }
    override val containerColor = Token { Mobius.colors.inverseSurface }
    override val contentColor = Token { Mobius.colors.inverseOnSurface }
    override val tonalElevation = Token(0.dp)
    override val shadowElevation = Token(0.dp)
    override val pointerSize = Token(DpSize.Unspecified)
    override val contentTextStyle = Token { Mobius.typography.bodySmall }
}
