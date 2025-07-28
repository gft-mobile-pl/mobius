@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)

package com.gft.mobius.components

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.BottomAppBarScrollBehavior
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.modifier.modifierLocalConsumer
import com.gft.mobius.Mobius
import com.gft.mobius.components.BottomAppBar.ScrollConfig
import com.gft.mobius.components.styles.BottomAppBarStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun BottomAppBar(
    actions: @Composable RowScope.() -> Unit,
    modifier: Modifier = Modifier,
    floatingActionButton: @Composable (BottomAppBarFloatingActionButtonScope.() -> Unit)? = null,
    windowInsets: WindowInsets = WindowInsets.systemBars.only(
        WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
    ),
    style: BottomAppBarStyle = Mobius.styles.bottomAppBarStyle
) {
    BottomAppBar(
        modifier = modifier,
        windowInsets = windowInsets,
        style = style,
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = Modifier.weight(1f),
                content = actions
            )
            if (floatingActionButton != null) {
                with(BottomAppBarFloatingActionButtonScope) {
                    floatingActionButton()
                }
            }
        }
    }
}

@Composable
fun BottomAppBar(
    modifier: Modifier = Modifier,
    windowInsets: WindowInsets = WindowInsets.systemBars.only(
        WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom
    ),
    style: BottomAppBarStyle = Mobius.styles.bottomAppBarStyle,
    content: @Composable RowScope.() -> Unit
) {
    var scrollContext by remember { mutableStateOf<ScrollContext<ScrollConfig>?>(null) }
    val scrollBehavior = scrollContext?.scrollConfig?.let { config ->
        config.scrollType.resolveScrollBehavior(config.state, config.canScroll)
    }

    val styleValues = style.resolve()
    androidx.compose.material3.BottomAppBar(
        modifier = modifier.modifierLocalConsumer {
            scrollContext = LocalBottomAppBarScrollContext.current
        },
        containerColor = styleValues.backgroundColor,
        contentColor = styleValues.contentColor,
        tonalElevation = styleValues.tonalElevation,
        contentPadding = styleValues.padding,
        windowInsets = windowInsets,
        scrollBehavior = scrollBehavior,
        content = content
    )

    DisposableEffect(scrollContext) {
        val connection = scrollBehavior?.nestedScrollConnection
        val appBarsConnection = scrollContext?.appBarsNestedScrollConnection
        if (connection != null) appBarsConnection?.registerNestedScrollConnection(connection)
        onDispose {
            if (connection != null) appBarsConnection?.unregisterNestedScrollConnection(connection)
        }
    }
}

object BottomAppBar {

    @Composable
    fun scrollConfig(
        scrollType: ScrollType = ScrollType.pinned(),
        state: BottomAppBarState = rememberBottomAppBarState(),
        canScroll: () -> Boolean = { true },
    ) = ScrollConfig(
        scrollType = scrollType,
        state = state,
        canScroll = canScroll
    )

    data class ScrollConfig internal constructor(
        val scrollType: ScrollType,
        val state: BottomAppBarState,
        val canScroll: () -> Boolean
    )

    @Stable
    sealed class ScrollType {
        @Composable
        internal abstract fun resolveScrollBehavior(state: BottomAppBarState, canScroll: () -> Boolean): BottomAppBarScrollBehavior?

        private data object Pinned : ScrollType() {
            @Composable
            override fun resolveScrollBehavior(state: BottomAppBarState, canScroll: () -> Boolean) = null
        }

        private class ShowOrHideOnScroll(
            val snapAnimationSpec: AnimationSpec<Float>?,
            val flingAnimationSpec: DecayAnimationSpec<Float>?
        ) : ScrollType() {
            @Composable
            override fun resolveScrollBehavior(state: BottomAppBarState, canScroll: () -> Boolean) =
                ShowOrHideScrollBehavior(
                    state = state.state,
                    snapAnimationSpec = snapAnimationSpec,
                    flingAnimationSpec = flingAnimationSpec,
                    canScroll = canScroll
                )
        }

        companion object {
            @Composable
            fun pinned(): ScrollType = Pinned

            @Composable
            fun showOrHideOnScroll(
                snapAnimationSpec: AnimationSpec<Float>? = spring(stiffness = Spring.StiffnessMediumLow),
                flingAnimationSpec: DecayAnimationSpec<Float>? = rememberSplineBasedDecay()
            ): ScrollType = remember(snapAnimationSpec, flingAnimationSpec) {
                ShowOrHideOnScroll(
                    snapAnimationSpec = snapAnimationSpec,
                    flingAnimationSpec = flingAnimationSpec
                )
            }
        }
    }
}

@Stable
class BottomAppBarState internal constructor(
    internal val state: androidx.compose.material3.BottomAppBarState
) {
    var heightOffsetLimit: Float
        get() {
            return state.heightOffsetLimit
        }
        set(value) {
            state.heightOffsetLimit = value
        }

    var heightOffset: Float
        get() {
            return state.heightOffset
        }
        set(value) {
            state.heightOffset = value
        }

    var contentOffset: Float
        get() {
            return state.contentOffset
        }
        set(value) {
            state.contentOffset = value
        }

    val collapsedFraction: Float
        get() {
            return state.collapsedFraction
        }
}

@Composable
fun rememberBottomAppBarState(
    initialHeightOffsetLimit: Float = -Float.MAX_VALUE,
    initialHeightOffset: Float = 0f,
    initialContentOffset: Float = 0f
): BottomAppBarState {
    val state = androidx.compose.material3.rememberBottomAppBarState(
        initialHeightOffsetLimit = initialHeightOffsetLimit,
        initialHeightOffset = initialHeightOffset,
        initialContentOffset = initialContentOffset
    )
    return remember(state) {
        BottomAppBarState(state)
    }
}

interface BottomAppBarFloatingActionButtonScope {
    companion object : BottomAppBarFloatingActionButtonScope
}

private class ShowOrHideScrollBehavior(
    override val state: androidx.compose.material3.BottomAppBarState,
    override val snapAnimationSpec: AnimationSpec<Float>?,
    override val flingAnimationSpec: DecayAnimationSpec<Float>?,
    val canScroll: () -> Boolean = { true }
) : BottomAppBarScrollBehavior {
    override val isPinned: Boolean = false
    override val nestedScrollConnection: NestedScrollConnection = object : NestedScrollConnection {
        @Suppress("SameReturnValue")
        override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
            if (!canScroll()) return Offset.Zero
            state.contentOffset += available.y
            if (state.heightOffset == 0f || state.heightOffset == state.heightOffsetLimit) {
                if (available.y == 0f && available.y > 0f) {
                    state.contentOffset = 0f
                }
            }
            state.heightOffset += available.y
            return Offset.Zero
        }
    }
}
