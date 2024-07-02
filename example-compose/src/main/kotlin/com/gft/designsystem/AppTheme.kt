package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.whitelabel.WhiteLabelColorScheme
import com.gft.designsystem.whitelabel.WhiteLabelDesignSystem

// definition
interface Gradients

@Immutable
interface AppColorScheme : WhiteLabelColorScheme {
    val color21: Color // <-- new color
}

@Immutable
class AppDesignSystemElements<out ColorSchemeType : ColorScheme, out TypographyType : Typography, out ShapesType : Shapes, out StylesType : AppStyles, out GradientsType : Gradients>(
    colors: ColorSchemeType,
    typography: TypographyType,
    shapes: ShapesType,
    styles: StylesType,
    val gradients: GradientsType,
) : DesignSystemElements<ColorSchemeType, TypographyType, ShapesType, StylesType>(
    colors, typography, shapes, styles
)

// never changing part
@Stable
object AppDesignSystem : AppDesignSystemElementsProvider<AppColorScheme, Typography, Shapes, AppStyles, Gradients>(LocalAppDesignSystem)

val LocalAppDesignSystem = staticCompositionLocalOf {
    AppDesignSystemElements(
        LightAppColorScheme() as AppColorScheme,
        object : Typography {} as Typography,
        object : Shapes {} as Shapes,
        DefaultAppStyles() as AppStyles,
        object : Gradients {} as Gradients
    )
}

@Composable
fun AppDesignSystem(
    colors: AppColorScheme = AppDesignSystem.colors,
    typography: Typography = AppDesignSystem.typography,
    shapes: Shapes = AppDesignSystem.shapes,
    styles: AppStyles = AppDesignSystem.styles,
    gradients: Gradients = AppDesignSystem.gradients,
    content: @Composable () -> Unit,
) = AppDesignSystem(AppDesignSystemElements(colors, typography, shapes, styles, gradients), content)

@Composable
fun AppDesignSystem(
    elements: AppDesignSystemElements<AppColorScheme, Typography, Shapes, AppStyles, Gradients>,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalAppDesignSystem provides elements) {
        WhiteLabelDesignSystem(elements, content)
    }
}

open class AppDesignSystemElementsProvider<ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes, StylesType : AppStyles, GradientsType : Gradients>(
    private val localComposition: ProvidableCompositionLocal<out AppDesignSystemElements<ColorSchemeType, TypographyType, ShapesType, StylesType, GradientsType>>,
) : DesignSystemElementsProvider<ColorSchemeType, TypographyType, ShapesType, StylesType>(localComposition) {
    val gradients: GradientsType
        @Composable @ReadOnlyComposable get() = localComposition.current.gradients
}
