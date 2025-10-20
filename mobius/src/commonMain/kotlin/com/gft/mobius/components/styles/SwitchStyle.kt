package com.gft.mobius.components.styles

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.gft.designsystem.GenerateStyleValues
import com.gft.designsystem.GenerateStyleWrapper
import com.gft.designsystem.Style
import com.gft.designsystem.Token
import com.gft.mobius.Mobius
import com.gft.mobius.components.IconSize
import mobius.mobius.generated.resources.Res
import mobius.mobius.generated.resources.ic_switch_thumb_off
import mobius.mobius.generated.resources.ic_switch_thumb_on
import org.jetbrains.compose.resources.painterResource

@GenerateStyleValues
@GenerateStyleWrapper
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
    val thumbIconOn: Token<Painter?>
    val thumbIconOff: Token<Painter?>
}

open class DefaultSwitchStyle : SwitchStyle {
    override val checkedThumbColor: Token<Color> = Token { Mobius.colors.onPrimary }
    override val checkedPressedThumbColor: Token<Color> = Token { Mobius.colors.primaryContainer }
    override val checkedTrackColor: Token<Color> = Token { Mobius.colors.primary }
    override val checkedBorderColor: Token<Color> = Token(Color.Transparent)
    override val checkedThumbIconColor: Token<Color> = Token { Mobius.colors.onPrimaryContainer }
    override val checkedRippleColor: Token<Color> = Token { Mobius.colors.primary }
    override val uncheckedThumbColor: Token<Color> = Token { Mobius.colors.outline }
    override val uncheckedTrackColor: Token<Color> = Token { Mobius.colors.surfaceContainerHighest }
    override val uncheckedBorderColor: Token<Color> = Token { Mobius.colors.outline }
    override val uncheckedThumbIconColor: Token<Color> = Token { Mobius.colors.surfaceContainerHighest }
    override val uncheckedRippleColor: Token<Color> = Token { Mobius.colors.onSurface }
    override val disabledCheckedThumbColor: Token<Color> = Token { Mobius.colors.surface }
    override val disabledCheckedTrackColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.12f) }
    override val disabledCheckedBorderColor: Token<Color> = Token(Color.Transparent)
    override val disabledCheckedIconColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledUncheckedThumbColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.38f) }
    override val disabledUncheckedTrackColor: Token<Color> = Token { Mobius.colors.surfaceVariant.copy(alpha = 0.12f) }
    override val disabledUncheckedBorderColor: Token<Color> = Token { Mobius.colors.onSurface.copy(alpha = 0.12f) }
    override val disabledUncheckedIconColor: Token<Color> = Token { Mobius.colors.surfaceVariant.copy(alpha = 0.38f) }
    override val thumbIconSize: Token<IconSize> = Token { IconSize.Small }
    override val thumbIconOn: Token<Painter?> = Token { painterResource(Res.drawable.ic_switch_thumb_on) }
    override val thumbIconOff: Token<Painter?> = Token { painterResource(Res.drawable.ic_switch_thumb_off) }
}
