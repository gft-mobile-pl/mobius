package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.GenerateStyleWrapper
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.components.styles.ListItemStyle.ByContentLayout
import com.gft.mobius.components.styles.ListItemStyle.BySideContent
import com.gft.mobius.components.styles.ListItemStyle.ContentAlignment
import com.gft.mobius.components.styles.ListItemStyle.ContentPaddingValues
import com.gft.mobius.references.MobiusReferenceDimensions
import com.gft.mobius.references.MobiusReferenceElevations

@GenerateStyleValues
@GenerateStyleWrapper
interface ListItemStyle : Style {
    val shape: Token<Shape>
    val backgroundColor: Token<Color>
    val tonalElevation: Token<Dp>
    val shadowElevation: Token<Dp>
    val minHeight: Token<ByContentLayout<Dp>>

    val contentPadding: Token<ContentPaddingValues>
    val contentAlignment: Token<ByContentLayout<ContentAlignment>>
    val supportingTextStyle: Token<TextStyle>
    val supportingTextColor: Token<Color>
    val overlineTextStyle: Token<TextStyle>
    val overlineColor: Token<Color>
    val headlineTextStyle: Token<TextStyle>
    val headlineColor: Token<Color>

    val leadingContentPadding: Token<ByContentLayout<PaddingValues>>
    val leadingContentAlignment: Token<ByContentLayout<ContentAlignment>>
    val leadingContentIconSize: Token<IconSize>
    val leadingContentTextStyle: Token<TextStyle>
    val leadingContentColor: Token<Color>

    val trailingContentPadding: Token<ByContentLayout<PaddingValues>>
    val trailingContentAlignment: Token<ByContentLayout<ContentAlignment>>
    val trailingContentTextStyle: Token<TextStyle>
    val trailingContentIconSize: Token<IconSize>
    val trailingContentColor: Token<Color>

    data class ByContentLayout<T>(
        val headlineOnly: T,
        val headlineWithOverline: T,
        val headlineWithSupportingText: T,
        val allElements: T
    ) {
        constructor(allLayouts: T) : this(allLayouts, allLayouts, allLayouts, allLayouts)
    }

    data class BySideContent<T>(
        val withSideContent: T,
        val withoutSideContent: T
    )

    data class ContentPaddingValues(
        val top: ByContentLayout<Dp>,
        val bottom: ByContentLayout<Dp>,
        val start: BySideContent<Dp>,
        val end: BySideContent<Dp>
    )

    @Suppress("FunctionName")
    fun PaddingValues(
        top: ByContentLayout<Dp>,
        bottom: ByContentLayout<Dp>,
        start: BySideContent<Dp>,
        end: BySideContent<Dp>
    ) = ContentPaddingValues(top, bottom, start, end)

    enum class ContentAlignment {
        Top, Center, CenterWithinMinHeight, Bottom
    }
}

open class DefaultListItemStyle : ListItemStyle {
    override val shape: Token<Shape> = Token(RoundedCornerShape(MobiusReferenceDimensions.Dimension0))
    override val backgroundColor: Token<Color> = Token { Mobius.colors.surface }
    override val tonalElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val shadowElevation: Token<Dp> = Token(MobiusReferenceElevations.Level0)
    override val minHeight: Token<ByContentLayout<Dp>> = Token(
        ByContentLayout(
            headlineOnly = MobiusReferenceDimensions.Dimension56,
            headlineWithOverline = MobiusReferenceDimensions.Dimension72,
            headlineWithSupportingText = MobiusReferenceDimensions.Dimension72,
            allElements = MobiusReferenceDimensions.Dimension72
        )
    )

    override val contentPadding: Token<ContentPaddingValues> = Token {
        PaddingValues(
            top = ByContentLayout(MobiusReferenceDimensions.Dimension8),
            bottom = ByContentLayout(MobiusReferenceDimensions.Dimension8),
            start = BySideContent(
                withSideContent = MobiusReferenceDimensions.Dimension0,
                withoutSideContent = Mobius.styles.contentStyle.resolve().padding.calculateStartPadding(LocalLayoutDirection.current)
            ),
            end = BySideContent(
                withSideContent = MobiusReferenceDimensions.Dimension0,
                withoutSideContent = Mobius.styles.contentStyle.resolve().padding.calculateEndPadding(LocalLayoutDirection.current)
            ),
        )
    }
    override val contentAlignment: Token<ByContentLayout<ContentAlignment>> = Token(
        ByContentLayout(
            headlineOnly = ContentAlignment.Center,
            headlineWithOverline = ContentAlignment.Center,
            headlineWithSupportingText = ContentAlignment.Center,
            allElements = ContentAlignment.CenterWithinMinHeight
        )
    )
    override val supportingTextStyle: Token<TextStyle> = Token { Mobius.typography.bodyMedium }
    override val supportingTextColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val overlineTextStyle: Token<TextStyle> = Token { Mobius.typography.labelSmall }
    override val overlineColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val headlineTextStyle: Token<TextStyle> = Token { Mobius.typography.bodyLarge }
    override val headlineColor: Token<Color> = Token { Mobius.colors.onSurface }

    override val leadingContentPadding: Token<ByContentLayout<PaddingValues>> = Token {
        ByContentLayout(
            PaddingValues(
                horizontal = Mobius.styles.listItemStyle.contentPadding.resolve().start.withoutSideContent,
                vertical = MobiusReferenceDimensions.Dimension8
            )
        )
    }
    override val leadingContentAlignment: Token<ByContentLayout<ContentAlignment>> = Token(
        ByContentLayout(
            headlineOnly = ContentAlignment.Center,
            headlineWithOverline = ContentAlignment.Center,
            headlineWithSupportingText = ContentAlignment.Center,
            allElements = ContentAlignment.CenterWithinMinHeight
        )
    )
    override val leadingContentTextStyle: Token<TextStyle> = Token { Mobius.typography.labelSmall }
    override val leadingContentIconSize: Token<IconSize> = Token { IconSize.Medium }
    override val leadingContentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }

    override val trailingContentPadding: Token<ByContentLayout<PaddingValues>> = Token {
        ByContentLayout(
            PaddingValues(
                horizontal = Mobius.styles.listItemStyle.contentPadding.resolve().end.withoutSideContent,
                vertical = MobiusReferenceDimensions.Dimension8
            )
        )
    }
    override val trailingContentAlignment: Token<ByContentLayout<ContentAlignment>> = Token(
        ByContentLayout(
            headlineOnly = ContentAlignment.Center,
            headlineWithOverline = ContentAlignment.Center,
            headlineWithSupportingText = ContentAlignment.Center,
            allElements = ContentAlignment.CenterWithinMinHeight
        )
    )
    override val trailingContentTextStyle: Token<TextStyle> = Token { Mobius.typography.labelSmall }
    override val trailingContentIconSize: Token<IconSize> = Token { IconSize.Medium }
    override val trailingContentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
}
