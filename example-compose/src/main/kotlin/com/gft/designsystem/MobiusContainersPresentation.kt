package com.gft.designsystem

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.Content
import com.gft.mobius.components.DialogScreen
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.Group
import com.gft.mobius.components.Header
import com.gft.mobius.components.HeaderSpacer
import com.gft.mobius.components.LargeElementSpacer
import com.gft.mobius.components.Screen
import com.gft.mobius.components.SmallElementSpacer
import com.gft.mobius.components.Text
import com.gft.mobius.components.styles.GroupStyle

@Composable
fun MobiusContainersPresentation() {
    Mobius {
        Screen {
            Content {
                Text(text = "The whole page is wrapped in Content container.")
                ElementSpacer()

                Column {
                    HorizontalBoxWithMessage("Below is a small content elements spacer.")
                    SmallElementSpacer()
                    HorizontalBoxWithMessage("Below is a default/medium content elements spacer.")
                    ElementSpacer()
                    HorizontalBoxWithMessage("Below is a large content elements spacer.")
                    LargeElementSpacer()
                }

                HorizontalBoxWithMessage(
                    message = "This message takes the whole screen width, ignoring content padding.",
                    modifier = Modifier.fillContentContainerWidth()
                )
                LargeElementSpacer()

                Row {
                    VerticalBox()
                    SmallElementSpacer()
                    VerticalBox()
                    ElementSpacer()
                    VerticalBox()
                    LargeElementSpacer()
                    VerticalBox()
                    SmallElementSpacer()
                    Text(
                        text = "On the left \nsmall, medium, and large content element spacers are displayed, respectively.",
                        style = Mobius.typography.bodySmall
                    )
                }

                LargeElementSpacer()

                Group(
                    style = customGroupStyle()
                ) {
                    Text(text = "This is a Group container with a custom style.")
                    ElementSpacer()

                    HorizontalBoxWithMessage("Below is a small group element spacer.")
                    SmallElementSpacer()
                    HorizontalBoxWithMessage("Below is a default/medium group element spacer.")
                    ElementSpacer()
                    HorizontalBoxWithMessage("Below is a large group element spacer.")
                    LargeElementSpacer()

                    Row {
                        VerticalBox()
                        SmallElementSpacer()
                        VerticalBox()
                        ElementSpacer()
                        VerticalBox()
                        LargeElementSpacer()
                        VerticalBox()
                        SmallElementSpacer()
                        Text(
                            text = "On the left \nsmall, medium, and large group element spacers are displayed, respectively.",
                            style = Mobius.typography.bodySmall
                        )
                    }

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
    modifier: Modifier = Modifier,
) = Box(
    modifier = modifier
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

@Suppress("unused")
@Composable
private fun MobiusContainersScopesTest() {
    Mobius {
        Screen {
            Header {
                // Header { } // not allowed in another Header
                Box(
                    // modifier = Modifier.fillContentContainerWidth() // not allowed in Header
                ) { }
                Content {
                    // Header { } // not allowed in the Content of another Header
                    // HeaderSpacer() // not allowed in the Content of another Header
                    Box(
                        // modifier = Modifier.fillContentContainerWidth() // not allowed in the Content of a Header
                    ) { }
                }
                // ScrollableContent {} // not allowed in Header
                //HeaderSpacer() // HeaderSpacer() not allowed in another Header
            }
            Content {
                Header(
                    modifier = Modifier
                        .fillContentContainerWidth()
                    //.ignoreContentContainerTopPadding() // .ignoreContentContainerTopPadding() is internal
                ) {
                    // Header { } // not allowed in another Header
                    // HeaderSpacer() // not allowed in another Header
                    Box(
                        // modifier = Modifier.fillContentContainerWidth() // not allowed in Header
                    ) { }

                    Content {
                        // Header { } // not allowed in the Content of another Header
                        Box(
                            // modifier = Modifier.fillContentContainerWidth() // not allowed in the Content of a Header
                        ) { }
                    }
                    // ScrollableContent {} // not allowed in Header
                }
                HeaderSpacer()
                Box(
                    modifier = Modifier.fillContentContainerWidth()
                ) {
                    Box(
                        // modifier = Modifier.fillContentContainerWidth() // not allowed in sub-layouts
                    ) {}
                    //HeaderSpacer() // not allowed in sub-layouts
                }
            }
            Content { }
        }

        DialogScreen {
            Header {
                // Header { } // not allowed in another Header
                Box(
                    // modifier = Modifier.fillContentContainerWidth() // not allowed in Header
                ) { }
                Content {
                    // Header { } // not allowed in the Content of another Header
                    Box(
                        // modifier = Modifier.fillContentContainerWidth() // not allowed in the Content of a Header
                    ) { }
                }
                // ScrollableContent {} // not allowed in Header
            }
            Content {
                Header(
                    modifier = Modifier.fillContentContainerWidth()
                ) {
                    // Header { } // not allowed in another Header
                    Box(
                        // modifier = Modifier.fillContentContainerWidth() // not allowed in Header
                    ) { }

                    Content {
                        // Header { } // not allowed in the Content of another Header
                        Box(
                            // modifier = Modifier.fillContentContainerWidth() // not allowed in the Content of a Header
                        ) { }
                    }
                    // ScrollableContent {} // not allowed in Header
                }
                Box(
                    modifier = Modifier.fillContentContainerWidth()
                ) {
                    Box(
                        // modifier = Modifier.fillContentContainerWidth() // not allowed in sub-layouts
                    ) {}
                }
            }
            Content { }
        }
    }
}