package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.base.Components
import com.gft.designsystem.base.DesignSystemElements
import com.gft.designsystem.base.DesignSystemElementsProvider
import com.gft.designsystem.base.Dimens
import com.gft.designsystem.base.Shapes
import com.gft.designsystem.base.Typography
import com.gft.designsystem.whitelabel.LightWhiteLabelColorScheme
import com.gft.designsystem.whitelabel.WhiteLabelColorScheme
import com.gft.designsystem.whitelabel.WhiteLabelDesignSystem

// definition
@Immutable
interface AppColorScheme : WhiteLabelColorScheme {
    val color21: Color // <-- new color
}

// never changing part
@Stable
object AppDesignSystem : DesignSystemElementsProvider<AppColorScheme, Typography, Shapes, Dimens, Components>(LocalAppDesignSystem)

val LocalAppDesignSystem = staticCompositionLocalOf {
    DesignSystemElements(
        LightAppColorScheme() as AppColorScheme,
        object : Typography {} as Typography,
        object : Shapes {} as Shapes,
        object : Dimens {} as Dimens,
        object : Components {} as Components
    )
}

@Composable
fun AppDesignSystem(
    colors: AppColorScheme = LocalAppDesignSystem.current.colors,
    typography: Typography = LocalAppDesignSystem.current.typography,
    shapes: Shapes = LocalAppDesignSystem.current.shapes,
    dimens: Dimens = LocalAppDesignSystem.current.dimens,
    components: Components = LocalAppDesignSystem.current.components,

    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalAppDesignSystem provides DesignSystemElements(colors, typography, shapes, dimens, components)
    ) {
        WhiteLabelDesignSystem(colors, typography, shapes, dimens, components, content)
    }
}
