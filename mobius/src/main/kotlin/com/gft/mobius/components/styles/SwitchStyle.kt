package com.gft.mobius.components.styles

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.Style
import com.gft.designsystem.StyleValues
import com.gft.designsystem.Token
import com.gft.designsystem.produceStyleValues
import com.gft.mobius.Mobius
import com.gft.mobius.R
import com.gft.mobius.components.IconSize
import com.gft.mobius.graphics.DrawableRes

interface SwitchStyleValues : StyleValues {
    val checkedThumbColor: Color
    val checkedPressedThumbColor: Color
    val checkedTrackColor: Color
    val checkedBorderColor: Color
    val checkedThumbIconColor: Color
    val checkedRippleColor: Color
    val uncheckedThumbColor: Color
    val uncheckedTrackColor: Color
    val uncheckedBorderColor: Color
    val uncheckedThumbIconColor: Color
    val uncheckedRippleColor: Color
    val disabledCheckedThumbColor: Color
    val disabledCheckedTrackColor: Color
    val disabledCheckedBorderColor: Color
    val disabledCheckedIconColor: Color
    val disabledUncheckedThumbColor: Color
    val disabledUncheckedTrackColor: Color
    val disabledUncheckedBorderColor: Color
    val disabledUncheckedIconColor: Color
    val thumbIconSize: IconSize
    val thumbIconOn: DrawableRes?
    val thumbIconOff: DrawableRes?
}

interface SwitchStyle : Style {
    val checkedThumbColor: Token<Color>
    val checkedPressedThumbColor: Token<Color>
    val checkedTrackColor: Token<Color>
    val checkedBorderColor: Token<Color>
    val checkedThumbIconColor: Token<Color>
    val checkedRippleColor: Token<Color>
    val uncheckedThumbColor: Token<Color>
    val uncheckedTrackColor: Token<Color>
    val uncheckedBorderColor: Token<Color>
    val uncheckedThumbIconColor: Token<Color>
    val uncheckedRippleColor: Token<Color>
    val disabledCheckedThumbColor: Token<Color>
    val disabledCheckedTrackColor: Token<Color>
    val disabledCheckedBorderColor: Token<Color>
    val disabledCheckedIconColor: Token<Color>
    val disabledUncheckedThumbColor: Token<Color>
    val disabledUncheckedTrackColor: Token<Color>
    val disabledUncheckedBorderColor: Token<Color>
    val disabledUncheckedIconColor: Token<Color>
    val thumbIconSize: Token<IconSize>
    val thumbIconOn: Token<DrawableRes?>
    val thumbIconOff: Token<DrawableRes?>
}

@Composable
fun SwitchStyle.resolve() = produceStyleValues { style ->
    object : SwitchStyleValues {
        override val checkedThumbColor = style.checkedThumbColor.resolve()
        override val checkedPressedThumbColor = style.checkedPressedThumbColor.resolve()
        override val checkedTrackColor = style.checkedTrackColor.resolve()
        override val checkedBorderColor = style.checkedBorderColor.resolve()
        override val checkedThumbIconColor = style.checkedThumbIconColor.resolve()
        override val checkedRippleColor = style.checkedRippleColor.resolve()
        override val uncheckedThumbColor = style.uncheckedThumbColor.resolve()
        override val uncheckedTrackColor = style.uncheckedTrackColor.resolve()
        override val uncheckedBorderColor = style.uncheckedBorderColor.resolve()
        override val uncheckedThumbIconColor = style.uncheckedThumbIconColor.resolve()
        override val uncheckedRippleColor = style.uncheckedRippleColor.resolve()
        override val disabledCheckedThumbColor = style.disabledCheckedThumbColor.resolve()
        override val disabledCheckedTrackColor = style.disabledCheckedTrackColor.resolve()
        override val disabledCheckedBorderColor = style.disabledCheckedBorderColor.resolve()
        override val disabledCheckedIconColor = style.disabledCheckedIconColor.resolve()
        override val disabledUncheckedThumbColor = style.disabledUncheckedThumbColor.resolve()
        override val disabledUncheckedTrackColor = style.disabledUncheckedTrackColor.resolve()
        override val disabledUncheckedBorderColor = style.disabledUncheckedBorderColor.resolve()
        override val disabledUncheckedIconColor = style.disabledUncheckedIconColor.resolve()
        override val thumbIconSize = style.thumbIconSize.resolve()
        override val thumbIconOn = style.thumbIconOn.resolve()
        override val thumbIconOff = style.thumbIconOff.resolve()
    }
}

open class DefaultSwitchStyle : SwitchStyle {
    override val checkedThumbColor = Token { Mobius.colors.onPrimary }
    override val checkedPressedThumbColor = Token { Mobius.colors.primaryContainer }
    override val checkedTrackColor = Token { Mobius.colors.primary }
    override val checkedBorderColor = Token(Color.Transparent)
    override val checkedThumbIconColor = Token { Mobius.colors.onPrimaryContainer }
    override val checkedRippleColor: Token<Color> = Token { Mobius.colors.primary }
    override val uncheckedThumbColor = Token { Mobius.colors.outline }
    override val uncheckedTrackColor = Token { Mobius.colors.surfaceContainerHighest }
    override val uncheckedBorderColor = Token { Mobius.colors.outline }
    override val uncheckedThumbIconColor = Token { Mobius.colors.surfaceContainerHighest }
    override val uncheckedRippleColor = Token { Mobius.colors.onSurface }
    override val disabledCheckedThumbColor = Token { Mobius.colors.surface }
    override val disabledCheckedTrackColor = Token { Mobius.colors.onSurface.copy(alpha = 0.12f) }
    override val disabledCheckedBorderColor = Token(Color.Transparent)
    override val disabledCheckedIconColor = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledUncheckedThumbColor = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledUncheckedTrackColor = Token { Mobius.colors.surfaceVariant.copy(alpha = 0.12f) }
    override val disabledUncheckedBorderColor = Token { Mobius.colors.onSurface.copy(alpha = 0.12f) }
    override val disabledUncheckedIconColor = Token { Mobius.colors.surfaceVariant.copy(alpha = 0.38f) }
    override val thumbIconSize = Token { IconSize.Small }
    override val thumbIconOn: Token<DrawableRes?> = Token(DrawableRes(R.drawable.ic_switch_thumb_on))
    override val thumbIconOff: Token<DrawableRes?> = Token(DrawableRes(R.drawable.ic_switch_thumb_off))
}
