package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.references.MobiusReferenceDimensions

interface InfoBoxPositionProviderStyleValues : StyleValues {
    val spaceFromContent: Dp
}

interface InfoBoxPositionProviderStyle : Style {
    val spaceFromContent: Token<Dp>
}

@Composable
fun InfoBoxPositionProviderStyle.resolve() = produceStyleValues { style ->
    object : InfoBoxPositionProviderStyleValues {
        override val spaceFromContent = style.spaceFromContent.resolve()
    }
}

open class DefaultInfoBoxPositionProviderStyle : InfoBoxPositionProviderStyle {
    override val spaceFromContent: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
}
