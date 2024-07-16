package com.gft.mobius

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import com.gft.designsystem.DesignSystem
import com.gft.designsystem.DesignSystemElements
import com.gft.designsystem.DesignSystemElementsProvider
import com.gft.designsystem.Styles
import com.gft.designsystem.Typography
import com.gft.mobius.colors.MobiusColors
import com.gft.mobius.colors.MobiusLightColors

@Stable
object Mobius : DesignSystemElementsProvider<MobiusColors, Typography, Styles>(LocalMobius)

val LocalMobius = staticCompositionLocalOf {
    DesignSystemElements(
        MobiusLightColors() as MobiusColors,
        object : Typography {} as Typography,
        object : Styles {} as Styles
    )
}

@Composable
fun Mobius(
    colors: MobiusColors = Mobius.colors,
    typography: Typography = Mobius.typography,
    styles: Styles = Mobius.styles,
    content: @Composable () -> Unit,
) = Mobius(DesignSystemElements(colors, typography, styles), content)

@Composable
fun Mobius(
    elements: DesignSystemElements<MobiusColors, Typography, Styles>,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalMobius provides elements) {
        DesignSystem(content = content)
    }
}
