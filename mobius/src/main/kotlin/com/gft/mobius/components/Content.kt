@file:Suppress("UnusedReceiverParameter")

package com.gft.mobius.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.layout.Measured
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.LayoutDirection
import com.gft.compose.common.modifyIf
import com.gft.mobius.colors.LocalContentColor
import com.gft.mobius.components.common.resolveHorizontalAlignment
import com.gft.mobius.components.common.resolveVerticalArrangement
import com.gft.mobius.components.styles.ContentStyleValues
import kotlin.math.max

@Composable
internal fun Content(
    modifier: Modifier,
    fillMaxSize: Boolean,
    scrollState: ScrollState?,
    styleValues: ContentStyleValues,
    content: @Composable ColumnScope.() -> Unit,
) {
    val contentColor = styleValues.contentColor.takeOrElse { LocalContentColor.current }
    CompositionLocalProvider(
        LocalContentColor provides contentColor
    ) {
        Column(
            modifier = Modifier
                .modifyIf(fillMaxSize) {
                    fillMaxSize()
                }
                .modifyIf(scrollState != null) {
                    verticalScroll(scrollState!!)
                }
                .modifyIf(styleValues.background != null) {
                    background(styleValues.background!!)
                }
                .padding(styleValues.padding)
                .then(modifier),
            verticalArrangement = styleValues.contentAlignment.resolveVerticalArrangement(),
            horizontalAlignment = styleValues.contentAlignment.resolveHorizontalAlignment(),
            content = content
        )
    }
}

interface ContentScope : ColumnScope {
    fun Modifier.fillContentContainerWidth(): Modifier
    fun Modifier.contentContainerVerticalPaddings(): Modifier
    fun Modifier.contentContainerHorizontalPaddings(): Modifier
    fun Modifier.contentContainerPaddings(): Modifier
    fun Modifier.ignoreContentContainerTopPadding(): Modifier
    fun Modifier.ignoreContentContainerBottomPadding(): Modifier
    fun Modifier.contentContainerTopPadding(): Modifier
    fun Modifier.contentContainerBottomPadding(): Modifier
}

internal open class ContentScopeImpl(
    private val columnScope: ColumnScope,
    private val contentStyle: ContentStyleValues,
    private val layoutDirection: LayoutDirection,
) : ContentScope, ColumnScope {

    override fun Modifier.fillContentContainerWidth() = this
        .layout { measurable, constraints ->
            val paddingLeft = contentStyle.padding
                .calculateLeftPadding(layoutDirection)
                .roundToPx()
            val paddingRight = contentStyle.padding
                .calculateRightPadding(layoutDirection)
                .roundToPx()
            if (constraints.hasBoundedWidth) {
                val placeable = measurable.measure(
                    constraints.copy(
                        minWidth = constraints.maxWidth + paddingLeft + paddingRight,
                        maxWidth = constraints.maxWidth + paddingLeft + paddingRight
                    )
                )
                layout(placeable.width, placeable.height) { placeable.place(0, 0) }
            } else {
                val placeable = measurable.measure(constraints)
                layout(max(placeable.width - paddingLeft - paddingRight, 0), placeable.height) {
                    placeable.place(0, 0)
                }
            }
        }

    override fun Modifier.ignoreContentContainerTopPadding() = this
        .layout { measurable, constraints ->
            val paddingTop = contentStyle.padding.calculateTopPadding().roundToPx()
            if (constraints.hasBoundedHeight) {
                val maxHeight = constraints.maxHeight + paddingTop
                val placeable = measurable.measure(constraints.copy(maxHeight = maxHeight))
                layout(placeable.width, max(placeable.height - paddingTop, 0)) {
                    placeable.place(
                        x = 0,
                        y = if (placeable.height > paddingTop) -paddingTop else -placeable.height
                    )
                }
            } else {
                val placeable = measurable.measure(constraints)
                layout(placeable.width, placeable.height - paddingTop) { placeable.place(0, -paddingTop) }
            }
        }

    override fun Modifier.ignoreContentContainerBottomPadding() = this
        .layout { measurable, constraints ->
            val paddingBottom = contentStyle.padding.calculateBottomPadding().roundToPx()
            if (constraints.hasBoundedHeight) {
                val maxHeight = constraints.maxHeight + paddingBottom
                val placeable = measurable.measure(constraints.copy(maxHeight = maxHeight))

                layout(placeable.width, max(placeable.height - paddingBottom, 0)) {
                    placeable.place(0, 0)
                }
            } else {
                val placeable = measurable.measure(constraints)
                layout(placeable.width, placeable.height - paddingBottom) { placeable.place(0, 0) }
            }
        }

    override fun Modifier.contentContainerTopPadding(): Modifier = padding(
        top = contentStyle.padding.calculateTopPadding()
    )

    override fun Modifier.contentContainerBottomPadding(): Modifier = padding(
        bottom = contentStyle.padding.calculateBottomPadding()
    )

    override fun Modifier.contentContainerHorizontalPaddings(): Modifier = padding(
        start = contentStyle.padding.calculateStartPadding(layoutDirection),
        end = contentStyle.padding.calculateEndPadding(layoutDirection)
    )

    override fun Modifier.contentContainerVerticalPaddings(): Modifier = padding(
        top = contentStyle.padding.calculateTopPadding(),
        bottom = contentStyle.padding.calculateBottomPadding()
    )

    override fun Modifier.contentContainerPaddings(): Modifier = padding(
        top = contentStyle.padding.calculateTopPadding(),
        bottom = contentStyle.padding.calculateBottomPadding(),
        start = contentStyle.padding.calculateStartPadding(layoutDirection),
        end = contentStyle.padding.calculateEndPadding(layoutDirection)
    )

    override fun Modifier.align(alignment: Alignment.Horizontal) = with(columnScope) { align(alignment) }

    override fun Modifier.alignBy(alignmentLineBlock: (Measured) -> Int) =
        with(columnScope) { alignBy(alignmentLineBlock) }

    override fun Modifier.alignBy(alignmentLine: VerticalAlignmentLine) = with(columnScope) { alignBy(alignmentLine) }

    override fun Modifier.weight(weight: Float, fill: Boolean): Modifier = with(columnScope) {
        weight(weight, fill).fillMaxHeight()
    }
}