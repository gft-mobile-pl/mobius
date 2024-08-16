package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius

interface TimeInputStyleValues : StyleValues {
    val periodSelectorBorderColor: Color
    val periodSelectorSelectedContainerColor: Color
    val periodSelectorUnselectedContainerColor: Color
    val periodSelectorSelectedContentColor: Color
    val periodSelectorUnselectedContentColor: Color
    val timeSelectorSelectedContainerColor: Color
    val timeSelectorUnselectedContainerColor: Color
    val timeSelectorSelectedContentColor: Color
    val timeSelectorUnselectedContentColor: Color
}

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

@Composable
fun TimeInputStyle.resolve() = produceStyleValues { style ->
    object : TimeInputStyleValues {
        override val periodSelectorBorderColor = style.periodSelectorBorderColor.resolve()
        override val periodSelectorSelectedContainerColor = style.periodSelectorSelectedContainerColor.resolve()
        override val periodSelectorUnselectedContainerColor = style.periodSelectorUnselectedContainerColor.resolve()
        override val periodSelectorSelectedContentColor = style.periodSelectorSelectedContentColor.resolve()
        override val periodSelectorUnselectedContentColor = style.periodSelectorUnselectedContentColor.resolve()
        override val timeSelectorSelectedContainerColor = style.timeSelectorSelectedContainerColor.resolve()
        override val timeSelectorUnselectedContainerColor = style.timeSelectorUnselectedContainerColor.resolve()
        override val timeSelectorSelectedContentColor = style.timeSelectorSelectedContentColor.resolve()
        override val timeSelectorUnselectedContentColor = style.timeSelectorUnselectedContentColor.resolve()
    }
}

open class DefaultTimeInputStyle : TimeInputStyle {
    override val periodSelectorBorderColor = Token { Mobius.colors.outline }
    override val periodSelectorSelectedContainerColor = Token { Mobius.colors.tertiaryContainer }
    override val periodSelectorUnselectedContainerColor = Token { Color.Transparent }
    override val periodSelectorSelectedContentColor = Token { Mobius.colors.onTertiaryContainer }
    override val periodSelectorUnselectedContentColor = Token { Mobius.colors.onSurfaceVariant }
    override val timeSelectorSelectedContainerColor = Token { Mobius.colors.primaryContainer }
    override val timeSelectorUnselectedContainerColor = Token { Mobius.colors.surfaceContainerHighest }
    override val timeSelectorSelectedContentColor = Token { Mobius.colors.onPrimaryContainer }
    override val timeSelectorUnselectedContentColor = Token { Mobius.colors.onSurface }
}
