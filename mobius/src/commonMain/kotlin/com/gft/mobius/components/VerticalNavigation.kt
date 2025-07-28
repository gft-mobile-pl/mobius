package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import com.gft.mobius.Mobius
import com.gft.mobius.components.common.resolveHorizontalAlignment
import com.gft.mobius.components.common.resolveVerticalArrangement
import com.gft.mobius.components.styles.ProvideTextStyle
import com.gft.mobius.components.styles.VerticalNavigationItemStyle
import com.gft.mobius.components.styles.VerticalNavigationStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun VerticalNavigation(
    modifier: Modifier = Modifier,
    style: VerticalNavigationStyle = Mobius.styles.verticalNavigationStyle,
    content: @Composable VerticalNavigationScope.() -> Unit
) {
    val styleValues = style.resolve()
    ContentBuilder(
        modifier = modifier,
        scrollState = null,
        styleValues = styleValues
    ) { contentModifier ->
        Column(
            modifier = Modifier
                .clip(styleValues.shape)
                .fillMaxSize()
                .then(contentModifier),
            verticalArrangement = styleValues.contentAlignment.resolveVerticalArrangement(),
            horizontalAlignment = styleValues.contentAlignment.resolveHorizontalAlignment()
        ) {
            VerticalNavigationScope(this).content()
        }
    }
}

interface VerticalNavigationScope

private fun VerticalNavigationScope(columnScope: ColumnScope) = object : VerticalNavigationScope, ColumnScope by columnScope {}

@Suppress("UnusedReceiverParameter")
@Composable
fun VerticalNavigationScope.Item(
    label: @Composable () -> Unit,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: (@Composable () -> Unit)? = null,
    badge: (@Composable () -> Unit)? = null,
    style: VerticalNavigationItemStyle = Mobius.styles.verticalNavigationItemStyle,
    interactionSource: MutableInteractionSource? = null
) {
    val styleValues = style.resolve()
    androidx.compose.material3.NavigationDrawerItem(
        label = {
            ProvideTextStyle(styleValues.labelTextStyle) {
                label()
            }
        },
        selected = selected,
        onClick = onClick,
        modifier = modifier.padding(styleValues.padding),
        icon = icon,
        badge = badge?.let {
            {
                ProvideTextStyle(styleValues.badgeTextStyle) {
                    badge()
                }
            }
        },
        shape = styleValues.shape,
        colors = NavigationDrawerItemDefaults.colors(
            selectedIconColor = styleValues.selectedIconColor,
            unselectedIconColor = styleValues.iconColor,
            selectedTextColor = styleValues.selectedLabelColor,
            unselectedTextColor = styleValues.labelColor,
            selectedContainerColor = styleValues.selectedBackgroundColor,
            unselectedContainerColor = styleValues.backgroundColor,
            selectedBadgeColor = styleValues.selectedBadgeColor,
            unselectedBadgeColor = styleValues.badgeColor
        ),
        interactionSource = interactionSource
    )
}
