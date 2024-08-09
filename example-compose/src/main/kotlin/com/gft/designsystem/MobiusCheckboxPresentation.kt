package com.gft.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.state.ToggleableState.Indeterminate
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Checkbox

@Composable
fun MobiusCheckboxPresentation() {
    Mobius {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically),
            ) {
                var checkboxChecked by remember { mutableStateOf(false) }
                Checkbox(
                    checked = checkboxChecked,
                    onCheckedChange = { checked ->
                        checkboxChecked = checked
                    },
                )

                var triStateCheckboxState by remember { mutableStateOf(Indeterminate) }
                Checkbox(
                    state = triStateCheckboxState,
                    onClick = {
                        triStateCheckboxState = triStateCheckboxState.next()
                    },
                )

                Checkbox(
                    checked = true,
                    enabled = false,
                    onCheckedChange = {},
                )

                Checkbox(
                    checked = false,
                    enabled = false,
                    onCheckedChange = {},
                )

                Checkbox(
                    state = Indeterminate,
                    enabled = false,
                    onClick = {},
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically),
            ) {
                var checkboxChecked by remember { mutableStateOf(false) }
                Checkbox(
                    checked = checkboxChecked,
                    isError = true,
                    onCheckedChange = { checked ->
                        checkboxChecked = checked
                    },
                )

                var triStateCheckboxState by remember { mutableStateOf(Indeterminate) }
                Checkbox(
                    state = triStateCheckboxState,
                    isError = true,
                    onClick = {
                        triStateCheckboxState = triStateCheckboxState.next()
                    },
                )

                Checkbox(
                    checked = true,
                    enabled = false,
                    isError = true,
                    onCheckedChange = {},
                )

                Checkbox(
                    checked = false,
                    enabled = false,
                    isError = true,
                    onCheckedChange = {},
                )

                Checkbox(
                    state = Indeterminate,
                    enabled = false,
                    isError = true,
                    onClick = {},
                )
            }
        }
    }
}

private fun ToggleableState.next(): ToggleableState =
    if (ordinal < ToggleableState.entries.size - 1) {
        ToggleableState.entries[ordinal + 1]
    } else {
        ToggleableState.entries.first()
    }
