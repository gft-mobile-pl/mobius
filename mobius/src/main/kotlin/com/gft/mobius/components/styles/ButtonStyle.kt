package com.gft.mobius.components.styles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.references.MobiusReferenceDimensions
import com.gft.mobius.references.MobiusReferenceElevations

@GenerateStyleValues
interface ButtonStyle : Style {
    val shape: Token<Shape>
    val contentColor: Token<Color>
    val background: Token<Brush?>
    val disabledContentColor: Token<Color>
    val disabledBackground: Token<Brush?>
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

open class DefaultButtonStyle : ButtonStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(50))
    override val contentColor: Token<Color> = Token { Mobius.colors.onPrimary }
    override val background: Token<Brush?> = Token { SolidColor(Mobius.colors.primary) }
    override val disabledContentColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledBackground: Token<Brush?> = Token { SolidColor(Mobius.colors.onSurface.copy(alpha = 0.12f)) }
    override val rippleColor: Token<Color> = Token { Mobius.colors.onPrimary }
    override val defaultElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val pressedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val focusedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val hoveredElevation: Token<Dp> = Token(MobiusReferenceElevations.Level1)
    override val disabledElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val contentElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val contentPadding: Token<PaddingValues> = Token(
        PaddingValues(
            horizontal = MobiusReferenceDimensions.Dimension24,
            vertical = MobiusReferenceDimensions.Dimension8
        )
    )
    override val height: Token<Dp> = Token(MobiusReferenceDimensions.Dimension40)
    override val border: Token<BorderStroke?> = Token(null)
    override val iconSize: Token<IconSize> = Token { IconSize.Unspecified }
    override val textStyle: Token<TextStyle> = Token { Mobius.typography.labelLarge }
}

open class OutlinedButtonStyle : ButtonStyle {
    override val shape: Token<Shape> = TokenReference { Mobius.styles.buttonStyle.shape }
    override val contentColor: Token<Color> = Token { Mobius.colors.primary }
    override val background: Token<Brush?> = Token(null)
    override val disabledContentColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledBackground: Token<Brush?> = Token(null)
    override val rippleColor: Token<Color> = Token { Mobius.colors.primary }
    override val defaultElevation: Token<Dp> = Token(Dp.Unspecified)
    override val pressedElevation: Token<Dp> = Token(Dp.Unspecified)
    override val focusedElevation: Token<Dp> = Token(Dp.Unspecified)
    override val hoveredElevation: Token<Dp> = Token(Dp.Unspecified)
    override val disabledElevation: Token<Dp> = Token(Dp.Unspecified)
    override val contentElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val contentPadding: Token<PaddingValues> = TokenReference { Mobius.styles.buttonStyle.contentPadding }
    override val height: Token<Dp> = TokenReference { Mobius.styles.buttonStyle.height }
    override val border: Token<BorderStroke?> = Token {
        BorderStroke(
            width = MobiusReferenceDimensions.Dimension1,
            color = Mobius.colors.outline
        )
    }
    override val iconSize: Token<IconSize> = TokenReference { Mobius.styles.buttonStyle.iconSize }
    override val textStyle: Token<TextStyle> = TokenReference { Mobius.styles.buttonStyle.textStyle }
}

open class ElevatedButtonStyle : ButtonStyle {
    override val shape: Token<Shape> = TokenReference { Mobius.styles.buttonStyle.shape }
    override val contentColor: Token<Color> = Token { Mobius.colors.primary }
    override val background: Token<Brush?> = Token { SolidColor(Mobius.colors.surface) }
    override val disabledContentColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledBackground: Token<Brush?> = Token { SolidColor(Mobius.colors.onSurface.copy(alpha = 0.12f)) }
    override val rippleColor: Token<Color> = Token { Mobius.colors.primary }
    override val defaultElevation: Token<Dp> = Token(MobiusReferenceElevations.Level2)
    override val pressedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level2)
    override val focusedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level2)
    override val hoveredElevation: Token<Dp> = Token(MobiusReferenceElevations.Level3)
    override val disabledElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val contentElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val contentPadding: Token<PaddingValues> = TokenReference { Mobius.styles.buttonStyle.contentPadding }
    override val height: Token<Dp> = TokenReference { Mobius.styles.buttonStyle.height }
    override val border = Token<BorderStroke?>(null)
    override val iconSize: Token<IconSize> = TokenReference { Mobius.styles.buttonStyle.iconSize }
    override val textStyle: Token<TextStyle> = TokenReference { Mobius.styles.buttonStyle.textStyle }
}

open class FilledTonalButtonStyle : ButtonStyle {
    override val shape: Token<Shape> = TokenReference { Mobius.styles.buttonStyle.shape }
    override val contentColor: Token<Color> = Token { Mobius.colors.onSecondaryContainer }
    override val background: Token<Brush?> = Token { SolidColor(Mobius.colors.secondaryContainer) }
    override val disabledContentColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledBackground: Token<Brush?> = Token { SolidColor(Mobius.colors.onSurface.copy(alpha = 0.12f)) }
    override val rippleColor: Token<Color> = Token { Mobius.colors.primary }
    override val defaultElevation: Token<Dp> = Token(Dp.Unspecified)
    override val pressedElevation: Token<Dp> = Token(Dp.Unspecified)
    override val focusedElevation: Token<Dp> = Token(Dp.Unspecified)
    override val hoveredElevation: Token<Dp> = Token(Dp.Unspecified)
    override val disabledElevation: Token<Dp> = Token(Dp.Unspecified)
    override val contentElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val contentPadding: Token<PaddingValues> = TokenReference { Mobius.styles.buttonStyle.contentPadding }
    override val height: Token<Dp> = TokenReference { Mobius.styles.buttonStyle.height }
    override val border: Token<BorderStroke?> = Token(null)
    override val iconSize: Token<IconSize> = TokenReference { Mobius.styles.buttonStyle.iconSize }
    override val textStyle: Token<TextStyle> = TokenReference { Mobius.styles.buttonStyle.textStyle }
}

open class TextButtonStyle : ButtonStyle {
    override val shape: Token<Shape> = TokenReference { Mobius.styles.buttonStyle.shape }
    override val contentColor: Token<Color> = Token { Mobius.colors.primary }
    override val background: Token<Brush?> = Token(null)
    override val disabledContentColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledBackground: Token<Brush?> = Token(null)
    override val rippleColor: Token<Color> = Token { Mobius.colors.primary }
    override val defaultElevation: Token<Dp> = TokenReference { Mobius.styles.buttonStyle.defaultElevation }
    override val pressedElevation: Token<Dp> = TokenReference { Mobius.styles.buttonStyle.pressedElevation }
    override val focusedElevation: Token<Dp> = TokenReference { Mobius.styles.buttonStyle.focusedElevation }
    override val hoveredElevation: Token<Dp> = TokenReference { Mobius.styles.buttonStyle.hoveredElevation }
    override val disabledElevation: Token<Dp> = TokenReference { Mobius.styles.buttonStyle.disabledElevation }
    override val contentElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val contentPadding: Token<PaddingValues> = Token(
        PaddingValues(
            horizontal = MobiusReferenceDimensions.Dimension12,
            vertical = MobiusReferenceDimensions.Dimension8
        )
    )
    override val height: Token<Dp> = TokenReference { Mobius.styles.buttonStyle.height }
    override val border: Token<BorderStroke?> = Token(null)
    override val iconSize: Token<IconSize> = TokenReference { Mobius.styles.buttonStyle.iconSize }
    override val textStyle: Token<TextStyle> = TokenReference { Mobius.styles.buttonStyle.textStyle }
}
