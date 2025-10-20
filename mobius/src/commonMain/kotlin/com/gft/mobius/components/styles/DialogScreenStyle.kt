package com.gft.mobius.components.styles

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.GenerateStyleWrapper
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
@GenerateStyleWrapper
interface DialogScreenStyle : Style {
    val shape: Token<Shape?>
    val background: Token<Brush?>
    val contentColor: Token<Color>
    val underlyingContentBlur: Token<Dp>
}

open class DefaultDialogScreenStyle : DialogScreenStyle {
    override val shape: Token<Shape?> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension24))
    override val background: Token<Brush?> = Token { SolidColor(Mobius.colors.surfaceContainerHigh) }
    override val contentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val underlyingContentBlur: Token<Dp> = Token(MobiusReferenceDimensions.Dimension8)
}
