package com.gft.mobius.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RichTooltip
import androidx.compose.material3.RichTooltipColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.InfoBoxStyle
import com.gft.mobius.components.styles.InfoBoxStyleValues
import com.gft.mobius.components.styles.ProvideTextStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun InfoBoxScope.InfoBox(
    modifier: Modifier = Modifier,
    title: String? = null,
    message: String,
    buttons: List<InfoBoxButton>? = null,
    style: InfoBoxStyle = Mobius.styles.infoBoxStyle
) {
    val styleValues = style.resolve()
    val buttonStyle = style.buttonsStyle.resolve()
    InfoBox(
        modifier = modifier,
        title = title?.let { { Text(text = title) } },
        message = {
            Text(text = message)
        },
        actions = {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = styleValues.buttonsArrangement
            ) {
                buttons?.forEach { action ->
                    TextButton(onClick = action.onClick, style = buttonStyle) {
                        Text(text = action.label)
                    }
                }
            }
        },
        styleValues = styleValues,
    )
}

@Composable
fun InfoBoxScope.InfoBox(
    modifier: Modifier = Modifier,
    style: InfoBoxStyle = Mobius.styles.infoBoxStyle,
    content: @Composable () -> Unit,
) {
    val styleValues = style.resolve()
    InfoBox(
        modifier = modifier,
        message = content,
        styleValues = styleValues,
    )
}

@Composable
private fun InfoBoxScope.InfoBox(
    modifier: Modifier = Modifier,
    title: (@Composable () -> Unit)? = null,
    message: @Composable () -> Unit,
    actions: (@Composable () -> Unit)? = null,
    styleValues: InfoBoxStyleValues,
) {
    @OptIn(ExperimentalMaterial3Api::class)
    with(scope) {
        RichTooltip(
            modifier = modifier,
            shape = styleValues.shape,
            caretSize = styleValues.pointerSize,
            colors = RichTooltipColors(
                containerColor = styleValues.containerColor,
                contentColor = styleValues.contentColor,
                titleContentColor = styleValues.titleContentColor,
                actionContentColor = styleValues.buttonsContentColor,
            ),
            shadowElevation = styleValues.shadowElevation,
            tonalElevation = styleValues.tonalElevation,
            title = title?.let {
                {
                    ProvideTextStyle(style = styleValues.titleTextStyle) {
                        title()
                    }
                }
            },
            text = {
                ProvideTextStyle(style = styleValues.contentTextStyle) {
                    message()
                }
            },
            action = actions
        )
    }
}

data class InfoBoxButton(
    val label: String,
    val onClick: () -> Unit
)
