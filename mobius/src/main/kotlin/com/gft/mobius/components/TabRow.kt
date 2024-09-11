package com.gft.mobius.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ScrollableTabRowStyle
import com.gft.mobius.components.styles.TabIndicatorStyle
import com.gft.mobius.components.styles.TabIndicatorWidth
import com.gft.mobius.components.styles.TabIndicatorWidth.Fixed
import com.gft.mobius.components.styles.TabIndicatorWidth.MatchContent
import com.gft.mobius.components.styles.TabIndicatorWidth.MatchTab
import com.gft.mobius.components.styles.TabRowStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun PrimaryTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    tabs: @Composable () -> Unit,
) = TabRow(
    selectedTabIndex = selectedTabIndex,
    modifier = modifier,
    style = Mobius.styles.primaryTabRow,
    tabs = tabs
)

@Composable
fun SecondaryTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    tabs: @Composable () -> Unit,
) = TabRow(
    selectedTabIndex = selectedTabIndex,
    modifier = modifier,
    style = Mobius.styles.secondaryTabRow,
    tabs = tabs
)

@Composable
fun TabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    style: TabRowStyle,
    tabs: @Composable () -> Unit,
) {
    val styleValues = style.resolve()
    TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = styleValues.containerColor,
        tabIndicator = TabRow.styleableTabIndicator(styleValues.indicatorStyle),
        divider = { HorizontalDivider(style = styleValues.dividerStyle) },
        tabs = tabs
    )
}


@Composable
fun TabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color,
    tabIndicator: @Composable TabIndicatorScope.(selectedTabIndex: Int, tabBounds: List<TabBounds>) -> Unit,
    divider: @Composable () -> Unit,
    tabs: @Composable () -> Unit,
) {
    val tabIndicatorScope = remember { TabIndicatorScope() }
    androidx.compose.material3.TabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = Color.Unspecified,
        indicator = { tabBounds ->
            tabIndicatorScope.tabIndicator(selectedTabIndex, tabBounds.mapToTabBounds())
        },
        divider = divider,
        tabs = tabs
    )
}

@Composable
fun PrimaryScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    tabs: @Composable () -> Unit,
) = ScrollableTabRow(
    selectedTabIndex = selectedTabIndex,
    modifier = modifier,
    style = Mobius.styles.primaryScrollableTabRow,
    tabs = tabs
)

@Composable
fun SecondaryScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    tabs: @Composable () -> Unit,
) = ScrollableTabRow(
    selectedTabIndex = selectedTabIndex,
    modifier = modifier,
    style = Mobius.styles.secondaryScrollableTabRow,
    tabs = tabs
)

@Composable
fun ScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    style: ScrollableTabRowStyle,
    tabs: @Composable () -> Unit,
) {
    val styleValues = style.resolve()
    ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = styleValues.containerColor,
        edgePadding = styleValues.edgePadding,
        tabIndicator = TabRow.styleableTabIndicator(styleValues.indicatorStyle),
        divider = { HorizontalDivider(style = styleValues.dividerStyle) },
        tabs = tabs
    )
}

@Composable
fun ScrollableTabRow(
    selectedTabIndex: Int,
    modifier: Modifier = Modifier,
    containerColor: Color,
    edgePadding: Dp,
    tabIndicator: @Composable TabIndicatorScope.(selectedTabIndex: Int, tabBounds: List<TabBounds>) -> Unit,
    divider: @Composable () -> Unit,
    tabs: @Composable () -> Unit,
) {
    val tabIndicatorScope = remember { TabIndicatorScope() }
    androidx.compose.material3.ScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = Color.Unspecified,
        edgePadding = edgePadding,
        indicator = { tabBounds ->
            tabIndicatorScope.tabIndicator(selectedTabIndex, tabBounds.mapToTabBounds())
        },
        divider = divider,
        tabs = tabs
    )
}

class TabIndicatorScope internal constructor() {
    @Composable
    fun Modifier.requiredWidth(tabIndicatorWidth: TabIndicatorWidth, tabBounds: TabBounds) = when (tabIndicatorWidth) {
        is Fixed -> this.requiredWidth(tabIndicatorWidth.width)
        MatchContent -> this.matchContentSize(tabBounds)
        MatchTab -> matchTabSize()
    }

    fun Modifier.matchTabSize(): Modifier {
        return this.requiredWidth(Dp.Unspecified)
    }

    @Suppress("AnimateAsStateLabel")
    @Composable
    fun Modifier.matchContentSize(tabBounds: TabBounds): Modifier {
        val width by animateDpAsState(targetValue = tabBounds.contentWidth)
        return this.requiredWidth(width)
    }
}

object TabRow {
    fun styleableTabIndicator(
        style: TabIndicatorStyle,
    ): @Composable TabIndicatorScope.(selectedTabIndex: Int, tabBounds: List<TabBounds>) -> Unit =
        { selectedTabIndex, tabBounds ->
            val styleValues = style.resolve()
            Spacer(
                Modifier
                    .tabIndicatorOffset(tabBounds[selectedTabIndex].bounds)
                    .requiredHeight(styleValues.height)
                    .requiredWidth(styleValues.width, tabBounds[selectedTabIndex])
                    .background(color = styleValues.color, shape = styleValues.shape)
            )
        }
}

@Immutable
class TabBounds(val bounds: TabPosition) {
    val width get() = bounds.width

    val contentWidth get() = bounds.contentWidth

    val right get() = bounds.right

    val left get() = bounds.left

    override fun equals(other: Any?): Boolean = bounds == other

    override fun hashCode(): Int = bounds.hashCode()

    override fun toString() = bounds.toString()
}

private fun TabPosition.toTabBounds() = TabBounds(this)

private fun List<TabPosition>.mapToTabBounds() = map(TabPosition::toTabBounds)
