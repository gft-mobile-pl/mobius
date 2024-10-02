package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

interface VerticalNavigationStyleValues : ContentStyleValues {
    val shape: Shape
}

interface VerticalNavigationStyle : ContentStyle {
    val shape: Token<Shape>
}

@Composable
fun VerticalNavigationStyle.resolve() = produceStyleValues { style ->
    object : VerticalNavigationStyleValues {
        override val padding = style.padding.resolve()
        override val background = style.background.resolve()
        override val contentColor = style.contentColor.resolve()
        override val contentAlignment = style.contentAlignment.resolve()
        override val smallVerticalElementsSpacing = style.smallVerticalElementsSpacing.resolve()
        override val mediumVerticalElementsSpacing = style.mediumVerticalElementsSpacing.resolve()
        override val largeVerticalElementsSpacing = style.largeVerticalElementsSpacing.resolve()
        override val smallHorizontalElementsSpacing = style.smallHorizontalElementsSpacing.resolve()
        override val mediumHorizontalElementsSpacing = style.mediumHorizontalElementsSpacing.resolve()
        override val largeHorizontalElementsSpacing = style.largeHorizontalElementsSpacing.resolve()
        override val shape = style.shape.resolve()
    }
}

open class DefaultVerticalNavigationStyle : VerticalNavigationStyle {
    override val padding = Token(PaddingValues(MobiusReferenceDimensions.Dimension0))
    override val background: Token<Brush?> = Token { SolidColor(Mobius.colors.surfaceContainerLow) }
    override val contentColor = Token { Mobius.colors.onSurface }
    override val contentAlignment = Token(Alignment.TopStart)
    override val smallVerticalElementsSpacing = TokenReference { Mobius.styles.scrollableContentStyle.smallVerticalElementsSpacing }
    override val mediumVerticalElementsSpacing = TokenReference { Mobius.styles.scrollableContentStyle.mediumVerticalElementsSpacing }
    override val largeVerticalElementsSpacing = TokenReference { Mobius.styles.scrollableContentStyle.largeVerticalElementsSpacing }
    override val smallHorizontalElementsSpacing = TokenReference { Mobius.styles.scrollableContentStyle.smallHorizontalElementsSpacing }
    override val mediumHorizontalElementsSpacing = TokenReference { Mobius.styles.scrollableContentStyle.mediumHorizontalElementsSpacing }
    override val largeHorizontalElementsSpacing = TokenReference { Mobius.styles.scrollableContentStyle.largeHorizontalElementsSpacing }
    override val shape: Token<Shape> = Token(
        RoundedCornerShape(
            topEnd = MobiusReferenceDimensions.Dimension16,
            bottomEnd = MobiusReferenceDimensions.Dimension16
        )
    )
}
