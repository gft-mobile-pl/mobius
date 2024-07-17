package com.gft.mobius

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import com.gft.designsystem.DesignSystem
import com.gft.designsystem.DesignSystemElements
import com.gft.designsystem.DesignSystemElementsProvider
import com.gft.mobius.Mobius.styles
import com.gft.mobius.colors.MobiusColors
import com.gft.mobius.colors.MobiusLightColors
import com.gft.mobius.components.styles.DefaultMobiusStyles
import com.gft.mobius.components.styles.MobiusStyles
import com.gft.mobius.components.styles.ProvideTextStyle
import com.gft.mobius.materialdesign.toMaterialDesign
import com.gft.mobius.typography.DefaultMobiusTypography
import com.gft.mobius.typography.MobiusTypography

@Stable
object Mobius :
    DesignSystemElementsProvider<MobiusColors, MobiusTypography, MobiusStyles>(LocalMobius)

val LocalMobius = staticCompositionLocalOf {
    DesignSystemElements(
        MobiusLightColors() as MobiusColors,
        DefaultMobiusTypography() as MobiusTypography,
        DefaultMobiusStyles() as MobiusStyles
    )
}

@Composable
fun Mobius(
    colors: MobiusColors = Mobius.colors,
    typography: MobiusTypography = Mobius.typography,
    styles: MobiusStyles = Mobius.styles,
    content: @Composable () -> Unit,
) = Mobius(DesignSystemElements(colors, typography, styles), content)

@Composable
fun Mobius(
    elements: DesignSystemElements<MobiusColors, MobiusTypography, MobiusStyles>,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalMobius provides elements) {
        DesignSystem {
            MaterialTheme(
                colorScheme = elements.colors.toMaterialDesign(),
                typography = elements.typography.toMaterialDesign(),
            ) {
                ProvideTextStyle(
                    style = styles.text.resolve(),
                    content = content
                )
            }
        }
    }
}
