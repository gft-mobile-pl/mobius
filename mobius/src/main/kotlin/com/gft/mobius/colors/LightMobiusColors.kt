package com.gft.mobius.colors

import androidx.compose.ui.graphics.Color
import com.gft.mobius.referencetokens.ReferenceColorTokens

open class LightMobiusColor : MobiusColors {
    override val primary: Color = ReferenceColorTokens.RoyalBlue20
    override val inversePrimary: Color = ReferenceColorTokens.RoyalBlue80
    override val secondary: Color = ReferenceColorTokens.MidnightBlue40
    override val tertiary: Color = ReferenceColorTokens.SkyBlue30
    override val onPrimary: Color = ReferenceColorTokens.RoyalBlue100
    override val onSecondary: Color = ReferenceColorTokens.MidnightBlue100
    override val onTertiary: Color = ReferenceColorTokens.SkyBlue100
    override val primaryContainer: Color = ReferenceColorTokens.RoyalBlue30
    override val secondaryContainer: Color = ReferenceColorTokens.MidnightBlue90
    override val tertiaryContainer: Color = ReferenceColorTokens.SkyBlue50
    override val onPrimaryContainer: Color = ReferenceColorTokens.RoyalBlue95
    override val onSecondaryContainer: Color = ReferenceColorTokens.MidnightBlue30
    override val onTertiaryContainer: Color = ReferenceColorTokens.SkyBlue100
    override val error: Color = ReferenceColorTokens.Red40
    override val onError: Color = ReferenceColorTokens.Red100
    override val errorContainer: Color = ReferenceColorTokens.Red90
    override val onErrorContainer: Color = ReferenceColorTokens.Red10
    override val surface: Color = ReferenceColorTokens.WarmGray95
    override val surfaceBright: Color = ReferenceColorTokens.WarmGray99
    override val surfaceDim: Color = ReferenceColorTokens.WarmGray80
    override val inverseSurface: Color = ReferenceColorTokens.WarmGray20
    override val surfaceContainer: Color = ReferenceColorTokens.WarmGray95
    override val surfaceContainerLow: Color = ReferenceColorTokens.WarmGray90
    override val surfaceContainerLowest: Color = ReferenceColorTokens.WarmGray80
    override val surfaceContainerHigh: Color = ReferenceColorTokens.WarmGray99
    override val surfaceContainerHighest: Color = ReferenceColorTokens.WarmGray100
    override val onSurface: Color = ReferenceColorTokens.WarmGray10
    override val inverseOnSurface: Color = ReferenceColorTokens.WarmGray95
    override val onSurfaceVariant: Color = ReferenceColorTokens.WarmGray30
    override val outline: Color = ReferenceColorTokens.WarmGray50
    override val outlineVariant: Color = ReferenceColorTokens.WarmGray80
    override val scrim: Color = ReferenceColorTokens.WarmGray0
    override val shadow: Color = ReferenceColorTokens.WarmGray0
}
