package com.gft.mobius.components

import androidx.annotation.FloatRange
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun SwipeToDismissBox(
    controller: SwipeToDismissBoxController,
    backgroundContent: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
    allowSwipeToEnd: Boolean = true,
    allowSwipeToStart: Boolean = true,
    onDismissed: (SwipeToDismissBoxState) -> Unit,
    content: @Composable RowScope.() -> Unit,
) {
    LaunchedEffect(controller.currentState) {
        if (controller.currentState != SwipeToDismissBoxState.Visible) {
            onDismissed(controller.currentState)
        }
    }
    androidx.compose.material3.SwipeToDismissBox(
        state = controller.controller,
        backgroundContent = backgroundContent,
        modifier = modifier,
        enableDismissFromStartToEnd = allowSwipeToEnd,
        enableDismissFromEndToStart = allowSwipeToStart,
        gesturesEnabled = allowSwipeToStart || allowSwipeToEnd,
        content = content
    )
}

@Composable
fun rememberSwipeToDismissBoxController(
    initialState: SwipeToDismissBoxState = SwipeToDismissBoxState.Visible,
    stateConfirmationCallback: (SwipeToDismissBoxState) -> Boolean = { true },
    swipeThreshold: (boxWidth: Float) -> Float = { boxWidth -> boxWidth / 3 }
): SwipeToDismissBoxController {
    val controller = androidx.compose.material3.rememberSwipeToDismissBoxState(
        initialValue = initialState.toMaterial3(),
        confirmValueChange = { stateConfirmationCallback(it.toState()) },
        positionalThreshold = swipeThreshold
    )
    return remember(controller) {
        SwipeToDismissBoxController(controller)
    }
}

class SwipeToDismissBoxController(internal val controller: androidx.compose.material3.SwipeToDismissBoxState) {
    fun requireOffset(): Float = controller.requireOffset()

    val currentState: SwipeToDismissBoxState
        get() = controller.currentValue.toState()

    val targetState: SwipeToDismissBoxState
        get() = controller.targetValue.toState()

    @get:FloatRange(from = 0.0, to = 1.0)
    val swipeProgress: Float
        get() = controller.progress

    val swipeDirection: SwipeToDismissBoxState
        get() = controller.dismissDirection.toState()

    suspend fun setState(targetValue: SwipeToDismissBoxState, animate: Boolean) =
        if (animate) {
            controller.dismiss(targetValue.toMaterial3())
        } else {
            controller.snapTo(targetValue.toMaterial3())
        }

    suspend fun reset() = controller.reset()
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
