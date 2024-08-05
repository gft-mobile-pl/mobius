package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius

interface RadioButtonStyleValues : StyleValues {
    val selectedColor: Color
    val unselectedColor: Color
    val disabledSelectedColor: Color
    val disabledUnselectedColor: Color
    val selectedRippleColor: Color
    val unselectedRippleColor: Color
}

interface RadioButtonStyle : Style {
    val selectedColor: Token<Color>
    val unselectedColor: Token<Color>
    val disabledSelectedColor: Token<Color>
    val disabledUnselectedColor: Token<Color>
    val selectedRippleColor: Token<Color>
    val unselectedRippleColor: Token<Color>
}

@Composable
fun RadioButtonStyle.resolve() = produceStyleValues { style ->
    object : RadioButtonStyleValues {
        override val selectedColor = style.selectedColor.resolve()
        override val unselectedColor = style.unselectedColor.resolve()
        override val disabledSelectedColor = style.disabledSelectedColor.resolve()
        override val disabledUnselectedColor = style.disabledUnselectedColor.resolve()
        override val selectedRippleColor = style.selectedRippleColor.resolve()
        override val unselectedRippleColor = style.unselectedRippleColor.resolve()
    }
}

open class DefaultRadioButtonStyle : RadioButtonStyle {
    override val selectedColor: Token<Color> = Token { Mobius.colors.primary }
    override val unselectedColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledSelectedColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledUnselectedColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val selectedRippleColor: Token<Color> = Token { Mobius.colors.primary }
    override val unselectedRippleColor: Token<Color> = Token { Mobius.colors.onSurface }
}
