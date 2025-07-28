package com.gft.mobius.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.resolve
import kotlin.jvm.JvmInline

@JvmInline
value class IconSize(
    internal val size: Dp,
) {
    companion object {
        val Small: IconSize @Composable get() = IconSize(Mobius.styles.iconSizeStyle.resolve().smallIconSize)
        val Medium: IconSize @Composable get() = IconSize(Mobius.styles.iconSizeStyle.resolve().mediumIconSize)
        val Large: IconSize @Composable get() = IconSize(Mobius.styles.iconSizeStyle.resolve().largeIconSize)
        val ExtraLarge: IconSize @Composable get() = IconSize(Mobius.styles.iconSizeStyle.resolve().extraLargeIconSize)
        val Unspecified: IconSize = IconSize(Dp.Unspecified)
    }
}
