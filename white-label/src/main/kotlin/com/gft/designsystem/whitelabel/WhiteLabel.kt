package com.gft.designsystem.whitelabel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.ColorScheme
import com.gft.designsystem.Styles

import com.gft.designsystem.DesignSystemElements
import com.gft.designsystem.DesignSystemElementsProvider
import com.gft.designsystem.Shapes
import com.gft.designsystem.Typography

// definition
@Immutable
interface WhiteLabelColorScheme : ColorScheme {
    val color11: Color // <-- new color
    val color12: Color // <-- new color
    val color13: Color // <-- new color
    val color14: Color // <-- new color
    val color15: Color // <-- new color
    val color16: Color // <-- new color
    val color17: Color // <-- new color
}

// copy-paste-replace-forget part
@Stable
object WhiteLabelDesignSystem : DesignSystemElementsProvider<WhiteLabelColorScheme, Typography, Shapes, Styles>(LocalWhiteLabelSystem)

val LocalWhiteLabelSystem = staticCompositionLocalOf {
    DesignSystemElements(
        LightWhiteLabelColorScheme() as WhiteLabelColorScheme,
        object : Typography {} as Typography,
        object : Shapes {} as Shapes,
        object : Styles {} as Styles
    )
}

@Composable
fun WhiteLabelDesignSystem(
    colors: WhiteLabelColorScheme = WhiteLabelDesignSystem.colors,
    typography: Typography = WhiteLabelDesignSystem.typography,
    shapes: Shapes = WhiteLabelDesignSystem.shapes,
    styles: Styles = WhiteLabelDesignSystem.styles,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalWhiteLabelSystem provides DesignSystemElements(colors, typography, shapes, styles),
        content = content
    )
}
