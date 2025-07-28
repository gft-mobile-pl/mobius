package com.gft.mobius.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.SliderTrackStyle
import com.gft.mobius.components.styles.SliderTrackStyleValues
import com.gft.mobius.components.styles.resolve

@Composable
fun SliderTrack(
    sliderState: SliderState,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: SliderTrackStyle = Mobius.styles.sliderTrackStyle
) {
    val styleValues = style.resolve()
    @OptIn(ExperimentalMaterial3Api::class)
    SliderDefaults.Track(
        sliderState = sliderState.state,
        modifier = modifier,
        enabled = enabled,
        colors = sliderColors(styleValues),
        thumbTrackGapSize = styleValues.thumbTrackGapSize,
        trackInsideCornerSize = styleValues.trackInsideCornerSize
    )
}

@Composable
fun SliderTrack(
    rangeSliderState: RangeSliderState,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    style: SliderTrackStyle = Mobius.styles.sliderTrackStyle
) {
    val styleValues = style.resolve()
    @OptIn(ExperimentalMaterial3Api::class)
    SliderDefaults.Track(
        rangeSliderState = rangeSliderState.state,
        modifier = modifier,
        enabled = enabled,
        colors = sliderColors(styleValues),
        thumbTrackGapSize = styleValues.thumbTrackGapSize,
        trackInsideCornerSize = styleValues.trackInsideCornerSize
    )
}

@Composable
private fun sliderColors(styleValues: SliderTrackStyleValues) = SliderDefaults.colors(
    activeTrackColor = styleValues.activeTrackColor,
    activeTickColor = styleValues.activeTickColor,
    inactiveTrackColor = styleValues.inactiveTrackColor,
    inactiveTickColor = styleValues.inactiveTickColor,
    disabledActiveTrackColor = styleValues.disabledActiveTrackColor,
    disabledActiveTickColor = styleValues.disabledActiveTickColor,
    disabledInactiveTrackColor = styleValues.disabledInactiveTrackColor,
    disabledInactiveTickColor = styleValues.disabledInactiveTickColor,
)
