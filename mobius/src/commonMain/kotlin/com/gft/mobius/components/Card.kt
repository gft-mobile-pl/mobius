package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.CardStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun Card(
    modifier: Modifier = Modifier,
    style: CardStyle = Mobius.styles.cardStyle,
    content: @Composable ColumnScope.() -> Unit,
) {
    val styleValues = style.resolve()
    androidx.compose.material3.Card(
        modifier = modifier,
        shape = styleValues.shape,
        colors = CardColors(
            containerColor = styleValues.containerColor,
            contentColor = styleValues.contentColor,
            disabledContainerColor = styleValues.disabledContainerColor,
            disabledContentColor = styleValues.disabledContentColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = styleValues.defaultElevation,
            pressedElevation = styleValues.pressedElevation,
            focusedElevation = styleValues.focusedElevation,
            hoveredElevation = styleValues.hoveredElevation,
            draggedElevation = styleValues.draggedElevation,
            disabledElevation = styleValues.disabledElevation
        ),
        border = styleValues.border,
        content = content
    )
}

@Composable
fun Card(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    style: CardStyle = Mobius.styles.cardStyle,
    content: @Composable ColumnScope.() -> Unit,
) {
    val styleValues = style.resolve()
    androidx.compose.material3.Card(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = styleValues.shape,
        colors = CardColors(
            containerColor = styleValues.containerColor,
            contentColor = styleValues.contentColor,
            disabledContainerColor = styleValues.disabledContainerColor,
            disabledContentColor = styleValues.disabledContentColor
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = styleValues.defaultElevation,
            pressedElevation = styleValues.pressedElevation,
            focusedElevation = styleValues.focusedElevation,
            hoveredElevation = styleValues.hoveredElevation,
            draggedElevation = styleValues.draggedElevation,
            disabledElevation = styleValues.disabledElevation
        ),
        border = if (enabled) styleValues.border else styleValues.disabledBorder,
        interactionSource = interactionSource,
        content = content
    )
}

@Composable
fun OutlinedCard(
    modifier: Modifier = Modifier,
    style: CardStyle = Mobius.styles.outlinedCardStyle,
    content: @Composable ColumnScope.() -> Unit,
) = Card(modifier, style, content)

@Composable
fun OutlinedCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    style: CardStyle = Mobius.styles.outlinedCardStyle,
    content: @Composable ColumnScope.() -> Unit,
) = Card(onClick, modifier, enabled, interactionSource, style, content)

@Composable
fun ElevatedCard(
    modifier: Modifier = Modifier,
    style: CardStyle = Mobius.styles.elevatedCardStyle,
    content: @Composable ColumnScope.() -> Unit,
) = Card(modifier, style, content)

@Composable
fun ElevatedCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource? = null,
    style: CardStyle = Mobius.styles.elevatedCardStyle,
    content: @Composable ColumnScope.() -> Unit,
) = Card(onClick, modifier, enabled, interactionSource, style, content)