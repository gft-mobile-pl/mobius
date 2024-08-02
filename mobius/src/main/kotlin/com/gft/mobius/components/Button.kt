package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.isSpecified
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ButtonStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: ButtonStyle = Mobius.styles.buttonStyle,
    content: @Composable RowScope.() -> Unit,
) {
    val styleValues = style.resolve()
    val contentColor = if (enabled) styleValues.contentColor else styleValues.disabledContentColor
    androidx.compose.material3.Button(
        onClick = onClick,
        modifier = modifier.then(Modifier.height(styleValues.height)),
        enabled = enabled,
        shape = styleValues.shape,
        colors = ButtonColors(
            containerColor = styleValues.containerColor,
            contentColor = styleValues.rippleColor,
            disabledContentColor = styleValues.disabledContentColor,
            disabledContainerColor = styleValues.disabledContainerColor
        ),
        elevation = createButtonElevationConfig(
            defaultElevation = styleValues.defaultElevation,
            pressedElevation = styleValues.pressedElevation,
            focusedElevation = styleValues.focusedElevation,
            hoveredElevation = styleValues.hoveredElevation,
            disabledElevation = styleValues.disabledElevation
        ),
        border = styleValues.border,
        contentPadding = styleValues.contentPadding,
        interactionSource = interactionSource,
    ) {
        CompositionLocalProvider(
            LocalContentColor provides contentColor,
            LocalTextStyle provides styleValues.textStyle,
            LocalIconSize provides styleValues.iconSize
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(
                    space = styleValues.contentElementsSpacing,
                    alignment = Alignment.CenterHorizontally
                ),
                verticalAlignment = Alignment.CenterVertically,
                content = content
            )
        }
    }
}

@Composable
fun OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: ButtonStyle = Mobius.styles.outlinedButtonStyle,
    content: @Composable RowScope.() -> Unit,
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    interactionSource = interactionSource,
    style = style,
    content = content
)

@Composable
fun ElevatedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: ButtonStyle = Mobius.styles.elevatedButtonStyle,
    content: @Composable RowScope.() -> Unit,
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    interactionSource = interactionSource,
    style = style,
    content = content
)

@Composable
fun FilledTonalButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: ButtonStyle = Mobius.styles.filledTonalButtonStyle,
    content: @Composable RowScope.() -> Unit,
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    interactionSource = interactionSource,
    style = style,
    content = content
)

@Composable
fun TextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: ButtonStyle = Mobius.styles.textButtonStyle,
    content: @Composable RowScope.() -> Unit,
) = Button(
    onClick = onClick,
    modifier = modifier,
    enabled = enabled,
    interactionSource = interactionSource,
    style = style,
    content = content
)


@Composable
private fun createButtonElevationConfig(
    defaultElevation: Dp,
    pressedElevation: Dp,
    focusedElevation: Dp,
    hoveredElevation: Dp,
    disabledElevation: Dp,
): ButtonElevation? = if (
    defaultElevation.isSpecified
    && pressedElevation.isSpecified
    && focusedElevation.isSpecified
    && hoveredElevation.isSpecified
    && disabledElevation.isSpecified
) {
    ButtonDefaults.buttonElevation(
        defaultElevation = defaultElevation,
        pressedElevation = pressedElevation,
        focusedElevation = focusedElevation,
        hoveredElevation = hoveredElevation,
        disabledElevation = disabledElevation
    )
} else null
