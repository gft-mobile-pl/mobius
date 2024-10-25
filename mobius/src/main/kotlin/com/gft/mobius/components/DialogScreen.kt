package com.gft.mobius.components

import android.os.Build
import android.view.WindowManager
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.takeOrElse
import androidx.compose.ui.layout.Measured
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.DialogWindowProvider
import androidx.lifecycle.Lifecycle
import com.gft.compose.common.modifyIf
import com.gft.compose.interaction.InteractionFilter
import com.gft.compose.interaction.clearFocusOnClick
import com.gft.mobius.Mobius
import com.gft.mobius.colors.LocalContentColor
import com.gft.mobius.components.common.LocalLayoutPass
import com.gft.mobius.components.common.MainLayoutPass
import com.gft.mobius.components.common.isInMainLayoutPass
import com.gft.mobius.components.styles.DialogScreenStyle
import com.gft.mobius.components.styles.resolve
import com.gft.mobius.references.MobiusReferenceDimensions
import kotlin.math.max

private object FindMaxChildWidthLayoutPhase

@Composable
fun DialogScreen(
    modifier: Modifier = Modifier,
    minActiveState: Lifecycle.State = Lifecycle.State.RESUMED,
    clearFocusOnClick: Boolean = true,
    style: DialogScreenStyle = Mobius.styles.dialogScreenStyle,
    content: @Composable DialogScreenScope.() -> Unit,
) {
    val styleValues = style.resolve()
    val contentColor = styleValues.contentColor.takeOrElse { LocalContentColor.current }

    if (styleValues.underlyingContentBlur != Dp.Unspecified
        && styleValues.underlyingContentBlur != MobiusReferenceDimensions.Dimension0
        && Build.VERSION.SDK_INT > Build.VERSION_CODES.R
    ) {
        val blur = with(LocalDensity.current) { styleValues.underlyingContentBlur.roundToPx() }
        val dialogWindowProvider = LocalView.current.parent as DialogWindowProvider
        LaunchedEffect(Unit) {
            dialogWindowProvider.window.apply {
                setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND, WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
                attributes.blurBehindRadius = blur
            }
        }
    }

    InteractionFilter(
        minActiveState = minActiveState
    ) {
        SubcomposeLayout { constraints ->
            // Pass 1: find the width of the widest child
            val widestChildWidth = subcompose(FindMaxChildWidthLayoutPhase) {
                CompositionLocalProvider(LocalLayoutPass provides FindMaxChildWidthLayoutPhase) {
                    DialogScreenScope(NoOpColumnScope).content()
                }
            }.fold(initial = 0) { currentMaxWidth, measurable ->
                max(currentMaxWidth, measurable.measure(constraints).width)
            }

            // Pass 2: Measure the content with the width constrained to the width of the widest child
            val placeable = subcompose(MainLayoutPass) {
                Column(
                    modifier = Modifier
                        .modifyIf(clearFocusOnClick) { clearFocusOnClick() }
                        .modifyIf(styleValues.shape != null) {
                            clip(styleValues.shape!!)
                        }
                        .width(widestChildWidth.toDp())
                        .modifyIf(styleValues.background != null) {
                            background(styleValues.background!!)
                        }
                        .then(modifier),
                    content = {
                        CompositionLocalProvider(
                            LocalLayoutPass provides MainLayoutPass,
                            LocalContentColor provides contentColor,
                        ) {
                            DialogScreenScope(this).content()
                        }
                    }
                )
            }.first().measure(constraints)

            layout(placeable.width, placeable.height) {
                placeable.placeRelative(0, 0)
            }
        }
    }
}

interface DialogScreenScope : ColumnScope {
    @Composable
    fun Modifier.fillDialogWidth(): Modifier = modifyIf(isInMainLayoutPass()) { fillMaxWidth() }
}

private fun DialogScreenScope(columnScope: ColumnScope) = object : DialogScreenScope, ColumnScope by columnScope {}

private object NoOpColumnScope : ColumnScope {
    override fun Modifier.align(alignment: Alignment.Horizontal) = this
    override fun Modifier.alignBy(alignmentLineBlock: (Measured) -> Int) = this
    override fun Modifier.alignBy(alignmentLine: VerticalAlignmentLine) = this
    override fun Modifier.weight(weight: Float, fill: Boolean) = this
}