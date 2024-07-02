package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable

@Immutable
interface ColorScheme

@Immutable
interface Typography

@Immutable
interface Shapes

@Stable
interface Styles

@Immutable
open class DesignSystemElements<out ColorSchemeType : ColorScheme, out TypographyType : Typography, out ShapesType : Shapes, out StylesType : Styles>(
    val colors: ColorSchemeType,
    val typography: TypographyType,
    val shapes: ShapesType,
    val styles: StylesType,
)

open class DesignSystemElementsProvider<ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes, StylesType : Styles>(
    private val localComposition: ProvidableCompositionLocal<out DesignSystemElements<ColorSchemeType, TypographyType, ShapesType, StylesType>>,
) {
    val colors: ColorSchemeType
        @Composable @ReadOnlyComposable get() = localComposition.current.colors
    val typography: TypographyType
        @Composable @ReadOnlyComposable get() = localComposition.current.typography
    val shapes: ShapesType
        @Composable @ReadOnlyComposable get() = localComposition.current.shapes
    val styles: StylesType
        @Composable @ReadOnlyComposable get() = localComposition.current.styles
}
