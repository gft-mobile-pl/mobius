package com.gft.mobius.components.styles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions
import com.gft.mobius.references.MobiusReferenceElevations

interface DropdownMenuStyleValues : StyleValues {
    val shape: Shape
    val backgroundColor: Color
    val tonalElevation: Dp
    val shadowElevation: Dp
    val border: BorderStroke?
}

interface DropdownMenuStyle : Style {
    val shape: Token<Shape>
    val backgroundColor: Token<Color>
    val tonalElevation: Token<Dp>
    val shadowElevation: Token<Dp>
    val border: Token<BorderStroke?>
}

@Composable
fun DropdownMenuStyle.resolve() = produceStyleValues { style ->
    object : DropdownMenuStyleValues {
        override val shape = style.shape.resolve()
        override val backgroundColor = style.backgroundColor.resolve()
        override val tonalElevation = style.tonalElevation.resolve()
        override val shadowElevation = style.shadowElevation.resolve()
        override val border = style.border.resolve()
    }
}

open class DefaultDropdownMenuStyle : DropdownMenuStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension4))
    override val backgroundColor: Token<Color> = Token { Mobius.colors.surfaceContainer }
    override val tonalElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val shadowElevation: Token<Dp> = Token(MobiusReferenceElevations.Level2)
    override val border: Token<BorderStroke?> = Token(null)
}
