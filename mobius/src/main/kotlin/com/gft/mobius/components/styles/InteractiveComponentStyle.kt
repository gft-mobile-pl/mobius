package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.references.MobiusReferenceDimensions

interface InteractiveComponentStyleValues : StyleValues {
    val minimumSize: Dp
}

interface InteractiveComponentStyle : Style {
    val minimumSize: Token<Dp>
}

@Composable
fun InteractiveComponentStyle.resolve() = produceStyleValues { style ->
    object : InteractiveComponentStyleValues {
        override val minimumSize = style.minimumSize.resolve()
    }
}

open class DefaultInteractiveComponentStyle : InteractiveComponentStyle {
    override val minimumSize: Token<Dp> = Token(MobiusReferenceDimensions.Dimension40)
}
