package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal

// models
@Immutable interface ColorScheme
@Immutable interface Typography
@Immutable interface Shapes
@Immutable interface Styles

// local composition
@Immutable
open class DesignSystemElements<ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes, StylesType : Styles>(
    val colors: ColorSchemeType,
    val typography: TypographyType,
    val shapes: ShapesType,
    val styles: StylesType,
)

open class DesignSystemElementsProvider<ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes, StylesType : Styles>(
    private val localComposition: ProvidableCompositionLocal<out DesignSystemElements<ColorSchemeType, TypographyType, ShapesType, StylesType>>,
) {
    val colors: ColorSchemeType
        @Composable get() = localComposition.current.colors
    val typography: TypographyType
        @Composable get() = localComposition.current.typography
    val shapes: ShapesType
        @Composable get() = localComposition.current.shapes
    val styles: StylesType
        @Composable get() = localComposition.current.styles
}
