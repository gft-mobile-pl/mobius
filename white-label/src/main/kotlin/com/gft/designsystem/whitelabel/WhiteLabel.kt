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
open class WhiteLabelColorScheme : ColorScheme {
    open val color11: Color = Color(0xff222222) // <-- new color
    open val color12: Color = Color(0xff444444) // <-- new color
    open val color13: Color = Color(0xff666666) // <-- new color
    open val color14: Color = Color(0xff888888) // <-- new color
    open val color15: Color = Color(0xffaaaaaa) // <-- new color
    open val color16: Color = Color(0xffcccccc) // <-- new color
    open val color17: Color = Color(0xffeeeeee) // <-- new color
}


// never changing part
@Stable
object WhiteLabelDesignSystem : DesignSystemElementsProvider<WhiteLabelColorScheme, Typography, Shapes, Dimens, Components>(LocalWhiteLabelSystem)

val LocalWhiteLabelSystem = staticCompositionLocalOf {
    DesignSystemElements(
        WhiteLabelColorScheme(),
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
