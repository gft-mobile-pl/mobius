package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ProvideTextStyle
import com.gft.mobius.components.styles.TabStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun Tab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable (() -> Unit)? = null,
    icon: @Composable (() -> Unit)? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: TabStyle = Mobius.styles.tab
) {
    val styleValues = style.resolve()
    androidx.compose.material3.Tab(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        text = text?.let { textContent ->
            {
                ProvideTextStyle(
                    style = styleValues.textStyle.copy(textAlign = TextAlign.Center),
                    content = textContent
                )
            }
        },
        icon = icon,
        selectedContentColor = styleValues.selectedContentColor,
        unselectedContentColor = styleValues.unselectedContentColor,
        interactionSource = interactionSource
    )
}

@Composable
fun LeadingIconTab(
    selected: Boolean,
    onClick: () -> Unit,
    text: @Composable () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: TabStyle = Mobius.styles.tab
) {
    val styleValues = style.resolve()
    androidx.compose.material3.LeadingIconTab(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        text = text.let { textContent ->
            {
                ProvideTextStyle(
                    style = styleValues.textStyle.copy(textAlign = TextAlign.Center),
                    content = textContent
                )
            }
        },
        icon = icon,
        selectedContentColor = styleValues.selectedContentColor,
        unselectedContentColor = styleValues.unselectedContentColor,
        interactionSource = interactionSource
    )
}

@Composable
fun Tab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    style: TabStyle = Mobius.styles.tab,
    content: @Composable ColumnScope.() -> Unit
) {
    val styleValues = style.resolve()
    ProvideTextStyle(styleValues.textStyle) {
        androidx.compose.material3.Tab(
            selected = selected,
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            selectedContentColor = styleValues.selectedContentColor,
            unselectedContentColor = styleValues.unselectedContentColor,
            interactionSource = interactionSource,
            content = content
        )
    }
}
