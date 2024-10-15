package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconToggleButtonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.IconButtonStyle
import com.gft.mobius.components.styles.IconToggleButtonStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun IconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    style: IconButtonStyle = Mobius.styles.iconButtonStyle,
    content: @Composable () -> Unit
) {
    val styleValues = style.resolve()
    androidx.compose.material3.OutlinedIconButton(
        onClick = onClick,
        modifier = Modifier.size(styleValues.size) then modifier,
        enabled = enabled,
        colors = IconButtonColors(
            containerColor = styleValues.backgroundColor,
            contentColor = styleValues.contentColor,
            disabledContainerColor = styleValues.disabledBackgroundColor,
            disabledContentColor = styleValues.disabledContentColor
        ),
        shape = styleValues.shape,
        border = if (enabled) styleValues.border else styleValues.disabledBorder,
        interactionSource = interactionSource,
        content = {
            ProvideIconSize(styleValues.iconSize) {
                content()
            }
        }
    )
}

@Composable
fun FilledIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    style: IconButtonStyle = Mobius.styles.filledIconButtonStyle,
    content: @Composable () -> Unit
) = IconButton(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    interactionSource = interactionSource,
    style = style,
    content = content
)

@Composable
fun FilledTonalIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    style: IconButtonStyle = Mobius.styles.filledTonalIconButtonStyle,
    content: @Composable () -> Unit
) = IconButton(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    interactionSource = interactionSource,
    style = style,
    content = content
)

@Composable
fun OutlinedIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    style: IconButtonStyle = Mobius.styles.outlinedIconButtonStyle,
    content: @Composable () -> Unit
) = IconButton(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    interactionSource = interactionSource,
    style = style,
    content = content
)

@Composable
fun IconButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    style: IconToggleButtonStyle = Mobius.styles.iconToggleButtonStyle,
    content: @Composable () -> Unit
) {
    val styleValues = style.resolve()
    androidx.compose.material3.OutlinedIconToggleButton(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier.size(styleValues.size),
        enabled = enabled,
        colors = IconToggleButtonColors(
            containerColor = styleValues.backgroundColor,
            contentColor = styleValues.contentColor,
            disabledContainerColor = styleValues.disabledBackgroundColor,
            disabledContentColor = styleValues.disabledContentColor,
            checkedContainerColor = styleValues.selectedBackgroundColor,
            checkedContentColor = styleValues.selectedContentColor
        ),
        shape = styleValues.shape,
        border = when {
            !enabled -> styleValues.disabledBorder
            checked -> styleValues.selectedBorder
            else -> styleValues.border
        },
        interactionSource = interactionSource,
        content = {
            ProvideIconSize(styleValues.iconSize) {
                content()
            }
        }
    )
}

@Composable
fun FilledIconButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    style: IconToggleButtonStyle = Mobius.styles.filledIconToggleButtonStyle,
    content: @Composable () -> Unit
) = IconButton(
    checked = checked,
    onCheckedChange = onCheckedChange,
    modifier = modifier,
    enabled = enabled,
    interactionSource = interactionSource,
    style = style,
    content = content,
)

@Composable
fun FilledTonalIconButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    style: IconToggleButtonStyle = Mobius.styles.filledTonalIconToggleButtonStyle,
    content: @Composable () -> Unit
) = IconButton(
    checked = checked,
    onCheckedChange = onCheckedChange,
    modifier = modifier,
    enabled = enabled,
    interactionSource = interactionSource,
    style = style,
    content = content,
)

@Composable
fun OutlinedIconButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    style: IconToggleButtonStyle = Mobius.styles.outlinedIconToggleButtonStyle,
    content: @Composable () -> Unit
) = IconButton(
    checked = checked,
    onCheckedChange = onCheckedChange,
    modifier = modifier,
    enabled = enabled,
    interactionSource = interactionSource,
    style = style,
    content = content,
)
