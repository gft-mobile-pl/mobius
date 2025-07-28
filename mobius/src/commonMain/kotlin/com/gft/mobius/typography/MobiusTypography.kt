package com.gft.mobius.typography

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import com.gft.designsystem.Typography

@Immutable
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

internal class MobiusTypographyStub : MobiusTypography {
    override val displayLarge: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val displayMedium: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val displaySmall: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val headlineLarge: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val headlineMedium: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val headlineSmall: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val titleLarge: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val titleMedium: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val titleSmall: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val labelLarge: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val labelMedium: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val labelSmall: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val bodyLarge: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val bodyMedium: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
    override val bodySmall: TextStyle
        get() = throw NotImplementedError("You must provide correct MobiusTypography")
}
