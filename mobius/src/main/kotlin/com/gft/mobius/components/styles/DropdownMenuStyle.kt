package com.gft.mobius.components.styles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions
import com.gft.mobius.references.MobiusReferenceElevations

@GenerateStyleValues
interface DropdownMenuStyle : Style {
    val shape: Token<Shape>
    val backgroundColor: Token<Color>
    val tonalElevation: Token<Dp>
    val shadowElevation: Token<Dp>
    val border: Token<BorderStroke?>
}

open class DefaultDropdownMenuStyle : DropdownMenuStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension4))
    override val backgroundColor: Token<Color> = Token { Mobius.colors.surfaceContainer }
    override val tonalElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val shadowElevation: Token<Dp> = Token(MobiusReferenceElevations.Level2)
    override val border: Token<BorderStroke?> = Token(null)
}
