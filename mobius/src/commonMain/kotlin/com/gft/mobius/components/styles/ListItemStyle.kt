package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.components.styles.ListItemStyle.SideContentAlignment
import com.gft.mobius.components.styles.ListItemStyle.SideContentVerticalAlignment
import com.gft.mobius.references.MobiusReferenceDimensions
import com.gft.mobius.references.MobiusReferenceElevations

@GenerateStyleValues
interface ListItemStyle : Style {
    val padding: Token<PaddingValues>
    val shape: Token<Shape>
    val backgroundColor: Token<Color>
    val tonalElevation: Token<Dp>
    val shadowElevation: Token<Dp>
    val contentPadding: Token<PaddingValues>
    val supportingTextStyle: Token<TextStyle>
    val supportingTextColor: Token<Color>
    val overlineTextStyle: Token<TextStyle>
    val overlineColor: Token<Color>
    val headlineTextStyle: Token<TextStyle>
    val headlineColor: Token<Color>
    val leadingContentPadding: Token<PaddingValues>
    val leadingContentAlignment: Token<SideContentAlignment>
    val leadingIconSize: Token<IconSize>
    val leadingContentColor: Token<Color>
    val trailingContentPadding: Token<PaddingValues>
    val trailingContentAlignment: Token<SideContentAlignment>
    val trailingTextStyle: Token<TextStyle>
    val trailingIconSize: Token<IconSize>
    val trailingContentColor: Token<Color>

    sealed interface SideContentVerticalAlignment {
        data class Top(val topPadding: Dp) : SideContentVerticalAlignment
        data object Center : SideContentVerticalAlignment
        data class Bottom(val bottomPadding: Dp) : SideContentVerticalAlignment
    }

    data class SideContentAlignment(
        val headlineOnly: SideContentVerticalAlignment,
        val headlineWithOverline: SideContentVerticalAlignment,
        val headlineWithSupportingText: SideContentVerticalAlignment,
        val allElements: SideContentVerticalAlignment
    )
}

open class DefaultListItemStyle : ListItemStyle {
    override val padding: Token<PaddingValues> = Token(PaddingValues(MobiusReferenceDimensions.Dimension16))
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension0))
    override val backgroundColor: Token<Color> = Token { Mobius.colors.surface }
    override val tonalElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val shadowElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val contentPadding: Token<PaddingValues> = Token(PaddingValues(MobiusReferenceDimensions.Dimension0))
    override val supportingTextStyle: Token<TextStyle> = Token { Mobius.typography.bodyMedium }
    override val supportingTextColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val overlineTextStyle: Token<TextStyle> = Token { Mobius.typography.labelSmall }
    override val overlineColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val headlineTextStyle: Token<TextStyle> = Token { Mobius.typography.bodyLarge }
    override val headlineColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val leadingContentPadding: Token<PaddingValues> = Token(PaddingValues(end = MobiusReferenceDimensions.Dimension16))
    override val leadingContentAlignment: Token<SideContentAlignment> = Token(
        SideContentAlignment(
            headlineOnly = SideContentVerticalAlignment.Center,
            headlineWithOverline = SideContentVerticalAlignment.Top(MobiusReferenceDimensions.Dimension4),
            headlineWithSupportingText = SideContentVerticalAlignment.Top(6.dp),
            allElements = SideContentVerticalAlignment.Top(MobiusReferenceDimensions.Dimension2)
        )
    )
    override val leadingIconSize: Token<IconSize> = Token { IconSize.Medium }
    override val leadingContentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val trailingContentPadding: Token<PaddingValues> = Token(PaddingValues(start = MobiusReferenceDimensions.Dimension16))
    override val trailingContentAlignment: Token<SideContentAlignment> = TokenReference { Mobius.styles.listItemStyle.leadingContentAlignment }
    override val trailingTextStyle: Token<TextStyle> = Token { Mobius.typography.labelSmall }
    override val trailingIconSize: Token<IconSize> = Token { IconSize.Medium }
    override val trailingContentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
}
