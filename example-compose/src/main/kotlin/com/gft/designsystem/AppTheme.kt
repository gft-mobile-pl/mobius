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
class AppDesignSystemElements<ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes, ComponentsType : Components, GradientsType : Gradients>(
    colors: ColorSchemeType,
    typography: TypographyType,
    shapes: ShapesType,
    components: ComponentsType,
    val gradients: GradientsType,
) : DesignSystemElements<ColorSchemeType, TypographyType, ShapesType, ComponentsType>(
    colors, typography, shapes, components
)

// never changing part
@Stable
object AppDesignSystem : AppDesignSystemElementsProvider<AppColorScheme, Typography, Shapes, Components, Gradients>(LocalAppDesignSystem)

val LocalAppDesignSystem = staticCompositionLocalOf {
    AppDesignSystemElements(
        LightAppColorScheme() as AppColorScheme,
        object : Typography {} as Typography,
        object : Shapes {} as Shapes,
        object : Components {} as Components,
        object : Gradients {} as Gradients
    )
}

@Composable
fun AppDesignSystem(
    colors: AppColorScheme = AppDesignSystem.colors,
    typography: Typography = AppDesignSystem.typography,
    shapes: Shapes = AppDesignSystem.shapes,
    components: Components = AppDesignSystem.components,
    gradients: Gradients = AppDesignSystem.gradients,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalAppDesignSystem provides AppDesignSystemElements(colors, typography, shapes, components, gradients)
    ) {
        WhiteLabelDesignSystem(colors, typography, shapes, components, content)
    }
}

open class AppDesignSystemElementsProvider<ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes, ComponentsType : Components, GradientsType : Gradients>(
    private val localComposition: ProvidableCompositionLocal<out AppDesignSystemElements<ColorSchemeType, TypographyType, ShapesType, ComponentsType, GradientsType>>,
) {
    val colors: ColorSchemeType
        @Composable get() = localComposition.current.colors
    val typography: TypographyType
        @Composable get() = localComposition.current.typography
    val shapes: ShapesType
        @Composable get() = localComposition.current.shapes
    val components: ComponentsType
        @Composable get() = localComposition.current.components
    val gradients: GradientsType
        @Composable get() = localComposition.current.gradients
}
