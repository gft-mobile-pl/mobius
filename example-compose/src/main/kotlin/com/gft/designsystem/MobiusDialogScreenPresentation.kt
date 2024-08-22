package com.gft.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.ContentElementsSpacer
import com.gft.mobius.components.DialogScreen
import com.gft.mobius.components.ScrollableContent
import com.gft.mobius.components.Text
import kotlin.random.Random

@Composable
fun MobiusDialogScreenPresentation(
    onNavigateBack: () -> Unit,
) {
    Mobius {
        DialogScreen {
            ScrollableContent {
                Text(text = "Dialog screen", style = Mobius.typography.titleLarge)
                ContentElementsSpacer()
                Text(text = "Dialog screen message")
                ContentElementsSpacer()
                repeat(10) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(30.dp)
                            .background(Color(0xff000000 + Random.nextInt(0xffffff)))
                    )
                }
                ContentElementsSpacer()
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        onClick = { onNavigateBack() }
                    ) {
                        Text(text = "Close me")
                    }
                }
            }
        }
    }
}
