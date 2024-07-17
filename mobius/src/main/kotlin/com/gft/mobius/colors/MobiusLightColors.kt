package com.gft.mobius.colors

import androidx.compose.ui.graphics.Color
import com.gft.mobius.references.MobiusReferenceColors

open class MobiusLightColors : MobiusColors {
    override val primary: Color = MobiusReferenceColors.RoyalBlue20
    override val inversePrimary: Color = MobiusReferenceColors.RoyalBlue80
    override val secondary: Color = MobiusReferenceColors.MidnightBlue40
    override val tertiary: Color = MobiusReferenceColors.SkyBlue30
    override val onPrimary: Color = MobiusReferenceColors.RoyalBlue100
    override val onSecondary: Color = MobiusReferenceColors.MidnightBlue100
    override val onTertiary: Color = MobiusReferenceColors.SkyBlue100
    override val primaryContainer: Color = MobiusReferenceColors.RoyalBlue30
    override val secondaryContainer: Color = MobiusReferenceColors.MidnightBlue90
    override val tertiaryContainer: Color = MobiusReferenceColors.SkyBlue50
    override val onPrimaryContainer: Color = MobiusReferenceColors.RoyalBlue95
    override val onSecondaryContainer: Color = MobiusReferenceColors.MidnightBlue30
    override val onTertiaryContainer: Color = MobiusReferenceColors.SkyBlue100
    override val error: Color = MobiusReferenceColors.Red40
    override val onError: Color = MobiusReferenceColors.Red100
    override val errorContainer: Color = MobiusReferenceColors.Red90
    override val onErrorContainer: Color = MobiusReferenceColors.Red10
    override val surface: Color = MobiusReferenceColors.WarmGray95
    override val surfaceBright: Color = MobiusReferenceColors.WarmGray99
    override val surfaceDim: Color = MobiusReferenceColors.WarmGray80
    override val inverseSurface: Color = MobiusReferenceColors.WarmGray20
    override val surfaceContainer: Color = MobiusReferenceColors.WarmGray95
    override val surfaceContainerLow: Color = MobiusReferenceColors.WarmGray99
    override val surfaceContainerLowest: Color = MobiusReferenceColors.WarmGray100
    override val surfaceContainerHigh: Color = MobiusReferenceColors.WarmGray90
    override val surfaceContainerHighest: Color = MobiusReferenceColors.WarmGray80
    override val onSurface: Color = MobiusReferenceColors.WarmGray10
    override val inverseOnSurface: Color = MobiusReferenceColors.WarmGray95
    override val surfaceVariant: Color = Color.Magenta // TODO: ask UX team for missing colors
    override val onSurfaceVariant: Color = MobiusReferenceColors.WarmGray30
    override val background: Color = Color.Yellow // TODO: ask UX team for missing colors
    override val onBackground: Color = Color.Blue // TODO: ask UX team for missing colors
    override val outline: Color = MobiusReferenceColors.WarmGray50
    override val outlineVariant: Color = MobiusReferenceColors.WarmGray80
    override val scrim: Color = MobiusReferenceColors.WarmGray0
    override val shadow: Color = MobiusReferenceColors.WarmGray0
}
