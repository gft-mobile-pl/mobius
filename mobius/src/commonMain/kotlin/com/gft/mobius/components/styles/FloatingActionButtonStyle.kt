package com.gft.mobius.components.styles

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.GenerateStyleWrapper
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.references.MobiusReferenceDimensions
import com.gft.mobius.references.MobiusReferenceElevations

@GenerateStyleValues
@GenerateStyleWrapper
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

open class DefaultFloatingActionButtonStyle : FloatingActionButtonStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension16))
    override val contentColor: Token<Color> = Token { Mobius.colors.onPrimaryContainer }
    override val backgroundColor: Token<Color> = Token { Mobius.colors.primaryContainer }
    override val textStyle: Token<TextStyle> = Token { Mobius.typography.labelLarge }
    override val defaultElevation: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val pressedElevation: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val focusedElevation: Token<Dp> = Token(MobiusReferenceDimensions.Dimension4)
    override val hoveredElevation: Token<Dp> = Token(MobiusReferenceDimensions.Dimension8)
    override val collapsedWidth: Token<Dp> = Token(MobiusReferenceDimensions.Dimension56)
    override val height: Token<Dp> = Token(MobiusReferenceDimensions.Dimension56)
    override val iconSize: Token<IconSize> = Token { IconSize.Medium }
}

open class SmallFloatingActionButtonStyle : FloatingActionButtonStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension8))
    override val contentColor: Token<Color> = TokenReference { Mobius.styles.floatingActionButtonStyle.contentColor }
    override val backgroundColor: Token<Color> = TokenReference { Mobius.styles.floatingActionButtonStyle.backgroundColor }
    override val textStyle: Token<TextStyle> = TokenReference { Mobius.styles.floatingActionButtonStyle.textStyle }
    override val defaultElevation: Token<Dp> = TokenReference { Mobius.styles.floatingActionButtonStyle.defaultElevation }
    override val pressedElevation: Token<Dp> = TokenReference { Mobius.styles.floatingActionButtonStyle.pressedElevation }
    override val focusedElevation: Token<Dp> = TokenReference { Mobius.styles.floatingActionButtonStyle.focusedElevation }
    override val hoveredElevation: Token<Dp> = TokenReference { Mobius.styles.floatingActionButtonStyle.hoveredElevation }
    override val collapsedWidth: Token<Dp> = Token(MobiusReferenceDimensions.Dimension40)
    override val height: Token<Dp> = Token(MobiusReferenceDimensions.Dimension40)
    override val iconSize: Token<IconSize> = Token { IconSize.Medium }
}

open class LargeFloatingActionButtonStyle : FloatingActionButtonStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension24))
    override val contentColor: Token<Color> = TokenReference { Mobius.styles.floatingActionButtonStyle.contentColor }
    override val backgroundColor: Token<Color> = TokenReference { Mobius.styles.floatingActionButtonStyle.backgroundColor }
    override val textStyle: Token<TextStyle> = TokenReference { Mobius.styles.floatingActionButtonStyle.textStyle }
    override val defaultElevation: Token<Dp> = TokenReference { Mobius.styles.floatingActionButtonStyle.defaultElevation }
    override val pressedElevation: Token<Dp> = TokenReference { Mobius.styles.floatingActionButtonStyle.pressedElevation }
    override val focusedElevation: Token<Dp> = TokenReference { Mobius.styles.floatingActionButtonStyle.focusedElevation }
    override val hoveredElevation: Token<Dp> = TokenReference { Mobius.styles.floatingActionButtonStyle.hoveredElevation }
    override val collapsedWidth: Token<Dp> = Token(MobiusReferenceDimensions.Dimension96)
    override val height: Token<Dp> = Token(MobiusReferenceDimensions.Dimension96)
    override val iconSize: Token<IconSize> = Token { IconSize.Medium }
}

open class FlatFloatingActionButtonStyle : FloatingActionButtonStyle {
    override val shape: Token<Shape> = TokenReference { Mobius.styles.floatingActionButtonStyle.shape }
    override val contentColor: Token<Color> = TokenReference { Mobius.styles.floatingActionButtonStyle.contentColor }
    override val backgroundColor: Token<Color> = TokenReference { Mobius.styles.floatingActionButtonStyle.backgroundColor }
    override val textStyle: Token<TextStyle> = TokenReference { Mobius.styles.floatingActionButtonStyle.textStyle }
    override val defaultElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val pressedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val focusedElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val hoveredElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val collapsedWidth: Token<Dp> = TokenReference { Mobius.styles.floatingActionButtonStyle.collapsedWidth }
    override val height: Token<Dp> = TokenReference { Mobius.styles.floatingActionButtonStyle.height }
    override val iconSize: Token<IconSize> = Token { IconSize.Medium }
}
