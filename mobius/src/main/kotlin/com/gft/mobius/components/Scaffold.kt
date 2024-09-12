package com.gft.mobius.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ScaffoldStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun Scaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    contentWindowInsets: WindowInsets = WindowInsets.systemBars,
    style: ScaffoldStyle = Mobius.styles.scaffoldStyle,
    content: @Composable (PaddingValues) -> Unit
) {
    val styleValues = style.resolve()
    androidx.compose.material3.Scaffold(
        modifier = modifier,
        topBar = topBar,
        bottomBar = bottomBar,
        snackbarHost = snackbarHost,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = styleValues.floatingActionButtonPosition.toMaterial3(),
        containerColor = styleValues.background,
        contentColor = styleValues.contentColor,
        contentWindowInsets = contentWindowInsets,
        content = content
    )
}

enum class FabPosition {
    Start, Center, End, EndOverlay;

    internal fun toMaterial3() = when (this) {
        Start -> androidx.compose.material3.FabPosition.Start
        Center -> androidx.compose.material3.FabPosition.Center
        End -> androidx.compose.material3.FabPosition.End
        EndOverlay -> androidx.compose.material3.FabPosition.EndOverlay
    }
}
