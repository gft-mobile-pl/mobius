package com.gft.designsystem.whitelabel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.base.ColorScheme
import com.gft.designsystem.base.Components
import com.gft.designsystem.base.DesignSystem
import com.gft.designsystem.base.DesignSystemElements
import com.gft.designsystem.base.DesignSystemElementsProvider
import com.gft.designsystem.base.Dimens
import com.gft.designsystem.base.Shapes
import com.gft.designsystem.base.Typography

// customization
@Stable
open class WhiteLabelColorScheme : ColorScheme {
    open val primaryColor: Color = Color.Red // <-- new color
    open val secondaryColor: Color = Color.Yellow // <-- new color
}

@Stable
open class WhiteLabelDesignSystem : DesignSystem() {
    override val colors: WhiteLabelColorScheme = WhiteLabelColorScheme() // <-- overridden color scheme

    companion object : DesignSystemElementsProvider<WhiteLabelColorScheme, Typography, Shapes, Dimens, Components>(LocalWhiteLabelSystem)
}






// never changing part
val LocalWhiteLabelSystem = staticCompositionLocalOf {
    val system = WhiteLabelDesignSystem()
    DesignSystemElements(system.colors, system.typography, system.shapes, system.dimens, system.components)
}

@Composable
fun <T : WhiteLabelDesignSystem> WhiteLabelDesignSystem(
    designSystem: T,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalWhiteLabelSystem provides DesignSystemElements(
            designSystem.colors,
            designSystem.typography,
            designSystem.shapes,
            designSystem.dimens,
            designSystem.components
        ),
        content = content
    )
}
