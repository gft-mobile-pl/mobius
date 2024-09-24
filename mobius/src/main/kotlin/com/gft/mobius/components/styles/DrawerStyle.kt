package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.DrawerStyle.Placement
import com.gft.mobius.components.styles.DrawerStyle.Placement.Modal
import com.gft.mobius.components.styles.DrawerStyle.Placement.Slide
import com.gft.mobius.references.MobiusReferenceDimensions

interface DrawerStyleValues : StyleValues {
    val placement: Placement
    val padding: PaddingValues
}

interface DrawerStyle : Style {
    val placement: Token<Placement>
    val padding: Token<PaddingValues>

    sealed interface Placement {
        data class Modal(val dimColor: Color) : Placement
        data object Slide : Placement
    }
}

@Composable
fun DrawerStyle.resolve() = produceStyleValues { style ->
    object : DrawerStyleValues {
        override val placement = style.placement.resolve()
        override val padding: PaddingValues = style.padding.resolve()
    }
}

open class ModalDrawerStyle : DrawerStyle {
    override val placement: Token<Placement> = Token { Modal(Mobius.colors.scrim.copy(alpha = 0.32f)) }
    override val padding = Token(PaddingValues(end = MobiusReferenceDimensions.Dimension48))
}

open class SlidingDrawerStyle : DrawerStyle {
    override val placement: Token<Placement> = Token(Slide)
    override val padding = Token(PaddingValues(MobiusReferenceDimensions.Dimension0))
}
