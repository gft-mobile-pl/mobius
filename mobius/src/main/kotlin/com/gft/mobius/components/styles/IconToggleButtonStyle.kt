package com.gft.mobius.components.styles

import androidx.compose.foundation.BorderStroke
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius

interface IconToggleButtonStyleValues : IconButtonStyleValues {
    val selectedBackgroundColor: Color
    val selectedContentColor: Color
    val selectedBorder: BorderStroke?
}

interface IconToggleButtonStyle : IconButtonStyle {
    val selectedBackgroundColor: Token<Color>
    val selectedContentColor: Token<Color>
    val selectedBorder: Token<BorderStroke?>
}

@Composable
fun IconToggleButtonStyle.resolve() = produceStyleValues { style ->
    object : IconToggleButtonStyleValues {
        override val size = style.size.resolve()
        override val iconSize = style.iconSize.resolve()
        override val backgroundColor = style.backgroundColor.resolve()
        override val contentColor = style.contentColor.resolve()
        override val border = style.border.resolve()
        override val disabledBackgroundColor = style.disabledBackgroundColor.resolve()
        override val disabledContentColor = style.disabledContentColor.resolve()
        override val disabledBorder = style.disabledBorder.resolve()
        override val shape = style.shape.resolve()
        override val selectedBackgroundColor = style.selectedBackgroundColor.resolve()
        override val selectedContentColor = style.selectedContentColor.resolve()
        override val selectedBorder = style.selectedBorder.resolve()
    }
}

open class DefaultIconToggleButtonStyle : IconToggleButtonStyle {
    override val size = TokenReference { Mobius.styles.iconButtonStyle.size }
    override val iconSize = TokenReference { Mobius.styles.iconButtonStyle.iconSize }
    override val backgroundColor = Token(Color.Unspecified)
    override val contentColor = Token { Mobius.colors.onSurfaceVariant }
    override val border: Token<BorderStroke?> = Token(null)
    override val disabledBackgroundColor = TokenReference { Mobius.styles.iconButtonStyle.disabledBackgroundColor }
    override val disabledContentColor = TokenReference { Mobius.styles.iconButtonStyle.disabledContentColor }
    override val disabledBorder = TokenReference { Mobius.styles.iconButtonStyle.disabledBorder }
    override val shape = TokenReference { Mobius.styles.iconButtonStyle.shape }
    override val selectedBackgroundColor = TokenReference { Mobius.styles.iconButtonStyle.backgroundColor }
    override val selectedContentColor = Token { Mobius.colors.primary }
    override val selectedBorder: Token<BorderStroke?> = TokenReference { Mobius.styles.iconButtonStyle.border }
}

open class FilledIconToggleButtonStyle : IconToggleButtonStyle {
    override val size = TokenReference { Mobius.styles.filledIconButtonStyle.size }
    override val iconSize = TokenReference { Mobius.styles.filledIconButtonStyle.iconSize }
    override val backgroundColor = Token { Mobius.colors.surfaceContainerHighest }
    override val contentColor = Token { Mobius.colors.primary }
    override val border: Token<BorderStroke?> = Token(null)
    override val disabledBackgroundColor = TokenReference { Mobius.styles.filledIconButtonStyle.disabledBackgroundColor }
    override val disabledContentColor = TokenReference { Mobius.styles.filledIconButtonStyle.disabledContentColor }
    override val disabledBorder = TokenReference { Mobius.styles.filledIconButtonStyle.disabledBorder }
    override val shape = TokenReference { Mobius.styles.filledIconButtonStyle.shape }
    override val selectedBackgroundColor = TokenReference { Mobius.styles.filledIconButtonStyle.backgroundColor }
    override val selectedContentColor = TokenReference { Mobius.styles.filledIconButtonStyle.contentColor }
    override val selectedBorder = TokenReference { Mobius.styles.filledIconButtonStyle.border }
}

open class FilledTonalIconToggleButtonStyle : IconToggleButtonStyle {
    override val size = TokenReference { Mobius.styles.filledTonalIconButtonStyle.size }
    override val iconSize = TokenReference { Mobius.styles.filledTonalIconButtonStyle.iconSize }
    override val backgroundColor = Token { Mobius.colors.surfaceContainerHighest }
    override val contentColor = Token { Mobius.colors.onSecondaryContainer }
    override val border: Token<BorderStroke?> = Token(null)
    override val disabledBackgroundColor = TokenReference { Mobius.styles.filledTonalIconButtonStyle.disabledBackgroundColor }
    override val disabledContentColor = TokenReference { Mobius.styles.filledTonalIconButtonStyle.disabledContentColor }
    override val disabledBorder = TokenReference { Mobius.styles.filledTonalIconButtonStyle.disabledBorder }
    override val shape = TokenReference { Mobius.styles.filledTonalIconButtonStyle.shape }
    override val selectedBackgroundColor = TokenReference { Mobius.styles.filledTonalIconButtonStyle.backgroundColor }
    override val selectedContentColor = TokenReference { Mobius.styles.filledTonalIconButtonStyle.contentColor }
    override val selectedBorder = TokenReference { Mobius.styles.filledTonalIconButtonStyle.border }
}

open class OutlinedIconToggleButtonStyle : IconToggleButtonStyle {
    override val size = TokenReference { Mobius.styles.outlinedIconButtonStyle.size }
    override val iconSize = TokenReference { Mobius.styles.outlinedIconButtonStyle.iconSize }
    override val backgroundColor = TokenReference { Mobius.styles.outlinedIconButtonStyle.backgroundColor }
    override val contentColor = TokenReference { Mobius.styles.outlinedIconButtonStyle.contentColor }
    override val border = TokenReference { Mobius.styles.outlinedIconButtonStyle.border }
    override val disabledBackgroundColor = TokenReference { Mobius.styles.outlinedIconButtonStyle.disabledBackgroundColor }
    override val disabledContentColor = TokenReference { Mobius.styles.outlinedIconButtonStyle.disabledContentColor }
    override val disabledBorder = TokenReference { Mobius.styles.outlinedIconButtonStyle.disabledBorder }
    override val shape = TokenReference { Mobius.styles.outlinedIconButtonStyle.shape }
    override val selectedBackgroundColor = Token { Mobius.colors.inverseSurface }
    override val selectedContentColor = Token { Mobius.colors.inverseOnSurface }
    override val selectedBorder: Token<BorderStroke?> = Token(null)
}
