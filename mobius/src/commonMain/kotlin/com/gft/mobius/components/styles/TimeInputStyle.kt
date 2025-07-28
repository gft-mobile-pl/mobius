package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.mobius.Mobius

@GenerateStyleValues
interface TimeInputStyle : Style {
    val periodSelectorBorderColor: Token<Color>
    val periodSelectorSelectedContainerColor: Token<Color>
    val periodSelectorUnselectedContainerColor: Token<Color>
    val periodSelectorSelectedContentColor: Token<Color>
    val periodSelectorUnselectedContentColor: Token<Color>
    val timeSelectorSelectedContainerColor: Token<Color>
    val timeSelectorUnselectedContainerColor: Token<Color>
    val timeSelectorSelectedContentColor: Token<Color>
    val timeSelectorUnselectedContentColor: Token<Color>
}

open class DefaultTimeInputStyle : TimeInputStyle {
    override val periodSelectorBorderColor: Token<Color> = Token { Mobius.colors.outline }
    override val periodSelectorSelectedContainerColor: Token<Color> = Token { Mobius.colors.tertiaryContainer }
    override val periodSelectorUnselectedContainerColor: Token<Color> = Token { Color.Transparent }
    override val periodSelectorSelectedContentColor: Token<Color> = Token { Mobius.colors.onTertiaryContainer }
    override val periodSelectorUnselectedContentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val timeSelectorSelectedContainerColor: Token<Color> = Token { Mobius.colors.primaryContainer }
    override val timeSelectorUnselectedContainerColor: Token<Color> = Token { Mobius.colors.surfaceContainerHighest }
    override val timeSelectorSelectedContentColor: Token<Color> = Token { Mobius.colors.onPrimaryContainer }
    override val timeSelectorUnselectedContentColor: Token<Color> = Token { Mobius.colors.onSurface }
}
