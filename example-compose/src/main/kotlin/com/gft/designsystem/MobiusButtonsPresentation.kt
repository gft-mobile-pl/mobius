package com.gft.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Button
import com.gft.mobius.components.ElevatedButton
import com.gft.mobius.components.FilledTonalButton
import com.gft.mobius.components.Icon
import com.gft.mobius.components.OutlinedButton
import com.gft.mobius.components.Text
import com.gft.mobius.components.TextButton

@Composable
fun MobiusButtonsPresentation() {
    Mobius {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically)
        ) {
            Button(
                onClick = { }
            ) {
                Icon(
                    drawableResId = android.R.drawable.ic_delete,
                    contentDescription = ""
                )
                Text(text = "Normal button")
            }

            Button(
                onClick = { },
                enabled = false
            ) {
                Text(text = "Normal button")
            }

            OutlinedButton(onClick = { }) {
                Icon(
                    drawableResId = android.R.drawable.ic_delete,
                    contentDescription = ""
                )
                Text(text = "Outlined button")
            }

            OutlinedButton(
                onClick = { },
                enabled = false
            ) {
                Text(text = "Outlined button")
            }

            ElevatedButton(onClick = { }) {
                Icon(
                    drawableResId = android.R.drawable.ic_delete,
                    contentDescription = ""
                )
                Text(text = "Elevated button")
            }

            ElevatedButton(
                onClick = { },
                enabled = false
            ) {
                Text(text = "Elevated button")
            }

            FilledTonalButton(onClick = { }) {
                Icon(
                    drawableResId = android.R.drawable.ic_delete,
                    contentDescription = ""
                )
                Text(text = "Filled tonal button")
            }

            FilledTonalButton(
                onClick = { },
                enabled = false
            ) {
                Text(text = "Filled tonal button")
            }

            TextButton(onClick = { }) {
                Text(text = "Text button")
            }

            TextButton(
                onClick = { },
                enabled = false
            ) {
                Text(text = "Text button")
            }
        }
    }
}