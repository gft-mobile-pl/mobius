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
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.modifier.modifierLocalProvider
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.TopAppBarStyle
import com.gft.mobius.components.styles.resolve

@OptIn(ExperimentalMaterial3Api::class)
private val LocalTopAppBarScrollBehavior = modifierLocalOf<TopAppBarScrollBehavior?> { null }

@Composable
@OptIn(ExperimentalComposeUiApi::class)
fun TopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit,
    windowInsets: WindowInsets = WindowInsets.systemBars.only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top),
    style: TopAppBarStyle = Mobius.styles.topAppBarStyle,
) {
    @OptIn(ExperimentalMaterial3Api::class)
    val scrollBehavior = remember {
        mutableStateOf<TopAppBarScrollBehavior?>(null)
    }
    val styleValues = style.resolve()
    @OptIn(ExperimentalMaterial3Api::class)
    androidx.compose.material3.TopAppBar(
        title = {
            Box(
                Modifier.fillMaxSize(),
                contentAlignment = styleValues.titleAlignment,
                content = { title() }
            )
        },
        modifier = modifier.modifierLocalConsumer {
            scrollBehavior.value = LocalTopAppBarScrollBehavior.current
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
        scrollBehavior = scrollBehavior.value
    )
}

@Composable
fun TopAppBarScope(
    modifier: Modifier = Modifier,
    scrollType: TopAppBarScrollType = TopAppBarScrollType.pinned(),
    state: TopAppBarState = rememberTopAppBarState(),
    canScroll: () -> Boolean = { true },
    content: @Composable () -> Unit,
) {
    Box(modifier.topAppBarScope(scrollType, state, canScroll)) {
        content()
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun Modifier.topAppBarScope(
    scrollType: TopAppBarScrollType = TopAppBarScrollType.pinned(),
    state: TopAppBarState = rememberTopAppBarState(),
    canScroll: () -> Boolean = { true }
): Modifier {
    @OptIn(ExperimentalMaterial3Api::class)
    val scrollBehavior = scrollType.resolveScrollBehavior(state, canScroll)
    @OptIn(ExperimentalMaterial3Api::class)
    return this
        .modifierLocalProvider(LocalTopAppBarScrollBehavior) { scrollBehavior }
        .nestedScroll(scrollBehavior.nestedScrollConnection)
}

@Stable
sealed class TopAppBarScrollType {
    @Composable
    @OptIn(ExperimentalMaterial3Api::class)
    internal abstract fun resolveScrollBehavior(state: TopAppBarState, canScroll: () -> Boolean): TopAppBarScrollBehavior

    private object Pinned : TopAppBarScrollType() {
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        override fun resolveScrollBehavior(state: TopAppBarState, canScroll: () -> Boolean) =
            pinnedScrollBehavior(
                state = state.state,
                canScroll = canScroll
            )
    }

    private class ShowOrHideOnScroll (
        val snapAnimationSpec: AnimationSpec<Float>?,
        val flingAnimationSpec: DecayAnimationSpec<Float>?
    ) : TopAppBarScrollType() {
        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        override fun resolveScrollBehavior(state: TopAppBarState, canScroll: () -> Boolean) =
            enterAlwaysScrollBehavior(
                state = state.state,
                snapAnimationSpec = snapAnimationSpec,
                flingAnimationSpec = flingAnimationSpec,
                canScroll = canScroll
            )
    }

    private class ScrollWithContent (
        val snapAnimationSpec: AnimationSpec<Float>?,
        val flingAnimationSpec: DecayAnimationSpec<Float>?
    ) : TopAppBarScrollType() {
        @OptIn(ExperimentalMaterial3Api::class)
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
        fun pinned(): TopAppBarScrollType = Pinned

        @Composable
        fun showOrHideOnScroll(
            snapAnimationSpec: AnimationSpec<Float>? = spring(stiffness = Spring.StiffnessMediumLow),
            flingAnimationSpec: DecayAnimationSpec<Float>? = rememberSplineBasedDecay()
        ): TopAppBarScrollType = remember(snapAnimationSpec, flingAnimationSpec) {
            ShowOrHideOnScroll(
                snapAnimationSpec = snapAnimationSpec,
                flingAnimationSpec = flingAnimationSpec
            )
        }

        @Composable
        fun scrollWithContent(
            snapAnimationSpec: AnimationSpec<Float>? = spring(stiffness = Spring.StiffnessMediumLow),
            flingAnimationSpec: DecayAnimationSpec<Float>? = rememberSplineBasedDecay()
        ): TopAppBarScrollType = remember(snapAnimationSpec, flingAnimationSpec) {
            ScrollWithContent(
                snapAnimationSpec = snapAnimationSpec,
                flingAnimationSpec = flingAnimationSpec
            )
        }
    }
}

@Stable
class TopAppBarState internal constructor(
    @OptIn(ExperimentalMaterial3Api::class)
    internal val state: androidx.compose.material3.TopAppBarState
) {
    var heightOffsetLimit: Float
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.heightOffsetLimit
        }
        set(value) {
            @OptIn(ExperimentalMaterial3Api::class)
            state.heightOffsetLimit = value
        }

    var heightOffset: Float
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.heightOffset
        }
        set(value) {
            @OptIn(ExperimentalMaterial3Api::class)
            state.heightOffset = value
        }

    var contentOffset: Float
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.contentOffset
        }
        set(value) {
            @OptIn(ExperimentalMaterial3Api::class)
            state.contentOffset = value
        }

    val collapsedFraction: Float
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.collapsedFraction
        }

    val overlappedFraction: Float
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.overlappedFraction
        }
}

@Composable
fun rememberTopAppBarState(
    initialHeightOffsetLimit: Float = -Float.MAX_VALUE,
    initialHeightOffset: Float = 0f,
    initialContentOffset: Float = 0f
): TopAppBarState {
    @OptIn(ExperimentalMaterial3Api::class)
    val state = androidx.compose.material3.rememberTopAppBarState(
        initialHeightOffsetLimit = initialHeightOffsetLimit,
        initialHeightOffset = initialHeightOffset,
        initialContentOffset = initialContentOffset
    )
    @OptIn(ExperimentalMaterial3Api::class)
    return remember(state) {
        TopAppBarState(state)
    }
}
