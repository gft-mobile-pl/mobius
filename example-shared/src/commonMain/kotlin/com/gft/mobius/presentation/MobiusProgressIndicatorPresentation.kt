package com.gft.mobius.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.gft.mobius.Mobius
import com.gft.mobius.components.CircularProgressIndicator
import com.gft.mobius.components.Content
import com.gft.mobius.components.LargeElementSpacer
import com.gft.mobius.components.LinearProgressIndicator
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

@Composable
internal fun MobiusProgressIndicatorPresentation(
    onBack: () -> Unit,
) {
    Mobius {
        Screen {
            MobiusPresentationNavigationBar(
                title = "Progress indicator",
                onBack = onBack,
            )
            Content {
                LinearProgressIndicator()
                LargeElementSpacer()

                val progress = flow {
                    for (i in 0..100) {
                        emit(i.toFloat() / 100)
                        delay(100)
                    }
                }.collectAsStateWithLifecycle(0f)

                LinearProgressIndicator(
                    progress = { progress.value }
                )
                LargeElementSpacer()

                LinearProgressIndicator(
                    progress = { progress.value },
                    endCap = {
                        val endCapSize = 8.dp.toPx()
                        val endCapOffset = (size.height - endCapSize) / 2
                        drawRect(
                            color = Color.Red,
                            topLeft = Offset(
                                x = size.width - endCapSize - endCapOffset,
                                y = (size.height - endCapSize) / 2f
                            ),
                            size = Size(width = endCapSize, height = endCapSize)
                        )
                    }
                )
                LargeElementSpacer()

                CircularProgressIndicator()
                LargeElementSpacer()

                CircularProgressIndicator(progress = { progress.value })
                LargeElementSpacer()
            }
        }
    }
}
