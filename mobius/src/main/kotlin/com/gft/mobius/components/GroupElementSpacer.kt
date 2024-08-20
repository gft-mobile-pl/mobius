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
fun ColumnScope.SmallGroupElementSpacer() {
    Spacer(Modifier.height(Mobius.styles.groupElementSpacerStyle.resolve().smallVerticalElementsSpacing))
}

@Composable
@NonRestartableComposable
fun ColumnScope.GroupElementSpacer() {
    Spacer(Modifier.height(Mobius.styles.groupElementSpacerStyle.resolve().mediumVerticalElementsSpacing))
}


@Composable
@NonRestartableComposable
fun ColumnScope.LargeGroupElementSpacer() {
    Spacer(Modifier.height(Mobius.styles.groupElementSpacerStyle.resolve().largeVerticalElementsSpacing))
}

@Composable
@NonRestartableComposable
fun RowScope.SmallGroupElementSpacer() {
    Spacer(Modifier.width(Mobius.styles.groupElementSpacerStyle.resolve().smallHorizontalElementsSpacing))
}

@Composable
@NonRestartableComposable
fun RowScope.GroupElementSpacer() {
    Spacer(Modifier.width(Mobius.styles.groupElementSpacerStyle.resolve().mediumHorizontalElementsSpacing))
}


@Composable
@NonRestartableComposable
fun RowScope.LargeGroupElementSpacer() {
    Spacer(Modifier.width(Mobius.styles.groupElementSpacerStyle.largeHorizontalElementsSpacing.resolve()))
}
