package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.base.Components
import com.gft.designsystem.base.DesignSystemElements
import com.gft.designsystem.base.DesignSystemElementsProvider
import com.gft.designsystem.base.Dimens
import com.gft.designsystem.base.Shapes
import com.gft.designsystem.base.Typography
import com.gft.designsystem.whitelabel.WhiteLabelColorScheme
import com.gft.designsystem.whitelabel.WhiteLabelDesignSystem

/**
 * #####################################
 * SOME APPLICATION THEME
 * #####################################
 */

@Stable
open class AppColorScheme : WhiteLabelColorScheme() {
    override val primaryColor: Color = Color.Blue // <-- overridden color
    open val tertiaryColor: Color = Color.Green // <-- new color
}

@Stable
open class AppDesignSystem : WhiteLabelDesignSystem() {
    override val colors: AppColorScheme = AppColorScheme() // <-- overridden color scheme

    companion object : DesignSystemElementsProvider<AppColorScheme, Typography, Shapes, Dimens, Components>(LocalAppDesignSystem)
}







// never changing part
val LocalAppDesignSystem = staticCompositionLocalOf {
    val system = AppDesignSystem()
    DesignSystemElements(system.colors, system.typography, system.shapes, system.dimens, system.components)
}

@Composable
fun <T : AppDesignSystem> AppDesignSystem(
    designSystem: T,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalAppDesignSystem provides DesignSystemElements(
            designSystem.colors,
            designSystem.typography,
            designSystem.shapes,
            designSystem.dimens,
            designSystem.components
        )
    ) {
        WhiteLabelDesignSystem(
            designSystem,
            content
        )
    }
}

