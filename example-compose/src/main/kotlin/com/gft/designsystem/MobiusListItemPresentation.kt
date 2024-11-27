package com.gft.designsystem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Header
import com.gft.mobius.components.Icon
import com.gft.mobius.components.ListItem
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Text
import com.gft.mobius.components.TopAppBar
import com.gft.mobius.components.styles.DefaultListItemStyle
import com.gft.mobius.components.styles.ListItemStyle.SideContentAlignment
import com.gft.mobius.components.styles.ListItemStyle.SideContentVerticalAlignment

@Composable
fun MobiusListItemPresentation() {
    Mobius {
        Screen {
            Header {
                TopAppBar(title = { Text(text = "List item presentation") })
            }
            Column {
                ListItem(
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("List item headline") },
                    leadingContent = { Icon(R.drawable.ic_settings, contentDescription = "Localized description") },
                    trailingContent = { Icon(R.drawable.ic_home, contentDescription = "Localized description") },
                )
                ListItem(
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("List item headline") },
                    supportingContent = { Text("List item supporting text") },
                    leadingContent = { Icon(R.drawable.ic_settings, contentDescription = "Localized description") },
                    trailingContent = { Icon(R.drawable.ic_home, contentDescription = "Localized description") },
                )
                ListItem(
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("List item headline that is so long that it should wrap") },
                    supportingContent = { Text("List item supporting text") },
                    leadingContent = { Icon(R.drawable.ic_settings, contentDescription = "Localized description") },
                    trailingContent = { Icon(R.drawable.ic_home, contentDescription = "Localized description") },
                )
                ListItem(
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("List item headline") },
                    overlineContent = { Text(text = "Overline") },
                    leadingContent = { Icon(R.drawable.ic_settings, contentDescription = "Localized description") },
                    trailingContent = { Icon(R.drawable.ic_home, contentDescription = "Localized description") },
                )
                ListItem(
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("List item headline that is so long that it should wrap") },
                    overlineContent = { Text(text = "Overline") },
                    leadingContent = { Icon(R.drawable.ic_settings, contentDescription = "Localized description") },
                    trailingContent = { Icon(R.drawable.ic_home, contentDescription = "Localized description") },
                )
                ListItem(
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("List item headline") },
                    supportingContent = { Text("List item supporting text that is so long that it wraps to the second line. Or maybe even third line?") },
                    leadingContent = { Icon(R.drawable.ic_settings, contentDescription = "Localized description") },
                    overlineContent = { Text(text = "Overline") }
                )
                ListItem(
                    style = TrailingCenteredListItemStyle,
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("List item headline") },
                    supportingContent = { Text("List item supporting text") },
                    overlineContent = { Text(text = "Overline") },
                    leadingContent = { Icon(R.drawable.ic_settings, contentDescription = "Localized description") },
                    trailingContent = { Icon(R.drawable.ic_chevron, contentDescription = "Localized description") },
                )
                ListItem(
                    style = TrailingBottomListItemStyle,
                    modifier = Modifier.clickable { },
                    headlineContent = { Text("List item headline") },
                    supportingContent = { Text("List item supporting text") },
                    overlineContent = { Text(text = "Overline") },
                    leadingContent = { Icon(R.drawable.ic_settings, contentDescription = "Localized description") },
                    trailingContent = { Icon(R.drawable.ic_chevron, contentDescription = "Localized description") },
                )
            }
        }
    }
}

object TrailingCenteredListItemStyle : DefaultListItemStyle() {
    override val trailingContentAlignment = Token {
        SideContentAlignment(
            headlineOnly = SideContentVerticalAlignment.Center,
            headlineWithOverline = SideContentVerticalAlignment.Center,
            headlineWithSupportingText = SideContentVerticalAlignment.Center,
            allElements = SideContentVerticalAlignment.Center
        )
    }
}

object TrailingBottomListItemStyle : DefaultListItemStyle() {
    override val trailingContentAlignment = Token {
        SideContentAlignment(
            headlineOnly = SideContentVerticalAlignment.Bottom(0.dp),
            headlineWithOverline = SideContentVerticalAlignment.Bottom(0.dp),
            headlineWithSupportingText = SideContentVerticalAlignment.Bottom(0.dp),
            allElements = SideContentVerticalAlignment.Bottom(10.dp)
        )
    }
}
