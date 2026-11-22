package com.gft.mobius.components

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.MutatePriority
import androidx.compose.material3.TooltipAnchorPosition
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults.rememberTooltipPositionProvider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.window.PopupPositionProvider
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.InfoBoxPositionProviderStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun InfoBoxPositioner(
    infoBox: @Composable InfoBoxScope.() -> Unit,
    modifier: Modifier = Modifier,
    positionProvider: PopupPositionProvider = InfoBoxPositionProvider.center(),
    state: InfoBoxState = rememberInfoBoxState(),
    focusable: Boolean = true,
    enableUserInput: Boolean = true,
    content: @Composable () -> Unit

) {
    TooltipBox(
        positionProvider = positionProvider,
        tooltip = {
            with(InfoBoxScope(this)) { infoBox() }
        },
        modifier = modifier,
        focusable = focusable,
        enableUserInput = enableUserInput,
        state = state.state,
        content = content,
    )
}

@Composable
fun rememberInfoBoxState(
    initialIsVisible: Boolean = false,
    isPersistent: Boolean = false,
): InfoBoxState {
    val state = androidx.compose.material3.rememberTooltipState(
        initialIsVisible = initialIsVisible,
        isPersistent = isPersistent
    )
    return remember(state) {
        InfoBoxState(state)
    }
}

object InfoBoxPositionProvider {
    @Composable
    fun center(style: InfoBoxPositionProviderStyle = Mobius.styles.infoBoxPositionProviderStyle): PopupPositionProvider {
        val styleValues = style.resolve()
        return rememberTooltipPositionProvider(TooltipAnchorPosition.Above, styleValues.spaceFromContent)
    }

    @Composable
    fun startOrEnd(style: InfoBoxPositionProviderStyle = Mobius.styles.infoBoxPositionProviderStyle): PopupPositionProvider {
        val styleValues = style.resolve()
        return rememberTooltipPositionProvider(TooltipAnchorPosition.Above, styleValues.spaceFromContent)
    }
}

class InfoBoxScope internal constructor(
    internal val scope: androidx.compose.material3.TooltipScope
) {
    fun MeasureScope.obtainAnchorBounds(): LayoutCoordinates? = with(scope) {
        obtainAnchorBounds()
    }

    fun obtainPositionProvider(): PopupPositionProvider = scope.obtainPositionProvider()
}

@Stable
class InfoBoxState(
    internal val state: androidx.compose.material3.TooltipState
) {
    val transition: MutableTransitionState<Boolean>
        get() {
            return state.transition
        }

    val isVisible: Boolean
        get() {
            return state.isVisible
        }

    val isPersistent: Boolean
        get() {
            return state.isPersistent
        }

    suspend fun show(mutatePriority: MutatePriority = MutatePriority.Default) {
        state.show(mutatePriority)
    }

    fun dismiss() {
        state.dismiss()
    }

    fun onDispose() {
        state.onDispose()
    }
}
