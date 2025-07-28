package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.NavigationBarItemStyle
import com.gft.mobius.components.styles.NavigationBarItemStyle.LabelVisibility.Always
import com.gft.mobius.components.styles.ProvideTextStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun NavigationBarScope.NavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    interactionSource: MutableInteractionSource? = null,
    style: NavigationBarItemStyle = Mobius.styles.navigationBarItemStyle
) {
    val styleValues = style.resolve()
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = icon,
        modifier = modifier,
        enabled = enabled,
        label = label?.let {
            {
                ProvideTextStyle(styleValues.textStyle) {
                    label()
                }
            }
        },
        alwaysShowLabel = styleValues.labelVisibility == Always,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = styleValues.selectedIconColor,
            selectedTextColor = styleValues.selectedTextColor,
            indicatorColor = styleValues.indicatorColor,
            unselectedIconColor = styleValues.unselectedIconColor,
            unselectedTextColor = styleValues.unselectedTextColor,
            disabledIconColor = styleValues.disabledIconColor,
            disabledTextColor = styleValues.disabledTextColor
        ),
        interactionSource = interactionSource
    )
}
