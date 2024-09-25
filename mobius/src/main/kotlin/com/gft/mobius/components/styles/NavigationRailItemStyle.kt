package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.components.styles.NavigationRailItemStyle.LabelVisibility
import com.gft.mobius.components.styles.NavigationRailItemStyle.LabelVisibility.Always

interface NavigationRailItemStyleValues : StyleValues {
    val labelTextStyle: TextStyle
    val labelVisibility: LabelVisibility
    val iconSize: IconSize
    val indicatorColor: Color
    val labelColor: Color
    val iconColor: Color
    val selectedLabelColor: Color
    val selectedIconColor: Color
    val disabledLabelColor: Color
    val disabledIconColor: Color
}

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

@Composable
fun NavigationRailItemStyle.resolve() = produceStyleValues { style ->
    object : NavigationRailItemStyleValues {
        override val labelTextStyle = style.labelTextStyle.resolve()
        override val labelVisibility = style.labelVisibility.resolve()
        override val iconSize = style.iconSize.resolve()
        override val indicatorColor = style.indicatorColor.resolve()
        override val labelColor = style.labelColor.resolve()
        override val iconColor = style.iconColor.resolve()
        override val selectedLabelColor = style.selectedLabelColor.resolve()
        override val selectedIconColor = style.selectedIconColor.resolve()
        override val disabledLabelColor = style.disabledLabelColor.resolve()
        override val disabledIconColor = style.disabledIconColor.resolve()
    }
}

open class DefaultNavigationRailItemStyle : NavigationRailItemStyle {
    override val labelTextStyle = Token { Mobius.typography.labelMedium }
    override val labelVisibility = Token(Always)
    override val iconSize = Token { IconSize.Medium }
    override val indicatorColor = Token { Mobius.colors.secondaryContainer }
    override val labelColor = Token { Mobius.colors.onSurfaceVariant }
    override val iconColor = Token { Mobius.colors.onSurfaceVariant }
    override val selectedLabelColor = Token { Mobius.colors.onSurface }
    override val selectedIconColor = Token { Mobius.colors.onSecondaryContainer }
    override val disabledLabelColor = Token { Mobius.colors.onSurfaceVariant.copy(alpha = 0.38f) }
    override val disabledIconColor = Token { Mobius.colors.onSurfaceVariant.copy(alpha = 0.38f) }
}
