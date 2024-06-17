package com.gft.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun AppDesignSystemWithColor21Red(
    content: @Composable () -> Unit,
) {
    AppDesignSystem(
        colors = object : AppColorScheme by LocalAppDesignSystem.current.colors {
            override val color21: Color = Color.Red
        },
        content = content
    )
}
