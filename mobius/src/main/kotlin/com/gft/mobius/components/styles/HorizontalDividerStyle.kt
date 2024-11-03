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

interface HorizontalDividerStyleValues : StyleValues {
    val thickness: Dp
    val color: Color
}

interface HorizontalDividerStyle : Style {
    val thickness: Token<Dp>
    val color: Token<Color>
}

@Composable
fun HorizontalDividerStyle.resolve() = produceStyleValues { style ->
    object : HorizontalDividerStyleValues {
        override val thickness = style.thickness.resolve()
        override val color = style.color.resolve()
    }
}

open class DefaultHorizontalDividerStyle : HorizontalDividerStyle {
    override val thickness: Token<Dp> = Token(MobiusReferenceDimensions.Dimension1)
    override val color: Token<Color> = Token { Mobius.colors.outlineVariant }
}
