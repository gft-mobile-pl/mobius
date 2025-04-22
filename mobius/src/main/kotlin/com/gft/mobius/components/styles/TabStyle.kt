package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius

@GenerateStyleValues
interface TabStyle : Style {
    val selectedContentColor: Token<Color>
    val unselectedContentColor: Token<Color>
    val textStyle: Token<TextStyle>
}

open class DefaultTabStyle : TabStyle {
    override val selectedContentColor: Token<Color> = Token { Mobius.colors.primary }
    override val unselectedContentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val textStyle: Token<TextStyle> = Token { Mobius.typography.titleSmall }
}
