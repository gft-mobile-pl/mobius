package com.gft.designsystem

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gft.designsystem.LongestElement.Content
import com.gft.designsystem.LongestElement.Footer
import com.gft.designsystem.LongestElement.Header
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.Content
import com.gft.mobius.components.DialogScreen
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.Footer
import com.gft.mobius.components.Header
import com.gft.mobius.components.Text
import com.gft.mobius.components.contentContainerHorizontalPaddings

@Composable
fun MobiusDialogScreenSizingPresentation() {
    Mobius {
        val longestElement = remember {
            mutableStateOf(Content)
        }

        DialogScreen {
            Header(
                modifier = Modifier
                    .background(Mobius.colors.primary)
            ) {
                Content {
                    Text(
                        text = if (longestElement.value == Header) "This is quite long header." else "Short header."
                    )
                }
            }
            Content(
                modifier = Modifier
                    .background(Mobius.colors.surfaceContainerHigh)
            ) {
                Text(
                    text = if (longestElement.value == Content) "This is quite long content." else "Short content."
                )
                ElementSpacer()
                Text(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillContentContainerWidth()
                        .contentContainerHorizontalPaddings(),
                    text = "Full width background"
                )
                ElementSpacer()
                Button(
                    onClick = {
                        longestElement.value = longestElement.value.nextElement()
                    }
                ) {
                    Text("Next case")
                }
            }
            Footer(
                modifier = Modifier
                    .background(Color.Gray)
            ) {
                Content {
                    Text(
                        text = if (longestElement.value == Footer) "This is quite long footer." else "Short footer."
                    )
                }

            }
        }
    }
}

private enum class LongestElement {
    Header, Content, Footer;

    fun nextElement() = when (this) {
        Header -> Content
        Content -> Footer
        Footer -> Header
    }
}