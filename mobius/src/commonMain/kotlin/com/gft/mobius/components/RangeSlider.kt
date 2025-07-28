package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun RangeSlider(
    value: ClosedFloatingPointRange<Float>,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    startTooltipVisibility: Slider.TooltipVisibility = Slider.TooltipVisibility.Default,
    endTooltipVisibility: Slider.TooltipVisibility = Slider.TooltipVisibility.Default,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
    rangeStartInputInteractionSource: MutableInteractionSource? = null,
    rangeEndInputInteractionSource: MutableInteractionSource? = null,
) {
    if (steps < 0) {
        throw IllegalArgumentException("'steps' parameter must be greater than or equal to 0.")
    }

    @Suppress("NAME_SHADOWING")
    val rangeStartInputInteractionSource = rangeStartInputInteractionSource ?: remember { MutableInteractionSource() }
    @Suppress("NAME_SHADOWING")
    val rangeEndInputInteractionSource = rangeEndInputInteractionSource ?: remember { MutableInteractionSource() }

    val startTooltipFormatter = startTooltipVisibility.resolveFormatter()
    val endTooltipFormatter = endTooltipVisibility.resolveFormatter()

    @OptIn(ExperimentalMaterial3Api::class)
    androidx.compose.material3.RangeSlider(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        onValueChangeFinished = onValueChangeFinished,
        colors = SliderDefaults.colors(),
        startInteractionSource = rangeStartInputInteractionSource,
        endInteractionSource = rangeEndInputInteractionSource,
        startThumb = { state ->
            SliderThumb(
                tooltip = startTooltipFormatter?.invoke(state.activeRangeStart),
                enabled = enabled,
                interactionSource = rangeStartInputInteractionSource
            )
        },
        endThumb = { state ->
            SliderThumb(
                tooltip = endTooltipFormatter?.invoke(state.activeRangeEnd),
                enabled = enabled,
                interactionSource = rangeEndInputInteractionSource
            )
        },
        track = { state ->
            SliderTrack(
                rangeSliderState = RangeSliderState(state),
                enabled = enabled
            )
        },
        steps = steps
    )
}

@Composable
fun RangeSlider(
    value: ClosedFloatingPointRange<Float>,
    onValueChange: (ClosedFloatingPointRange<Float>) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
    startThumb: @Composable (RangeSliderState, MutableInteractionSource) -> Unit = { state, interactionSource ->
        SliderThumb(
            tooltip = Slider.TooltipVisibility.Default.formatter(state.activeRangeStart),
            enabled = enabled,
            interactionSource = interactionSource
        )
    },
    endThumb: @Composable (RangeSliderState, MutableInteractionSource) -> Unit = { state, interactionSource ->
        SliderThumb(
            tooltip = Slider.TooltipVisibility.Default.formatter(state.activeRangeEnd),
            enabled = enabled,
            interactionSource = interactionSource
        )
    },
    track: @Composable (RangeSliderState) -> Unit = { state ->
        SliderTrack(
            rangeSliderState = state,
            enabled = enabled
        )
    },
    rangeStartInputInteractionSource: MutableInteractionSource? = null,
    rangeEndInputInteractionSource: MutableInteractionSource? = null,
) {
    if (steps < 0) {
        throw IllegalArgumentException("'steps' parameter must be greater than or equal to 0.")
    }

    @Suppress("NAME_SHADOWING")
    val rangeStartInputInteractionSource = rangeStartInputInteractionSource ?: remember { MutableInteractionSource() }
    @Suppress("NAME_SHADOWING")
    val rangeEndInputInteractionSource = rangeEndInputInteractionSource ?: remember { MutableInteractionSource() }

    @OptIn(ExperimentalMaterial3Api::class)
    androidx.compose.material3.RangeSlider(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        steps = steps,
        onValueChangeFinished = onValueChangeFinished,
        colors = SliderDefaults.colors(),
        startInteractionSource = rangeStartInputInteractionSource,
        endInteractionSource = rangeEndInputInteractionSource,
        startThumb = { state -> startThumb(RangeSliderState(state), rangeStartInputInteractionSource) },
        endThumb = { state -> endThumb(RangeSliderState(state), rangeEndInputInteractionSource) },
        track = { state -> track(RangeSliderState(state)) }
    )
}

@Stable
class RangeSliderState(
    @OptIn(ExperimentalMaterial3Api::class)
    internal val state: androidx.compose.material3.RangeSliderState
) {
    val activeRangeStart: Float
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.activeRangeStart
        }

    val activeRangeEnd: Float
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.activeRangeEnd
        }

    val steps: Int
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.steps
        }

    val valueRange: ClosedFloatingPointRange<Float>
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.valueRange
        }
}
