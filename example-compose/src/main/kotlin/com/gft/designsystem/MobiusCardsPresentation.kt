package com.gft.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Card
import com.gft.mobius.components.ElevatedCard
import com.gft.mobius.components.OutlinedCard
import com.gft.mobius.components.Screen
import com.gft.mobius.components.Content
import com.gft.mobius.components.Text

@Composable
fun MobiusCardsPresentation() {
    Mobius {
        Screen {
            Content {
                val cardModifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Card(
                        modifier = cardModifier
                    ) {
                        Text(text = "Card")
                    }

                    Card(
                        onClick = {},
                        modifier = cardModifier
                    ) {
                        Text(text = "Clickable card")
                    }

                    Card(
                        onClick = {},
                        enabled = false,
                        modifier = cardModifier
                    ) {
                        Text(text = "Disabled card")
                    }

                    OutlinedCard(
                        modifier = cardModifier
                    ) {
                        Text(text = "Outlined card")
                    }

                    OutlinedCard(
                        onClick = {},
                        modifier = cardModifier
                    ) {
                        Text(text = "Outlined clickable card")
                    }

                    OutlinedCard(
                        onClick = {},
                        enabled = false,
                        modifier = cardModifier
                    ) {
                        Text(text = "Outlined disabled card")
                    }

                    ElevatedCard(
                        modifier = cardModifier
                    ) {
                        Text(text = "Elevated card")
                    }

                    ElevatedCard(
                        onClick = {},
                        modifier = cardModifier
                    ) {
                        Text(text = "Elevated clickable card")
                    }

                    ElevatedCard(
                        onClick = {},
                        enabled = false,
                        modifier = cardModifier
                    ) {
                        Text(text = "Elevated disabled card")
                    }
                }
            }
        }
    }
}
