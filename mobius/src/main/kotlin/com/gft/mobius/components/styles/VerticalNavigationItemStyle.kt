package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
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

open class DefaultVerticalNavigationItemStyle : VerticalNavigationItemStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(50))
    override val backgroundColor: Token<Color> = Token(Color.Transparent)
    override val selectedBackgroundColor: Token<Color> = Token { Mobius.colors.secondaryContainer }
    override val iconColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val selectedIconColor: Token<Color> = Token { Mobius.colors.onSecondaryContainer }
    override val labelColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val selectedLabelColor: Token<Color> = Token { Mobius.colors.onSecondaryContainer }
    override val labelTextStyle: Token<TextStyle> = Token { Mobius.typography.bodyLarge }
    override val badgeColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val selectedBadgeColor: Token<Color> = Token { Mobius.colors.onSecondaryContainer }
    override val badgeTextStyle: Token<TextStyle> = Token { Mobius.typography.bodyLarge }
    override val padding: Token<PaddingValues> = Token(PaddingValues(horizontal = MobiusReferenceDimensions.Dimension12))
}
