package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.GenerateStyleValues

sealed interface TabIndicatorWidth {
    data object MatchTab : TabIndicatorWidth
    data object MatchContent : TabIndicatorWidth
    data class Fixed(val width: Dp) : TabIndicatorWidth
}

@GenerateStyleValues
interface TabIndicatorStyle : Style {
    val color: Token<Color>
    val width: Token<TabIndicatorWidth>
    val height: Token<Dp>
    val shape: Token<Shape>
}
