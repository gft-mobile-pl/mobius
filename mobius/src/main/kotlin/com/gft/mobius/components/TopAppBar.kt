@file:OptIn(ExperimentalComposeUiApi::class, ExperimentalMaterial3Api::class)

package com.gft.mobius.components

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior
import androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior
import androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import com.gft.mobius.Mobius
import com.gft.mobius.components.TopAppBar.ScrollConfig
import com.gft.mobius.components.styles.TopAppBarStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun TopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit,
    windowInsets: WindowInsets = WindowInsets.systemBars.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top),
    style: TopAppBarStyle = Mobius.styles.topAppBarStyle,
) {
    var scrollContext by remember { mutableStateOf<ScrollContext<ScrollConfig>?>(null) }
    val scrollBehavior = scrollContext?.scrollConfig?.let { config ->
        config.scrollType.resolveScrollBehavior(config.state, config.canScroll)
    }

    val styleValues = style.resolve()
    androidx.compose.material3.TopAppBar(
        title = {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = styleValues.titleAlignment,
                content = { title() }
            )
        },
        modifier = modifier.modifierLocalConsumer {
            scrollContext = LocalTopAppBarScrollContext.current
        },
        navigationIcon = {
            ProvideIconSize(styleValues.navigationIconSize) {
                navigationIcon()
            }
        },
        actions = {
            ProvideIconSize(styleValues.actionIconsSize) {
                actions()
            }
        },
        windowInsets = windowInsets,
        expandedHeight = styleValues.height,
        colors = TopAppBarColors(
            containerColor = styleValues.backgroundColor,
            scrolledContainerColor = styleValues.scrolledBackgroundColor,
            navigationIconContentColor = styleValues.navigationIconContentColor,
            titleContentColor = styleValues.titleContentColor,
            actionIconContentColor = styleValues.actionIconsContentColor
        ),
        scrollBehavior = scrollBehavior
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

object TopAppBar {

    @Composable
    fun scrollConfig(
        scrollType: ScrollType = ScrollType.pinned(),
        state: TopAppBarState = rememberTopAppBarState(),
        canScroll: () -> Boolean = { true },
    ) = ScrollConfig(
        scrollType = scrollType,
        state = state,
        canScroll = canScroll
    )

    data class ScrollConfig internal constructor(
        val scrollType: ScrollType,
        val state: TopAppBarState,
        val canScroll: () -> Boolean
    )

    @Stable
    sealed class ScrollType {
        @Composable
        internal abstract fun resolveScrollBehavior(state: TopAppBarState, canScroll: () -> Boolean): TopAppBarScrollBehavior

        private data object Pinned : ScrollType() {
            @Composable
            override fun resolveScrollBehavior(state: TopAppBarState, canScroll: () -> Boolean) =
                pinnedScrollBehavior(
                    state = state.state,
                    canScroll = canScroll
                )
        }

        private class ShowOrHideOnScroll(
            val snapAnimationSpec: AnimationSpec<Float>?,
            val flingAnimationSpec: DecayAnimationSpec<Float>?
        ) : ScrollType() {
            @Composable
            override fun resolveScrollBehavior(state: TopAppBarState, canScroll: () -> Boolean) =
                enterAlwaysScrollBehavior(
                    state = state.state,
                    snapAnimationSpec = snapAnimationSpec,
                    flingAnimationSpec = flingAnimationSpec,
                    canScroll = canScroll
                )
        }

        private class ScrollWithContent(
            val snapAnimationSpec: AnimationSpec<Float>?,
            val flingAnimationSpec: DecayAnimationSpec<Float>?
        ) : ScrollType() {
            @Composable
            override fun resolveScrollBehavior(state: TopAppBarState, canScroll: () -> Boolean) =
                exitUntilCollapsedScrollBehavior(
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

            @Composable
            fun scrollWithContent(
                snapAnimationSpec: AnimationSpec<Float>? = spring(stiffness = Spring.StiffnessMediumLow),
                flingAnimationSpec: DecayAnimationSpec<Float>? = rememberSplineBasedDecay()
            ): ScrollType = remember(snapAnimationSpec, flingAnimationSpec) {
                ScrollWithContent(
                    snapAnimationSpec = snapAnimationSpec,
                    flingAnimationSpec = flingAnimationSpec
                )
            }
        }
    }
}

@Stable
class TopAppBarState internal constructor(
    internal val state: androidx.compose.material3.TopAppBarState
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

    val overlappedFraction: Float
        get() {
            return state.overlappedFraction
        }
}

@Composable
fun rememberTopAppBarState(
    initialHeightOffsetLimit: Float = -Float.MAX_VALUE,
    initialHeightOffset: Float = 0f,
    initialContentOffset: Float = 0f
): TopAppBarState {
    val state = androidx.compose.material3.rememberTopAppBarState(
        initialHeightOffsetLimit = initialHeightOffsetLimit,
        initialHeightOffset = initialHeightOffset,
        initialContentOffset = initialContentOffset
    )
    return remember(state) {
        TopAppBarState(state)
    }
}
