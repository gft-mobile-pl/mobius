package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.GenerateStyleWrapper
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.mobius.Mobius

@GenerateStyleValues
@GenerateStyleWrapper
interface CheckboxStyle : Style {
    val checkedCheckmarkColor : Token<Color>
    val checkedRippleColor : Token<Color>
    val checkedBoxColor : Token<Color>
    val checkedBorderColor : Token<Color>
    val uncheckedCheckmarkColor : Token<Color>
    val uncheckedRippleColor : Token<Color>
    val uncheckedBoxColor : Token<Color>
    val uncheckedBorderColor : Token<Color>
    val disabledCheckedBoxColor : Token<Color>
    val disabledUncheckedBoxColor : Token<Color>
    val disabledIndeterminateBoxColor : Token<Color>
    val disabledBorderColor : Token<Color>
    val disabledUncheckedBorderColor : Token<Color>
    val disabledIndeterminateBorderColor : Token<Color>
    val errorCheckmarkColor : Token<Color>
    val errorRippleColor : Token<Color>
    val errorCheckedBoxColor : Token<Color>
    val errorUncheckedBoxColor : Token<Color>
    val errorBorderColor : Token<Color>
}

open class DefaultCheckboxStyle : CheckboxStyle {
    override val checkedCheckmarkColor: Token<Color> = Token { Mobius.colors.onPrimary }
    override val checkedRippleColor: Token<Color> = Token { Mobius.colors.primary }
    override val checkedBoxColor: Token<Color> = Token { Mobius.colors.primary }
    override val checkedBorderColor: Token<Color> = Token { Mobius.colors.primary }
    override val uncheckedCheckmarkColor: Token<Color> = Token(Color.Transparent)
    override val uncheckedRippleColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val uncheckedBoxColor: Token<Color> = Token(Color.Transparent)
    override val uncheckedBorderColor: Token<Color> = Token { Mobius.colors.onSurfaceVariant }
    override val disabledCheckedBoxColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledUncheckedBoxColor: Token<Color> = Token(Color.Transparent)
    override val disabledIndeterminateBoxColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledBorderColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledUncheckedBorderColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledIndeterminateBorderColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val errorCheckmarkColor: Token<Color> = Token { Mobius.colors.onPrimary }
    override val errorRippleColor: Token<Color> = Token { Mobius.colors.error }
    override val errorCheckedBoxColor: Token<Color> = Token { Mobius.colors.error }
    override val errorUncheckedBoxColor: Token<Color> = Token(Color.Transparent)
    override val errorBorderColor: Token<Color> = Token { Mobius.colors.error }
}
