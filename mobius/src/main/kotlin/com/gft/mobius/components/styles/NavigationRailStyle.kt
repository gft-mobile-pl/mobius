package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

interface NavigationRailStyleValues : StyleValues {
    val shape: Shape?
    val backgroundColor: Color
    val contentColor: Color
    val padding: PaddingValues
    val arrangement: Arrangement.Vertical
}

interface NavigationRailStyle : Style {
    val shape: Token<Shape?>
    val backgroundColor: Token<Color>
    val contentColor: Token<Color>
    val padding: Token<PaddingValues>
    val arrangement: Token<Arrangement.Vertical>
}

@Composable
fun NavigationRailStyle.resolve() = produceStyleValues { style ->
    object : NavigationRailStyleValues {
        override val shape: Shape? = style.shape.resolve()
        override val backgroundColor = style.backgroundColor.resolve()
        override val contentColor = style.contentColor.resolve()
        override val padding = style.padding.resolve()
        override val arrangement = style.arrangement.resolve()
    }
}

open class DefaultNavigationRailStyle : NavigationRailStyle {
    override val shape: Token<Shape?> = Token(null)
    override val backgroundColor = Token { Mobius.colors.surface }
    override val contentColor = Token { Mobius.colors.onSurface }
    override val padding = Token(PaddingValues(MobiusReferenceDimensions.Dimension8))
    override val arrangement = Token(Arrangement.Top)
}
