package com.gft.mobius.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier

@Composable
fun SwipeToDismissBox(
    controller: SwipeToDismissBoxController,
    backgroundContent: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
    allowSwipeToEnd: Boolean = true,
    allowSwipeToStart: Boolean = true,
    onDismissed: (SwipeToDismissBoxState) -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) {
    val currentOnDismissed by rememberUpdatedState(onDismissed)
    androidx.compose.material3.SwipeToDismissBox(
        state = controller.state,
        backgroundContent = backgroundContent,
        modifier = modifier,
        enableDismissFromStartToEnd = allowSwipeToEnd,
        enableDismissFromEndToStart = allowSwipeToStart,
        gesturesEnabled = allowSwipeToStart || allowSwipeToEnd,
        onDismiss = remember {
            { value -> currentOnDismissed(value.toState()) }
        },
        content = content
    )
}

@Composable
fun rememberSwipeToDismissBoxController(
    initialState: SwipeToDismissBoxState = SwipeToDismissBoxState.Visible,
    swipeThreshold: (boxWidth: Float) -> Float = { boxWidth -> boxWidth / 3 }
): SwipeToDismissBoxController {
    val state = androidx.compose.material3.rememberSwipeToDismissBoxState(
        initialValue = initialState.toMaterial3(),
        positionalThreshold = swipeThreshold
    )
    return remember(state) { SwipeToDismissBoxController(state) }
}

class SwipeToDismissBoxController internal constructor(
    internal val state: androidx.compose.material3.SwipeToDismissBoxState,
) {
    fun requireOffset(): Float = state.requireOffset()

    val currentValue: SwipeToDismissBoxState
        get() = state.currentValue.toState()

    val targetValue: SwipeToDismissBoxState
        get() = state.targetValue.toState()

    val settledValue: SwipeToDismissBoxState
        get() = state.settledValue.toState()

    val swipeProgress: Float
        get() = state.progress

    val swipeDirection: SwipeToDismissBoxState
        get() = state.dismissDirection.toState()

    suspend fun snapTo(targetValue: SwipeToDismissBoxState) {
        state.snapTo(targetValue.toMaterial3())
    }

    suspend fun setState(targetValue: SwipeToDismissBoxState, animate: Boolean) =
        if (animate) {
            state.dismiss(targetValue.toMaterial3())
        } else {
            state.snapTo(targetValue.toMaterial3())
        }

    suspend fun dismiss(direction: SwipeToDismissBoxState) {
        state.dismiss(direction.toMaterial3())
    }
}

enum class SwipeToDismissBoxState {
    Visible,
    SwipedToEnd,
    SwipedToStart;

    internal fun toMaterial3() = when (this) {
        SwipedToEnd -> SwipeToDismissBoxValue.StartToEnd
        SwipedToStart -> SwipeToDismissBoxValue.EndToStart
        Visible -> SwipeToDismissBoxValue.Settled
    }
}

private fun SwipeToDismissBoxValue.toState() = when (this) {
    SwipeToDismissBoxValue.StartToEnd -> SwipeToDismissBoxState.SwipedToEnd
    SwipeToDismissBoxValue.EndToStart -> SwipeToDismissBoxState.SwipedToStart
    SwipeToDismissBoxValue.Settled -> SwipeToDismissBoxState.Visible
}
