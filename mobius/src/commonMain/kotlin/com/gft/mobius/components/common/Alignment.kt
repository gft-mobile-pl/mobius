package com.gft.mobius.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment

@Stable
internal fun Alignment.resolveVerticalAlignment(): Alignment.Vertical = when (this) {
    Alignment.TopStart, Alignment.TopCenter, Alignment.TopEnd -> Alignment.Top
    Alignment.CenterStart, Alignment.Center, Alignment.CenterEnd -> Alignment.CenterVertically
    Alignment.BottomStart, Alignment.BottomCenter, Alignment.BottomEnd -> Alignment.Bottom
    else -> Alignment.CenterVertically
}

@Stable
internal fun Alignment.resolveHorizontalAlignment(): Alignment.Horizontal = when (this) {
    Alignment.TopStart, Alignment.CenterStart, Alignment.BottomStart -> Alignment.Start
    Alignment.TopCenter, Alignment.Center, Alignment.BottomCenter -> Alignment.CenterHorizontally
    Alignment.TopEnd, Alignment.CenterEnd, Alignment.BottomEnd -> Alignment.End
    else -> Alignment.CenterHorizontally
}

@Stable
internal fun Alignment.Vertical.resolveVerticalArrangement(): Arrangement.Vertical = when (this) {
    Alignment.Top -> Arrangement.Top
    Alignment.Bottom -> Arrangement.Bottom
    else -> Arrangement.Center
}

@Stable
internal fun Alignment.resolveVerticalArrangement(): Arrangement.Vertical =
    resolveVerticalAlignment().resolveVerticalArrangement()

fun Alignment.Horizontal.reverse() = when (this) {
    Alignment.Start -> Alignment.End
    Alignment.CenterHorizontally -> Alignment.CenterHorizontally
    Alignment.End -> Alignment.Start
    else -> throw IllegalArgumentException("Unsupported alignment.")
}
