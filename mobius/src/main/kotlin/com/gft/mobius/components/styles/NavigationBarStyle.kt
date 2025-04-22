package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions
import com.gft.mobius.references.MobiusReferenceElevations

@GenerateStyleValues
interface NavigationBarStyle : Style {
    val backgroundColor: Token<Color>
    val contentColor: Token<Color>
    val tonalElevation: Token<Dp>
    val shape: Token<Shape?>
    val padding: Token<PaddingValues>
}

open class DefaultNavigationBarStyle : NavigationBarStyle {
    override val backgroundColor: Token<Color> = Token { Mobius.colors.surfaceContainer }
    override val contentColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val tonalElevation: Token<Dp> = Token { MobiusReferenceElevations.Level0 }
    override val shape: Token<Shape?> = Token(RectangleShape)
    override val padding: Token<PaddingValues> = Token(PaddingValues(MobiusReferenceDimensions.Dimension0))
}
