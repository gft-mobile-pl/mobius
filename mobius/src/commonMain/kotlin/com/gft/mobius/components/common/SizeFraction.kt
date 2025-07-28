package com.gft.mobius.components.common

import kotlin.jvm.JvmInline

@JvmInline
value class SizeFraction(
    val value: Float,
) {
    init {
        if (value < 0.0 || value > 1.0) {
            throw IllegalArgumentException("The value must be between 0 and 1, inclusive.")
        }
    }
}
