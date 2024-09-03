package com.gft.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.Content
import com.gft.mobius.components.ContentElementsSpacer
import com.gft.mobius.components.DialogScreen
import com.gft.mobius.components.Screen
import com.gft.mobius.components.ScrollableContent
import com.gft.mobius.components.Text
import kotlin.random.Random

@Composable
fun MobiusDialogScreenPresentation() {
    Mobius {
        Screen {
            Content {
                val shortDialogVisible = remember { mutableStateOf(false) }
                val longDialogVisible = remember { mutableStateOf(false) }

                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = { shortDialogVisible.value = true }
                ) {
                    Text("Show short DialogScreen")
                }

                ContentElementsSpacer()

                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = { longDialogVisible.value = true }
                ) {
                    Text("Show long DialogScreen")
                }

                if (shortDialogVisible.value) {
                    TestDialog(
                        numberOfBlocks = 10,
                        onDismissRequest = {
                            shortDialogVisible.value = false
                        }
                    )
                }

                if (longDialogVisible.value) {
                    TestDialog(
                        numberOfBlocks = 30,
                        onDismissRequest = {
                            longDialogVisible.value = false
                        }
                    )
                }

            }

        }


    }
}

@Composable
private fun TestDialog(
    numberOfBlocks: Int,
    onDismissRequest: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        DialogScreen {
            ScrollableContent {
                Text(text = "Dialog screen", style = Mobius.typography.titleLarge)
                ContentElementsSpacer()
                Text(text = "Dialog screen message")
                ContentElementsSpacer()
                repeat(numberOfBlocks) {
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
                        onClick = onDismissRequest
                    ) {
                        Text(text = "Close me")
                    }
                }
            }
        }
    }
}
