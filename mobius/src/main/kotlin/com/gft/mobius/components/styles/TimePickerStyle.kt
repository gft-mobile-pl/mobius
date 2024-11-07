package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.TimePickerLayoutType
import com.gft.mobius.components.TimePickerLayoutType.Sensor

interface TimePickerStyleValues : StyleValues {
    val clockDialColor: Color
    val clockDialSelectedContentColor: Color
    val clockDialUnselectedContentColor: Color
    val selectorColor: Color
    val periodSelectorBorderColor: Color
    val periodSelectorSelectedContainerColor: Color
    val periodSelectorUnselectedContainerColor: Color
    val periodSelectorSelectedContentColor: Color
    val periodSelectorUnselectedContentColor: Color
    val timeSelectorSelectedContainerColor: Color
    val timeSelectorUnselectedContainerColor: Color
    val timeSelectorSelectedContentColor: Color
    val timeSelectorUnselectedContentColor: Color
    val layoutType: TimePickerLayoutType
}

interface TimePickerStyle : Style {
    val clockDialColor: Token<Color>
    val clockDialSelectedContentColor: Token<Color>
    val clockDialUnselectedContentColor: Token<Color>
    val selectorColor: Token<Color>
    val periodSelectorBorderColor: Token<Color>
    val periodSelectorSelectedContainerColor: Token<Color>
    val periodSelectorUnselectedContainerColor: Token<Color>
    val periodSelectorSelectedContentColor: Token<Color>
    val periodSelectorUnselectedContentColor: Token<Color>
    val timeSelectorSelectedContainerColor: Token<Color>
    val timeSelectorUnselectedContainerColor: Token<Color>
    val timeSelectorSelectedContentColor: Token<Color>
    val timeSelectorUnselectedContentColor: Token<Color>
    val layoutType: Token<TimePickerLayoutType>
}

@Composable
fun TimePickerStyle.resolve() = produceStyleValues { style ->
    object : TimePickerStyleValues {
        override val clockDialColor = style.clockDialColor.resolve()
        override val clockDialSelectedContentColor = style.clockDialSelectedContentColor.resolve()
        override val clockDialUnselectedContentColor = style.clockDialUnselectedContentColor.resolve()
        override val selectorColor = style.selectorColor.resolve()
        override val periodSelectorBorderColor = style.periodSelectorBorderColor.resolve()
        override val periodSelectorSelectedContainerColor = style.periodSelectorSelectedContainerColor.resolve()
        override val periodSelectorUnselectedContainerColor = style.periodSelectorUnselectedContainerColor.resolve()
        override val periodSelectorSelectedContentColor = style.periodSelectorSelectedContentColor.resolve()
        override val periodSelectorUnselectedContentColor = style.periodSelectorUnselectedContentColor.resolve()
        override val timeSelectorSelectedContainerColor = style.timeSelectorSelectedContainerColor.resolve()
        override val timeSelectorUnselectedContainerColor = style.timeSelectorUnselectedContainerColor.resolve()
        override val timeSelectorSelectedContentColor = style.timeSelectorSelectedContentColor.resolve()
        override val timeSelectorUnselectedContentColor = style.timeSelectorUnselectedContentColor.resolve()
        override val layoutType = style.layoutType.resolve()
    }
}

open class DefaultTimePickerStyle : TimePickerStyle {
    override val clockDialColor: Token<Color> = Token { Mobius.colors.surfaceContainerHighest }
    override val clockDialSelectedContentColor: Token<Color> = Token { Mobius.colors.onPrimary }
    override val clockDialUnselectedContentColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val selectorColor: Token<Color> = Token { Mobius.colors.primary }
    override val periodSelectorBorderColor: Token<Color> = Token { Mobius.colors.outline }
    override val periodSelectorSelectedContainerColor: Token<Color> = Token { Mobius.colors.tertiaryContainer }
    override val periodSelectorUnselectedContainerColor: Token<Color> = Token(Color.Transparent)
    override val periodSelectorSelectedContentColor: Token<Color> = Token { Mobius.colors.onTertiaryContainer }
    override val periodSelectorUnselectedContentColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val timeSelectorSelectedContainerColor: Token<Color> = Token { Mobius.colors.primaryContainer }
    override val timeSelectorUnselectedContainerColor: Token<Color> = Token { Mobius.colors.surfaceContainerHighest }
    override val timeSelectorSelectedContentColor: Token<Color> = Token { Mobius.colors.onPrimaryContainer }
    override val timeSelectorUnselectedContentColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val layoutType: Token<TimePickerLayoutType> = Token(Sensor)
}
