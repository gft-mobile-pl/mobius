package com.gft.mobius.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.gft.mobius.Mobius
import com.gft.mobius.components.styles.CircularProgressIndicatorStyle
import com.gft.mobius.components.styles.LinearProgressIndicatorEndCapStyle
import com.gft.mobius.components.styles.LinearProgressIndicatorStyle
import com.gft.mobius.components.styles.resolve

@Composable
fun LinearProgressIndicator(
    modifier: Modifier = Modifier,
    style: LinearProgressIndicatorStyle = Mobius.styles.linearProgressIndicatorStyle
) {
    val styleValues = style.resolve()
    LinearProgressIndicator(
        modifier = modifier.size(styleValues.width, styleValues.height),
        color = styleValues.color,
        trackColor = styleValues.trackColor,
        strokeCap = styleValues.strokeCap,
        gapSize = styleValues.gapSize
    )
}

@Composable
fun LinearProgressIndicator(
    progress: () -> Float,
    modifier: Modifier = Modifier,
    endCap: DrawScope.() -> Unit = LinearProgressIndicator.endCap(),
    style: LinearProgressIndicatorStyle = Mobius.styles.linearProgressIndicatorStyle,
) {
    val styleValues = style.resolve()
    LinearProgressIndicator(
        modifier = modifier.size(styleValues.width, styleValues.height),
        progress = progress,
        color = styleValues.color,
        trackColor = styleValues.trackColor,
        strokeCap = styleValues.strokeCap,
        gapSize = styleValues.gapSize,
        drawStopIndicator = endCap
    )
}

object LinearProgressIndicator {
    @Composable
    fun endCap(
        style: LinearProgressIndicatorEndCapStyle = Mobius.styles.linearProgressIndicatorEndCapStyle
    ):  DrawScope.() -> Unit {
        val styleValues = style.resolve()
        val indicatorProvider: DrawScope.() -> Unit = {
            ProgressIndicatorDefaults.drawStopIndicator(
                drawScope = this,
                stopSize = (size.height * styleValues.sizeFraction.value).toDp(),
                strokeCap = styleValues.strokeCap,
                color = styleValues.color
            )
        }
        return indicatorProvider
    }
}

@Composable
fun CircularProgressIndicator(
    progress: () -> Float,
    modifier: Modifier = Modifier,
    style: CircularProgressIndicatorStyle = Mobius.styles.circularProgressIndicatorStyle,
) {
    val styleValues = style.resolve()
    androidx.compose.material3.CircularProgressIndicator(
        progress = progress,
        modifier = modifier.size(styleValues.size),
        color = styleValues.color,
        strokeWidth = styleValues.strokeWidth,
        trackColor = styleValues.trackColor,
        strokeCap = styleValues.strokeCap,
        gapSize = styleValues.gapSize
    )
}

@Composable
fun CircularProgressIndicator(
    modifier: Modifier = Modifier,
    style: CircularProgressIndicatorStyle = Mobius.styles.indeterminateCircularProgressIndicatorStyle,
) {
    val styleValues = style.resolve()
    androidx.compose.material3.CircularProgressIndicator(
        modifier = modifier.size(styleValues.size),
        color = styleValues.color,
        strokeWidth = styleValues.strokeWidth,
        trackColor = styleValues.trackColor,
        strokeCap = styleValues.strokeCap,
    )
}
