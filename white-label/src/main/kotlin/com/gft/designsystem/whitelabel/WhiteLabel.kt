package com.gft.designsystem.whitelabel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.base.ColorScheme
import com.gft.designsystem.base.Components

import com.gft.designsystem.base.DesignSystemElements
import com.gft.designsystem.base.DesignSystemElementsProvider
import com.gft.designsystem.base.Dimens
import com.gft.designsystem.base.Shapes
import com.gft.designsystem.base.Typography

// customization
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

class LightWhiteLabelColorScheme : WhiteLabelColorScheme {
    override val color11: Color = Color(0xff222222)
    override val color12: Color = Color(0xff444444)
    override val color13: Color = Color(0xff666666)
    override val color14: Color = Color(0xff888888)
    override val color15: Color = Color(0xffaaaaaa)
    override val color16: Color = Color(0xffcccccc)
    override val color17: Color = Color(0xffeeeeee)
}

// never changing part
@Stable
object WhiteLabelDesignSystem : DesignSystemElementsProvider<WhiteLabelColorScheme, Typography, Shapes, Dimens, Components>(LocalWhiteLabelSystem)

val LocalWhiteLabelSystem = staticCompositionLocalOf {
    DesignSystemElements(
        LightWhiteLabelColorScheme() as WhiteLabelColorScheme,
        object : Typography {} as Typography,
        object : Shapes {} as Shapes,
        object : Dimens {} as Dimens,
        object : Components {} as Components
    )
}

@Composable
fun WhiteLabelDesignSystem(
    colors: WhiteLabelColorScheme = LocalWhiteLabelSystem.current.colors,
    typography: Typography = LocalWhiteLabelSystem.current.typography,
    shapes: Shapes = LocalWhiteLabelSystem.current.shapes,
    dimens: Dimens = LocalWhiteLabelSystem.current.dimens,
    components: Components = LocalWhiteLabelSystem.current.components,

    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalWhiteLabelSystem provides DesignSystemElements(colors, typography, shapes, dimens, components),
        content = content
    )
}
