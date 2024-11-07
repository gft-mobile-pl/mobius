package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.references.MobiusReferenceDimensions

interface DropdownMenuItemStyleValues : StyleValues {
    val padding: PaddingValues
    val textStyle: TextStyle
    val textColor: Color
    val disabledTextColor: Color
    val leadingIconSize: IconSize
    val leadingIconColor: Color
    val disabledLeadingIconColor: Color
    val trailingIconSize: IconSize
    val trailingIconColor: Color
    val disabledTrailingIconColor: Color
}

interface DropdownMenuItemStyle : Style {
    val padding: Token<PaddingValues>
    val textStyle: Token<TextStyle>
    val textColor: Token<Color>
    val disabledTextColor: Token<Color>
    val leadingIconSize: Token<IconSize>
    val leadingIconColor: Token<Color>
    val disabledLeadingIconColor: Token<Color>
    val trailingIconSize: Token<IconSize>
    val trailingIconColor: Token<Color>
    val disabledTrailingIconColor: Token<Color>
}

@Composable
fun DropdownMenuItemStyle.resolve() = produceStyleValues { style ->
    object : DropdownMenuItemStyleValues {
        override val padding = style.padding.resolve()
        override val textStyle = style.textStyle.resolve()
        override val textColor = style.textColor.resolve()
        override val disabledTextColor = style.disabledTextColor.resolve()
        override val leadingIconSize = style.leadingIconSize.resolve()
        override val leadingIconColor = style.leadingIconColor.resolve()
        override val disabledLeadingIconColor = style.disabledLeadingIconColor.resolve()
        override val trailingIconSize = style.trailingIconSize.resolve()
        override val trailingIconColor = style.trailingIconColor.resolve()
        override val disabledTrailingIconColor = style.disabledTrailingIconColor.resolve()
    }
}

open class DefaultDropdownMenuItemStyle : DropdownMenuItemStyle {
    override val padding: Token<PaddingValues> = Token(PaddingValues(horizontal = MobiusReferenceDimensions.Dimension12))
    override val textStyle: Token<TextStyle> = Token { Mobius.typography.bodyLarge }
    override val textColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val disabledTextColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val leadingIconSize: Token<IconSize> = Token { IconSize.Medium }
    override val leadingIconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledLeadingIconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant.copy(alpha = 0.38f) }
    override val trailingIconSize: Token<IconSize> = Token { IconSize.Medium }
    override val trailingIconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledTrailingIconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant.copy(alpha = 0.38f) }
}
