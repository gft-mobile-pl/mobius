package com.gft.mobius.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.gft.compose.common.modifyIf
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.NavigationRailStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun NavigationRail(
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    header: @Composable (NavigationRailScope.() -> Unit)? = null,
    windowInsets: WindowInsets = WindowInsets.systemBars.only(WindowInsetsSides.Vertical + WindowInsetsSides.Start),
    style: NavigationRailStyle = Mobius.styles.navigationRailStyle,
    content: @Composable NavigationRailScope.() -> Unit
) {
    val styleValues = style.resolve()
    androidx.compose.material3.NavigationRail(
        modifier = wrapper
            .modifyIf(styleValues.shape != null) {
                clip(styleValues.shape!!)
            }
            .background(styleValues.backgroundColor)
            .padding(styleValues.padding)
            .then(modifier),
        containerColor = Color.Unspecified,
        contentColor = styleValues.contentColor,
        header = header?.let {
            {
                NavigationRailScope(this).header()
            }
        },
        windowInsets = windowInsets,
        content = {
            Column(Modifier.fillMaxHeight(), verticalArrangement = styleValues.arrangement) {
                NavigationRailScope(this).content()
            }
        }
    )
}

interface NavigationRailScope : ColumnScope

private fun NavigationRailScope(columnScope: ColumnScope) = object : NavigationRailScope, ColumnScope by columnScope {}
