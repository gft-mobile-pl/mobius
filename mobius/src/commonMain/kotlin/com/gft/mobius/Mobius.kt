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
import com.gft.mobius.Mobius.styles
import com.gft.mobius.colors.MobiusColors
import com.gft.mobius.colors.MobiusLightColors
import com.gft.mobius.components.styles.DefaultMobiusStyles
import com.gft.mobius.components.styles.LocalTextLinkStyles
import com.gft.mobius.components.styles.LocalTextStyle
import com.gft.mobius.components.styles.MobiusStyles
import com.gft.mobius.materialdesign.toMaterialDesign
import com.gft.mobius.references.MobiusReferenceFonts
import com.gft.mobius.typography.DefaultMobiusTypography
import com.gft.mobius.typography.MobiusTypography
import com.gft.mobius.typography.MobiusTypographyStub

@Stable
object Mobius :
    DesignSystemModulesProvider<MobiusColors, MobiusTypography, MobiusStyles>(LocalMobius)

val LocalMobius = staticCompositionLocalOf {
    DesignSystemModules(
        MobiusLightColors() as MobiusColors,
        MobiusTypographyStub() as MobiusTypography,
        DefaultMobiusStyles() as MobiusStyles
    )
}

@Composable
fun Mobius(
    colors: MobiusColors = Mobius.colors,
    typography: MobiusTypography = resolveTypography(),
    styles: MobiusStyles = Mobius.styles,
    content: @Composable () -> Unit,
) = Mobius(DesignSystemModules(colors, typography, styles), content)

@Composable
fun Mobius(
    elements: DesignSystemModules<MobiusColors, MobiusTypography, MobiusStyles>,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalMobius provides elements) {
        DesignSystem {
            MaterialTheme(
                colorScheme = elements.colors.toMaterialDesign(),
                typography = elements.typography.toMaterialDesign(),
            ) {
                CompositionLocalProvider(
                    LocalMinimumInteractiveComponentSize provides styles.interactiveComponentStyle.minimumSize.resolve(),
                    LocalTextLinkStyles provides styles.textLink.resolve(),
                    LocalTextStyle provides styles.text.resolve(),
                    content = content
                )
            }
        }
    }
}

@Stable
@Composable
private fun resolveTypography(): MobiusTypography = if (Mobius.typography is MobiusTypographyStub) {
    MobiusReferenceFonts.initializeFonts()
    DefaultMobiusTypography()
} else {
    Mobius.typography
}
