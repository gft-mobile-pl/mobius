package com.gft.mobius.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MenuItemColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.window.PopupProperties
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.DropdownMenuItemStyle
import com.gft.mobius.components.styles.DropdownMenuStyle
import com.gft.mobius.components.styles.ProvideTextStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun DropdownMenu(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
    offset: DpOffset = DpOffset.Zero,
    scrollState: ScrollState = rememberScrollState(),
    popupProperties: PopupProperties = DropdownMenu.DefaultPopupProperties,
    style: DropdownMenuStyle = Mobius.styles.dropdownMenuStyle,
    content: @Composable DropdownMenuScope.() -> Unit
) {
    val styleValues = style.resolve()
    androidx.compose.material3.DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        modifier = modifier,
        offset = offset,
        scrollState = scrollState,
        properties = popupProperties,
        containerColor = styleValues.backgroundColor,
        tonalElevation = styleValues.tonalElevation,
        shadowElevation = styleValues.shadowElevation,
        border = styleValues.border,
        content = { DropdownMenuScope(this).content() }
    )
}

@Suppress("UnusedReceiverParameter")
@Composable
fun DropdownMenuScope.DropdownMenuItem(
    text: @Composable () -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    style: DropdownMenuItemStyle = Mobius.styles.dropdownMenuItemStyle
) {
    val styleValues = style.resolve()
    androidx.compose.material3.DropdownMenuItem(
        text = {
            ProvideTextStyle(
                style = styleValues.textStyle,
                content = text
            )
        },
        onClick = onClick,
        modifier = modifier,
        leadingIcon = leadingIcon?.let {
            {
                ProvideIconSize(
                    value = styleValues.leadingIconSize,
                    content = leadingIcon
                )
            }
        },
        trailingIcon = trailingIcon?.let {
            {
                ProvideIconSize(
                    value = styleValues.trailingIconSize,
                    content = trailingIcon
                )
            }
        },
        enabled = enabled,
        colors = MenuItemColors(
            textColor = styleValues.textColor,
            leadingIconColor = styleValues.leadingIconColor,
            trailingIconColor = styleValues.trailingIconColor,
            disabledTextColor = styleValues.disabledTextColor,
            disabledLeadingIconColor = styleValues.disabledLeadingIconColor,
            disabledTrailingIconColor = styleValues.disabledTrailingIconColor,
        ),
        contentPadding = styleValues.padding,
        interactionSource = interactionSource
    )
}

object DropdownMenu {
    val DefaultPopupProperties = PopupProperties(focusable = true)
}

interface DropdownMenuScope

private fun DropdownMenuScope(columnScope: ColumnScope) = object : DropdownMenuScope, ColumnScope by columnScope {}
