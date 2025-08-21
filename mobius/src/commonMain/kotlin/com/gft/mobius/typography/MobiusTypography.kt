package com.gft.mobius.typography

import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Typography

interface MobiusTypography : Typography {
    val displayLarge: TextStyle
    val displayMedium: TextStyle
    val displaySmall: TextStyle

    val headlineLarge: TextStyle
    val headlineMedium: TextStyle
    val headlineSmall: TextStyle

    val titleLarge: TextStyle
    val titleMedium: TextStyle
    val titleSmall: TextStyle

    val labelLarge: TextStyle
    val labelMedium: TextStyle
    val labelSmall: TextStyle

    val bodyLarge: TextStyle
    val bodyMedium: TextStyle
    val bodySmall: TextStyle
}
