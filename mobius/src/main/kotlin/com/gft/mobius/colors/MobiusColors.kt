package com.gft.mobius.colors

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
interface MobiusColors {
    // defining colors
    val primary: Color
    val inversePrimary: Color
    val secondary: Color
    val tertiary: Color
    val onPrimary: Color
    val onSecondary: Color
    val onTertiary: Color
    val primaryContainer: Color
    val secondaryContainer: Color
    val tertiaryContainer: Color
    val onPrimaryContainer: Color
    val onSecondaryContainer: Color
    val onTertiaryContainer: Color

    // errors
    val error: Color
    val onError: Color
    val errorContainer: Color
    val onErrorContainer: Color

    // surfaces
    val surface: Color
    val surfaceBright: Color
    val surfaceDim: Color
    val inverseSurface: Color
    val surfaceContainer: Color
    val surfaceContainerLow: Color
    val surfaceContainerLowest: Color
    val surfaceContainerHigh: Color
    val surfaceContainerHighest: Color
    val onSurface: Color
    val inverseOnSurface: Color
    val onSurfaceVariant: Color

    // outlines
    val outline: Color
    val outlineVariant: Color

    // other
    val scrim: Color
    val shadow: Color
}
