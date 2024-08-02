package com.gft.mobius.components.styles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.references.MobiusReferenceDimensions
import com.gft.mobius.references.MobiusReferenceElevations

interface ButtonStyleValues : StyleValues {
    val shape: Shape
    val contentColor: Color
    val containerColor: Color
    val disabledContentColor: Color
    val disabledContainerColor: Color
    val defaultElevation: Dp
    val pressedElevation: Dp
    val focusedElevation: Dp
    val hoveredElevation: Dp
    val disabledElevation: Dp
    val contentElementsSpacing: Dp
    val contentPadding: PaddingValues
    val height: Dp
    val rippleColor: Color
    val border: BorderStroke?
    val iconSize: IconSize
    val textStyle: TextStyle
}

interface ButtonStyle : Style {
    val shape: Token<Shape>
    val contentColor: Token<Color>
    val containerColor: Token<Color>
    val disabledContentColor: Token<Color>
    val disabledContainerColor: Token<Color>
    val defaultElevation: Token<Dp>
    val pressedElevation: Token<Dp>
    val focusedElevation: Token<Dp>
    val hoveredElevation: Token<Dp>
    val disabledElevation: Token<Dp>
    val contentElementsSpacing: Token<Dp>
    val contentPadding: Token<PaddingValues>
    val height: Token<Dp>
    val rippleColor: Token<Color>
    val border: Token<BorderStroke?>
    val iconSize: Token<IconSize>
    val textStyle: Token<TextStyle>
}

@Composable
fun ButtonStyle.resolve() = produceStyleValues { style ->
    object : ButtonStyleValues {
        override val shape = style.shape.resolve()
        override val contentColor = style.contentColor.resolve()
        override val containerColor = style.containerColor.resolve()
        override val disabledContentColor = style.disabledContentColor.resolve()
        override val disabledContainerColor = style.disabledContainerColor.resolve()
        override val defaultElevation = style.defaultElevation.resolve()
        override val pressedElevation = style.pressedElevation.resolve()
        override val focusedElevation = style.focusedElevation.resolve()
        override val hoveredElevation = style.hoveredElevation.resolve()
        override val disabledElevation = style.disabledElevation.resolve()
        override val contentElementsSpacing = style.contentElementsSpacing.resolve()
        override val contentPadding = style.contentPadding.resolve()
        override val height = style.height.resolve()
        override val rippleColor = style.rippleColor.resolve()
        override val border = style.border.resolve()
        override val iconSize = style.iconSize.resolve()
        override val textStyle = style.textStyle.resolve()
    }
}

open class DefaultButtonStyle : ButtonStyle {
    override val shape = Token<Shape>(RoundedCornerShape(50))
    override val contentColor = Token { Mobius.colors.onPrimary }
    override val containerColor = Token { Mobius.colors.primary }
    override val disabledContentColor = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledContainerColor = Token { Mobius.colors.onSurface.copy(alpha = 0.12f) }
    override val rippleColor = Token { Mobius.colors.onPrimary }
    override val defaultElevation = Token(MobiusReferenceElevations.Level0)
    override val pressedElevation = Token(MobiusReferenceElevations.Level0)
    override val focusedElevation = Token(MobiusReferenceElevations.Level0)
    override val hoveredElevation = Token(MobiusReferenceElevations.Level1)
    override val disabledElevation = Token(MobiusReferenceElevations.Level0)
    override val contentElementsSpacing = Token(MobiusReferenceDimensions.Dimension4)
    override val contentPadding = Token(
        PaddingValues(
            horizontal = MobiusReferenceDimensions.Dimension24,
            vertical = MobiusReferenceDimensions.Dimension8
        )
    )
    override val height = Token(MobiusReferenceDimensions.Dimension40)
    override val border = Token<BorderStroke?>(null)
    override val iconSize = Token { IconSize.Unspecified }
    override val textStyle = Token { Mobius.typography.labelLarge }
}

open class OutlinedButtonStyle : ButtonStyle {
    override val shape = TokenReference { Mobius.styles.buttonStyle.shape }
    override val contentColor = Token { Mobius.colors.primary }
    override val containerColor = Token(Color.Transparent)
    override val disabledContentColor = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledContainerColor = Token(Color.Transparent)
    override val rippleColor = Token { Mobius.colors.primary }
    override val defaultElevation = Token(Dp.Unspecified)
    override val pressedElevation = Token(Dp.Unspecified)
    override val focusedElevation = Token(Dp.Unspecified)
    override val hoveredElevation = Token(Dp.Unspecified)
    override val disabledElevation = Token(Dp.Unspecified)
    override val contentElementsSpacing = Token(MobiusReferenceDimensions.Dimension4)
    override val contentPadding = TokenReference { Mobius.styles.buttonStyle.contentPadding }
    override val height = TokenReference { Mobius.styles.buttonStyle.height }
    override val border = Token<BorderStroke?> {
        BorderStroke(
            width = MobiusReferenceDimensions.Dimension1,
            color = Mobius.colors.outline
        )
    }
    override val iconSize = TokenReference { Mobius.styles.buttonStyle.iconSize }
    override val textStyle = TokenReference { Mobius.styles.buttonStyle.textStyle }
}

open class ElevatedButtonStyle : ButtonStyle {
    override val shape = TokenReference { Mobius.styles.buttonStyle.shape }
    override val contentColor = Token { Mobius.colors.primary }
    override val containerColor = Token { Mobius.colors.surface }
    override val disabledContentColor = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledContainerColor = Token { Mobius.colors.onSurface.copy(alpha = 0.12f) }
    override val rippleColor = Token { Mobius.colors.primary }
    override val defaultElevation = Token(MobiusReferenceElevations.Level2)
    override val pressedElevation = Token(MobiusReferenceElevations.Level2)
    override val focusedElevation = Token(MobiusReferenceElevations.Level2)
    override val hoveredElevation = Token(MobiusReferenceElevations.Level3)
    override val disabledElevation = Token(MobiusReferenceElevations.Level0)
    override val contentElementsSpacing = Token(MobiusReferenceDimensions.Dimension4)
    override val contentPadding = TokenReference { Mobius.styles.buttonStyle.contentPadding }
    override val height = TokenReference { Mobius.styles.buttonStyle.height }
    override val border = Token<BorderStroke?>(null)
    override val iconSize = TokenReference { Mobius.styles.buttonStyle.iconSize }
    override val textStyle = TokenReference { Mobius.styles.buttonStyle.textStyle }
}

open class FilledTonalButtonStyle : ButtonStyle {
    override val shape = TokenReference { Mobius.styles.buttonStyle.shape }
    override val contentColor = Token { Mobius.colors.onSecondaryContainer }
    override val containerColor = Token { Mobius.colors.secondaryContainer }
    override val disabledContentColor = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledContainerColor = Token { Mobius.colors.onSurface.copy(alpha = 0.12f) }
    override val rippleColor = Token { Mobius.colors.primary }
    override val defaultElevation = Token(Dp.Unspecified)
    override val pressedElevation = Token(Dp.Unspecified)
    override val focusedElevation = Token(Dp.Unspecified)
    override val hoveredElevation = Token(Dp.Unspecified)
    override val disabledElevation = Token(Dp.Unspecified)
    override val contentElementsSpacing = Token(MobiusReferenceDimensions.Dimension4)
    override val contentPadding = TokenReference { Mobius.styles.buttonStyle.contentPadding }
    override val height = TokenReference { Mobius.styles.buttonStyle.height }
    override val border = Token<BorderStroke?>(null)
    override val iconSize = TokenReference { Mobius.styles.buttonStyle.iconSize }
    override val textStyle = TokenReference { Mobius.styles.buttonStyle.textStyle }
}

open class TextButtonStyle : ButtonStyle {
    override val shape = TokenReference { Mobius.styles.buttonStyle.shape }
    override val contentColor = Token { Mobius.colors.primary }
    override val containerColor = Token(Color.Transparent)
    override val disabledContentColor = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledContainerColor = Token(Color.Transparent)
    override val rippleColor = Token { Mobius.colors.primary }
    override val defaultElevation = TokenReference { Mobius.styles.buttonStyle.defaultElevation }
    override val pressedElevation = TokenReference { Mobius.styles.buttonStyle.pressedElevation }
    override val focusedElevation = TokenReference { Mobius.styles.buttonStyle.focusedElevation }
    override val hoveredElevation = TokenReference { Mobius.styles.buttonStyle.hoveredElevation }
    override val disabledElevation = TokenReference { Mobius.styles.buttonStyle.disabledElevation }
    override val contentElementsSpacing = Token(MobiusReferenceDimensions.Dimension4)
    override val contentPadding = Token(
        PaddingValues(
            horizontal = MobiusReferenceDimensions.Dimension12,
            vertical = MobiusReferenceDimensions.Dimension8
        )
    )
    override val height = TokenReference { Mobius.styles.buttonStyle.height }
    override val border = Token<BorderStroke?>(null)
    override val iconSize = TokenReference { Mobius.styles.buttonStyle.iconSize }
    override val textStyle = TokenReference { Mobius.styles.buttonStyle.textStyle }
}