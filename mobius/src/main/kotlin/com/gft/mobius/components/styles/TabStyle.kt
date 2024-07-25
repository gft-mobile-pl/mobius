package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius

interface TabStyleValues : StyleValues {
    val selectedContentColor: Color
    val unselectedContentColor: Color
    val textStyle: TextStyle
}

interface TabStyle : Style {
    val selectedContentColor: Token<Color>
    val unselectedContentColor: Token<Color>
    val textStyle: Token<TextStyle>
}

@Composable
fun TabStyle.resolve() = produceStyleValues { style ->
    object : TabStyleValues {
        override val selectedContentColor: Color = style.selectedContentColor.resolve()
        override val unselectedContentColor: Color = style.unselectedContentColor.resolve()
        override val textStyle: TextStyle = style.textStyle.resolve()
    }
}

open class DefaultTabStyle : TabStyle {
    override val selectedContentColor: Token<Color> = Token { Mobius.colors.primary }
    override val unselectedContentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val textStyle: Token<TextStyle> = Token { Mobius.typography.titleSmall }
}
