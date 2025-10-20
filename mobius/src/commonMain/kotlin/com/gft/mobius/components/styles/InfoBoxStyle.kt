package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.ShapeDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.GenerateStyleWrapper
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
@GenerateStyleWrapper
interface InfoBoxStyle : Style {
    val shape: Token<Shape>
    val containerColor: Token<Color>
    val contentColor: Token<Color>
    val titleContentColor: Token<Color>
    val buttonsContentColor: Token<Color>
    val tonalElevation: Token<Dp>
    val shadowElevation: Token<Dp>
    val pointerSize: Token<DpSize>
    val titleTextStyle: Token<TextStyle>
    val contentTextStyle: Token<TextStyle>
    val buttonsStyle: Token<ButtonStyle>
    val buttonsArrangement: Token<Arrangement.Horizontal>
}

open class DefaultInfoBoxStyle : InfoBoxStyle {
    override val shape: Token<Shape> = Token { ShapeDefaults.Medium }
    override val containerColor: Token<Color> = Token { Mobius.colors.surfaceContainer }
    override val contentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val titleContentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val buttonsContentColor: Token<Color> = Token { Color.Unspecified }
    override val tonalElevation: Token<Dp> = Token(0.dp)
    override val shadowElevation: Token<Dp> = Token(MobiusReferenceDimensions.Dimension2)
    override val pointerSize: Token<DpSize> = Token(DpSize.Unspecified)
    override val titleTextStyle: Token<TextStyle> = Token { Mobius.typography.titleSmall }
    override val contentTextStyle: Token<TextStyle> = Token { Mobius.typography.bodyMedium }
    override val buttonsStyle: Token<ButtonStyle> = Token { Mobius.styles.textButtonStyle }
    override val buttonsArrangement: Token<Arrangement.Horizontal> = Token(Arrangement.Start)
}
