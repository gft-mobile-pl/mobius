package com.gft.designsystem

import androidx.compose.runtime.Composable
import com.gft.mobius.Mobius
import com.gft.mobius.components.Content
import com.gft.mobius.components.Label
import com.gft.mobius.components.LabelPlacement.Bottom
import com.gft.mobius.components.LabelPlacement.End
import com.gft.mobius.components.LabelPlacement.Start
import com.gft.mobius.components.LabelPlacement.Top
import com.gft.mobius.components.LargeElementSpacer
import com.gft.mobius.components.RadioButton
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Text

@Composable
fun MobiusLabelPresentation() {
    Mobius {
        Screen {
            Content {
                Label(
                    text = { Text(text = "Start - top aligned") },
                    labelPlacement = Start.AlignTop
                ) {
                    RadioButton(selected = false, onClick = { })
                }

                Label(
                    text = { Text(text = "Start - center aligned") },
                    labelPlacement = Start.CenterVertically
                ) {
                    RadioButton(selected = false, onClick = { })
                }

                Label(
                    text = { Text(text = "Start - bottom aligned") },
                    labelPlacement = Start.AlignBottom
                ) {
                    RadioButton(selected = false, onClick = { })
                }

                LargeElementSpacer()

                Label(
                    text = { Text(text = "End - top aligned") },
                    labelPlacement = End.AlignTop
                ) {
                    RadioButton(selected = false, onClick = { })
                }

                Label(
                    text = { Text(text = "End - center aligned") },
                    labelPlacement = End.CenterVertically
                ) {
                    RadioButton(selected = false, onClick = { })
                }

                Label(
                    text = { Text(text = "End - bottom aligned") },
                    labelPlacement = End.AlignBottom
                ) {
                    RadioButton(selected = false, onClick = { })
                }

                LargeElementSpacer()

                Label(
                    text = { Text(text = "Top - start aligned") },
                    labelPlacement = Top.AlignStart
                ) {
                    RadioButton(selected = false, onClick = { })
                }

                Label(
                    text = { Text(text = "Top - center aligned") },
                    labelPlacement = Top.CenterHorizontally
                ) {
                    RadioButton(selected = false, onClick = { })
                }

                Label(
                    text = { Text(text = "Top - end aligned") },
                    labelPlacement = Top.AlignEnd
                ) {
                    RadioButton(selected = false, onClick = { })
                }

                LargeElementSpacer()

                Label(
                    text = { Text(text = "Bottom - start aligned") },
                    labelPlacement = Bottom.AlignStart
                ) {
                    RadioButton(selected = false, onClick = { })
                }

                Label(
                    text = { Text(text = "Bottom - center aligned") },
                    labelPlacement = Bottom.CenterHorizontally
                ) {
                    RadioButton(selected = false, onClick = { })
                }

                Label(
                    text = { Text(text = "Bottom - end aligned") },
                    labelPlacement = Bottom.AlignEnd
                ) {
                    RadioButton(selected = false, onClick = { })
                }
            }
        }
    }
}
