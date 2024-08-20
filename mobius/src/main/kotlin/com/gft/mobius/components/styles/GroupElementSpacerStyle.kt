package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.references.MobiusReferenceDimensions


interface GroupElementSpacerStyleValues : StyleValues {
    val smallVerticalElementsSpacing: Dp
    val mediumVerticalElementsSpacing: Dp
    val largeVerticalElementsSpacing: Dp
    val smallHorizontalElementsSpacing: Dp
    val mediumHorizontalElementsSpacing: Dp
    val largeHorizontalElementsSpacing: Dp
}

interface GroupElementSpacerStyle : Style {
    val smallVerticalElementsSpacing: Token<Dp>
    val mediumVerticalElementsSpacing: Token<Dp>
    val largeVerticalElementsSpacing: Token<Dp>
    val smallHorizontalElementsSpacing: Token<Dp>
    val mediumHorizontalElementsSpacing: Token<Dp>
    val largeHorizontalElementsSpacing: Token<Dp>
}

@Composable
fun GroupElementSpacerStyle.resolve() = produceStyleValues { style ->
    object : GroupElementSpacerStyleValues {
        override val smallVerticalElementsSpacing = style.smallVerticalElementsSpacing.resolve()
        override val mediumVerticalElementsSpacing = style.mediumVerticalElementsSpacing.resolve()
        override val largeVerticalElementsSpacing = style.largeVerticalElementsSpacing.resolve()
        override val smallHorizontalElementsSpacing = style.smallHorizontalElementsSpacing.resolve()
        override val mediumHorizontalElementsSpacing = style.mediumHorizontalElementsSpacing.resolve()
        override val largeHorizontalElementsSpacing = style.largeHorizontalElementsSpacing.resolve()
    }
}

open class DefaultGroupElementSpacerStyle : GroupElementSpacerStyle {
    override val smallVerticalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val mediumVerticalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension12)
    override val largeVerticalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension24)
    override val smallHorizontalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val mediumHorizontalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension12)
    override val largeHorizontalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension24)
}
