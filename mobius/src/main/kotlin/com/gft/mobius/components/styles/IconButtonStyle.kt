package com.gft.mobius.components.styles

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.references.MobiusReferenceDimensions

interface IconButtonStyleValues : StyleValues {
    val size: Dp
    val iconSize: IconSize
    val backgroundColor: Color
    val contentColor: Color
    val border: BorderStroke?
    val disabledBackgroundColor: Color
    val disabledContentColor: Color
    val disabledBorder: BorderStroke?
    val shape: Shape
}

interface IconButtonStyle : Style {
    val size: Token<Dp>
    val iconSize: Token<IconSize>
    val backgroundColor: Token<Color>
    val contentColor: Token<Color>
    val border: Token<BorderStroke?>
    val disabledBackgroundColor: Token<Color>
    val disabledContentColor: Token<Color>
    val disabledBorder: Token<BorderStroke?>
    val shape: Token<Shape>
}

@Composable
fun IconButtonStyle.resolve() = produceStyleValues { style ->
    object : IconButtonStyleValues {
        override val size = style.size.resolve()
        override val iconSize = style.iconSize.resolve()
        override val backgroundColor = style.backgroundColor.resolve()
        override val contentColor = style.contentColor.resolve()
        override val border = style.border.resolve()
        override val disabledBackgroundColor = style.disabledBackgroundColor.resolve()
        override val disabledContentColor = style.disabledContentColor.resolve()
        override val disabledBorder = style.disabledBorder.resolve()
        override val shape = style.shape.resolve()
    }
}

open class DefaultIconButtonStyle : IconButtonStyle {
    override val size: Token<Dp> = TokenReference { Mobius.styles.buttonStyle.height }
    override val iconSize: Token<IconSize> = Token { IconSize.Medium }
    override val backgroundColor: Token<Color> = Token(Color.Unspecified)
    override val contentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val border: Token<BorderStroke?> = Token(null)
    override val disabledBackgroundColor: Token<Color> = Token(Color.Unspecified)
    override val disabledContentColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledBorder: Token<BorderStroke?> = Token(null)
    override val shape: Token<Shape> = Token(CircleShape)
}

open class FilledIconButtonStyle : IconButtonStyle {
    override val size: Token<Dp> = TokenReference { Mobius.styles.buttonStyle.height }
    override val iconSize: Token<IconSize> = Token { IconSize.Medium }
    override val backgroundColor: Token<Color> = Token { Mobius.colors.primary }
    override val contentColor: Token<Color> = Token { Mobius.colors.onPrimary }
    override val border: Token<BorderStroke?> = Token(null)
    override val disabledBackgroundColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.12f) }
    override val disabledContentColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledBorder: Token<BorderStroke?> = Token(null)
    override val shape: Token<Shape> = Token(CircleShape)
}

open class FilledTonalIconButtonStyle : IconButtonStyle {
    override val size: Token<Dp> = TokenReference { Mobius.styles.buttonStyle.height }
    override val iconSize: Token<IconSize> = Token { IconSize.Medium }
    override val backgroundColor: Token<Color> = Token { Mobius.colors.secondaryContainer }
    override val contentColor: Token<Color> = Token { Mobius.colors.onSecondaryContainer }
    override val border: Token<BorderStroke?> = Token(null)
    override val disabledBackgroundColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.12f) }
    override val disabledContentColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledBorder: Token<BorderStroke?> = Token(null)
    override val shape: Token<Shape> = Token(CircleShape)
}

open class OutlinedIconButtonStyle : IconButtonStyle {
    override val size: Token<Dp> = TokenReference { Mobius.styles.buttonStyle.height }
    override val iconSize: Token<IconSize> = Token { IconSize.Medium }
    override val backgroundColor: Token<Color> = Token(Color.Transparent)
    override val contentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val border: Token<BorderStroke?> = Token { BorderStroke(MobiusReferenceDimensions.Dimension1, Mobius.colors.outline) }
    override val disabledBackgroundColor: Token<Color> = Token(Color.Transparent)
    override val disabledContentColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledBorder: Token<BorderStroke?> =
        Token { BorderStroke(MobiusReferenceDimensions.Dimension1, Mobius.colors.onSurface.copy(alpha = 0.12f)) }
    override val shape: Token<Shape> = Token(CircleShape)
}
