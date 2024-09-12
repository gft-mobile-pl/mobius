package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.colors.contentColorFor
import com.gft.mobius.components.FabPosition

interface ScaffoldStyleValues : StyleValues {
    val containerColor: Color
    val contentColor: Color
    val floatingActionButtonPosition: FabPosition
}

interface ScaffoldStyle : Style {
    val containerColor: Token<Color>
    val contentColor: Token<Color>
    val floatingActionButtonPosition: Token<FabPosition>
}

@Composable
fun ScaffoldStyle.resolve() = produceStyleValues { style ->
    object : ScaffoldStyleValues {
        override val containerColor = style.containerColor.resolve()
        override val contentColor = style.contentColor.resolve()
        override val floatingActionButtonPosition = style.floatingActionButtonPosition.resolve()
    }
}

open class DefaultScaffoldStyle : ScaffoldStyle {
    override val containerColor = Token { Mobius.colors.background }
    override val contentColor = Token { contentColorFor(Mobius.colors.background ) }
    override val floatingActionButtonPosition = Token { FabPosition.End }
}
