package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.StyleValuesProducer
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.references.MobiusReferenceDimensions

interface GroupStyleValues : ContentStyleValues {
    val shape: Shape?
    val background: Brush?
    val contentColor: Color
}

interface GroupStyle : ContentStyle {
    val shape: Token<Shape?>
    val background: Token<Brush?>
    val contentColor: Token<Color>
}

@Composable
fun GroupStyle.resolve() = produceStyleValues(
    StyleValuesProducer<GroupStyle, GroupStyleValues> { style: GroupStyle ->
    object : GroupStyleValues {
        override val padding = style.padding.resolve()
        override val background = style.background.resolve()
        override val shape = style.shape.resolve()
        override val contentColor = style.contentColor.resolve()
        override val contentAlignment = style.contentAlignment.resolve()
        override val smallVerticalElementsSpacing = style.smallVerticalElementsSpacing.resolve()
        override val mediumVerticalElementsSpacing = style.mediumVerticalElementsSpacing.resolve()
        override val largeVerticalElementsSpacing = style.largeVerticalElementsSpacing.resolve()
        override val smallHorizontalElementsSpacing = style.smallHorizontalElementsSpacing.resolve()
        override val mediumHorizontalElementsSpacing = style.mediumHorizontalElementsSpacing.resolve()
        override val largeHorizontalElementsSpacing = style.largeHorizontalElementsSpacing.resolve()
    }
}
)

open class DefaultGroupStyle : GroupStyle {
    override val padding: Token<PaddingValues> = Token(
        PaddingValues(
            start = MobiusReferenceDimensions.Dimension16,
            end = MobiusReferenceDimensions.Dimension16,
            top = MobiusReferenceDimensions.Dimension16,
            bottom = MobiusReferenceDimensions.Dimension16,
        )
    )
    override val background: Token<Brush?> = Token(null)
    override val shape: Token<Shape?> = Token(null)
    override val contentColor: Token<Color> = Token(Color.Unspecified)
    override val contentAlignment: Token<Alignment> = Token(Alignment.TopStart)
    override val smallVerticalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val mediumVerticalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension12)
    override val largeVerticalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension24)
    override val smallHorizontalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val mediumHorizontalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension12)
    override val largeHorizontalElementsSpacing: Token<Dp> = Token(MobiusReferenceDimensions.Dimension24)
}
