package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import com.gft.mobius.references.MobiusReferenceDimensions

interface TopAppBarStyleValues : StyleValues {
    val height: Dp
    val backgroundColor: Color
    val scrolledBackgroundColor: Color
    val navigationIconSize: IconSize
    val navigationIconContentColor: Color
    val titleAlignment: Alignment
    val titleContentColor: Color
    val actionIconsSize: IconSize
    val actionIconsContentColor: Color
}

interface TopAppBarStyle : Style {
    val height: Token<Dp>
    val backgroundColor: Token<Color>
    val scrolledBackgroundColor: Token<Color>
    val navigationIconSize: Token<IconSize>
    val navigationIconContentColor: Token<Color>
    val titleAlignment: Token<Alignment>
    val titleContentColor: Token<Color>
    val actionIconsSize: Token<IconSize>
    val actionIconsContentColor: Token<Color>
}

@Composable
fun TopAppBarStyle.resolve() = produceStyleValues { style ->
    object : TopAppBarStyleValues {
        override val height = style.height.resolve()
        override val backgroundColor = style.backgroundColor.resolve()
        override val scrolledBackgroundColor = style.scrolledBackgroundColor.resolve()
        override val navigationIconSize = style.navigationIconSize.resolve()
        override val navigationIconContentColor = style.navigationIconContentColor.resolve()
        override val actionIconsSize = style.actionIconsSize.resolve()
        override val actionIconsContentColor = style.actionIconsContentColor.resolve()
        override val titleAlignment = style.titleAlignment.resolve()
        override val titleContentColor = style.titleContentColor.resolve()
    }
}

open class DefaultTopAppBarStyle : TopAppBarStyle {
    override val height = Token(MobiusReferenceDimensions.Dimension64)
    override val backgroundColor = Token { Mobius.colors.surface }
    override val scrolledBackgroundColor = Token { Mobius.colors.surfaceContainer }
    override val navigationIconSize = Token { IconSize.Medium }
    override val navigationIconContentColor = Token { Mobius.colors.onSurface }
    override val actionIconsSize = Token { IconSize.Medium }
    override val actionIconsContentColor = Token { Mobius.colors.onSurface }
    override val titleAlignment = Token(Alignment.CenterStart)
    override val titleContentColor = Token { Mobius.colors.onSurface }
}

open class CenteredTopAppBarStyle : TopAppBarStyle {
    override val height = Token(MobiusReferenceDimensions.Dimension64)
    override val backgroundColor = Token { Mobius.colors.surface }
    override val scrolledBackgroundColor = Token { Mobius.colors.surfaceContainer }
    override val navigationIconSize = Token { IconSize.Medium }
    override val navigationIconContentColor = Token { Mobius.colors.onSurface }
    override val actionIconsSize = Token { IconSize.Medium }
    override val actionIconsContentColor = Token { Mobius.colors.onSurface }
    override val titleAlignment = Token(Alignment.Center)
    override val titleContentColor = Token { Mobius.colors.onSurface }
}
