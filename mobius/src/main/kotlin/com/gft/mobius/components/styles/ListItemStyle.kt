package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.components.styles.ListItemStyle.SideContentAlignment
import com.gft.mobius.components.styles.ListItemStyle.SideContentVerticalAlignment
import com.gft.mobius.references.MobiusReferenceDimensions
import com.gft.mobius.references.MobiusReferenceElevations

interface ListItemStyleValues : StyleValues {
    val padding: PaddingValues
    val shape: Shape
    val backgroundColor: Color
    val tonalElevation: Dp
    val shadowElevation: Dp
    val contentPadding: PaddingValues
    val supportingTextStyle: TextStyle
    val supportingTextColor: Color
    val overlineTextStyle: TextStyle
    val overlineColor: Color
    val headlineTextStyle: TextStyle
    val headlineColor: Color
    val leadingContentPadding: PaddingValues
    val leadingContentAlignment: SideContentAlignment
    val leadingIconSize: IconSize
    val leadingContentColor: Color
    val trailingContentPadding: PaddingValues
    val trailingContentAlignment: SideContentAlignment
    val trailingTextStyle: TextStyle
    val trailingIconSize: IconSize
    val trailingContentColor: Color
}

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

@Composable
fun ListItemStyle.resolve() = produceStyleValues { style ->
    object : ListItemStyleValues {
        override val padding = style.padding.resolve()
        override val shape = style.shape.resolve()
        override val backgroundColor = style.backgroundColor.resolve()
        override val tonalElevation = style.tonalElevation.resolve()
        override val shadowElevation = style.shadowElevation.resolve()
        override val contentPadding = style.contentPadding.resolve()
        override val supportingTextStyle = style.supportingTextStyle.resolve()
        override val supportingTextColor = style.supportingTextColor.resolve()
        override val overlineTextStyle = style.overlineTextStyle.resolve()
        override val overlineColor = style.overlineColor.resolve()
        override val headlineTextStyle = style.headlineTextStyle.resolve()
        override val headlineColor = style.headlineColor.resolve()
        override val leadingContentPadding = style.leadingContentPadding.resolve()
        override val leadingContentAlignment = style.leadingContentAlignment.resolve()
        override val leadingIconSize = style.leadingIconSize.resolve()
        override val leadingContentColor = style.leadingContentColor.resolve()
        override val trailingContentPadding = style.trailingContentPadding.resolve()
        override val trailingContentAlignment = style.trailingContentAlignment.resolve()
        override val trailingTextStyle = style.trailingTextStyle.resolve()
        override val trailingIconSize = style.trailingIconSize.resolve()
        override val trailingContentColor = style.trailingContentColor.resolve()
    }
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
