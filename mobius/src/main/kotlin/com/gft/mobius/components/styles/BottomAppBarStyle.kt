package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions
import com.gft.mobius.references.MobiusReferenceElevations

interface BottomAppBarStyleValues : StyleValues {
    val padding: PaddingValues
    val backgroundColor: Color
    val contentColor: Color
    val tonalElevation: Dp
}

interface BottomAppBarStyle : Style {
    val padding: Token<PaddingValues>
    val backgroundColor: Token<Color>
    val contentColor: Token<Color>
    val tonalElevation: Token<Dp>
}

@Composable
fun BottomAppBarStyle.resolve() = produceStyleValues { style ->
    object : BottomAppBarStyleValues {
        override val padding = style.padding.resolve()
        override val backgroundColor = style.backgroundColor.resolve()
        override val contentColor = style.contentColor.resolve()
        override val tonalElevation = style.tonalElevation.resolve()
    }
}

open class DefaultBottomAppBarStyle : BottomAppBarStyle {
    override val padding: Token<PaddingValues> = Token {
        PaddingValues(
            start = MobiusReferenceDimensions.Dimension8,
            top = MobiusReferenceDimensions.Dimension12,
            end = MobiusReferenceDimensions.Dimension16,
            bottom = MobiusReferenceDimensions.Dimension12
        )
    }
    override val backgroundColor: Token<Color> = Token { Mobius.colors.surfaceContainer }
    override val contentColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val tonalElevation: Token<Dp> = Token { MobiusReferenceElevations.Level2 }
}
