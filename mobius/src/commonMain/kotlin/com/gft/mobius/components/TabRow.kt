package com.gft.mobius.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.material3.TabPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.Dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.ScrollableTabRowStyle
import com.gft.mobius.components.styles.TabIndicatorStyle
import com.gft.mobius.components.styles.TabIndicatorWidth
import com.gft.mobius.components.styles.TabRowStyle
import com.gft.mobius.components.styles.resolve
import androidx.compose.material3.TabIndicatorScope as Material3TabIndicatorScope

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
    tabIndicator: @Composable TabIndicatorScope.(selectedTabIndex: Int) -> Unit,
    divider: @Composable () -> Unit,
    tabs: @Composable () -> Unit,
) {
    // Primary and Secondary variants share the same implementation in Material3 and differ only
    // in default values. All values are provided explicitly here, so the choice is irrelevant.
    androidx.compose.material3.PrimaryTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = Color.Unspecified,
        indicator = { remember(this) { TabIndicatorScope(this) }.tabIndicator(selectedTabIndex) },
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
    tabIndicator: @Composable TabIndicatorScope.(selectedTabIndex: Int) -> Unit,
    divider: @Composable () -> Unit,
    tabs: @Composable () -> Unit,
) {
    androidx.compose.material3.PrimaryScrollableTabRow(
        selectedTabIndex = selectedTabIndex,
        modifier = modifier,
        containerColor = containerColor,
        contentColor = Color.Unspecified,
        edgePadding = edgePadding,
        indicator = { remember(this) { TabIndicatorScope(this) }.tabIndicator(selectedTabIndex) },
        divider = divider,
        tabs = tabs
    )
}

/**
 * Scope for the composable used to render a tab indicator in [TabRow] and [ScrollableTabRow].
 */
@Stable
class TabIndicatorScope internal constructor(
    private val scope: Material3TabIndicatorScope,
) {
    /**
     * Positions the indicator under the tab at [selectedTabIndex] and animates its offset and width
     * whenever the selection changes.
     *
     * @param selectedTabIndex index of the currently selected tab.
     * @param width how wide the indicator is relative to the selected tab.
     */
    fun Modifier.tabIndicatorOffset(
        selectedTabIndex: Int,
        width: TabIndicatorWidth = TabIndicatorWidth.MatchTab,
    ): Modifier {
        return with(scope) {
            when (width) {
                TabIndicatorWidth.MatchTab -> tabIndicatorOffset(
                    selectedTabIndex = selectedTabIndex,
                    matchContentSize = false
                )

                TabIndicatorWidth.MatchContent -> tabIndicatorOffset(
                    selectedTabIndex = selectedTabIndex,
                    matchContentSize = true
                )

                is TabIndicatorWidth.Fixed -> tabIndicatorOffset(
                    selectedTabIndex = selectedTabIndex,
                    matchContentSize = false
                ).requiredWidth(width.width)
            }
        }
    }

    /**
     * A layout modifier that provides [TabBounds] of all tabs. Use it for fully custom indicator
     * layouts and animations, when [tabIndicatorOffset] is not enough.
     */
    fun Modifier.tabIndicatorLayout(
        measure: MeasureScope.(measurable: Measurable, constraints: Constraints, tabBounds: List<TabBounds>) -> MeasureResult,
    ): Modifier = with(scope) {
        tabIndicatorLayout { measurable, constraints, tabPositions ->
            measure(measurable, constraints, tabPositions.map(::TabBounds))
        }
    }
}

object TabRow {
    fun styleableTabIndicator(
        style: TabIndicatorStyle,
    ): @Composable TabIndicatorScope.(selectedTabIndex: Int) -> Unit =
        { selectedTabIndex ->
            val styleValues = style.resolve()
            Spacer(
                Modifier
                    .tabIndicatorOffset(selectedTabIndex, styleValues.width)
                    .requiredHeight(styleValues.height)
                    .background(color = styleValues.color, shape = styleValues.shape)
            )
        }
}

@Immutable
class TabBounds internal constructor(private val bounds: TabPosition) {
    val width: Dp get() = bounds.width

    val contentWidth: Dp get() = bounds.contentWidth

    val right: Dp get() = bounds.right

    val left: Dp get() = bounds.left

    override fun equals(other: Any?): Boolean = other is TabBounds && bounds == other.bounds

    override fun hashCode(): Int = bounds.hashCode()

    override fun toString() = bounds.toString()
}
