package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.references.MobiusReferenceDimensions

interface ContentStyleValues : StyleValues {
    val padding: PaddingValues
    val contentAlignment: Alignment
    val smallVerticalElementsSpacing: Dp
    val mediumVerticalElementsSpacing: Dp
    val largeVerticalElementsSpacing: Dp
    val smallHorizontalElementsSpacing: Dp
    val mediumHorizontalElementsSpacing: Dp
    val largeHorizontalElementsSpacing: Dp
}

interface ContentStyle : Style {
    val padding: Token<PaddingValues>
    val contentAlignment: Token<Alignment>
    val smallVerticalElementsSpacing: Token<Dp>
    val mediumVerticalElementsSpacing: Token<Dp>
    val largeVerticalElementsSpacing: Token<Dp>
    val smallHorizontalElementsSpacing: Token<Dp>
    val mediumHorizontalElementsSpacing: Token<Dp>
    val largeHorizontalElementsSpacing: Token<Dp>
}

@Composable
fun ContentStyle.resolve() = produceStyleValues { style ->
    object : ContentStyleValues {
        override val padding = style.padding.resolve()
        override val contentAlignment = style.contentAlignment.resolve()
        override val smallVerticalElementsSpacing = style.smallVerticalElementsSpacing.resolve()
        override val mediumVerticalElementsSpacing = style.mediumVerticalElementsSpacing.resolve()
        override val largeVerticalElementsSpacing = style.largeVerticalElementsSpacing.resolve()
        override val smallHorizontalElementsSpacing = style.smallHorizontalElementsSpacing.resolve()
        override val mediumHorizontalElementsSpacing = style.mediumHorizontalElementsSpacing.resolve()
        override val largeHorizontalElementsSpacing = style.largeHorizontalElementsSpacing.resolve()
    }
}

open class DefaultScrollableContentStyle : ContentStyle {
    override val padding: Token<PaddingValues> = Token(
        PaddingValues(
            start = MobiusReferenceDimensions.Dimension16,
            end = MobiusReferenceDimensions.Dimension16,
            top = MobiusReferenceDimensions.Dimension16,
            bottom = MobiusReferenceDimensions.Dimension16,
        )
    )
    override val contentAlignment: Token<Alignment> = Token(Alignment.TopStart)
    override val smallVerticalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension8)
    override val mediumVerticalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension16)
    override val largeVerticalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension32)
    override val smallHorizontalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension8)
    override val mediumHorizontalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension16)
    override val largeHorizontalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension32)
}

open class DefaultDialogScrollableContentStyle : ContentStyle {
    override val padding: Token<PaddingValues> = Token(
        PaddingValues(all = MobiusReferenceDimensions.Dimension24)
    )
    override val contentAlignment: Token<Alignment> = Token(Alignment.TopStart)
    override val smallVerticalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension8)
    override val mediumVerticalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension16)
    override val largeVerticalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension24)
    override val smallHorizontalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension8)
    override val mediumHorizontalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension16)
    override val largeHorizontalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension24)
}

open class DefaultHeaderContentStyle : ContentStyle {
    override val padding: Token<PaddingValues> = TokenReference { Mobius.styles.scrollableContentStyle.padding }
    override val contentAlignment: Token<Alignment> = Token(Alignment.CenterStart)
    override val smallVerticalElementsSpacing: Token<Dp> = TokenReference { Mobius.styles.scrollableContentStyle.smallVerticalElementsSpacing }
    override val mediumVerticalElementsSpacing: Token<Dp>  = TokenReference { Mobius.styles.scrollableContentStyle.mediumVerticalElementsSpacing }
    override val largeVerticalElementsSpacing: Token<Dp>  = TokenReference { Mobius.styles.scrollableContentStyle.largeVerticalElementsSpacing }
    override val smallHorizontalElementsSpacing: Token<Dp> = TokenReference { Mobius.styles.scrollableContentStyle.smallHorizontalElementsSpacing }
    override val mediumHorizontalElementsSpacing: Token<Dp>  = TokenReference { Mobius.styles.scrollableContentStyle.mediumHorizontalElementsSpacing }
    override val largeHorizontalElementsSpacing: Token<Dp> = TokenReference { Mobius.styles.scrollableContentStyle.largeHorizontalElementsSpacing }
}

open class DefaultDialogHeaderContentStyle : ContentStyle {
    override val padding: Token<PaddingValues> = TokenReference { Mobius.styles.dialogScrollableContentStyle.padding }
    override val contentAlignment: Token<Alignment> = Token(Alignment.CenterStart)
    override val smallVerticalElementsSpacing: Token<Dp> = TokenReference { Mobius.styles.dialogScrollableContentStyle.smallVerticalElementsSpacing }
    override val mediumVerticalElementsSpacing: Token<Dp>  = TokenReference { Mobius.styles.dialogScrollableContentStyle.mediumVerticalElementsSpacing }
    override val largeVerticalElementsSpacing: Token<Dp>  = TokenReference { Mobius.styles.dialogScrollableContentStyle.largeVerticalElementsSpacing }
    override val smallHorizontalElementsSpacing: Token<Dp> = TokenReference { Mobius.styles.dialogScrollableContentStyle.smallHorizontalElementsSpacing }
    override val mediumHorizontalElementsSpacing: Token<Dp>  = TokenReference { Mobius.styles.dialogScrollableContentStyle.mediumHorizontalElementsSpacing }
    override val largeHorizontalElementsSpacing: Token<Dp> = TokenReference { Mobius.styles.dialogScrollableContentStyle.largeHorizontalElementsSpacing }
}

open class DefaultFooterContentStyle : ContentStyle {
    override val padding: Token<PaddingValues> = TokenReference { Mobius.styles.scrollableContentStyle.padding }
    override val contentAlignment: Token<Alignment> = Token(Alignment.CenterStart)
    override val smallVerticalElementsSpacing: Token<Dp> = TokenReference { Mobius.styles.scrollableContentStyle.smallVerticalElementsSpacing }
    override val mediumVerticalElementsSpacing: Token<Dp>  = TokenReference { Mobius.styles.scrollableContentStyle.mediumVerticalElementsSpacing }
    override val largeVerticalElementsSpacing: Token<Dp>  = TokenReference { Mobius.styles.scrollableContentStyle.largeVerticalElementsSpacing }
    override val smallHorizontalElementsSpacing: Token<Dp> = TokenReference { Mobius.styles.scrollableContentStyle.smallHorizontalElementsSpacing }
    override val mediumHorizontalElementsSpacing: Token<Dp>  = TokenReference { Mobius.styles.scrollableContentStyle.mediumHorizontalElementsSpacing }
    override val largeHorizontalElementsSpacing: Token<Dp> = TokenReference { Mobius.styles.scrollableContentStyle.largeHorizontalElementsSpacing }
}

open class DefaultDialogFooterContentStyle : ContentStyle {
    override val padding: Token<PaddingValues> = TokenReference { Mobius.styles.dialogScrollableContentStyle.padding }
    override val contentAlignment: Token<Alignment> = Token(Alignment.CenterStart)
    override val smallVerticalElementsSpacing: Token<Dp> = TokenReference { Mobius.styles.dialogScrollableContentStyle.smallVerticalElementsSpacing }
    override val mediumVerticalElementsSpacing: Token<Dp>  = TokenReference { Mobius.styles.dialogScrollableContentStyle.mediumVerticalElementsSpacing }
    override val largeVerticalElementsSpacing: Token<Dp>  = TokenReference { Mobius.styles.dialogScrollableContentStyle.largeVerticalElementsSpacing }
    override val smallHorizontalElementsSpacing: Token<Dp> = TokenReference { Mobius.styles.dialogScrollableContentStyle.smallHorizontalElementsSpacing }
    override val mediumHorizontalElementsSpacing: Token<Dp>  = TokenReference { Mobius.styles.dialogScrollableContentStyle.mediumHorizontalElementsSpacing }
    override val largeHorizontalElementsSpacing: Token<Dp> = TokenReference { Mobius.styles.dialogScrollableContentStyle.largeHorizontalElementsSpacing }
}