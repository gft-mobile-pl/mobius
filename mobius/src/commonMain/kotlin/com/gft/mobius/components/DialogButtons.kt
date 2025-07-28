package com.gft.mobius.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import com.gft.compose.common.modifyIf
import com.gft.mobius.Mobius
import com.gft.mobius.components.common.MainLayoutPass
import com.gft.mobius.components.common.ReverseLayoutConditionally
import com.gft.mobius.components.common.isInMainLayoutPass
import com.gft.mobius.components.common.reverse
import com.gft.mobius.components.styles.DialogButtonsStyle
import com.gft.mobius.components.styles.DialogButtonsStyle.ButtonsLayout
import com.gft.mobius.components.styles.DialogButtonsStyle.ButtonsLayout.ButtonWidth
import com.gft.mobius.components.styles.DialogButtonsStyleValues
import com.gft.mobius.components.styles.resolve
import kotlin.math.max
import kotlin.math.min

private object FindWidestButtonLayoutPhase

@Composable
fun DialogScreenContentFooterScope.DialogButtons(
    modifier: Modifier = Modifier,
    style: DialogButtonsStyle = Mobius.styles.dialogButtonsStyle,
    buttons: @Composable () -> Unit,
) = DialogButtonsImplementation(
    modifier = modifier,
    style = style,
    buttons = buttons
)

@Composable
fun DialogScreenFooterScope.DialogButtons(
    modifier: Modifier = Modifier,
    style: DialogButtonsStyle = Mobius.styles.dialogButtonsStyle,
    buttons: @Composable () -> Unit,
) = DialogButtonsImplementation(
    modifier = modifier,
    style = style,
    buttons = buttons
)

@Composable
private fun FooterScope.DialogButtonsImplementation(
    modifier: Modifier,
    style: DialogButtonsStyle,
    buttons: @Composable () -> Unit,
) {
    val styleValues = style.resolve()
    when (val buttonsLayout = styleValues.buttonsLayout) {
        is ButtonsLayout.Column -> {
            ButtonsColumn(
                modifier = modifier,
                styleValues = styleValues,
                buttonsLayout = buttonsLayout,
                buttons = buttons
            )
        }

        is ButtonsLayout.HorizontalFlow -> {
            ButtonsFlow(
                modifier = modifier,
                styleValues = styleValues,
                buttonsLayout = buttonsLayout,
                buttons = buttons
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun FooterScope.ButtonsFlow(
    modifier: Modifier,
    styleValues: DialogButtonsStyleValues,
    buttonsLayout: ButtonsLayout.HorizontalFlow,
    buttons: @Composable () -> Unit,
) {
    ReverseLayoutConditionally(buttonsLayout.reverseButtonsOrder) {
        FlowRow(
            modifier = Modifier
                .fillFooterWidth()
                .modifyIf(styleValues.background != null) {
                    background(styleValues.background!!)
                }
                .padding(styleValues.padding)
                .then(modifier),
            verticalArrangement = Arrangement.spacedBy(buttonsLayout.verticalSpacing),
            horizontalArrangement = Arrangement.spacedBy(
                space = buttonsLayout.horizontalSpacing,
                alignment = if (buttonsLayout.reverseButtonsOrder) buttonsLayout.horizontalAlignment.reverse() else buttonsLayout.horizontalAlignment
            )
        ) {
            ReverseLayoutConditionally(buttonsLayout.reverseButtonsOrder) {
                buttons()
            }
        }
    }
}

@Composable
private fun FooterScope.ButtonsColumn(
    modifier: Modifier,
    styleValues: DialogButtonsStyleValues,
    buttonsLayout: ButtonsLayout.Column,
    buttons: @Composable () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillFooterWidth()
            .modifyIf(styleValues.background != null) {
                background(styleValues.background!!)
            }
            .padding(styleValues.padding)
            .then(modifier),
        verticalArrangement = buttonsLayout.verticalArrangement,
        horizontalAlignment = buttonsLayout.horizontalAlignment
    ) {
        when (buttonsLayout.buttonWidth) {
            ButtonWidth.Default -> {
                buttons()
            }

            is ButtonWidth.Fixed, ButtonWidth.Max -> {
                FixedOrMaxWidthButtonsLayout(
                    spacing = buttonsLayout.verticalArrangement.spacing,
                    buttonWidth = buttonsLayout.buttonWidth,
                    buttons = buttons
                )
            }

            ButtonWidth.MatchOtherButtons -> {
                MatchOtherButtonsLayout(
                    spacing = buttonsLayout.verticalArrangement.spacing,
                    buttonWidth = buttonsLayout.buttonWidth,
                    buttons = buttons
                )
            }
        }
    }
}

@Composable
private fun MatchOtherButtonsLayout(
    spacing: Dp,
    buttonWidth: ButtonWidth,
    isInMainLayoutPass: Boolean = isInMainLayoutPass(),
    buttons: @Composable () -> Unit,
) {
    SubcomposeLayout { constraints ->
        val spacingInPx = spacing.roundToPx()
        val size: IntSize =
            subcompose(FindWidestButtonLayoutPhase, buttons).fold(initial = IntSize.Zero) { currentSize, measurable ->
                val placeable = measurable.measure(constraints)
                IntSize(
                    width = max(currentSize.width, placeable.width),
                    height = currentSize.height + placeable.height + min(spacingInPx, currentSize.height)
                )
            }
        val adjustedConstraints = constraints.copy(
            minWidth = size.width
        )
        val placeables = subcompose(MainLayoutPass, buttons).map { measurable ->
            measurable.measure(adjustedConstraints)
        }

        layout(size.width, size.height) {
            var yPosition = 0
            placeables.forEach { placeable ->
                placeable.placeRelative(0, yPosition)
                yPosition += placeable.height + spacingInPx
            }
        }
    }
}


@Composable
private fun FixedOrMaxWidthButtonsLayout(
    spacing: Dp,
    buttonWidth: ButtonWidth,
    isInMainLayoutPass: Boolean = isInMainLayoutPass(),
    buttons: @Composable () -> Unit,
) {
    Layout(buttons) { measurables, constraints ->
        var height = 0
        var width = 0
        val spacingInPx = spacing.roundToPx()

        val adjustedConstraints = when (buttonWidth) {
            is ButtonWidth.Fixed -> constraints.copy(
                minWidth = min(
                    constraints.maxWidth,
                    max(constraints.minWidth, buttonWidth.width.roundToPx())
                ),
                maxWidth = min(constraints.maxWidth, buttonWidth.width.roundToPx()),
            )

            ButtonWidth.Max -> constraints.copy(
                minWidth = if (isInMainLayoutPass) constraints.maxWidth else 0
            )

            else -> throw IllegalStateException()
        }

        val placeables = measurables.map { button ->
            val placeable = button.measure(adjustedConstraints)
            height += placeable.height + spacingInPx
            width = max(placeable.width, width)
            placeable
        }

        if (height > 0) height -= spacingInPx
        layout(width, height) {
            var yPosition = 0
            placeables.forEach { placeable ->
                placeable.placeRelative(x = 0, y = yPosition)
                yPosition += placeable.height + spacingInPx
            }
        }
    }
}
