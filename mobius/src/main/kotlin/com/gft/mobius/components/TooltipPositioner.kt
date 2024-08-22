package com.gft.mobius.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Label
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.CacheDrawScope
import androidx.compose.ui.draw.DrawResult
import androidx.compose.ui.layout.LayoutCoordinates
import com.gft.mobius.components.TooltipVisibilityPolicy.OnInteraction
import com.gft.mobius.components.TooltipVisibilityPolicy.Static

@Composable
fun TooltipPositioner(
    tooltip: String,
    modifier: Modifier = Modifier,
    visibilityPolicy: TooltipVisibilityPolicy,
    content: @Composable (MutableInteractionSource?) -> Unit
) {
    TooltipPositioner(
        tooltip = { Tooltip(message = tooltip) },
        modifier = modifier,
        visibilityPolicy = visibilityPolicy,
        content = content
    )
}

@Composable
fun TooltipPositioner(
    tooltip: @Composable TooltipScope.() -> Unit,
    modifier: Modifier = Modifier,
    visibilityPolicy: TooltipVisibilityPolicy,
    content: @Composable (MutableInteractionSource?) -> Unit
) {
    val interactionSource = when(visibilityPolicy) {
        is OnInteraction -> visibilityPolicy.interactionSource ?: remember { MutableInteractionSource() }
        is Static -> null
    }

    @OptIn(ExperimentalMaterial3Api::class)
    Label(
        modifier = modifier,
        interactionSource = interactionSource,
        isPersistent = visibilityPolicy.isPersistent,
        label = {
            with(TooltipScope(this)) {
                tooltip()
            }
        },
        content = { content(interactionSource) }
    )
}

class TooltipScope @OptIn(ExperimentalMaterial3Api::class) internal constructor(
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
sealed class TooltipVisibilityPolicy(
    internal val isPersistent: Boolean,
    internal val interactionSource: MutableInteractionSource?
) {
    class Static(visible: Boolean) : TooltipVisibilityPolicy(visible, null)
    class OnInteraction(interactionSource: MutableInteractionSource? = null) : TooltipVisibilityPolicy(false, interactionSource)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TooltipVisibilityPolicy

        if (isPersistent != other.isPersistent) return false
        if (interactionSource != other.interactionSource) return false

        return true
    }

    override fun hashCode(): Int {
        var result = isPersistent.hashCode()
        result = 31 * result + (interactionSource?.hashCode() ?: 0)
        return result
    }
}
