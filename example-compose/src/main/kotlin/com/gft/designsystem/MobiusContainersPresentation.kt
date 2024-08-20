package com.gft.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.Content
import com.gft.mobius.components.ContentElementsSpacer
import com.gft.mobius.components.LargeContentElementsSpacer
import com.gft.mobius.components.Screen
import com.gft.mobius.components.SmallContentElementsSpacer
import com.gft.mobius.components.Text

@Composable
fun MobiusContainersPresentation() {
    Mobius {
        Screen {

            Content {
                Text(text = "The whole page is wrapped in Content container.")
                ContentElementsSpacer()

                Column {
                    HorizontalBoxWithMessage("Below is a small content elements spacer.")
                    SmallContentElementsSpacer()
                    HorizontalBoxWithMessage("Below is a default/medium content elements spacer.")
                    ContentElementsSpacer()
                    HorizontalBoxWithMessage("Below is a large content elements spacer.")
                    LargeContentElementsSpacer()
                }

                Row {
                    VerticalBox()
                    SmallContentElementsSpacer()
                    VerticalBox()
                    ContentElementsSpacer()
                    VerticalBox()
                    LargeContentElementsSpacer()
                    VerticalBox()
                    SmallContentElementsSpacer()
                    Text(
                        text = "On the left \nsmall, medium, and large content element spacers are displayed, respectively.",
                        style = Mobius.typography.bodySmall
                    )
                }


                Spacer(modifier = Modifier.weight(1.0f))
                Button(onClick = { }) {
                    Text(text = "Bottom button")
                }
            }


        }
    }
}

@Composable
private fun HorizontalBoxWithMessage(
    message: String,
) = Box(
    modifier = Modifier
        .fillMaxWidth()
        .height(32.dp)
        .background(Mobius.colors.primary),
    contentAlignment = Alignment.BottomStart
) {
    Text(text = message, color = Mobius.colors.onPrimary, style = Mobius.typography.bodySmall)
}

@Composable
private fun VerticalBox() = Box(
    modifier = Modifier
        .height(64.dp)
        .width(32.dp)
        .background(Mobius.colors.primary),
)