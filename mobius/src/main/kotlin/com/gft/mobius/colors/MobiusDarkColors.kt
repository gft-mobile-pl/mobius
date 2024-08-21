package com.gft.mobius.colors

import androidx.compose.ui.graphics.Color
import com.gft.mobius.references.MobiusReferenceColors

open class MobiusDarkColors : MobiusColors {
    override val primary: Color = MobiusReferenceColors.RoyalBlue80
    override val inversePrimary: Color = MobiusReferenceColors.RoyalBlue40
    override val secondary: Color = MobiusReferenceColors.MidnightBlue80
    override val tertiary: Color = MobiusReferenceColors.SkyBlue80
    override val onPrimary: Color = MobiusReferenceColors.RoyalBlue20
    override val onSecondary: Color = MobiusReferenceColors.MidnightBlue20
    override val onTertiary: Color = MobiusReferenceColors.SkyBlue20

    override val primaryContainer: Color = MobiusReferenceColors.RoyalBlue25
    override val secondaryContainer: Color = MobiusReferenceColors.MidnightBlue25
    override val tertiaryContainer: Color = MobiusReferenceColors.SkyBlue50
    override val onPrimaryContainer: Color = MobiusReferenceColors.RoyalBlue80
    override val onSecondaryContainer: Color = MobiusReferenceColors.MidnightBlue80
    override val onTertiaryContainer: Color = MobiusReferenceColors.SkyBlue100

    override val error: Color = MobiusReferenceColors.Red80
    override val onError: Color = MobiusReferenceColors.Red20
    override val errorContainer: Color = MobiusReferenceColors.Red30
    override val onErrorContainer: Color = MobiusReferenceColors.Red90

    override val surface: Color = MobiusReferenceColors.WarmGray6
    override val surfaceBright: Color = MobiusReferenceColors.WarmGray22
    override val surfaceDim: Color = MobiusReferenceColors.WarmGray6
    override val inverseSurface: Color = MobiusReferenceColors.WarmGray90
    override val surfaceContainer: Color = MobiusReferenceColors.WarmGray12
    override val surfaceContainerLow: Color = MobiusReferenceColors.WarmGray10
    override val surfaceContainerLowest: Color = MobiusReferenceColors.WarmGray4
    override val surfaceContainerHigh: Color = MobiusReferenceColors.WarmGray17
    override val surfaceContainerHighest: Color = MobiusReferenceColors.WarmGray22
    override val onSurface: Color = MobiusReferenceColors.WarmGray90
    override val surfaceVariant: Color = MobiusReferenceColors.WarmGray30
    override val inverseOnSurface: Color = MobiusReferenceColors.WarmGray20
    override val onSurfaceVariant: Color = MobiusReferenceColors.WarmGray80
    override val background: Color = MobiusReferenceColors.WarmGray6
    override val onBackground: Color = MobiusReferenceColors.WarmGray90
    override val outline: Color = MobiusReferenceColors.WarmGray60
    override val outlineVariant: Color = MobiusReferenceColors.WarmGray30
    override val scrim: Color = MobiusReferenceColors.WarmGray0
    override val shadow: Color = MobiusReferenceColors.WarmGray0
}
