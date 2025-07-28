package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
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
