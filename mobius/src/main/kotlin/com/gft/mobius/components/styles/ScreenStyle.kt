package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ScreenStyle.SystemBarOverlappingPolicy
import com.gft.mobius.components.styles.ScreenStyle.SystemBarOverlappingPolicy.ALLOW_DISPLAYING_BEHIND_SYSTEM_BAR

interface ScreenStyleValues : StyleValues {
    val background: Brush?
    val contentColor: Color
    val statusBarOverlappingPolicy: SystemBarOverlappingPolicy
    val navigationBarOverlappingPolicy: SystemBarOverlappingPolicy
}

interface ScreenStyle : Style {
    val background: Token<Brush?>
    val contentColor: Token<Color>
    val statusBarOverlappingPolicy: Token<SystemBarOverlappingPolicy>
    val navigationBarOverlappingPolicy: Token<SystemBarOverlappingPolicy>

    enum class SystemBarOverlappingPolicy {
        NEVER_DISPLAY_BEHIND_SYSTEM_BAR,

        /**
         * Note: This mode is typically used in conjunction with [androidx.activity.enableEdgeToEdge].
         */
        ALLOW_DISPLAYING_BEHIND_SYSTEM_BAR
    }
}

@Composable
fun ScreenStyle.resolve() = produceStyleValues { style ->
    object : ScreenStyleValues {
        override val background: Brush? = style.background.resolve()
        override val contentColor: Color = style.contentColor.resolve()
        override val statusBarOverlappingPolicy = style.statusBarOverlappingPolicy.resolve()
        override val navigationBarOverlappingPolicy = style.navigationBarOverlappingPolicy.resolve()
    }
}

open class DefaultScreenStyle : ScreenStyle {
    override val background: Token<Brush?> = Token { SolidColor(Mobius.colors.background) }
    override val contentColor: Token<Color> = Token { Mobius.colors.onBackground }
    override val statusBarOverlappingPolicy: Token<SystemBarOverlappingPolicy> = Token(ALLOW_DISPLAYING_BEHIND_SYSTEM_BAR)
    override val navigationBarOverlappingPolicy: Token<SystemBarOverlappingPolicy> = Token(ALLOW_DISPLAYING_BEHIND_SYSTEM_BAR)
}
