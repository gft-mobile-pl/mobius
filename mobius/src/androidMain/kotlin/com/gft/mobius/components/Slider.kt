@file:JvmName("SliderAndroid")
package com.gft.mobius.components

internal actual val DefaultSliderTooltipFormatter: (Float) -> String = { sliderValue -> "%.2f".format(sliderValue) }
