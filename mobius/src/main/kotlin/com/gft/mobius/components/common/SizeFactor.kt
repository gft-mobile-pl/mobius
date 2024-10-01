package com.gft.mobius.components.common

import androidx.annotation.FloatRange

@JvmInline
value class SizeFactor(
    @FloatRange(0.0, 1.0)
    val value: Float
)
