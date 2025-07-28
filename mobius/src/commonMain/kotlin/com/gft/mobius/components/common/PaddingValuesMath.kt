package com.gft.mobius.components.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.coerceAtLeast
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.takeOrElse

@Composable
fun PaddingValues.union(
    top: Dp = Dp.Unspecified,
    bottom: Dp = Dp.Unspecified,
    start: Dp = Dp.Unspecified,
    end: Dp = Dp.Unspecified,
) = union(
    layoutDirection = LocalLayoutDirection.current,
    top = top,
    bottom = bottom,
    start = start,
    end = end
)

@Composable
fun PaddingValues.union(
    other: PaddingValues,
): PaddingValues {
    val layoutDirection = LocalLayoutDirection.current
    return union(
        layoutDirection = LocalLayoutDirection.current,
        top = other.calculateTopPadding(),
        bottom = other.calculateBottomPadding(),
        start = other.calculateStartPadding(layoutDirection),
        end = other.calculateEndPadding(layoutDirection)
    )
}

@Composable
private fun PaddingValues.union(
    layoutDirection: LayoutDirection,
    top: Dp = Dp.Unspecified,
    bottom: Dp = Dp.Unspecified,
    start: Dp = Dp.Unspecified,
    end: Dp = Dp.Unspecified,
): PaddingValues {
    return PaddingValues(
        top = max(calculateTopPadding(), top.takeOrElse { 0.dp }),
        bottom = max(calculateBottomPadding(), bottom.takeOrElse { 0.dp }),
        start = max(calculateStartPadding(layoutDirection), start.takeOrElse { 0.dp }),
        end = max(calculateEndPadding(layoutDirection), end.takeOrElse { 0.dp })
    )
}

@Composable
fun PaddingValues.minus(
    other: PaddingValues,
): PaddingValues {
    val layoutDirection = LocalLayoutDirection.current
    return PaddingValues(
        top = (calculateTopPadding() - other.calculateTopPadding()).coerceAtLeast(0.dp),
        bottom = (calculateBottomPadding() - other.calculateBottomPadding()).coerceAtLeast(0.dp),
        start = (calculateStartPadding(layoutDirection) - other.calculateStartPadding(layoutDirection)).coerceAtLeast(0.dp),
        end = (calculateEndPadding(layoutDirection) - other.calculateEndPadding(layoutDirection)).coerceAtLeast(0.dp),
    )
}