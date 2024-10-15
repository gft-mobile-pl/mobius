@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)

package com.gft.mobius.components

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.DecayAnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.rememberSplineBasedDecay
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.BottomAppBarDefaults.exitAlwaysScrollBehavior
import androidx.compose.material3.BottomAppBarScrollBehavior
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.modifier.modifierLocalProvider
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.BottomAppBarStyle
import com.gft.mobius.components.styles.resolve


private val LocalBottomAppBarScrollBehavior = modifierLocalOf<BottomAppBarScrollBehavior?> { null }


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
                BottomAppBarFloatingActionButtonScope.floatingActionButton()
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
    val scrollBehavior = remember {
        mutableStateOf<BottomAppBarScrollBehavior?>(null)
    }
    val styleValues = style.resolve()
    androidx.compose.material3.BottomAppBar(
        modifier = modifier.modifierLocalConsumer {
            scrollBehavior.value = LocalBottomAppBarScrollBehavior.current
        },
        containerColor = styleValues.backgroundColor,
        contentColor = styleValues.contentColor,
        tonalElevation = styleValues.tonalElevation,
        contentPadding = styleValues.padding,
        windowInsets = windowInsets,
        scrollBehavior = scrollBehavior.value,
        content = content
    )
}

@Composable
fun BottomAppBarScope(
    modifier: Modifier = Modifier,
    scrollType: BottomAppBarScrollType = BottomAppBarScrollType.pinned(),
    state: BottomAppBarState = rememberBottomAppBarState(),
    canScroll: () -> Boolean = { true },
    content: @Composable () -> Unit,
) {
    Box(modifier.bottomAppBarScope(scrollType, state, canScroll)) {
        content()
    }
}

@Composable
fun Modifier.bottomAppBarScope(
    scrollType: BottomAppBarScrollType = BottomAppBarScrollType.pinned(),
    state: BottomAppBarState = rememberBottomAppBarState(),
    canScroll: () -> Boolean = { true }
): Modifier {
    val scrollBehavior = scrollType.resolveScrollBehavior(state, canScroll)
    return scrollBehavior?.let {
        this
            .modifierLocalProvider(LocalBottomAppBarScrollBehavior) { scrollBehavior }
            .nestedScroll(scrollBehavior.nestedScrollConnection)
    } ?: this
}

@Stable
sealed class BottomAppBarScrollType {
    @Composable
    internal abstract fun resolveScrollBehavior(state: BottomAppBarState, canScroll: () -> Boolean): BottomAppBarScrollBehavior?

    private data object Pinned : BottomAppBarScrollType() {
        @Composable
        override fun resolveScrollBehavior(state: BottomAppBarState, canScroll: () -> Boolean) = null
    }

    private class ShowOrHideOnScroll(
        val snapAnimationSpec: AnimationSpec<Float>?,
        val flingAnimationSpec: DecayAnimationSpec<Float>?
    ) : BottomAppBarScrollType() {
        @Composable
        override fun resolveScrollBehavior(state: BottomAppBarState, canScroll: () -> Boolean) =
            exitAlwaysScrollBehavior(
                state = state.state,
                snapAnimationSpec = snapAnimationSpec,
                flingAnimationSpec = flingAnimationSpec,
                canScroll = canScroll
            )
    }

    companion object {
        @Composable
        fun pinned(): BottomAppBarScrollType = Pinned

        @Composable
        fun showOrHideOnScroll(
            snapAnimationSpec: AnimationSpec<Float>? = spring(stiffness = Spring.StiffnessMediumLow),
            flingAnimationSpec: DecayAnimationSpec<Float>? = rememberSplineBasedDecay()
        ): BottomAppBarScrollType = remember(snapAnimationSpec, flingAnimationSpec) {
            ShowOrHideOnScroll(
                snapAnimationSpec = snapAnimationSpec,
                flingAnimationSpec = flingAnimationSpec
            )
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
