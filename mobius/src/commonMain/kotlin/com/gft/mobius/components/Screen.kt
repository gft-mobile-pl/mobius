package com.gft.mobius.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.takeOrElse
import androidx.lifecycle.Lifecycle
import com.gft.compose.common.modifyIf
import com.gft.compose.interaction.InteractionFilter
import com.gft.compose.interaction.clearFocusOnClick
import com.gft.mobius.Mobius
import com.gft.mobius.colors.LocalContentColor
import com.gft.mobius.components.styles.ScreenStyle
import com.gft.mobius.components.styles.ScreenStyle.SystemBarOverlappingPolicy.ALLOW_SCREEN_BACKGROUND_BEHIND_SYSTEM_BAR
import com.gft.mobius.components.styles.ScreenStyle.SystemBarOverlappingPolicy.NEVER_DISPLAY_BEHIND_SYSTEM_BAR
import com.gft.mobius.components.styles.resolve

@Composable
fun Screen(
    modifier: Modifier = Modifier,
    minActiveState: Lifecycle.State = Lifecycle.State.RESUMED,
    clearFocusOnClick: Boolean = true,
    style: ScreenStyle = Mobius.styles.screenStyle,
    content: @Composable ScreenScope.() -> Unit,
) {
    val styleValues = style.resolve()
    val contentColor = styleValues.contentColor.takeOrElse { LocalContentColor.current }

    InteractionFilter(
        minActiveState = minActiveState
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .modifyIf(styleValues.statusBarOverlappingPolicy == NEVER_DISPLAY_BEHIND_SYSTEM_BAR) {
                        statusBarsPadding()
                    }
                    .modifyIf(styleValues.navigationBarOverlappingPolicy == NEVER_DISPLAY_BEHIND_SYSTEM_BAR) {
                        navigationBarsPadding()
                    }
                    .modifyIf(styleValues.background != null) {
                        background(styleValues.background!!)
                    }
                    .modifyIf(styleValues.statusBarOverlappingPolicy == ALLOW_SCREEN_BACKGROUND_BEHIND_SYSTEM_BAR) {
                        statusBarsPadding()
                    }
                    .modifyIf(styleValues.navigationBarOverlappingPolicy == ALLOW_SCREEN_BACKGROUND_BEHIND_SYSTEM_BAR) {
                        navigationBarsPadding()
                    }
                    .modifyIf(clearFocusOnClick) { clearFocusOnClick() }

                    .then(modifier),
            ) {
                ScreenScope(this).content()
            }
        }
    }
}

interface ScreenScope : ColumnScope

internal fun ScreenScope(columnScope: ColumnScope): ScreenScope = object : ScreenScope, ColumnScope by columnScope {}
