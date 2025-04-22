package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface NavigationRailStyle : Style {
    val shape: Token<Shape?>
    val backgroundColor: Token<Color>
    val contentColor: Token<Color>
    val padding: Token<PaddingValues>
    val arrangement: Token<Arrangement.Vertical>
}

open class DefaultNavigationRailStyle : NavigationRailStyle {
    override val shape: Token<Shape?> = Token(null)
    override val backgroundColor: Token<Color> = Token { Mobius.colors.surface }
    override val contentColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val padding: Token<PaddingValues> = Token(PaddingValues(MobiusReferenceDimensions.Dimension8))
    override val arrangement: Token<Arrangement.Vertical> = Token(Arrangement.Top)
}
