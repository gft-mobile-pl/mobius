package com.gft.mobius.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.resolve

@Composable
@NonRestartableComposable
fun ColumnScope.SmallContentElementsSpacer() {
    Spacer(Modifier.height(Mobius.styles.contentElementSpacerStyle.resolve().smallVerticalElementsSpacing))
}

@Composable
@NonRestartableComposable
fun ColumnScope.ContentElementsSpacer() {
    Spacer(Modifier.height(Mobius.styles.contentElementSpacerStyle.resolve().mediumVerticalElementsSpacing))
}


@Composable
@NonRestartableComposable
fun ColumnScope.LargeContentElementsSpacer() {
    Spacer(Modifier.height(Mobius.styles.contentElementSpacerStyle.resolve().largeVerticalElementsSpacing))
}

@Composable
@NonRestartableComposable
fun RowScope.SmallContentElementsSpacer() {
    Spacer(Modifier.width(Mobius.styles.contentElementSpacerStyle.resolve().smallHorizontalElementsSpacing))
}

@Composable
@NonRestartableComposable
fun RowScope.ContentElementsSpacer() {
    Spacer(Modifier.width(Mobius.styles.contentElementSpacerStyle.resolve().mediumHorizontalElementsSpacing))
}


@Composable
@NonRestartableComposable
fun RowScope.LargeContentElementsSpacer() {
    Spacer(Modifier.width(Mobius.styles.contentElementSpacerStyle.largeHorizontalElementsSpacing.resolve()))
}
