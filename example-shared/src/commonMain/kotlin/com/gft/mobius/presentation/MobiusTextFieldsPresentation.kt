package com.gft.mobius.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.OutlinedTextField
import com.gft.mobius.components.Text
import com.gft.mobius.components.TextField

@Composable
internal fun MobiusTextFields(
    onBack: () -> Unit,
) {
    Mobius {
        Column {
            MobiusPresentationNavigationBar(
                title = "Text field",
                onBack = onBack,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(
                    space = 16.dp,
                    alignment = Alignment.CenterVertically
                )
            ) {
                val textField1 = remember { mutableStateOf("Text field 1") }
                OutlinedTextField(
                    value = textField1.value,
                    onValueChange = { textField1.value = it },
                    label = { Text(text = "Label") },
                    supportingText = { Text(text = "Supporting text") }
                )

                OutlinedTextField(
                    value = textField1.value,
                    onValueChange = { textField1.value = it },
                    label = { Text(text = "Label") },
                    isError = true,
                    supportingText = { Text(text = "Supporting text") }
                )

                OutlinedTextField(
                    value = textField1.value,
                    onValueChange = { textField1.value = it },
                    label = { Text(text = "Label") },
                    enabled = false,
                    supportingText = { Text(text = "Supporting text") }
                )

                val textField2 = remember { mutableStateOf("") }
                OutlinedTextField(
                    value = textField2.value,
                    onValueChange = { textField2.value = it },
                    label = { Text(text = "Label") },
                    supportingText = { Text(text = "Supporting text") }
                )

                val textField3 = remember { mutableStateOf("Text field 3") }
                TextField(
                    value = textField3.value,
                    onValueChange = { textField3.value = it },
                    label = { Text(text = "Label") },
                    supportingText = { Text(text = "Supporting text") }
                )

                TextField(
                    value = textField3.value,
                    onValueChange = { textField3.value = it },
                    label = { Text(text = "Label") },
                    isError = true,
                    supportingText = { Text(text = "Supporting text") }
                )

                TextField(
                    value = textField3.value,
                    onValueChange = { textField3.value = it },
                    label = { Text(text = "Label") },
                    enabled = false,
                    supportingText = { Text(text = "Supporting text") }
                )

                val textField4 = remember { mutableStateOf("") }
                TextField(
                    value = textField4.value,
                    onValueChange = { textField4.value = it },
                    label = { Text(text = "Label") },
                    supportingText = { Text(text = "Supporting text") }
                )
            }
        }
    }
}
