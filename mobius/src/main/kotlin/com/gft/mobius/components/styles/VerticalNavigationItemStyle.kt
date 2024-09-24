package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

interface VerticalNavigationItemStyleValues : StyleValues {
    val shape: Shape
    val backgroundColor: Color
    val selectedBackgroundColor: Color
    val iconColor: Color
    val selectedIconColor: Color
    val labelColor: Color
    val selectedLabelColor: Color
    val labelTextStyle: TextStyle
    val badgeColor: Color
    val selectedBadgeColor: Color
    val badgeTextStyle: TextStyle
    val padding: PaddingValues
}

interface VerticalNavigationItemStyle : Style {
    val shape: Token<Shape>
    val backgroundColor: Token<Color>
    val selectedBackgroundColor: Token<Color>
    val iconColor: Token<Color>
    val selectedIconColor: Token<Color>
    val labelColor: Token<Color>
    val selectedLabelColor: Token<Color>
    val labelTextStyle: Token<TextStyle>
    val badgeColor: Token<Color>
    val selectedBadgeColor: Token<Color>
    val badgeTextStyle: Token<TextStyle>
    val padding: Token<PaddingValues>
}

@Composable
fun VerticalNavigationItemStyle.resolve() = produceStyleValues { style ->
    object : VerticalNavigationItemStyleValues {
        override val shape = style.shape.resolve()
        override val backgroundColor = style.backgroundColor.resolve()
        override val selectedBackgroundColor = style.selectedBackgroundColor.resolve()
        override val iconColor = style.iconColor.resolve()
        override val selectedIconColor = style.selectedIconColor.resolve()
        override val labelColor = style.labelColor.resolve()
        override val selectedLabelColor = style.selectedLabelColor.resolve()
        override val labelTextStyle = style.labelTextStyle.resolve()
        override val badgeColor = style.badgeColor.resolve()
        override val selectedBadgeColor = style.selectedBadgeColor.resolve()
        override val badgeTextStyle = style.badgeTextStyle.resolve()
        override val padding = style.padding.resolve()
    }
}

open class DefaultVerticalNavigationItemStyle : VerticalNavigationItemStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(50))
    override val backgroundColor = Token(Color.Transparent)
    override val selectedBackgroundColor = Token { Mobius.colors.secondaryContainer }
    override val iconColor = Token { Mobius.colors.onSurfaceVariant }
    override val selectedIconColor = Token { Mobius.colors.onSecondaryContainer }
    override val labelColor = Token { Mobius.colors.onSurfaceVariant }
    override val selectedLabelColor = Token { Mobius.colors.onSecondaryContainer }
    override val labelTextStyle = Token { Mobius.typography.bodyLarge }
    override val badgeColor = Token { Mobius.colors.onSurfaceVariant }
    override val selectedBadgeColor = Token { Mobius.colors.onSecondaryContainer }
    override val badgeTextStyle = Token { Mobius.typography.bodyLarge }
    override val padding = Token(PaddingValues(horizontal = MobiusReferenceDimensions.Dimension12))
}
