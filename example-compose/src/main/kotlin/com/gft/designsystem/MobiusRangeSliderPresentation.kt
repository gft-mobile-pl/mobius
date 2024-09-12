package com.gft.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gft.mobius.components.Content
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.RangeSlider
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Slider

@Composable
fun MobiusRangeSliderPresentation() {
    Screen {
        Content {
            var rangeSliderValue by remember { mutableStateOf(0f..100f) }

            RangeSlider(
                value = rangeSliderValue,
                valueRange = 0f..100f,
                onValueChange = { value ->
                    rangeSliderValue = value
                }
            )
            ElementSpacer()

            RangeSlider(
                value = rangeSliderValue,
                valueRange = 0f..100f,
                startTooltipVisibility = Slider.TooltipVisibility.Invisible,
                endTooltipVisibility = Slider.TooltipVisibility.Invisible,
                steps = 9,
                onValueChange = { value ->
                    rangeSliderValue = value
                }
            )
            ElementSpacer()

            RangeSlider(
                value = rangeSliderValue,
                valueRange = 0f..100f,
                startTooltipVisibility = Slider.TooltipVisibility.VisibleOnInteraction { value -> "${value.toInt()}" },
                endTooltipVisibility = Slider.TooltipVisibility.VisibleOnInteraction { value -> "${value.toInt()}" },
                onValueChange = { value ->
                    rangeSliderValue = value
                }
            )
            ElementSpacer()

            RangeSlider(
                value = rangeSliderValue,
                valueRange = 0f..100f,
                track = { state ->
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(10.dp)
                            .background(Color.Blue)
                    )
                },
                startThumb = { state, interactionSource ->
                    Box(
                        Modifier
                            .size(10.dp, 30.dp)
                            .background(Color.Green)
                    )
                },
                endThumb = { state, interactionSource ->
                    Box(
                        Modifier
                            .size(10.dp, 30.dp)
                            .background(Color.Red)
                    )
                },
                onValueChange = { value ->
                    rangeSliderValue = value
                }
            )
            ElementSpacer()

            RangeSlider(
                value = rangeSliderValue,
                valueRange = 0f..100f,
                steps = 9,
                enabled = false,
                onValueChange = { value ->
                    rangeSliderValue = value
                }
            )
            ElementSpacer()

            RangeSlider(
                value = rangeSliderValue,
                valueRange = 0f..100f,
                enabled = false,
                onValueChange = { value ->
                    rangeSliderValue = value
                }
            )
        }
    }
}
