package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.components.common.copy
import com.gft.mobius.references.MobiusReferenceDimensions

interface PopUpScreenStyleValues : StyleValues, DialogScreenStyleValues {
    val minimumPadding: PaddingValues
    val headerPadding: PaddingValues
    val headerBackground: Brush?
    val headerIconSize: IconSize
    val headerIconContentColor: Color
    val headerTextStyle: TextStyle
    val headerContentColor: Color
    val textOnlyHeaderAlignment: Alignment.Horizontal
    val withIconHeaderAlignment: Alignment.Horizontal
    val headerVerticalArrangement: Arrangement.Vertical
    val contentStyle: ContentStyle
    val contentTextStyle: TextStyle
    val buttonsStyle: DialogButtonsStyle
}

interface PopUpScreenStyle : Style, DialogScreenStyle {
    val minimumPadding: Token<PaddingValues>
    val headerPadding: Token<PaddingValues>
    val headerBackground: Token<Brush?>
    val headerIconSize: Token<IconSize>
    val headerIconContentColor: Token<Color>
    val headerTextStyle: Token<TextStyle>
    val headerContentColor: Token<Color>
    val textOnlyHeaderAlignment: Token<Alignment.Horizontal>
    val withIconHeaderAlignment: Token<Alignment.Horizontal>
    val headerVerticalArrangement: Token<Arrangement.Vertical>
    val contentStyle: Token<ContentStyle>
    val contentTextStyle: Token<TextStyle>
    val buttonsStyle: Token<DialogButtonsStyle>
}

@Composable
fun PopUpScreenStyle.resolve() = produceStyleValues { style ->
    object : PopUpScreenStyleValues {
        override val minimumPadding: PaddingValues = style.minimumPadding.resolve()
        override val shape: Shape? = style.shape.resolve()
        override val background: Brush? = style.background.resolve()
        override val contentColor: Color = style.contentColor.resolve()
        override val underlyingContentBlur: Dp = style.underlyingContentBlur.resolve()
        override val headerPadding: PaddingValues = style.headerPadding.resolve()
        override val headerBackground: Brush? = style.headerBackground.resolve()
        override val headerIconSize: IconSize = style.headerIconSize.resolve()
        override val headerIconContentColor: Color = style.headerIconContentColor.resolve()
        override val headerTextStyle: TextStyle = style.headerTextStyle.resolve()
        override val headerContentColor: Color = style.headerContentColor.resolve()
        override val textOnlyHeaderAlignment: Alignment.Horizontal = style.textOnlyHeaderAlignment.resolve()
        override val withIconHeaderAlignment: Alignment.Horizontal = style.withIconHeaderAlignment.resolve()
        override val headerVerticalArrangement: Arrangement.Vertical = style.headerVerticalArrangement.resolve()
        override val contentStyle: ContentStyle = style.contentStyle.resolve()
        override val contentTextStyle: TextStyle = style.contentTextStyle.resolve()
        override val buttonsStyle: DialogButtonsStyle = style.buttonsStyle.resolve()
    }
}

open class DefaultPopUpScreenStyle : PopUpScreenStyle {
    override val shape: Token<Shape?> = TokenReference { Mobius.styles.dialogScreenStyle.shape }
    override val underlyingContentBlur: Token<Dp> = TokenReference { Mobius.styles.dialogScreenStyle.underlyingContentBlur }

    override val minimumPadding: Token<PaddingValues> = TokenReference { Mobius.styles.dialogContentStyle.padding }
    override val background: Token<Brush?> = TokenReference { Mobius.styles.dialogScreenStyle.background }

    override val headerPadding: Token<PaddingValues> = Token {
        with(Mobius.styles.dialogContentStyle.resolve()) {
            padding.copy(bottom = mediumVerticalElementsSpacing)
        }
    }
    override val headerBackground: Token<Brush?> = Token(null)
    override val headerIconSize: Token<IconSize> = Token { IconSize.Medium }
    override val headerIconContentColor: Token<Color> = Token { Mobius.colors.secondary }
    override val headerTextStyle: Token<TextStyle> = Token { Mobius.typography.headlineSmall }
    override val headerContentColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val textOnlyHeaderAlignment: Token<Alignment.Horizontal> = Token(Alignment.Start)
    override val withIconHeaderAlignment: Token<Alignment.Horizontal> = Token(Alignment.CenterHorizontally)
    override val headerVerticalArrangement: Token<Arrangement.Vertical> = Token {
        Arrangement.spacedBy(Mobius.styles.dialogContentStyle.resolve().mediumVerticalElementsSpacing)
    }

    override val contentStyle: Token<ContentStyle> = Token {
        val style = Mobius.styles.dialogContentStyle
        object : ContentStyle by style {
            override val padding: Token<PaddingValues> = Token(
                style.padding.resolve().copy(
                    top = MobiusReferenceDimensions.Dimension0,
                    bottom = MobiusReferenceDimensions.Dimension0
                )
            )
        }
    }
    override val contentColor: Token<Color> = TokenReference { Mobius.styles.dialogScreenStyle.contentColor }
    override val contentTextStyle: Token<TextStyle> = Token { Mobius.typography.bodyMedium }

    override val buttonsStyle: Token<DialogButtonsStyle> = Token { Mobius.styles.dialogButtonsStyle }
}
