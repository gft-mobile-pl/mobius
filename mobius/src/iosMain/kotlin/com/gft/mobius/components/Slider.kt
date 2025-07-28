package com.gft.mobius.components

import platform.Foundation.NSString
import platform.Foundation.stringWithFormat

internal actual val DefaultSliderTooltipFormatter: (Float) -> String = { sliderValue -> NSString.stringWithFormat("%.2f", sliderValue) }
