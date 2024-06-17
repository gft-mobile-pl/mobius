package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppDesignSystemWithColor1Blue(
    content: @Composable () -> Unit,
) {
    AppDesignSystem(
        colors = object : AppColorScheme by LocalAppDesignSystem.current.colors {
            override val color11: Color = Color(0xff1133bb)
        },
        content = content
    )
}
