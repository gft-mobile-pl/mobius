package com.gft.mobius.components.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment

@Stable
internal fun Alignment.resolveVerticalAlignment() = when (this) {
    Alignment.TopStart, Alignment.TopCenter, Alignment.TopEnd, Alignment.Top -> Alignment.Top
    Alignment.CenterStart, Alignment.Center, Alignment.CenterEnd, Alignment.CenterVertically -> Alignment.CenterVertically
    Alignment.BottomStart, Alignment.BottomCenter, Alignment.BottomEnd, Alignment.Bottom -> Alignment.Bottom
    else -> Alignment.CenterVertically
}

@Stable
internal fun Alignment.resolveHorizontalAlignment() = when (this) {
    Alignment.TopStart, Alignment.CenterStart, Alignment.BottomStart, Alignment.Start -> Alignment.Start
    Alignment.TopCenter, Alignment.Center, Alignment.BottomCenter, Alignment.CenterHorizontally -> Alignment.CenterHorizontally
    Alignment.TopEnd, Alignment.CenterEnd, Alignment.BottomEnd, Alignment.End -> Alignment.End
    else -> Alignment.CenterHorizontally
}

@Stable
internal fun Alignment.resolveVerticalArrangement() = when (resolveVerticalAlignment()) {
    Alignment.Top -> Arrangement.Top
    Alignment.Bottom -> Arrangement.Bottom
    else -> Arrangement.Center
}
