package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius

interface CheckboxStyleValues : StyleValues {
    val checkedCheckmarkColor : Color
    val checkedRippleColor : Color
    val checkedBoxColor : Color
    val checkedBorderColor : Color
    val uncheckedCheckmarkColor : Color
    val uncheckedRippleColor : Color
    val uncheckedBoxColor : Color
    val uncheckedBorderColor : Color
    val disabledCheckedBoxColor : Color
    val disabledUncheckedBoxColor : Color
    val disabledIndeterminateBoxColor : Color
    val disabledBorderColor : Color
    val disabledUncheckedBorderColor : Color
    val disabledIndeterminateBorderColor : Color
    val errorCheckmarkColor : Color
    val errorRippleColor : Color
    val errorCheckedBoxColor : Color
    val errorUncheckedBoxColor : Color
    val errorBorderColor : Color
}

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

@Composable
fun CheckboxStyle.resolve() = produceStyleValues { style ->
    object : CheckboxStyleValues {
        override val checkedCheckmarkColor = style.checkedCheckmarkColor.resolve()
        override val checkedRippleColor = style.checkedRippleColor.resolve()
        override val checkedBoxColor = style.checkedBoxColor.resolve()
        override val checkedBorderColor = style.checkedBorderColor.resolve()
        override val uncheckedCheckmarkColor = style.uncheckedCheckmarkColor.resolve()
        override val uncheckedRippleColor = style.uncheckedRippleColor.resolve()
        override val uncheckedBoxColor = style.uncheckedBoxColor.resolve()
        override val uncheckedBorderColor = style.uncheckedBorderColor.resolve()
        override val disabledCheckedBoxColor = style.disabledCheckedBoxColor.resolve()
        override val disabledUncheckedBoxColor = style.disabledUncheckedBoxColor.resolve()
        override val disabledIndeterminateBoxColor = style.disabledIndeterminateBoxColor.resolve()
        override val disabledBorderColor = style.disabledBorderColor.resolve()
        override val disabledUncheckedBorderColor = style.disabledUncheckedBorderColor.resolve()
        override val disabledIndeterminateBorderColor = style.disabledIndeterminateBorderColor.resolve()
        override val errorCheckmarkColor = style.errorCheckmarkColor.resolve()
        override val errorRippleColor = style.errorRippleColor.resolve()
        override val errorCheckedBoxColor = style.errorCheckedBoxColor.resolve()
        override val errorUncheckedBoxColor = style.errorUncheckedBoxColor.resolve()
        override val errorBorderColor = style.errorBorderColor.resolve()
    }
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
