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
    wrapper: Modifier = Modifier,
    style: LinearProgressIndicatorStyle = Mobius.styles.linearProgressIndicatorStyle
) {
    val styleValues = style.resolve()
    LinearProgressIndicator(
        modifier = wrapper.size(styleValues.width, styleValues.height).then(modifier),
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
    wrapper: Modifier = Modifier,
    endCap: DrawScope.() -> Unit = LinearProgressIndicator.endCap(),
    style: LinearProgressIndicatorStyle = Mobius.styles.linearProgressIndicatorStyle,
) {
    val styleValues = style.resolve()
    LinearProgressIndicator(
        modifier = wrapper.size(styleValues.width, styleValues.height).then(modifier),
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
    wrapper: Modifier = Modifier,
    style: CircularProgressIndicatorStyle = Mobius.styles.circularProgressIndicatorStyle,
) {
    val styleValues = style.resolve()
    androidx.compose.material3.CircularProgressIndicator(
        progress = progress,
        modifier = wrapper.size(styleValues.size).then(modifier),
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
    wrapper: Modifier = Modifier,
    style: CircularProgressIndicatorStyle = Mobius.styles.indeterminateCircularProgressIndicatorStyle,
) {
    val styleValues = style.resolve()
    androidx.compose.material3.CircularProgressIndicator(
        modifier = wrapper.size(styleValues.size).then(modifier),
        color = styleValues.color,
        strokeWidth = styleValues.strokeWidth,
        trackColor = styleValues.trackColor,
        strokeCap = styleValues.strokeCap,
    )
}
