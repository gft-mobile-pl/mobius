package com.gft.mobius.components

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.MutatePriority
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TooltipBox
import androidx.compose.material3.TooltipDefaults.rememberPlainTooltipPositionProvider
import androidx.compose.material3.TooltipDefaults.rememberRichTooltipPositionProvider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.CacheDrawScope
import androidx.compose.ui.draw.DrawResult
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.window.PopupPositionProvider
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.InfoBoxPositionProviderStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun InfoBoxPositioner(
    infoBox: @Composable InfoBoxScope.() -> Unit,
    modifier: Modifier = Modifier,
    positionProvider: PopupPositionProvider = InfoBoxPositionProvider.Center(),
    state: InfoBoxState = rememberInfoBoxState(),
    focusable: Boolean = true,
    enableUserInput: Boolean = true,
    content: @Composable () -> Unit

) {
    @OptIn(ExperimentalMaterial3Api::class)
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
    @OptIn(ExperimentalMaterial3Api::class)
    val state = androidx.compose.material3.rememberTooltipState(
        initialIsVisible = initialIsVisible,
        isPersistent = isPersistent
    )
    @OptIn(ExperimentalMaterial3Api::class)
    return remember(state) {
        InfoBoxState(state)
    }
}

object InfoBoxPositionProvider {
    @Composable
    fun Center(style: InfoBoxPositionProviderStyle = Mobius.styles.infoBoxPositionProviderStyle): PopupPositionProvider {
        val styleValues = style.resolve()
        @OptIn(ExperimentalMaterial3Api::class)
        return rememberPlainTooltipPositionProvider(styleValues.spaceFromContent)
    }

    @Composable
    fun StartOrEnd(style: InfoBoxPositionProviderStyle = Mobius.styles.infoBoxPositionProviderStyle): PopupPositionProvider {
        val styleValues = style.resolve()
        @OptIn(ExperimentalMaterial3Api::class)
        return rememberRichTooltipPositionProvider(styleValues.spaceFromContent)
    }
}

class InfoBoxScope @OptIn(ExperimentalMaterial3Api::class) internal constructor(
    internal val scope: androidx.compose.material3.TooltipScope
) {
    fun Modifier.drawPointer(draw: CacheDrawScope.(LayoutCoordinates?) -> DrawResult): Modifier {
        @OptIn(ExperimentalMaterial3Api::class)
        return with(scope) {
            this@drawPointer.drawCaret(draw)
        }
    }
}

@Stable
class InfoBoxState(
    @OptIn(ExperimentalMaterial3Api::class) internal val state: androidx.compose.material3.TooltipState
) {
    val transition: MutableTransitionState<Boolean>
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.transition
        }

    val isVisible: Boolean
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.isVisible
        }

    val isPersistent: Boolean
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.isPersistent
        }

    suspend fun show(mutatePriority: MutatePriority = MutatePriority.Default) {
        @OptIn(ExperimentalMaterial3Api::class)
        state.show(mutatePriority)
    }

    fun dismiss() {
        @OptIn(ExperimentalMaterial3Api::class)
        state.dismiss()
    }

    fun onDispose() {
        @OptIn(ExperimentalMaterial3Api::class)
        state.onDispose()
    }
}
