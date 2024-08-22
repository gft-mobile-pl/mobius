package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.ShapeDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

interface InfoBoxStyleValues : StyleValues {
    val shape: CornerBasedShape
    val containerColor: Color
    val contentColor: Color
    val titleContentColor: Color
    val buttonsContentColor: Color
    val tonalElevation: Dp
    val shadowElevation: Dp
    val pointerSize: DpSize
    val titleTextStyle: TextStyle
    val contentTextStyle: TextStyle
    val buttonsStyle: ButtonStyle
    val buttonsArrangement: Arrangement.Horizontal
}

interface InfoBoxStyle : Style {
    val shape: Token<CornerBasedShape>
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

@Composable
fun InfoBoxStyle.resolve() = produceStyleValues { style ->
    object : InfoBoxStyleValues {
        override val shape = style.shape.resolve()
        override val containerColor = style.containerColor.resolve()
        override val contentColor = style.contentColor.resolve()
        override val titleContentColor = style.titleContentColor.resolve()
        override val buttonsContentColor = style.buttonsContentColor.resolve()
        override val tonalElevation = style.tonalElevation.resolve()
        override val shadowElevation = style.shadowElevation.resolve()
        override val pointerSize = style.pointerSize.resolve()
        override val titleTextStyle = style.titleTextStyle.resolve()
        override val contentTextStyle = style.contentTextStyle.resolve()
        override val buttonsStyle = style.buttonsStyle.resolve()
        override val buttonsArrangement = style.buttonsArrangement.resolve()
    }
}

open class DefaultInfoBoxStyle : InfoBoxStyle {
    override val shape = Token { ShapeDefaults.Medium }
    override val containerColor = Token { Mobius.colors.surfaceContainer }
    override val contentColor = Token { Mobius.colors.onSurfaceVariant }
    override val titleContentColor = Token { Mobius.colors.onSurfaceVariant }
    override val buttonsContentColor = Token { Color.Unspecified }
    override val tonalElevation = Token(0.dp)
    override val shadowElevation = Token(MobiusReferenceDimensions.Dimension2)
    override val pointerSize = Token(DpSize.Unspecified)
    override val titleTextStyle = Token { Mobius.typography.titleSmall }
    override val contentTextStyle = Token { Mobius.typography.bodyMedium }
    override val buttonsStyle = Token { Mobius.styles.textButtonStyle }
    override val buttonsArrangement = Token(Arrangement.Start)
}
