package com.gft.mobius

import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import com.gft.designsystem.DesignSystem
import com.gft.designsystem.DesignSystemModules
import com.gft.designsystem.DesignSystemModulesProvider
import com.gft.designsystem.ModuleInitialization
import com.gft.mobius.colors.MobiusColors
import com.gft.mobius.colors.MobiusLightColors
import com.gft.mobius.components.styles.DefaultMobiusStyles
import com.gft.mobius.components.styles.LocalTextLinkStyles
import com.gft.mobius.components.styles.LocalTextStyle
import com.gft.mobius.components.styles.MobiusStyles
import com.gft.mobius.materialdesign.toMaterialDesign
import com.gft.mobius.typography.DefaultMobiusTypography
import com.gft.mobius.typography.MobiusTypography

private val LocalMobius = staticCompositionLocalOf {
    DesignSystemModules(
        MobiusLightColors() as MobiusColors,
        DefaultMobiusTypography() as MobiusTypography,
        DefaultMobiusStyles() as MobiusStyles
    )
}

val Mobius = DesignSystemModulesProvider(LocalMobius)

@Composable
fun Mobius(
    colors: MobiusColors = Mobius.colors,
    typography: MobiusTypography = Mobius.typography,
    styles: MobiusStyles = Mobius.styles,
    content: @Composable () -> Unit,
) = Mobius(DesignSystemModules(colors, typography, styles), content)

@Composable
fun Mobius(
    modules: DesignSystemModules<MobiusColors, MobiusTypography, MobiusStyles>,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalMobius provides modules) {
        DesignSystem(modules) {
            MaterialTheme(
                colorScheme = modules.colors.toMaterialDesign(),
                typography = modules.typography.toMaterialDesign(),
            ) {
                CompositionLocalProvider(
                    LocalMinimumInteractiveComponentSize provides modules.styles.interactiveComponentStyle.minimumSize.resolve(),
                    LocalTextLinkStyles provides modules.styles.textLink.resolve(),
                    LocalTextStyle provides modules.styles.text.resolve(),
                    content = content
                )
            }
        }
    }
}
