package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.FabPosition

interface ScaffoldScreenStyleValues : ScreenStyleValues {
    val floatingActionButtonPosition: FabPosition
}

interface ScaffoldScreenStyle : ScreenStyle {
    val floatingActionButtonPosition: Token<FabPosition>
}

@Composable
fun ScaffoldScreenStyle.resolve() = produceStyleValues { style ->
    object : ScaffoldScreenStyleValues {
        override val background = style.background.resolve()
        override val contentColor = style.contentColor.resolve()
        override val statusBarOverlappingPolicy = style.statusBarOverlappingPolicy.resolve()
        override val navigationBarOverlappingPolicy = style.navigationBarOverlappingPolicy.resolve()
        override val floatingActionButtonPosition = style.floatingActionButtonPosition.resolve()
    }
}

open class DefaultScaffoldScreenStyle : ScaffoldScreenStyle {
    override val background: Token<Brush?> = TokenReference { Mobius.styles.screenStyle.background }
    override val contentColor: Token<Color> = TokenReference { Mobius.styles.screenStyle.contentColor }
    override val statusBarOverlappingPolicy: Token<ScreenStyle.SystemBarOverlappingPolicy> = TokenReference { Mobius.styles.screenStyle.statusBarOverlappingPolicy }
    override val navigationBarOverlappingPolicy: Token<ScreenStyle.SystemBarOverlappingPolicy> = TokenReference { Mobius.styles.screenStyle.navigationBarOverlappingPolicy }
    override val floatingActionButtonPosition: Token<FabPosition> = Token { FabPosition.End }
}
