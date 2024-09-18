package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.NavigationBarItemStyle.LabelVisibility
import com.gft.mobius.components.styles.NavigationBarItemStyle.LabelVisibility.Always

interface NavigationBarItemStyleValues : StyleValues {
    val textStyle: TextStyle
    val selectedIconColor: Color
    val selectedTextColor: Color
    val indicatorColor: Color
    val iconColor: Color
    val textColor: Color
    val disabledIconColor: Color
    val disabledTextColor: Color
    val labelVisibility: LabelVisibility
}

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

@Composable
fun NavigationBarItemStyle.resolve() = produceStyleValues { style ->
    object : NavigationBarItemStyleValues {
        override val textStyle = style.textStyle.resolve()
        override val selectedIconColor = style.selectedIconColor.resolve()
        override val selectedTextColor = style.selectedTextColor.resolve()
        override val indicatorColor = style.indicatorColor.resolve()
        override val iconColor = style.unselectedIconColor.resolve()
        override val textColor = style.unselectedTextColor.resolve()
        override val disabledIconColor = style.disabledIconColor.resolve()
        override val disabledTextColor = style.disabledTextColor.resolve()
        override val labelVisibility = style.labelVisibility.resolve()
    }
}

open class DefaultNavigationBarItemStyle : NavigationBarItemStyle {
    override val textStyle = Token { Mobius.typography.labelMedium }
    override val selectedIconColor = Token { Mobius.colors.onSecondaryContainer }
    override val selectedTextColor = Token { Mobius.colors.onSurface }
    override val indicatorColor = Token { Mobius.colors.secondaryContainer }
    override val unselectedIconColor = Token { Mobius.colors.onSurfaceVariant }
    override val unselectedTextColor = Token { Mobius.colors.onSurfaceVariant }
    override val disabledIconColor = Token { Mobius.colors.onSurfaceVariant.copy(alpha = 0.38f) }
    override val disabledTextColor = Token { Mobius.colors.onSurfaceVariant.copy(alpha = 0.38f) }
    override val labelVisibility = Token(Always)
}
