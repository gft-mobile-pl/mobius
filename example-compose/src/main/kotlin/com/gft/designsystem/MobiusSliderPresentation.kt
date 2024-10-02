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
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.Content
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Slider

@Composable
fun MobiusSliderPresentation() {
    Screen {
        Content(
            isScrollable = false
        ) {
            var sliderValue by remember { mutableStateOf(0f) }
            Slider(
                value = sliderValue,
                valueRange = 0f..100f,
                onValueChange = { value -> sliderValue = value },
            )
            ElementSpacer()

            Slider(
                value = sliderValue,
                tooltipVisibility = Slider.TooltipVisibility.Invisible,
                steps = 9,
                valueRange = 0f..100f,
                onValueChange = { value -> sliderValue = value },
            )
            ElementSpacer()

            Slider(
                value = sliderValue,
                tooltipVisibility = Slider.TooltipVisibility.VisibleOnInteraction { value -> "${value.toInt()}" },
                valueRange = 0f..100f,
                onValueChange = { value -> sliderValue = value },
            )
            ElementSpacer()

            Slider(
                value = sliderValue,
                valueRange = 0f..100f,
                thumb = { state, interactionSource ->
                    Box(
                        Modifier
                            .size(10.dp, 30.dp)
                            .background(Color.Red)
                    )
                },
                track = { state ->
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(10.dp)
                            .background(Color.Blue)
                    )
                },
                onValueChange = { value -> sliderValue = value },
            )
            ElementSpacer()

            Slider(
                value = sliderValue,
                steps = 9,
                enabled = false,
                valueRange = 0f..100f,
                onValueChange = {},
            )
            ElementSpacer()

            Slider(
                value = sliderValue,
                enabled = false,
                valueRange = 0f..100f,
                onValueChange = {},
            )
            ElementSpacer()
        }
    }
}
