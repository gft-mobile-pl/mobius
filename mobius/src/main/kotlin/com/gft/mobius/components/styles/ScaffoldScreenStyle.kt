package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.FabPosition

interface ScaffoldScreenStyleValues : StyleValues {
    val background: Color
    val contentColor: Color
    val floatingActionButtonPosition: FabPosition
}

interface ScaffoldScreenStyle : Style {
    val background: Token<Color>
    val contentColor: Token<Color>
    val floatingActionButtonPosition: Token<FabPosition>
}

@Composable
fun ScaffoldScreenStyle.resolve() = produceStyleValues { style ->
    object : ScaffoldScreenStyleValues {
        override val background = style.background.resolve()
        override val contentColor = style.contentColor.resolve()
        override val floatingActionButtonPosition = style.floatingActionButtonPosition.resolve()
    }
}

open class DefaultScaffoldScreenStyle : ScaffoldScreenStyle {
    override val background: Token<Color> = Token { Mobius.colors.background }
    override val contentColor: Token<Color> = Token { Mobius.colors.onBackground }
    override val floatingActionButtonPosition: Token<FabPosition> = Token { FabPosition.End }
}
