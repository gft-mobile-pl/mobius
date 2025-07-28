package com.gft.mobius.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.DrawerStyle
import com.gft.mobius.components.styles.DrawerStyle.Placement.Modal
import com.gft.mobius.components.styles.DrawerStyle.Placement.Slide
import com.gft.mobius.components.styles.resolve
import com.gft.mobius.references.MobiusReferenceElevations

@Composable
fun Drawer(
    drawerContent: @Composable ColumnScope.() -> Unit,
    modifier: Modifier = Modifier,
    drawerController: DrawerController = rememberDrawerController(DrawerState.Closed),
    gesturesEnabled: Boolean = true,
    windowsInsets: WindowInsets = WindowInsets.systemBars.only(
        WindowInsetsSides.Vertical + WindowInsetsSides.Start
    ),
    style: DrawerStyle = Mobius.styles.drawerStyle,
    content: @Composable () -> Unit
) {
    val styleValues = style.resolve()
    when (val placement = styleValues.placement) {
        is Modal -> ModalNavigationDrawer(
            drawerContent = {
                DrawerSheet(
                    drawerController = drawerController,
                    modifier = modifier.padding(styleValues.padding),
                    windowsInsets = windowsInsets,
                    drawerContent = drawerContent
                )
            },
            modifier = modifier,
            drawerState = drawerController.controller,
            gesturesEnabled = gesturesEnabled,
            scrimColor = placement.dimColor,
            content = content
        )

        Slide -> DismissibleNavigationDrawer(
            drawerContent = {
                DrawerSheet(
                    drawerController = drawerController,
                    modifier = modifier.padding(styleValues.padding),
                    windowsInsets = windowsInsets,
                    drawerContent = drawerContent
                )
            },
            modifier = modifier,
            drawerState = drawerController.controller,
            gesturesEnabled = gesturesEnabled,
            content = content
        )
    }
}

@Composable
private fun DrawerSheet(
    drawerController: DrawerController,
    modifier: Modifier,
    windowsInsets: WindowInsets,
    drawerContent: @Composable ColumnScope.() -> Unit,
) {
    ModalDrawerSheet(
        modifier = modifier,
        drawerContainerColor = Color.Unspecified,
        drawerContentColor = Color.Unspecified,
        drawerTonalElevation = MobiusReferenceElevations.Level0,
        drawerShape = RectangleShape,
        windowInsets = windowsInsets,
        content = drawerContent
    )
}

@Composable
fun rememberDrawerController(
    initialState: DrawerState,
    stateConfirmationCallback: (DrawerState) -> Boolean = { true }
): DrawerController {
    val controller = rememberDrawerState(
        initialValue = initialState.toMaterial3(),
        confirmStateChange = { stateConfirmationCallback(it.toState()) }
    )
    return remember(controller) {
        DrawerController(controller)
    }
}

@Stable
class DrawerController internal constructor (
    internal val controller: androidx.compose.material3.DrawerState
) {
    val currentState: DrawerState get() = controller.currentValue.toState()

    val isAnimationRunning: Boolean get() = controller.isAnimationRunning

    suspend fun open() = controller.open()

    suspend fun close() = controller.close()

    suspend fun setState(state: DrawerState, animate: Boolean) {
        if (animate && state == DrawerState.Closed) {
            controller.close()
        } else if (animate && state == DrawerState.Open) {
            controller.open()
        } else {
            controller.snapTo(state.toMaterial3())
        }
    }

    val targetState: DrawerState = controller.targetValue.toState()

    val currentOffset: Float get() = controller.currentOffset
}

enum class DrawerState {
    Open, Closed;

    internal fun toMaterial3() = when (this) {
        Open -> DrawerValue.Open
        Closed -> DrawerValue.Closed
    }
}

private fun DrawerValue.toState() = when (this) {
    DrawerValue.Open -> DrawerState.Open
    DrawerValue.Closed -> DrawerState.Closed
}
