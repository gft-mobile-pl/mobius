package com.gft.mobius.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.gft.compose.common.modifyIf
import com.gft.mobius.components.common.isInMainLayoutPass
import com.gft.mobius.components.styles.ContentStyleValues
import com.gft.mobius.references.MobiusReferenceDimensions
import kotlin.math.max

@Composable
internal fun ContentBuilder(
    modifier: Modifier,
    wrapper: Modifier,
    scrollState: ScrollState?,
    styleValues: ContentStyleValues,
    content: @Composable (modifier: Modifier) -> Unit,
) {
    CompositionLocalProvider(
        LocalContentStyle provides styleValues,
        LocalFooterVisible provides remember { mutableStateOf(false) },
        LocalContentHeaderVisible provides remember { mutableStateOf(false) },
    ) {
        content(
            wrapper
                .modifyIf(scrollState != null) {
                    verticalScroll(scrollState!!)
                }
                .padding(
                    PaddingValues(
                        start = styleValues.padding.calculateStartPadding(LocalLayoutDirection.current),
                        end = styleValues.padding.calculateEndPadding(LocalLayoutDirection.current),
                        top = if (LocalContentHeaderVisible.current.value) 0.dp else styleValues.padding.calculateTopPadding(),
                        bottom = if (LocalFooterVisible.current.value) 0.dp else styleValues.padding.calculateBottomPadding(),
                    )
                )
                .then(modifier)
        )
    }
}

open class ContentScope internal constructor(
    internal val contentStyle: ContentStyleValues,
) {
    @Composable
    fun Modifier.fillContentContainerWidth(ignorePadding: Boolean = false): Modifier {
        val isInMainLayoutPhase = isInMainLayoutPass()
        return if (ignorePadding) {
            layout { measurable, constraints ->
                val paddingLeft = contentStyle.padding
                    .calculateLeftPadding(layoutDirection)
                    .roundToPx()
                val paddingRight = contentStyle.padding
                    .calculateRightPadding(layoutDirection)
                    .roundToPx()
                if (constraints.hasBoundedWidth) {
                    val placeable = measurable.measure(
                        constraints.copy(
                            minWidth = if (isInMainLayoutPhase) {
                                constraints.maxWidth + paddingLeft + paddingRight
                            } else {
                                constraints.minWidth + paddingLeft + paddingRight
                            },
                            maxWidth = constraints.maxWidth + paddingLeft + paddingRight
                        )
                    )
                    layout(
                        width = if (isInMainLayoutPhase) {
                            placeable.width
                        } else {
                            placeable.width - paddingLeft - paddingRight
                        },
                        height = placeable.height
                    ) { placeable.place(0, 0) }
                } else {
                    val placeable = measurable.measure(constraints)
                    layout(max(placeable.width - paddingLeft - paddingRight, 0), placeable.height) {
                        placeable.place(0, 0)
                    }
                }
            }
        } else {
            if (isInMainLayoutPhase) fillMaxWidth() else this
        }
    }
}


@Composable
fun Modifier.contentContainerHorizontalPaddings(): Modifier {
    val layoutDirection = LocalLayoutDirection.current
    val contentStyle = LocalContentStyle.current
    return padding(
        start = contentStyle.padding.calculateStartPadding(layoutDirection),
        end = contentStyle.padding.calculateEndPadding(layoutDirection)
    )
}

val LocalContentStyle = staticCompositionLocalOf<ContentStyleValues> {
    object : ContentStyleValues {
        override val padding: PaddingValues = PaddingValues(0.dp)
        override val contentAlignment: Alignment = Alignment.TopStart
        override val smallVerticalElementsSpacing: Dp = MobiusReferenceDimensions.Dimension8
        override val mediumVerticalElementsSpacing: Dp = MobiusReferenceDimensions.Dimension16
        override val largeVerticalElementsSpacing: Dp = MobiusReferenceDimensions.Dimension32
        override val smallHorizontalElementsSpacing: Dp = MobiusReferenceDimensions.Dimension8
        override val mediumHorizontalElementsSpacing: Dp = MobiusReferenceDimensions.Dimension16
        override val largeHorizontalElementsSpacing: Dp = MobiusReferenceDimensions.Dimension32
    }
}
