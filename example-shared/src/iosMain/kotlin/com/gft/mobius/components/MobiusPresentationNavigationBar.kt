package com.gft.mobius.components

import androidx.compose.runtime.Composable

@Composable
internal actual fun MobiusPresentationNavigationBar(
    title: String,
    onBack: () -> Unit,
) {
    MobiusPresentationNavigationBarContent(title, onBack)
}
