package com.gft.mobius.components.styles

import androidx.compose.ui.unit.Dp
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface InfoBoxPositionProviderStyle : Style {
    val spaceFromContent: Token<Dp>
}

open class DefaultInfoBoxPositionProviderStyle : InfoBoxPositionProviderStyle {
    override val spaceFromContent: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
}
