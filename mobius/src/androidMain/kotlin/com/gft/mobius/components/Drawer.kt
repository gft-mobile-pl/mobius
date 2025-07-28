@file:JvmName("DrawerAndroid")

package com.gft.mobius.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.DismissibleNavigationDrawer
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
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
    handlePredictiveBack: Boolean = false,
    windowsInsets: WindowInsets = WindowInsets.systemBars.only(
        WindowInsetsSides.Vertical + WindowInsetsSides.Start
    ),
    style: DrawerStyle = Mobius.styles.drawerStyle,
    content: @Composable () -> Unit,
) {
    val styleValues = style.resolve()
    when (val placement = styleValues.placement) {
        is Modal -> ModalNavigationDrawer(
            drawerContent = {
                DrawerSheet(
                    handlePredictiveBack = handlePredictiveBack,
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
                    handlePredictiveBack = handlePredictiveBack,
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
    handlePredictiveBack: Boolean,
    drawerController: DrawerController,
    modifier: Modifier,
    windowsInsets: WindowInsets,
    drawerContent: @Composable ColumnScope.() -> Unit,
) {
    if (handlePredictiveBack) {
        ModalDrawerSheet(
            drawerState = drawerController.controller,
            modifier = modifier,
            drawerContainerColor = Color.Unspecified,
            drawerContentColor = Color.Unspecified,
            drawerTonalElevation = MobiusReferenceElevations.Level0,
            drawerShape = RectangleShape,
            windowInsets = windowsInsets,
            content = drawerContent
        )
    } else {
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
}
