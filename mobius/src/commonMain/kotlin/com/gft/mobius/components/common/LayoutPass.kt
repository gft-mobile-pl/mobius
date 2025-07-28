package com.gft.mobius.components.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf

internal object MainLayoutPass

internal val LocalLayoutPass = compositionLocalOf<Any> { MainLayoutPass }

@Composable
internal fun isInMainLayoutPass() = LocalLayoutPass.current == MainLayoutPass