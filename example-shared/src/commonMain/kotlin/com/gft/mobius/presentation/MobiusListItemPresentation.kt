package com.gft.mobius.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gft.designsystem.Token
import com.gft.mobius.Mobius
import com.gft.mobius.components.Content
import com.gft.mobius.components.ContentScope
import com.gft.mobius.components.HorizontalDivider
import com.gft.mobius.components.Icon
import com.gft.mobius.components.IconButton
import com.gft.mobius.components.ListItem
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.Screen
import com.gft.mobius.components.SmallElementSpacer
import com.gft.mobius.components.Text
import com.gft.mobius.components.common.copy
import com.gft.mobius.components.styles.DefaultListItemStyle
import com.gft.mobius.components.styles.ListItemStyle
import com.gft.mobius.components.styles.ListItemStyle.ByContentLayout
import com.gft.mobius.components.styles.ListItemStyle.BySideContent
import com.gft.mobius.components.styles.ListItemStyle.ContentAlignment
import com.gft.mobius.components.styles.ListItemStyleWrapper
import com.gft.mobius.components.styles.resolve
import mobius.example_shared.generated.resources.Res
import mobius.example_shared.generated.resources.ic_chevron
import mobius.example_shared.generated.resources.ic_settings

@Composable
internal fun MobiusListItemPresentation(
    onBack: () -> Unit,
) {
    Mobius {
        Screen {
            MobiusPresentationNavigationBar(
                title = "List item",
                onBack = onBack,
            )
            Content {
                Text("Overline and supporting text variations")
                SmallElementSpacer()
                HorizontalDivider()
                ListItem(
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("List item headline") },
                    leadingContent = {
                        IconButton(onClick = {}) {
                            Icon(drawableResource = Res.drawable.ic_settings, contentDescription = "Go to settings")
                        }
                    },
                    trailingContent = { Icon(drawableResource = Res.drawable.ic_chevron, contentDescription = "Go to details") },
                    style = ListItemWithLeadingButtonStyle
                )
                HorizontalDivider()
                ListItem(
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("List item headline") },
                    supportingContent = { Text("List item supporting text") },
                    leadingContent = {
                        IconButton(onClick = {}) {
                            Icon(drawableResource = Res.drawable.ic_settings, contentDescription = "Go to settings")
                        }
                    },
                    trailingContent = { Icon(drawableResource = Res.drawable.ic_chevron, contentDescription = "Go to details") },
                    style = ListItemWithLeadingButtonStyle
                )
                HorizontalDivider()
                ListItem(
                    modifier = Modifier.clickable { },
                    overlineContent = { Text(text = "Overline") },
                    headlineContent = { Text("List item headline") },
                    leadingContent = {
                        IconButton(onClick = {}) {
                            Icon(drawableResource = Res.drawable.ic_settings, contentDescription = "Go to settings")
                        }
                    },
                    trailingContent = { Icon(drawableResource = Res.drawable.ic_chevron, contentDescription = "Go to details") },
                    style = ListItemWithLeadingButtonStyle
                )
                HorizontalDivider()
                ListItem(
                    modifier = Modifier.clickable { },
                    overlineContent = { Text(text = "Overline") },
                    headlineContent = { Text("List item headline") },
                    supportingContent = { Text("List item supporting text.") },
                    leadingContent = {
                        IconButton(onClick = {}) {
                            Icon(drawableResource = Res.drawable.ic_settings, contentDescription = "Go to settings")
                        }
                    },
                    trailingContent = { Icon(drawableResource = Res.drawable.ic_chevron, contentDescription = "Go to details") },
                    style = ListItemWithLeadingButtonStyle
                )

                /* No side content -> default paddings */
                SmallElementSpacer()
                Text("No side content")
                SmallElementSpacer()
                HorizontalDivider()
                ListItem(
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("List item headline that is so long that it should wrap") },
                    supportingContent = { Text("List item supporting text") },
                )
                HorizontalDivider()
                ListItem(
                    modifier = Modifier.clickable { },
                    overlineContent = { Text(text = "Overline") },
                    headlineContent = { Text("List item headline that is so long that it should wrap") },
                )
                HorizontalDivider()
                ListItem(
                    modifier = Modifier.clickable { },
                    overlineContent = { Text(text = "Overline") },
                    headlineContent = { Text("List item headline") },
                    supportingContent = { Text("List item supporting text that is so long that it wraps to the second line. Or maybe even third line, because it really very long?") },
                )

                /* Text wrapping and non-button leading content */
                SmallElementSpacer()
                Text("Text wrapping")
                SmallElementSpacer()
                HorizontalDivider()
                ListItem(
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("List item headline that is so long that it should wrap") },
                    supportingContent = { Text("List item supporting text") },
                    leadingContent = { UserAvatar("AB") },
                )
                HorizontalDivider()
                ListItem(
                    modifier = Modifier.clickable { },
                    overlineContent = { Text(text = "Overline") },
                    headlineContent = { Text("List item headline that is so long that it should wrap") },
                    leadingContent = { UserAvatar("CD") },
                )
                HorizontalDivider()
                ListItem(
                    modifier = Modifier.clickable { },
                    overlineContent = { Text(text = "Overline") },
                    headlineContent = { Text("List item headline") },
                    supportingContent = { Text("List item supporting text that is so long that it wraps to the second line. Or maybe even third line, because it really very long?") },
                    leadingContent = { UserAvatar("EF") },
                )


                /* Material Design 3 emulation with custom ListItemStyle */
                SmallElementSpacer()
                Text("Material Design 3 emulation")
                SmallElementSpacer()
                HorizontalDivider()
                ListItem(
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("Material Design 3 version") },
                    leadingContent = { UserAvatar("AB") },
                    trailingContent = { Icon(drawableResource = Res.drawable.ic_chevron, contentDescription = "Go to details") },
                    style = MaterialDesign3ListItemStyle
                )
                HorizontalDivider()
                ListItem(
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("Material Design 3 version") },
                    supportingContent = { Text("This style mirrors M3 list item appearance. Let's check how it behaves with a very long text.") },
                    leadingContent = { UserAvatar("CD") },
                    style = MaterialDesign3ListItemStyle
                )
                HorizontalDivider()
                ListItem(
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("Material Design 3 version") },
                    supportingContent = { Text("The 3-line version is aligned to top in M3.") },
                    leadingContent = { UserAvatar("EF") },
                    overlineContent = { Text(text = "Overline") },
                    style = MaterialDesign3ListItemStyle
                )
                HorizontalDivider()
            }
        }
    }
}

object MaterialDesign3ListItemStyle : DefaultListItemStyle() {
    override val minHeight: Token<ByContentLayout<Dp>> = Token(
        ByContentLayout(
            headlineOnly = 56.dp,
            headlineWithOverline = 72.dp,
            headlineWithSupportingText = 72.dp,
            allElements = 88.dp
        )
    )
    override val contentAlignment: Token<ByContentLayout<ContentAlignment>> = Token(
        ByContentLayout(ContentAlignment.Center).copy(allElements = ContentAlignment.Top)
    )
    override val contentPadding: Token<ListItemStyle.ContentPaddingValues> = Token {
        PaddingValues(
            top = ByContentLayout(8.dp).copy(allElements = 12.dp),
            bottom = ByContentLayout(8.dp).copy(allElements = 12.dp),
            start = BySideContent(
                withSideContent = 0.dp,
                withoutSideContent = Mobius.styles.contentStyle.resolve().padding.calculateStartPadding(LocalLayoutDirection.current)
            ),
            end = BySideContent(
                withSideContent = 0.dp,
                withoutSideContent = Mobius.styles.contentStyle.resolve().padding.calculateEndPadding(LocalLayoutDirection.current)
            ),
        )
    }
    override val leadingContentAlignment: Token<ByContentLayout<ContentAlignment>> = contentAlignment
    override val leadingContentPadding: Token<ByContentLayout<PaddingValues>> = Token {
        val basePadding = PaddingValues(
            horizontal = Mobius.styles.contentStyle.resolve().padding.calculateStartPadding(LocalLayoutDirection.current),
            vertical = 8.dp
        )
        ByContentLayout(basePadding).copy(allElements = basePadding.copy(vertical = 12.dp))
    }

    override val trailingContentAlignment: Token<ByContentLayout<ContentAlignment>> = contentAlignment
    override val trailingContentPadding: Token<ByContentLayout<PaddingValues>> = Token {
        val basePadding = PaddingValues(
            horizontal = Mobius.styles.contentStyle.resolve().padding.calculateEndPadding(LocalLayoutDirection.current),
            vertical = 8.dp
        )
        ByContentLayout(basePadding).copy(allElements = basePadding.copy(vertical = 12.dp))
    }
}

@Composable
private fun UserAvatar(text: String) = Box(
    modifier = Modifier
        .clip(CircleShape)
        .size(32.dp)
        .background(Color.DarkGray),
    contentAlignment = Alignment.Center
) {
    Text(
        text = text,
        color = Color.White
    )
}

@Composable
private fun ContentScope.HorizontalDivider() = HorizontalDivider(Modifier.fillContentContainerWidth(ignorePadding = true))

private object ListItemWithLeadingButtonStyle : ListItemStyleWrapper({ Mobius.styles.listItemStyle }) {
    override val leadingContentPadding: Token<ByContentLayout<PaddingValues>> = Token(ByContentLayout(PaddingValues(8.dp)))
}
