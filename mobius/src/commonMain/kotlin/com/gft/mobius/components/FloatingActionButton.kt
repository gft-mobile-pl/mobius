package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.FloatingActionButtonStyle
import com.gft.mobius.components.styles.ProvideTextStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun FloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    interactionSource: MutableInteractionSource? = null,
    style: FloatingActionButtonStyle = Mobius.styles.floatingActionButtonStyle,
    text: (@Composable () -> Unit)? = null,
    expanded: Boolean = text != null,
    icon: @Composable () -> Unit
) {
    val styleValues = style.resolve()
    androidx.compose.material3.ExtendedFloatingActionButton(
        onClick = onClick,
        modifier = wrapper.sizeIn(
            minWidth = styleValues.collapsedWidth,
            minHeight = styleValues.height,
            maxWidth = if (text != null) Dp.Unspecified else styleValues.collapsedWidth
        ) then modifier,
        shape = styleValues.shape,
        containerColor = styleValues.backgroundColor,
        contentColor = styleValues.contentColor,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = styleValues.defaultElevation,
            pressedElevation = styleValues.pressedElevation,
            focusedElevation = styleValues.focusedElevation,
            hoveredElevation = styleValues.hoveredElevation,
        ),
        interactionSource = interactionSource,
        expanded = expanded,
        icon = {
            ProvideIconSize(styleValues.iconSize){
                icon()
            }
        },
        text = {
            if (text != null) {
                ProvideTextStyle(styleValues.textStyle) {
                    text()
                }
            }
        }
    )
}

@Suppress("UnusedReceiverParameter")
@Composable
fun BottomAppBarFloatingActionButtonScope.FloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    interactionSource: MutableInteractionSource? = null,
    style: FloatingActionButtonStyle = Mobius.styles.bottomAppBarFloatingActionButtonStyle,
    text: (@Composable () -> Unit)? = null,
    expanded: Boolean = text != null,
    icon: @Composable () -> Unit
) {
    com.gft.mobius.components.FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        wrapper = wrapper,
        interactionSource = interactionSource,
        style = style,
        text = text,
        expanded = expanded,
        icon = icon,
    )
}
