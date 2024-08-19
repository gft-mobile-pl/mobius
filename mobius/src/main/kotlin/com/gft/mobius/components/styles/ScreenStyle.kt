package com.gft.mobius.components.styles

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.components.styles.ScreenStyle.SystemBarOverlappingPolicy
import com.gft.mobius.components.styles.ScreenStyle.SystemBarOverlappingPolicy.ALLOW_DISPLAYING_CONTENT_BEHIND_SYSTEM_BAR

interface ScreenStyleValues : StyleValues {
    val paddingValues: PaddingValues
    val background: Brush?
    val shape: Shape?
    val contentColor: Color
    val statusBarOverlappingPolicy: SystemBarOverlappingPolicy
    val navigationBarOverlappingPolicy: SystemBarOverlappingPolicy
}

interface ScreenStyle : Style {
    val paddingValues: Token<PaddingValues>
    val background: Token<Brush?>
    val shape: Token<Shape?>
    val contentColor: Token<Color>
    val statusBarOverlappingPolicy: Token<SystemBarOverlappingPolicy>
    val navigationBarOverlappingPolicy: Token<SystemBarOverlappingPolicy>

    enum class SystemBarOverlappingPolicy {
        NEVER_DISPLAY_BEHIND_SYSTEM_BAR,

        /**
         * Note: This mode is typically used in conjunction with [androidx.activity.enableEdgeToEdge].
         */
        ALLOW_DISPLAYING_BACKGROUND_BEHIND_SYSTEM_BAR,

        /**
         * Note: This mode is typically used in conjunction with [androidx.activity.enableEdgeToEdge].
         */
        ALLOW_DISPLAYING_CONTENT_BEHIND_SYSTEM_BAR
    }
}

@Composable
fun ScreenStyle.resolve() = produceStyleValues { style ->
    object : ScreenStyleValues {
        override val paddingValues = style.paddingValues.resolve()
        override val background = style.background.resolve()
        override val shape = style.shape.resolve()
        override val contentColor = style.contentColor.resolve()
        override val statusBarOverlappingPolicy = style.statusBarOverlappingPolicy.resolve()
        override val navigationBarOverlappingPolicy = style.navigationBarOverlappingPolicy.resolve()
    }
}

open class DefaultScreenStyle : ScreenStyle {
    override val paddingValues = Token(PaddingValues(all = 0.dp))
    override val background = Token(null as Brush?)
    override val shape = Token(null as Shape?)
    override val contentColor = Token(Color.Unspecified)
    override val statusBarOverlappingPolicy = Token(ALLOW_DISPLAYING_CONTENT_BEHIND_SYSTEM_BAR)
    override val navigationBarOverlappingPolicy = Token(ALLOW_DISPLAYING_CONTENT_BEHIND_SYSTEM_BAR)
}