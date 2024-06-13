package com.gft.designsystem.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.Stable

// models
@Immutable interface ColorScheme
@Immutable interface Typography
@Immutable interface Shapes
@Immutable interface Dimens
@Immutable interface Components

// local composition
@Immutable
class DesignSystemElements<ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes, DimensType : Dimens, ComponentsType : Components>(
    val colors: ColorSchemeType,
    val typography: TypographyType,
    val shapes: ShapesType,
    val dimens: DimensType,
    val components: ComponentsType,
)

open class DesignSystemElementsProvider<ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes, DimensType : Dimens, ComponentsType : Components>(
    private val localComposition: ProvidableCompositionLocal<out DesignSystemElements<ColorSchemeType, TypographyType, ShapesType, DimensType, ComponentsType>>,
) {
    val colors: ColorSchemeType
        @Composable get() = localComposition.current.colors
    val typography: TypographyType
        @Composable get() = localComposition.current.typography
    val dimens: DimensType
        @Composable get() = localComposition.current.dimens
    val shapes: ShapesType
        @Composable get() = localComposition.current.shapes
    val components: ComponentsType
        @Composable get() = localComposition.current.components
}
