package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.designsystem.codegen.annotation.GenerateStyleValues
import com.gft.mobius.Mobius

@GenerateStyleValues
interface RadioButtonStyle : Style {
    val selectedColor: Token<Color>
    val unselectedColor: Token<Color>
    val disabledSelectedColor: Token<Color>
    val disabledUnselectedColor: Token<Color>
    val selectedRippleColor: Token<Color>
    val unselectedRippleColor: Token<Color>
}

open class DefaultRadioButtonStyle : RadioButtonStyle {
    override val selectedColor: Token<Color> = Token { Mobius.colors.primary }
    override val unselectedColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledSelectedColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledUnselectedColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val selectedRippleColor: Token<Color> = Token { Mobius.colors.primary }
    override val unselectedRippleColor: Token<Color> = Token { Mobius.colors.onSurface }
}
