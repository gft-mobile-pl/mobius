@file:JvmName("MobiusPresentationNavigationBarAndroid")

package com.gft.mobius.components

import androidx.compose.runtime.Composable
import com.gft.compose.interaction.LifecycleAwareBackHandler

@Composable
internal actual fun MobiusPresentationNavigationBar(
    title: String,
    onBack: () -> Unit,
) {
    LifecycleAwareBackHandler {
        onBack()
    }
    MobiusPresentationNavigationBarContent(title, onBack)
}
