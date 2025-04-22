package com.gft.mobius.components.styles

import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.codegen.annotation.GenerateStyleValues
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface InteractiveComponentStyle : Style {
    val minimumSize: Token<Dp>
}

open class DefaultInteractiveComponentStyle : InteractiveComponentStyle {
    override val minimumSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension40)
}
