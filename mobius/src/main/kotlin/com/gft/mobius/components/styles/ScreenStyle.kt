package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.components.styles.ScreenStyle.SystemBarOverlappingPolicy
import com.gft.mobius.components.styles.ScreenStyle.SystemBarOverlappingPolicy.ALLOW_DISPLAYING_BEHIND_SYSTEM_BAR

interface ScreenStyleValues : StyleValues {
    val statusBarOverlappingPolicy: SystemBarOverlappingPolicy
    val navigationBarOverlappingPolicy: SystemBarOverlappingPolicy
}

interface ScreenStyle : Style {
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
        override val statusBarOverlappingPolicy = style.statusBarOverlappingPolicy.resolve()
        override val navigationBarOverlappingPolicy = style.navigationBarOverlappingPolicy.resolve()
    }
}

open class DefaultScreenStyle : ScreenStyle {
    override val statusBarOverlappingPolicy = Token(ALLOW_DISPLAYING_BEHIND_SYSTEM_BAR)
    override val navigationBarOverlappingPolicy = Token(ALLOW_DISPLAYING_BEHIND_SYSTEM_BAR)
}