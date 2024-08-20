package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.references.MobiusReferenceDimensions

interface GroupStyleValues : StyleValues {
    val padding: PaddingValues
    val background: Brush?
    val shape: Shape?
    val contentColor: Color
    val horizontalAlignment: Alignment.Horizontal
}

interface GroupStyle : Style {
    val padding: Token<PaddingValues>
    val background: Token<Brush?>
    val shape: Token<Shape?>
    val contentColor: Token<Color>
    val horizontalAlignment: Token<Alignment.Horizontal>
}

@Composable
fun GroupStyle.resolve() = produceStyleValues { style ->
    object : GroupStyleValues {
        override val padding = style.padding.resolve()
        override val background = style.background.resolve()
        override val shape = style.shape.resolve()
        override val contentColor = style.contentColor.resolve()
        override val horizontalAlignment = style.horizontalAlignment.resolve()
    }
}

open class DefaultGroupStyle : GroupStyle {
    override val padding: Token<PaddingValues> = Token(
        PaddingValues(
            start = MobiusReferenceDimensions.Dimension16,
            end = MobiusReferenceDimensions.Dimension16,
            top = MobiusReferenceDimensions.Dimension16,
            bottom = MobiusReferenceDimensions.Dimension16,
        )
    )
    override val background: Token<Brush?> = Token(null)
    override val shape: Token<Shape?> = Token(null)
    override val contentColor: Token<Color> = Token(Color.Unspecified)
    override val horizontalAlignment: Token<Alignment.Horizontal> = Token(Alignment.Start)
}
