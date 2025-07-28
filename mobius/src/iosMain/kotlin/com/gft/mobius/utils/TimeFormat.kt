package com.gft.mobius.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSLocale
import platform.Foundation.currentLocale

@Composable
@ReadOnlyComposable
internal actual fun is24HourFormat(): Boolean {
    val format = NSDateFormatter.dateFormatFromTemplate("j", options = 0u, NSLocale.currentLocale) ?: return true
    return !format.contains("a")
}
