package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues

interface HeaderStyleValues : StyleValues {
    val background: Brush?
    val contentColor: Color
}

interface HeaderStyle : Style {
    val background: Token<Brush?>
    val contentColor: Token<Color>
}

@Composable
fun HeaderStyle.resolve() = produceStyleValues { style ->
    object : HeaderStyleValues {
        override val background: Brush? = style.background.resolve()
        override val contentColor: Color = style.contentColor.resolve()
    }
}

open class DefaultHeaderStyle : HeaderStyle {
    override val background: Token<Brush?> = Token(null)
    override val contentColor: Token<Color> = Token(Color.Unspecified)
}
