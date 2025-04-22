package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Token
import com.gft.designsystem.TokenReference
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.FabPosition

@GenerateStyleValues
interface ScaffoldScreenStyle : ScreenStyle {
    val floatingActionButtonPosition: Token<FabPosition>
}

open class DefaultScaffoldScreenStyle : ScaffoldScreenStyle {
    override val background: Token<Brush?> = TokenReference { Mobius.styles.screenStyle.background }
    override val contentColor: Token<Color> = TokenReference { Mobius.styles.screenStyle.contentColor }
    override val statusBarOverlappingPolicy: Token<ScreenStyle.SystemBarOverlappingPolicy> = TokenReference { Mobius.styles.screenStyle.statusBarOverlappingPolicy }
    override val navigationBarOverlappingPolicy: Token<ScreenStyle.SystemBarOverlappingPolicy> = TokenReference { Mobius.styles.screenStyle.navigationBarOverlappingPolicy }
    override val floatingActionButtonPosition: Token<FabPosition> = Token { FabPosition.End }
}
