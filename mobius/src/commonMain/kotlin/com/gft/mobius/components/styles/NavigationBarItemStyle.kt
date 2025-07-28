package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.NavigationBarItemStyle.LabelVisibility
import com.gft.mobius.components.styles.NavigationBarItemStyle.LabelVisibility.Always

@GenerateStyleValues
interface NavigationBarItemStyle : Style {
    val textStyle: Token<TextStyle>
    val selectedIconColor: Token<Color>
    val selectedTextColor: Token<Color>
    val indicatorColor: Token<Color>
    val unselectedIconColor: Token<Color>
    val unselectedTextColor: Token<Color>
    val disabledIconColor: Token<Color>
    val disabledTextColor: Token<Color>
    val labelVisibility: Token<LabelVisibility>

    enum class LabelVisibility {
        Always, WhenSelected
    }
}

open class DefaultNavigationBarItemStyle : NavigationBarItemStyle {
    override val textStyle: Token<TextStyle> = Token { Mobius.typography.labelMedium }
    override val selectedIconColor: Token<Color> = Token { Mobius.colors.onSecondaryContainer }
    override val selectedTextColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val indicatorColor: Token<Color> = Token { Mobius.colors.secondaryContainer }
    override val unselectedIconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val unselectedTextColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledIconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant.copy(alpha = 0.38f) }
    override val disabledTextColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant.copy(alpha = 0.38f) }
    override val labelVisibility: Token<LabelVisibility> = Token(Always)
}
