package com.gft.mobius.components.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.takeOrElse

@Composable
fun PaddingValues.copy(
    top: Dp = Dp.Unspecified,
    bottom: Dp = Dp.Unspecified,
    start: Dp = Dp.Unspecified,
    end: Dp = Dp.Unspecified,
): PaddingValues {
    val layoutDirection = LocalLayoutDirection.current
    return PaddingValues(
        top = top.takeOrElse { calculateTopPadding() },
        bottom = bottom.takeOrElse { calculateBottomPadding() },
        start = start.takeOrElse { calculateStartPadding(layoutDirection) },
        end = end.takeOrElse { calculateEndPadding(layoutDirection) }
    )
}