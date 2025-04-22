package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.codegen.annotation.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
interface ScrollableTabRowStyle : TabRowStyle {
    val edgePadding: Token<Dp>
}

open class PrimaryScrollableTabRowStyle : ScrollableTabRowStyle {
    override val containerColor: Token<Color> = TokenReference { Mobius.styles.primaryTabRow.containerColor }
    override val indicatorStyle: Token<TabIndicatorStyle> = TokenReference { Mobius.styles.primaryTabRow.indicatorStyle }
    override val dividerStyle: Token<HorizontalDividerStyle> = TokenReference { Mobius.styles.primaryTabRow.dividerStyle }
    override val edgePadding: Token<Dp> = Token(MobiusReferenceDimensions.Dimension48)
}

open class SecondaryScrollableTabRowStyle : ScrollableTabRowStyle {
    override val containerColor: Token<Color> = TokenReference { Mobius.styles.secondaryTabRow.containerColor }
    override val indicatorStyle: Token<TabIndicatorStyle> = TokenReference { Mobius.styles.secondaryTabRow.indicatorStyle }
    override val dividerStyle: Token<HorizontalDividerStyle> = TokenReference { Mobius.styles.secondaryTabRow.dividerStyle }
    override val edgePadding: Token<Dp> = TokenReference { Mobius.styles.primaryScrollableTabRow.edgePadding }
}
