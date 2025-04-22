package com.gft.mobius.components.styles

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface LabelStyle : Style {
    val textStyle: Token<TextStyle>
    val spacing: Token<Dp>
}

open class DefaultLabelStyle : LabelStyle {
    override val textStyle: Token<TextStyle> = Token { Mobius.typography.bodyMedium }
    override val spacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension0)
}
