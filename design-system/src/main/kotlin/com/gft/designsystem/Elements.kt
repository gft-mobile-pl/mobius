package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable

@Immutable
interface Colors

@Immutable
interface Typography

@Stable
interface Styles

@Immutable
open class DesignSystemElements<out ColorSchemeType : Colors, out TypographyType : Typography, out StylesType : Styles>(
    val colors: ColorSchemeType,
    val typography: TypographyType,
    val styles: StylesType,
)

open class DesignSystemElementsProvider<ColorSchemeType : Colors, TypographyType : Typography, StylesType : Styles>(
    private val localComposition: ProvidableCompositionLocal<out DesignSystemElements<ColorSchemeType, TypographyType, StylesType>>,
) {
    val colors: ColorSchemeType
        @Composable @ReadOnlyComposable get() = localComposition.current.colors
    val typography: TypographyType
        @Composable @ReadOnlyComposable get() = localComposition.current.typography
    val styles: StylesType
        @Composable @ReadOnlyComposable get() = localComposition.current.styles
}
