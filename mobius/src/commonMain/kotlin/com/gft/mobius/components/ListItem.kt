package com.gft.mobius.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.gft.compose.common.modifyIf
import com.gft.mobius.Mobius
import com.gft.mobius.colors.LocalContentColor
import com.gft.mobius.components.ListItemLayout.AllElements
import com.gft.mobius.components.ListItemLayout.HeadlineOnly
import com.gft.mobius.components.ListItemLayout.HeadlineWithOverline
import com.gft.mobius.components.ListItemLayout.HeadlineWithSupportingText
import com.gft.mobius.components.styles.ListItemStyle
import com.gft.mobius.components.styles.ListItemStyle.ByContentLayout
import com.gft.mobius.components.styles.ListItemStyle.ContentAlignment
import com.gft.mobius.components.styles.LocalTextStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun ContentScope.ListItem(
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    headlineContent: @Composable () -> Unit,
    overlineContent: (@Composable () -> Unit)? = null,
    supportingContent: (@Composable () -> Unit)? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    ignoreContainerPadding: Boolean = true,
    style: ListItemStyle = Mobius.styles.listItemStyle
) = ListItemImplementation(
    modifier = wrapper
        .modifyIf(ignoreContainerPadding) {
            fillContentContainerWidth(ignorePadding = true)
        }
        .then(modifier),
    headlineContent = headlineContent,
    overlineContent = overlineContent,
    supportingContent = supportingContent,
    leadingContent = leadingContent,
    trailingContent = trailingContent,
    style = style
)

@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    headlineContent: @Composable () -> Unit,
    overlineContent: (@Composable () -> Unit)? = null,
    supportingContent: (@Composable () -> Unit)? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    style: ListItemStyle = Mobius.styles.listItemStyle
) = ListItemImplementation(
    modifier = modifier,
    headlineContent = headlineContent,
    overlineContent = overlineContent,
    supportingContent = supportingContent,
    leadingContent = leadingContent,
    trailingContent = trailingContent,
    style = style
)

@Composable
private fun ListItemImplementation(
    modifier: Modifier = Modifier,
    headlineContent: @Composable () -> Unit,
    overlineContent: (@Composable () -> Unit)? = null,
    supportingContent: (@Composable () -> Unit)? = null,
    leadingContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null,
    style: ListItemStyle = Mobius.styles.listItemStyle
) {
    val styleValues = style.resolve()
    val layout = resolveLayout(
        supportingContent = supportingContent,
        overlineContent = overlineContent,
        leadingContent = leadingContent,
        trailingContent = trailingContent
    )
    val minHeight = styleValues.minHeight.resolve(layout)

    val styledLeadingContent: @Composable RowScope.() -> Unit = {
        val alignment = styleValues.leadingContentAlignment.resolve(layout)
        leadingContent?.let {
            Box(
                modifier = Modifier
                    .modifyIf(alignment == ContentAlignment.CenterWithinMinHeight) {
                        heightIn(min = minHeight)
                    }
                    .padding(styleValues.leadingContentPadding.resolve(layout))
                    .align(alignment.resolveVerticalAlignment()),
                contentAlignment = Alignment.Center
            ) {
                CompositionLocalProvider(
                    LocalIconSize provides styleValues.leadingContentIconSize,
                    LocalContentColor provides styleValues.leadingContentColor,
                    content = leadingContent
                )
            }
        }
    }

    val styledHeadlineContent: @Composable () -> Unit = {
        CompositionLocalProvider(
            LocalTextStyle provides styleValues.headlineTextStyle,
            LocalContentColor provides styleValues.headlineColor,
            content = headlineContent
        )
    }

    val styledOverlineContent: @Composable () -> Unit = {
        overlineContent?.let {
            CompositionLocalProvider(
                LocalTextStyle provides styleValues.overlineTextStyle,
                LocalContentColor provides styleValues.overlineColor,
                content = overlineContent
            )
        }
    }

    val styledSupportingContent: @Composable () -> Unit = {
        supportingContent?.let {
            CompositionLocalProvider(
                LocalTextStyle provides styleValues.supportingTextStyle,
                LocalContentColor provides styleValues.supportingTextColor,
                content = supportingContent
            )
        }
    }

    val styledTrailingContent: @Composable RowScope.() -> Unit = {
        val alignment = styleValues.trailingContentAlignment.resolve(layout)
        trailingContent?.let {
            Box(
                modifier = Modifier
                    .modifyIf(alignment == ContentAlignment.CenterWithinMinHeight) {
                        heightIn(min = minHeight)
                    }
                    .padding(styleValues.trailingContentPadding.resolve(layout))
                    .align(alignment.resolveVerticalAlignment()),
                contentAlignment = Alignment.Center
            ) {
                CompositionLocalProvider(
                    LocalTextStyle provides styleValues.trailingContentTextStyle,
                    LocalContentColor provides styleValues.trailingContentColor,
                    LocalIconSize provides styleValues.trailingContentIconSize,
                    content = trailingContent
                )
            }
        }
    }

    androidx.compose.material3.Surface(
        modifier = modifier,
        shape = styleValues.shape,
        color = styleValues.backgroundColor,
        contentColor = styleValues.headlineColor,
        tonalElevation = styleValues.tonalElevation,
        shadowElevation = styleValues.shadowElevation,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = minHeight)
        ) {
            val alignment = styleValues.contentAlignment.resolve(layout)
            styledLeadingContent()
            Column(
                modifier = Modifier
                    .weight(1f)
                    .modifyIf(alignment == ContentAlignment.CenterWithinMinHeight) {
                        heightIn(min = minHeight)
                    }
                    .padding(styleValues.contentPadding.resolve(layout))
                    .align(alignment.resolveVerticalAlignment()),
                verticalArrangement = Arrangement.Center
            ) {
                styledOverlineContent()
                styledHeadlineContent()
                styledSupportingContent()
            }
            styledTrailingContent()
        }
    }
}

private sealed interface ListItemLayout {
    val leadingContentPresent: Boolean
    val trailingContentPresent: Boolean

    data class HeadlineOnly(override val leadingContentPresent: Boolean, override val trailingContentPresent: Boolean) : ListItemLayout
    data class HeadlineWithOverline(override val leadingContentPresent: Boolean, override val trailingContentPresent: Boolean) : ListItemLayout
    data class HeadlineWithSupportingText(override val leadingContentPresent: Boolean, override val trailingContentPresent: Boolean) : ListItemLayout
    data class AllElements(override val leadingContentPresent: Boolean, override val trailingContentPresent: Boolean) : ListItemLayout
}

private fun resolveLayout(
    supportingContent: (@Composable () -> Unit)?,
    overlineContent: (@Composable () -> Unit)?,
    leadingContent: (@Composable () -> Unit)?,
    trailingContent: (@Composable () -> Unit)?
): ListItemLayout {
    val leadingContentPresent = leadingContent != null
    val trailingContentPresent = trailingContent != null
    return when {
        supportingContent != null && overlineContent != null -> AllElements(leadingContentPresent, trailingContentPresent)
        supportingContent != null -> HeadlineWithSupportingText(leadingContentPresent, trailingContentPresent)
        overlineContent != null -> HeadlineWithOverline(leadingContentPresent, trailingContentPresent)
        else -> HeadlineOnly(leadingContentPresent, trailingContentPresent)
    }
}

private fun <T> ByContentLayout<T>.resolve(itemType: ListItemLayout): T = when (itemType) {
    is AllElements -> allElements
    is HeadlineOnly -> headlineOnly
    is HeadlineWithOverline -> headlineWithOverline
    is HeadlineWithSupportingText -> headlineWithSupportingText
}

private fun ContentAlignment.resolveVerticalAlignment() = when (this) {
    ContentAlignment.Top -> Alignment.Top
    ContentAlignment.Bottom -> Alignment.Bottom
    ContentAlignment.Center -> Alignment.CenterVertically
    ContentAlignment.CenterWithinMinHeight -> Alignment.Top
}

private fun ListItemStyle.ContentPaddingValues.resolve(layout: ListItemLayout) = PaddingValues(
    top = top.resolve(layout),
    bottom = bottom.resolve(layout),
    start = if (layout.leadingContentPresent) start.withSideContent else start.withoutSideContent,
    end = if (layout.trailingContentPresent) end.withSideContent else end.withoutSideContent
)
