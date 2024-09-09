package com.gft.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.gft.designsystem.MobiusDialogScreenPresentation.MessagePadding
import com.gft.designsystem.MobiusDialogScreenPresentation.MessagePadding.ASYMMETRIC
import com.gft.designsystem.MobiusDialogScreenPresentation.MessagePadding.CONTENT_CONTAINER
import com.gft.designsystem.MobiusDialogScreenPresentation.MessagePadding.NONE
import com.gft.designsystem.MobiusDialogScreenPresentation.MessageWidth
import com.gft.designsystem.MobiusDialogScreenPresentation.MessageWidth.DEFAULT
import com.gft.designsystem.MobiusDialogScreenPresentation.MessageWidth.FILL
import com.gft.designsystem.MobiusDialogScreenPresentation.MessageWidth.LONG
import com.gft.designsystem.MobiusDialogScreenPresentation.MessageWidth.SHORT
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.Checkbox
import com.gft.mobius.components.Content
import com.gft.mobius.components.ContentElementsSpacer
import com.gft.mobius.components.DialogScreen
import com.gft.mobius.components.DialogScreenContentScope
import com.gft.mobius.components.Group
import com.gft.mobius.components.GroupElementSpacer
import com.gft.mobius.components.LargeContentElementsSpacer
import com.gft.mobius.components.Screen
import com.gft.mobius.components.ScrollableContent
import com.gft.mobius.components.SmallGroupElementSpacer
import com.gft.mobius.components.Text
import com.gft.mobius.components.styles.DefaultButtonStyle
import com.gft.mobius.components.styles.GroupStyle
import kotlin.random.Random

@Composable
fun MobiusDialogScreenPresentation() {
    Mobius {
        Screen {
            ScrollableContent {
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

                ContentElementsSpacer()

                Group(
                    style = customGroupStyle()
                ) {
                    val scrollable = remember { mutableStateOf(true) }
                    Text(
                        text = "Test cases",
                        style = Mobius.typography.titleLarge,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    SmallGroupElementSpacer()
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Checkbox(checked = scrollable.value, onCheckedChange = { scrollable.value = it })
                        Text(text = "Use ScrollableContent")
                    }
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Pad: 0-0")
                            GroupElementSpacer()

                            TestCase(
                                name = "Test 1",
                                scrollable = scrollable.value,
                                message1Width = DEFAULT,
                                message2Width = DEFAULT,
                                message2Padding = NONE
                            )

                            TestCase(
                                name = "Test 2",
                                scrollable = scrollable.value,
                                message1Width = DEFAULT,
                                message2Width = SHORT,
                                message2Padding = NONE
                            )

                            TestCase(
                                name = "Test 3",
                                scrollable = scrollable.value,
                                message1Width = LONG,
                                message2Width = DEFAULT,
                                message2Padding = NONE
                            )

                            TestCase(
                                name = "Test 4",
                                scrollable = scrollable.value,
                                message1Width = LONG,
                                message2Width = SHORT,
                                message2Padding = NONE
                            )

                            TestCase(
                                name = "Test 5",
                                scrollable = scrollable.value,
                                message1Width = FILL,
                                message2Width = DEFAULT,
                                message2Padding = NONE
                            )

                            TestCase(
                                name = "Test 6",
                                scrollable = scrollable.value,
                                message1Width = DEFAULT,
                                message2Width = FILL,
                                message2Padding = NONE
                            )
                        }

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Pad: C-C")
                            GroupElementSpacer()

                            TestCase(
                                name = "Test 1B",
                                scrollable = scrollable.value,
                                message1Width = DEFAULT,
                                message2Width = DEFAULT,
                                message2Padding = CONTENT_CONTAINER
                            )

                            TestCase(
                                name = "Test 2B",
                                scrollable = scrollable.value,
                                message1Width = DEFAULT,
                                message2Width = SHORT,
                                message2Padding = CONTENT_CONTAINER
                            )

                            TestCase(
                                name = "Test 3B",
                                scrollable = scrollable.value,
                                message1Width = LONG,
                                message2Width = DEFAULT,
                                message2Padding = CONTENT_CONTAINER
                            )

                            TestCase(
                                name = "Test 4B",
                                scrollable = scrollable.value,
                                message1Width = LONG,
                                message2Width = SHORT,
                                message2Padding = CONTENT_CONTAINER
                            )

                            TestCase(
                                name = "Test 5B",
                                scrollable = scrollable.value,
                                message1Width = FILL,
                                message2Width = DEFAULT,
                                message2Padding = CONTENT_CONTAINER
                            )

                            TestCase(
                                name = "Test 6B",
                                scrollable = scrollable.value,
                                message1Width = DEFAULT,
                                message2Width = FILL,
                                message2Padding = CONTENT_CONTAINER
                            )
                        }

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(text = "Pad: 10-30 ")
                            GroupElementSpacer()

                            TestCase(
                                name = "Test 1C",
                                scrollable = scrollable.value,
                                message1Width = DEFAULT,
                                message2Width = DEFAULT,
                                message2Padding = ASYMMETRIC
                            )

                            TestCase(
                                name = "Test 2C",
                                scrollable = scrollable.value,
                                message1Width = DEFAULT,
                                message2Width = SHORT,
                                message2Padding = ASYMMETRIC
                            )

                            TestCase(
                                name = "Test 3C",
                                scrollable = scrollable.value,
                                message1Width = LONG,
                                message2Width = DEFAULT,
                                message2Padding = ASYMMETRIC
                            )

                            TestCase(
                                name = "Test 4C",
                                scrollable = scrollable.value,
                                message1Width = LONG,
                                message2Width = SHORT,
                                message2Padding = ASYMMETRIC
                            )

                            TestCase(
                                name = "Test 5C",
                                scrollable = scrollable.value,
                                message1Width = FILL,
                                message2Width = DEFAULT,
                                message2Padding = ASYMMETRIC
                            )

                            TestCase(
                                name = "Test 6C",
                                scrollable = scrollable.value,
                                message1Width = DEFAULT,
                                message2Width = FILL,
                                message2Padding = ASYMMETRIC
                            )
                        }
                    }


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


@Composable
private fun ColumnScope.TestCase(
    name: String,
    scrollable: Boolean,
    message1Width: MessageWidth,
    message2Width: MessageWidth,
    message2Padding: MessagePadding,
) {
    val dialogVisible = remember { mutableStateOf(false) }

    Button(
        style = TestButtonStyle,
        modifier = Modifier.fillMaxWidth(),
        onClick = { dialogVisible.value = true }
    ) {
        Text(name)
    }

    ContentElementsSpacer()

    if (dialogVisible.value) {
        TestDialog(
            onDismissRequest = { dialogVisible.value = false },
            scrollable = scrollable,
            message1Width = message1Width,
            message2Width = message2Width,
            message2Padding = message2Padding
        )
    }
}

@Composable
private fun TestDialog(
    onDismissRequest: () -> Unit,
    scrollable: Boolean,
    message1Width: MessageWidth,
    message2Width: MessageWidth,
    message2Padding: MessagePadding,
) {
    Dialog(onDismissRequest = onDismissRequest) {
        DialogScreen {
            if (scrollable) {
                ScrollableContent {
                    TestDialogContent(
                        message1Width = message1Width,
                        message2Width = message2Width,
                        message2Padding = message2Padding
                    )
                }
            } else {
                Content {
                    TestDialogContent(
                        message1Width = message1Width,
                        message2Width = message2Width,
                        message2Padding = message2Padding
                    )
                }
            }
        }
    }
}

@Composable
private fun DialogScreenContentScope.TestDialogContent(
    message1Width: MessageWidth,
    message2Width: MessageWidth,
    message2Padding: MessagePadding,
) {
    Text(
        text = "Dialog screen message",
        modifier = Modifier
            .run {
                when (message1Width) {
                    DEFAULT -> this
                    LONG -> width(245.dp)
                    FILL -> fillMaxWidth()
                    else -> throw NotImplementedError("Test case not supported")
                }
            }
            .background(Color.White)
    )
    Column(
        modifier = Modifier
            .fillContentContainerWidth()
            .background(Color.LightGray)
            .run {
                when (message2Padding) {
                    NONE -> this
                    CONTENT_CONTAINER -> contentContainerHorizontalPaddings()
                    ASYMMETRIC -> padding(PaddingValues(start = 10.dp, end = 30.dp))
                }
            }
            .background(Color.DarkGray)
    ) {
        Text(
            text = "This is Text which background\nexpands to a full width\nof the Content element." +
                    "\nThe text is long enough\nto require scrolling\nwhen the width\nis significantly reduced." +
                    "",
            modifier = Modifier
                .run {
                    when (message2Width) {
                        DEFAULT -> this
                        FILL -> fillMaxWidth()
                        SHORT -> width(30.dp)
                        LONG -> throw NotImplementedError("Test case not supported")
                    }
                }
                .background(Color.Red)
                .padding(2.dp)
                .background(Color.Yellow)
        )
    }
}

@Composable
private fun customGroupStyle(): GroupStyle {
    val defaultStyle = Mobius.styles.groupStyle
    return remember(defaultStyle) {
        object : GroupStyle by defaultStyle {
            override val background: Token<Brush?> = Token {
                Brush.linearGradient(
                    0.0f to Mobius.colors.secondary,
                    1.0f to Mobius.colors.tertiary
                )
            }
            override val shape: Token<Shape?> = Token(RoundedCornerShape(16.dp))
            override val contentColor: Token<Color> = Token { Mobius.colors.onSecondary }
        }
    }
}

private object MobiusDialogScreenPresentation {
    enum class MessageWidth {
        DEFAULT,
        FILL,
        LONG,
        SHORT
    }

    enum class MessagePadding {
        NONE,
        CONTENT_CONTAINER,
        ASYMMETRIC
    }
}

object TestButtonStyle : DefaultButtonStyle() {
    override val contentPadding: Token<PaddingValues> = Token(PaddingValues(all = 8.dp))
}