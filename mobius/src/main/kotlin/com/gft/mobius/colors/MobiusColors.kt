package com.gft.mobius.colors

import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.takeOrElse
import com.gft.designsystem.Colors
import com.gft.mobius.Mobius

@Immutable
interface MobiusColors : Colors {
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

    // background
    val background: Color
    val onBackground: Color

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
    val surfaceVariant: Color
    val onSurfaceVariant: Color

    // outlines
    val outline: Color
    val outlineVariant: Color

    // other
    val scrim: Color
    val shadow: Color
}

@Composable
@ReadOnlyComposable
fun contentColorFor(color: Color) = with(Mobius.colors) {
    when (color) {
        primary -> onPrimary
        secondary -> onSecondary
        tertiary -> onTertiary
        background -> onBackground
        error -> onError
        primaryContainer -> onPrimaryContainer
        secondaryContainer -> onSecondaryContainer
        tertiaryContainer -> onTertiaryContainer
        errorContainer -> onErrorContainer
        inverseSurface -> inverseOnSurface
        surface -> onSurface
        surfaceVariant -> onSurfaceVariant
        surfaceDim -> onSurface
        surfaceBright -> onSurface
        surfaceContainer -> onSurface
        surfaceContainerHigh -> onSurface
        surfaceContainerHighest -> onSurface
        surfaceContainerLow -> onSurface
        surfaceContainerLowest -> onSurface
        else -> Color.Unspecified
    }
}.takeOrElse {
    LocalContentColor.current
}
