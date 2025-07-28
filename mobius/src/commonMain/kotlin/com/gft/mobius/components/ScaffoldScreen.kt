package com.gft.mobius.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ScaffoldScreenStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun ScaffoldScreen(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    contentWindowInsets: WindowInsets = WindowInsets.systemBars,
    style: ScaffoldScreenStyle = Mobius.styles.scaffoldScreenStyle,
    content: @Composable ScreenScope.(PaddingValues) -> Unit
) {
    val styleValues = style.resolve()
    Screen(
        style = style
    ) {
        androidx.compose.material3.Scaffold(
            modifier = modifier,
            topBar = topBar,
            bottomBar = bottomBar,
            snackbarHost = snackbarHost,
            floatingActionButton = floatingActionButton,
            floatingActionButtonPosition = styleValues.floatingActionButtonPosition.toMaterial3(),
            containerColor = Color.Unspecified,
            contentColor = Color.Unspecified,
            contentWindowInsets = contentWindowInsets,
            content = { paddingValues ->
                Column {
                    ScreenScope(this).content(paddingValues)
                }
            }
        )
    }
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
