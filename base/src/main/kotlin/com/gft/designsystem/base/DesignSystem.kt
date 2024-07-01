package com.gft.designsystem.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal

// models
@Immutable interface ColorScheme
@Immutable interface Typography
@Immutable interface Shapes
@Immutable interface Components

// local composition
@Immutable
open class DesignSystemElements<ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes, ComponentsType : Components>(
    val colors: ColorSchemeType,
    val typography: TypographyType,
    val shapes: ShapesType,
    val components: ComponentsType,
)

open class DesignSystemElementsProvider<ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes, ComponentsType : Components>(
    private val localComposition: ProvidableCompositionLocal<out DesignSystemElements<ColorSchemeType, TypographyType, ShapesType, ComponentsType>>,
) {
    val colors: ColorSchemeType
        @Composable get() = localComposition.current.colors
    val typography: TypographyType
        @Composable get() = localComposition.current.typography
    val shapes: ShapesType
        @Composable get() = localComposition.current.shapes
    val components: ComponentsType
        @Composable get() = localComposition.current.components
}
