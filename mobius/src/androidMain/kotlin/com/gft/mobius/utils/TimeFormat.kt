package com.gft.mobius.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext

@Composable
@ReadOnlyComposable
internal actual fun is24HourFormat(): Boolean =
    android.text.format.DateFormat.is24HourFormat(LocalContext.current)
