package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.base.ColorScheme
import com.gft.designsystem.base.Styles
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
class AppDesignSystemElements<ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes, StylesType : Styles, GradientsType : Gradients>(
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
object AppDesignSystem : AppDesignSystemElementsProvider<AppColorScheme, Typography, Shapes, Styles, Gradients>(LocalAppDesignSystem)

val LocalAppDesignSystem = staticCompositionLocalOf {
    AppDesignSystemElements(
        LightAppColorScheme() as AppColorScheme,
        object : Typography {} as Typography,
        object : Shapes {} as Shapes,
        object : Styles {} as Styles,
        object : Gradients {} as Gradients
    )
}

@Composable
fun AppDesignSystem(
    colors: AppColorScheme = AppDesignSystem.colors,
    typography: Typography = AppDesignSystem.typography,
    shapes: Shapes = AppDesignSystem.shapes,
    styles: Styles = AppDesignSystem.components,
    gradients: Gradients = AppDesignSystem.gradients,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalAppDesignSystem provides AppDesignSystemElements(colors, typography, shapes, styles, gradients)
    ) {
        WhiteLabelDesignSystem(colors, typography, shapes, styles, content)
    }
}

open class AppDesignSystemElementsProvider<ColorSchemeType : ColorScheme, TypographyType : Typography, ShapesType : Shapes, StylesType : Styles, GradientsType : Gradients>(
    private val localComposition: ProvidableCompositionLocal<out AppDesignSystemElements<ColorSchemeType, TypographyType, ShapesType, StylesType, GradientsType>>,
) {
    val colors: ColorSchemeType
        @Composable get() = localComposition.current.colors
    val typography: TypographyType
        @Composable get() = localComposition.current.typography
    val shapes: ShapesType
        @Composable get() = localComposition.current.shapes
    val components: StylesType
        @Composable get() = localComposition.current.styles
    val gradients: GradientsType
        @Composable get() = localComposition.current.gradients
}
