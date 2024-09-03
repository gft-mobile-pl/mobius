package com.gft.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.gft.mobius.components.LargeContentElementsSpacer
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
                val scrollableDialogVisible = remember { mutableStateOf(false) }
                val dialogWithFixedHeaderVisible = remember { mutableStateOf(false) }
                val dialogWithScrollableHeaderVisible = remember { mutableStateOf(false) }


                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = { shortDialogVisible.value = true }
                ) {
                    Text("Short dialog")
                }

                ContentElementsSpacer()

                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = { scrollableDialogVisible.value = true }
                ) {
                    Text("Scrollable dialog")
                }

                ContentElementsSpacer()

                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = { dialogWithFixedHeaderVisible.value = true }
                ) {
                    Text("Dialog with fixed header")
                }

                ContentElementsSpacer()

                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    onClick = { dialogWithScrollableHeaderVisible.value = true }
                ) {
                    Text("Dialog with scrollable header")
                }

                if (shortDialogVisible.value) {
                    TestDialog(
                        numberOfBlocks = 10,
                        onDismissRequest = {
                            shortDialogVisible.value = false
                        }
                    )
                }

                if (scrollableDialogVisible.value) {
                    TestDialog(
                        numberOfBlocks = 30,
                        onDismissRequest = {
                            scrollableDialogVisible.value = false
                        }
                    )
                }

                if (dialogWithFixedHeaderVisible.value) {
                    DialogWithFixedHeader(
                        onDismissRequest = {
                            dialogWithFixedHeaderVisible.value = false
                        }
                    )
                }

                if (dialogWithScrollableHeaderVisible.value) {
                    DialogWithScrollableHeader(
                        numberOfBlocks = 30,
                        onDismissRequest = {
                            dialogWithScrollableHeaderVisible.value = false
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
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillContentContainerWidth()
                        .contentContainerHorizontalPaddings()
                ) {
                    Text("This is text which background expands to a full width of the Content element.")
                }
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

@Composable
private fun DialogWithFixedHeader(
    onDismissRequest: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        DialogScreen {
            // Tip: If you need a header, create a DialogHeader component and DialogHeaderStyle
            // instead of repeating this code for each dialog. Remember that you can reference ContentStyle fields (like padding)
            // inside your DialogHeaderStyle.
            Box(
                modifier = Modifier
                    .background(Mobius.colors.primary)
                    .padding(all = 24.dp)
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "Dialog screen",
                    style = Mobius.typography.titleLarge,
                    color = Mobius.colors.onPrimary
                )
            }
            ScrollableContent {
                Text(text = "Dialog screen message")
                ContentElementsSpacer()
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillContentContainerWidth()
                        .contentContainerHorizontalPaddings()
                ) {
                    Text("This is text which background expands to a full width of the Content element.")
                }
                LargeContentElementsSpacer()
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

@Composable
private fun DialogWithScrollableHeader(
    numberOfBlocks: Int,
    onDismissRequest: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest
    ) {
        DialogScreen {
            ScrollableContent {
                Box(
                    modifier = Modifier
                        .ignoreContentContainerTopPadding()
                        .fillContentContainerWidth()
                        .background(Mobius.colors.primary)
                        .contentContainerPaddings()

//                        Other options are:
//                        .contentContainerHorizontalPaddings()
//                        .contentContainerVerticalPaddings()
//                        .contentContainerTopPadding()
//                        .contentContainerBottomPadding()
                ) {
                    Text(text = "Dialog screen", style = Mobius.typography.titleLarge, color = Mobius.colors.onPrimary)
                }
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
