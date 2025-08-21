@file:JvmName("MobiusPresentationAndroid")

package com.gft.mobius

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.gft.compose.interaction.LifecycleAwareBackHandler

@Composable
fun MobiusPresentation(
    onClose: () -> Unit,
) {
    val currentDestination = remember { mutableStateOf(rootDestination) }

    LifecycleAwareBackHandler {
        if (currentDestination.value == rootDestination) {
            onClose()
        }
    }

    MobiusPresentation(currentDestination = currentDestination)
}
