package com.gft.mobius.components.styles

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.references.MobiusReferenceDimensions
import com.gft.mobius.references.MobiusReferenceElevations

interface FloatingActionButtonStyleValues : StyleValues {
    val shape: Shape
    val contentColor: Color
    val backgroundColor: Color
    val textStyle: TextStyle
    val defaultElevation: Dp
    val pressedElevation: Dp
    val focusedElevation: Dp
    val hoveredElevation: Dp
    val collapsedWidth: Dp
    val height: Dp
    val iconSize: IconSize
}

interface FloatingActionButtonStyle : Style {
    val shape: Token<Shape>
    val contentColor: Token<Color>
    val backgroundColor: Token<Color>
    val textStyle: Token<TextStyle>
    val defaultElevation: Token<Dp>
    val pressedElevation: Token<Dp>
    val focusedElevation: Token<Dp>
    val hoveredElevation: Token<Dp>
    val collapsedWidth: Token<Dp>
    val height: Token<Dp>
    val iconSize: Token<IconSize>
}

@Composable
fun FloatingActionButtonStyle.resolve() = produceStyleValues { style ->
    object : FloatingActionButtonStyleValues {
        override val shape = style.shape.resolve()
        override val contentColor = style.contentColor.resolve()
        override val backgroundColor = style.backgroundColor.resolve()
        override val textStyle = style.textStyle.resolve()
        override val defaultElevation = style.defaultElevation.resolve()
        override val pressedElevation = style.pressedElevation.resolve()
        override val focusedElevation = style.focusedElevation.resolve()
        override val hoveredElevation = style.hoveredElevation.resolve()
        override val collapsedWidth = style.collapsedWidth.resolve()
        override val height = style.height.resolve()
        override val iconSize = style.iconSize.resolve()
    }
}

open class DefaultFloatingActionButtonStyle : FloatingActionButtonStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension16))
    override val contentColor = Token { Mobius.colors.onPrimaryContainer }
    override val backgroundColor = Token { Mobius.colors.primaryContainer }
    override val textStyle = Token { Mobius.typography.labelLarge }
    override val defaultElevation = Token(MobiusReferenceDimensions.Dimension4)
    override val pressedElevation = Token(MobiusReferenceDimensions.Dimension4)
    override val focusedElevation = Token(MobiusReferenceDimensions.Dimension4)
    override val hoveredElevation = Token(MobiusReferenceDimensions.Dimension8)
    override val collapsedWidth = Token(MobiusReferenceDimensions.Dimension56)
    override val height = Token(MobiusReferenceDimensions.Dimension56)
    override val iconSize = Token { IconSize.Medium }
}

open class SmallFloatingActionButtonStyle : FloatingActionButtonStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension8))
    override val contentColor = TokenReference { Mobius.styles.floatingActionButtonStyle.contentColor }
    override val backgroundColor = TokenReference { Mobius.styles.floatingActionButtonStyle.backgroundColor }
    override val textStyle = TokenReference { Mobius.styles.floatingActionButtonStyle.textStyle }
    override val defaultElevation = TokenReference { Mobius.styles.floatingActionButtonStyle.defaultElevation }
    override val pressedElevation = TokenReference { Mobius.styles.floatingActionButtonStyle.pressedElevation }
    override val focusedElevation = TokenReference { Mobius.styles.floatingActionButtonStyle.focusedElevation }
    override val hoveredElevation = TokenReference { Mobius.styles.floatingActionButtonStyle.hoveredElevation }
    override val collapsedWidth = Token(MobiusReferenceDimensions.Dimension40)
    override val height = Token(MobiusReferenceDimensions.Dimension40)
    override val iconSize = Token { IconSize.Medium }
}

open class LargeFloatingActionButtonStyle : FloatingActionButtonStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension24))
    override val contentColor = TokenReference { Mobius.styles.floatingActionButtonStyle.contentColor }
    override val backgroundColor = TokenReference { Mobius.styles.floatingActionButtonStyle.backgroundColor }
    override val textStyle = TokenReference { Mobius.styles.floatingActionButtonStyle.textStyle }
    override val defaultElevation = TokenReference { Mobius.styles.floatingActionButtonStyle.defaultElevation }
    override val pressedElevation = TokenReference { Mobius.styles.floatingActionButtonStyle.pressedElevation }
    override val focusedElevation = TokenReference { Mobius.styles.floatingActionButtonStyle.focusedElevation }
    override val hoveredElevation = TokenReference { Mobius.styles.floatingActionButtonStyle.hoveredElevation }
    override val collapsedWidth = Token(MobiusReferenceDimensions.Dimension96)
    override val height = Token(MobiusReferenceDimensions.Dimension96)
    override val iconSize = Token { IconSize.Medium }
}

open class FlatFloatingActionButtonStyle : FloatingActionButtonStyle {
    override val shape: Token<Shape> = TokenReference { Mobius.styles.floatingActionButtonStyle.shape }
    override val contentColor = TokenReference { Mobius.styles.floatingActionButtonStyle.contentColor }
    override val backgroundColor = TokenReference { Mobius.styles.floatingActionButtonStyle.backgroundColor }
    override val textStyle = TokenReference { Mobius.styles.floatingActionButtonStyle.textStyle }
    override val defaultElevation = Token(MobiusReferenceElevations.Level0)
    override val pressedElevation = Token(MobiusReferenceElevations.Level0)
    override val focusedElevation = Token(MobiusReferenceElevations.Level0)
    override val hoveredElevation = Token(MobiusReferenceElevations.Level0)
    override val collapsedWidth = TokenReference { Mobius.styles.floatingActionButtonStyle.collapsedWidth }
    override val height = TokenReference { Mobius.styles.floatingActionButtonStyle.height }
    override val iconSize = Token { IconSize.Medium }
}
