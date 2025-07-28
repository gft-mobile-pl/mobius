package com.gft.mobius.components.styles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions
import com.gft.mobius.references.MobiusReferenceElevations

@GenerateStyleValues
interface CardStyle : Style {
    val contentColor: Token<Color>
    val containerColor: Token<Color>
    val disabledContentColor: Token<Color>
    val disabledContainerColor: Token<Color>
    val border: Token<BorderStroke?>
    val disabledBorder: Token<BorderStroke?>
    val shape: Token<Shape>
    val defaultElevation: Token<Dp>
    val pressedElevation: Token<Dp>
    val focusedElevation: Token<Dp>
    val hoveredElevation: Token<Dp>
    val draggedElevation: Token<Dp>
    val disabledElevation: Token<Dp>
}

open class DefaultCardStyle : CardStyle {
    override val containerColor: Token<Color> = Token { Mobius.colors.surfaceContainerHighest }
    override val contentColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val disabledContainerColor: Token<Color> = Token {
        Mobius.colors.surfaceVariant.copy(alpha = 0.38f).compositeOver(Mobius.colors.surfaceContainerHighest)
    }
    override val disabledContentColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val border: Token<BorderStroke?> = Token(null)
    override val disabledBorder: Token<BorderStroke?> = Token(null)
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension12))
    override val defaultElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val pressedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val focusedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val hoveredElevation: Token<Dp> = Token(MobiusReferenceElevations.Level1)
    override val draggedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level3)
    override val disabledElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
}

open class OutlinedCardStyle : CardStyle {
    override val containerColor: Token<Color> = Token { Mobius.colors.surface }
    override val contentColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val disabledContainerColor: Token<Color> = Token { Mobius.colors.surface }
    override val disabledContentColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val border: Token<BorderStroke?> = Token {
        BorderStroke(
            width = MobiusReferenceDimensions.Dimension1,
            color = Mobius.colors.outlineVariant
        )
    }
    override val disabledBorder: Token<BorderStroke?> = Token {
        BorderStroke(
            width = MobiusReferenceDimensions.Dimension1,
            color = Mobius.colors.outline.copy(alpha = 0.12f).compositeOver(Mobius.colors.surfaceContainerLow)
        )
    }
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension12))
    override val defaultElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val pressedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val focusedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val hoveredElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val draggedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level3)
    override val disabledElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
}

open class ElevatedCardStyle : CardStyle {
    override val containerColor: Token<Color> = Token { Mobius.colors.surfaceContainerLow }
    override val contentColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val disabledContainerColor: Token<Color> = Token { Mobius.colors.surface }
    override val disabledContentColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val border: Token<BorderStroke?> = Token(null)
    override val disabledBorder: Token<BorderStroke?> = Token(null)
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension12))
    override val defaultElevation: Token<Dp> = Token(MobiusReferenceElevations.Level1)
    override val pressedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level1)
    override val focusedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level1)
    override val hoveredElevation: Token<Dp> = Token(MobiusReferenceElevations.Level2)
    override val draggedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level4)
    override val disabledElevation: Token<Dp> = Token(MobiusReferenceElevations.Level1)
}
