package com.gft.mobius.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier

@Composable
@NonRestartableComposable
fun ColumnScope.SmallElementSpacer() {
    Spacer(Modifier.height(LocalContentStyle.current.smallVerticalElementsSpacing))
}

@Composable
@NonRestartableComposable
fun ColumnScope.ElementSpacer() {
    Spacer(Modifier.height(LocalContentStyle.current.mediumVerticalElementsSpacing))
}


@Composable
@NonRestartableComposable
fun ColumnScope.LargeElementSpacer() {
    Spacer(Modifier.height(LocalContentStyle.current.largeVerticalElementsSpacing))
}

@Composable
@NonRestartableComposable
fun RowScope.SmallElementSpacer() {
    Spacer(Modifier.width(LocalContentStyle.current.smallHorizontalElementsSpacing))
}

@Composable
@NonRestartableComposable
fun RowScope.ElementSpacer() {
    Spacer(Modifier.width(LocalContentStyle.current.mediumHorizontalElementsSpacing))
}


@Composable
@NonRestartableComposable
fun RowScope.LargeElementSpacer() {
    Spacer(Modifier.width(LocalContentStyle.current.largeHorizontalElementsSpacing))
}
