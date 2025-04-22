package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.codegen.annotation.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.components.styles.NavigationRailItemStyle.LabelVisibility
import com.gft.mobius.components.styles.NavigationRailItemStyle.LabelVisibility.Always

@GenerateStyleValues
interface NavigationRailItemStyle : Style {
    val labelTextStyle: Token<TextStyle>
    val labelVisibility: Token<LabelVisibility>
    val iconSize: Token<IconSize>
    val indicatorColor: Token<Color>
    val labelColor: Token<Color>
    val iconColor: Token<Color>
    val selectedLabelColor: Token<Color>
    val selectedIconColor: Token<Color>
    val disabledLabelColor: Token<Color>
    val disabledIconColor: Token<Color>

    enum class LabelVisibility {
        Always, WhenSelected
    }
}

open class DefaultNavigationRailItemStyle : NavigationRailItemStyle {
    override val labelTextStyle: Token<TextStyle> = Token { Mobius.typography.labelMedium }
    override val labelVisibility: Token<LabelVisibility> = Token(Always)
    override val iconSize: Token<IconSize> = Token { IconSize.Medium }
    override val indicatorColor: Token<Color> = Token { Mobius.colors.secondaryContainer }
    override val labelColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val iconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val selectedLabelColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val selectedIconColor: Token<Color> = Token { Mobius.colors.onSecondaryContainer }
    override val disabledLabelColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant.copy(alpha = 0.38f) }
    override val disabledIconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant.copy(alpha = 0.38f) }
}
