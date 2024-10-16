package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

interface LabelStyleValues : StyleValues {
    val textStyle: TextStyle
    val spacing: Dp
}

interface LabelStyle : Style {
    val textStyle: Token<TextStyle>
    val spacing: Token<Dp>
}

@Composable
fun LabelStyle.resolve() = produceStyleValues { style ->
    object : LabelStyleValues {
        override val textStyle = style.textStyle.resolve()
        override val spacing = style.spacing.resolve()
    }
}

open class DefaultLabelStyle : LabelStyle {
    override val textStyle = Token { Mobius.typography.bodyMedium }
    override val spacing = Token(MobiusReferenceDimensions.Dimension0)
}
