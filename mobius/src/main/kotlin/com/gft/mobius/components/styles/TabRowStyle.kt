package com.gft.mobius.components.styles

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.codegen.annotation.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface TabRowStyle : Style {
    val containerColor: Token<Color>
    val indicatorStyle: Token<TabIndicatorStyle>
    val dividerStyle: Token<HorizontalDividerStyle>
}

open class PrimaryTabRowStyle : TabRowStyle {
    override val containerColor: Token<Color> = Token { Mobius.colors.surface }
    override val indicatorStyle: Token<TabIndicatorStyle> = Token {
        object : TabIndicatorStyle {
            override val color: Token<Color> = Token { Mobius.colors.primary }
            override val width: Token<TabIndicatorWidth> = Token(TabIndicatorWidth.MatchContent)
            override val height: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
            override val shape: Token<Shape> = Token(RoundedCornerShape(3.0.dp))
        }
    }
    override val dividerStyle: Token<HorizontalDividerStyle> = Token { Mobius.styles.horizontalDivider }
}

open class SecondaryTabRowStyle : TabRowStyle {
    override val containerColor: Token<Color> = TokenReference { Mobius.styles.primaryTabRow.containerColor }
    override val indicatorStyle: Token<TabIndicatorStyle> = Token {
        object : TabIndicatorStyle {
            override val color: Token<Color> = Token { Mobius.colors.primary }
            override val width: Token<TabIndicatorWidth> = Token(TabIndicatorWidth.MatchTab)
            override val height: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
            override val shape: Token<Shape> = Token(RectangleShape)
        }
    }
    override val dividerStyle: Token<HorizontalDividerStyle> = TokenReference { Mobius.styles.primaryTabRow.dividerStyle }
}
