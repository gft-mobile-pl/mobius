package com.gft.mobius.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.colors.LocalContentColor
import com.gft.mobius.components.ListItemLayout.AllElements
import com.gft.mobius.components.ListItemLayout.HeadlineOnly
import com.gft.mobius.components.ListItemLayout.HeadlineWithOverline
import com.gft.mobius.components.ListItemLayout.HeadlineWithSupportingText
import com.gft.mobius.components.styles.ListItemStyle
import com.gft.mobius.components.styles.ListItemStyle.SideContentAlignment
import com.gft.mobius.components.styles.ListItemStyle.SideContentVerticalAlignment
import com.gft.mobius.components.styles.LocalTextStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun ListItem(
    headlineContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    overlineContent: @Composable (() -> Unit)? = null,
    supportingContent: @Composable (() -> Unit)? = null,
    leadingContent: @Composable (() -> Unit)? = null,
    trailingContent: @Composable (() -> Unit)? = null,
    style: ListItemStyle = Mobius.styles.listItemStyle
) {
    val styleValues = style.resolve()

    val listItemType = resolveListItemLayout(supportingContent = supportingContent, overlineContent = overlineContent)
    val leadingContentAlignment = styleValues.leadingContentAlignment.resolveAlignment(listItemType)
    val trailingContentAlignment = styleValues.trailingContentAlignment.resolveAlignment(listItemType)

    val styledLeadingContent: @Composable RowScope.() -> Unit = {
        leadingContent?.let {
            Box(
                Modifier
                    .padding(styleValues.leadingContentPadding)
                    .align(leadingContentAlignment.resolveVerticalAlignment())
                    .offset(y = leadingContentAlignment.resolveOffset())
            ) {
                CompositionLocalProvider(
                    LocalIconSize provides styleValues.leadingIconSize,
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
        trailingContent?.let {
            Box(
                Modifier
                    .padding(styleValues.trailingContentPadding)
                    .align(trailingContentAlignment.resolveVerticalAlignment())
                    .offset(y = trailingContentAlignment.resolveOffset())
            ) {
                CompositionLocalProvider(
                    LocalTextStyle provides styleValues.trailingTextStyle,
                    LocalContentColor provides styleValues.trailingContentColor,
                    LocalIconSize provides styleValues.trailingIconSize,
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
            Modifier
                .fillMaxWidth()
                .padding(styleValues.padding),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            styledLeadingContent()
            Column(Modifier.weight(1f)) {
                styledOverlineContent()
                styledHeadlineContent()
                styledSupportingContent()
            }
            styledTrailingContent()
        }
    }
}

private enum class ListItemLayout {
    HeadlineOnly,
    HeadlineWithOverline,
    HeadlineWithSupportingText,
    AllElements
}

private fun resolveListItemLayout(
    supportingContent: @Composable (() -> Unit)?,
    overlineContent: @Composable (() -> Unit)?
) = when {
    supportingContent != null && overlineContent != null -> AllElements
    supportingContent != null -> HeadlineWithSupportingText
    overlineContent != null -> HeadlineWithOverline
    else -> HeadlineOnly
}

private fun SideContentAlignment.resolveAlignment(itemType: ListItemLayout) = when (itemType) {
    HeadlineOnly -> headlineOnly
    HeadlineWithOverline -> headlineWithOverline
    HeadlineWithSupportingText -> headlineWithSupportingText
    AllElements -> allElements
}

private fun SideContentVerticalAlignment.resolveOffset() = when (this) {
    SideContentVerticalAlignment.Center -> 0.dp
    is SideContentVerticalAlignment.Top -> offset
}

private fun SideContentVerticalAlignment.resolveVerticalAlignment() = when (this) {
    SideContentVerticalAlignment.Center -> Alignment.CenterVertically
    is SideContentVerticalAlignment.Top -> Alignment.Top
}
