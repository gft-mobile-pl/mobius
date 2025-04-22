package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.GenerateStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.components.TimePickerLayoutType
import com.gft.mobius.components.TimePickerLayoutType.Sensor

@GenerateStyleValues
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
