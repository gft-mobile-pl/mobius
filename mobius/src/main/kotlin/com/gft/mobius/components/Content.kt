package com.gft.mobius.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalLayoutDirection
import com.gft.compose.common.modifyIf
import com.gft.mobius.colors.LocalContentColor
import com.gft.mobius.components.styles.ContentStyleValues
import kotlin.math.max

@Composable
internal fun ContentBuilder(
    modifier: Modifier,
    fillMaxSize: Boolean,
    scrollState: ScrollState?,
    styleValues: ContentStyleValues,
    content: @Composable (modifier: Modifier) -> Unit,
) {
    val contentColor = styleValues.contentColor.takeOrElse { LocalContentColor.current }
    CompositionLocalProvider(
        LocalContentColor provides contentColor
    ) {
        content(
            Modifier
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
                .then(modifier)
        )
    }
}

open class ContentScope internal constructor(
    private val contentStyle: ContentStyleValues,
) {

    fun Modifier.fillContentContainerWidth() = this
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

    internal fun Modifier.ignoreContentContainerTopPadding() = this
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

    internal fun Modifier.ignoreContentContainerBottomPadding() = this
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

    @Composable
    fun Modifier.contentContainerHorizontalPaddings(): Modifier {
        val layoutDirection = LocalLayoutDirection.current
        return padding(
            start = contentStyle.padding.calculateStartPadding(layoutDirection),
            end = contentStyle.padding.calculateEndPadding(layoutDirection)
        )
    }
}

open class ColumnContentScope(
    contentStyle: ContentStyleValues,
    private val columnScope: ColumnScope,
) : ContentScope(contentStyle), ColumnScope by columnScope {
    override fun Modifier.weight(weight: Float, fill: Boolean): Modifier = with(columnScope) {
        weight(weight, fill).fillMaxHeight()
    }
}
