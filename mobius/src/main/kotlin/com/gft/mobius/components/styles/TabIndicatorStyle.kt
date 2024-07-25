package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues


sealed interface TabIndicatorWidth {
    data object MatchTab : TabIndicatorWidth
    data object MatchContent : TabIndicatorWidth
    data class Fixed(val width: Dp) : TabIndicatorWidth
}

interface TabIndicatorStyleValues : StyleValues {
    val color: Color
    val width: TabIndicatorWidth
    val height: Dp
    val shape: Shape
}

interface TabIndicatorStyle : Style {
    val color: Token<Color>
    val width: Token<TabIndicatorWidth>
    val height: Token<Dp>
    val shape: Token<Shape>
}

@Composable
fun TabIndicatorStyle.resolve() = produceStyleValues { style ->
    object : TabIndicatorStyleValues {
        override val color: Color = style.color.resolve()
        override val width: TabIndicatorWidth = style.width.resolve()
        override val height: Dp = style.height.resolve()
        override val shape: Shape = style.shape.resolve()
    }
}
