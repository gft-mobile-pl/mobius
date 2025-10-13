package com.gft.mobius.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.gft.compose.common.modifyIf
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.NavigationBarStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun NavigationBar(
    modifier: Modifier = Modifier,
    wrapper: Modifier = Modifier,
    windowInsets: WindowInsets = WindowInsets.systemBars.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom),
    style: NavigationBarStyle = Mobius.styles.navigationBarStyle,
    content: @Composable NavigationBarScope.() -> Unit
) {
    val styleValues = style.resolve()
    androidx.compose.material3.NavigationBar(
        modifier = wrapper
            .modifyIf(styleValues.shape != null) {
                clip(styleValues.shape!!)
            }
            .background(styleValues.backgroundColor)
            .padding(styleValues.padding)
            .then(modifier),
        containerColor = Color.Unspecified,
        contentColor = styleValues.contentColor,
        tonalElevation = styleValues.tonalElevation,
        windowInsets = windowInsets,
        content = {
            NavigationBarScope(this).content()
        }
    )
}

interface NavigationBarScope : RowScope

private fun NavigationBarScope(rowScope: RowScope) = object : NavigationBarScope, RowScope by rowScope {}
