package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.components.common.copy
import com.gft.mobius.references.MobiusReferenceDimensions

@GenerateStyleValues
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
