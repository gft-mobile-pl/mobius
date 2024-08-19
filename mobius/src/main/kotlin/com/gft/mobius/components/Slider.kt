package com.gft.mobius.components

import androidx.annotation.IntRange
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun Slider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    tooltipVisibility: Slider.TooltipVisibility = Slider.TooltipVisibility.Visible(),
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    @IntRange(from = 0) steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
    interactionSource: MutableInteractionSource? = null,
) {
    @Suppress("NAME_SHADOWING")
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    val tooltipFormatter = when(tooltipVisibility) {
        is Slider.TooltipVisibility.Visible -> tooltipVisibility.formatter
        else -> null
    }
    @OptIn(ExperimentalMaterial3Api::class)
    androidx.compose.material3.Slider(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        steps = steps,
        onValueChangeFinished = onValueChangeFinished,
        colors = SliderDefaults.colors(),
        interactionSource = interactionSource,
        thumb = { state ->
            SliderThumb(
                tooltip = tooltipFormatter?.invoke(state.value),
                enabled = enabled,
                interactionSource = interactionSource
            )
        },
        track = { state ->
            SliderTrack(
                sliderState = SliderState(state),
                enabled = enabled,
            )
        }
    )
}

@Suppress("NAME_SHADOWING")
@Composable
fun Slider(
    value: Float,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    valueRange: ClosedFloatingPointRange<Float> = 0f..1f,
    @IntRange(from = 0) steps: Int = 0,
    onValueChangeFinished: (() -> Unit)? = null,
    thumb: @Composable (SliderState, MutableInteractionSource) -> Unit = { sliderState, interactionSource ->
        SliderThumb(
            tooltip = Slider.TooltipVisibility.Visible().formatter(sliderState.value),
            enabled = enabled,
            interactionSource = interactionSource
        )
    },
    track: @Composable (SliderState) -> Unit = { sliderState ->
        SliderTrack(
            sliderState = sliderState,
            enabled = enabled
        )
    },
    interactionSource: MutableInteractionSource? = null,
) {
    @Suppress("NAME_SHADOWING")
    val interactionSource = interactionSource ?: remember { MutableInteractionSource() }
    @OptIn(ExperimentalMaterial3Api::class)
    androidx.compose.material3.Slider(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        enabled = enabled,
        valueRange = valueRange,
        steps = steps,
        onValueChangeFinished = onValueChangeFinished,
        colors = SliderDefaults.colors(),
        interactionSource = interactionSource,
        thumb = { state -> thumb(SliderState(state), interactionSource) },
        track = { state -> track(SliderState(state)) }
    )
}

@Stable
class SliderState(
    @OptIn(ExperimentalMaterial3Api::class)
    internal val state: androidx.compose.material3.SliderState,
) {
    val value: Float
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.value
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

interface Slider {
    @Stable
    sealed interface TooltipVisibility {
        data object Invisible : TooltipVisibility
        data class Visible(val formatter: (Float) -> String = { sliderValue -> "%.2f".format(sliderValue) }) : TooltipVisibility
    }
}
