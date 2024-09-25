package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.NavigationRailItemStyle
import com.gft.mobius.components.styles.NavigationRailItemStyle.LabelVisibility.Always
import com.gft.mobius.components.styles.ProvideTextStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun NavigationRailScope.NavigationRailItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    interactionSource: MutableInteractionSource? = null,
    style: NavigationRailItemStyle = Mobius.styles.navigationRailItemStyle
) {
    val styleValues = style.resolve()
    androidx.compose.material3.NavigationRailItem(
        selected = selected,
        onClick = onClick,
        icon = {
            ProvideIconSize(styleValues.iconSize) {
                icon()
            }
        },
        modifier = modifier,
        enabled = enabled,
        label = label?.let {
            {
                ProvideTextStyle(styleValues.labelTextStyle) {
                    label()
                }
            }
        },
        alwaysShowLabel = styleValues.labelVisibility == Always,
        colors = NavigationRailItemDefaults.colors(
            selectedIconColor = styleValues.selectedIconColor,
            selectedTextColor = styleValues.selectedLabelColor,
            indicatorColor = styleValues.indicatorColor,
            unselectedIconColor = styleValues.iconColor,
            unselectedTextColor = styleValues.labelColor,
            disabledIconColor = styleValues.disabledIconColor,
            disabledTextColor = styleValues.disabledLabelColor
        ),
        interactionSource = interactionSource
    )
}
