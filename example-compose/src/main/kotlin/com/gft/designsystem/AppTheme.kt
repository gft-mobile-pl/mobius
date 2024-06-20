package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.base.ColorScheme
import com.gft.designsystem.base.Components
import com.gft.designsystem.base.DesignSystemElements
import com.gft.designsystem.base.Dimens
import com.gft.designsystem.base.Shapes
import com.gft.designsystem.base.Typography
import com.gft.designsystem.whitelabel.WhiteLabelColorScheme
import com.gft.designsystem.whitelabel.WhiteLabelDesignSystem

// definition
interface Gradients

@Immutable
interface AppColorScheme : WhiteLabelColorScheme {
    val color21: Color // <-- new color
}

@Immutable
class AppDesignSystemElements<
    ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes,
    DimensType : Dimens, ComponentsType : Components, GradientsType : Gradients,
    >(
    colors: ColorSchemeType,
    typography: TypographyType,
    shapes: ShapesType,
    dimens: DimensType,
    components: ComponentsType,
    val gradients: GradientsType,
) : DesignSystemElements<ColorSchemeType, TypographyType, ShapesType, DimensType, ComponentsType>(
    colors, typography, shapes, dimens, components
)

// never changing part
@Stable
object AppDesignSystem : AppDesignSystemElementsProvider<AppColorScheme, Typography, Shapes, Dimens, Components, Gradients>(LocalAppDesignSystem)

val LocalAppDesignSystem = staticCompositionLocalOf {
    AppDesignSystemElements(
        LightAppColorScheme() as AppColorScheme,
        object : Typography {} as Typography,
        object : Shapes {} as Shapes,
        object : Dimens {} as Dimens,
        object : Components {} as Components,
        object : Gradients {} as Gradients
    )
}

@Composable
fun AppDesignSystem(
    colors: AppColorScheme = LocalAppDesignSystem.current.colors,
    typography: Typography = LocalAppDesignSystem.current.typography,
    shapes: Shapes = LocalAppDesignSystem.current.shapes,
    dimens: Dimens = LocalAppDesignSystem.current.dimens,
    components: Components = LocalAppDesignSystem.current.components,
    gradients: Gradients = LocalAppDesignSystem.current.gradients,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalAppDesignSystem provides AppDesignSystemElements(colors, typography, shapes, dimens, components, gradients)
    ) {
        WhiteLabelDesignSystem(colors, typography, shapes, dimens, components, content)
    }
}

open class AppDesignSystemElementsProvider<
    ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes,
    DimensType : Dimens, ComponentsType : Components, GradientsType : Gradients,
    >(
    private val localComposition: ProvidableCompositionLocal<out AppDesignSystemElements<ColorSchemeType, TypographyType, ShapesType, DimensType, ComponentsType, GradientsType>>,
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
    val gradients: GradientsType
        @Composable get() = localComposition.current.gradients
}
