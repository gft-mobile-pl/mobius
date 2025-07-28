package com.gft.designsystem

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.Content
import com.gft.mobius.components.DatePicker
import com.gft.mobius.components.ElementSpacer
import com.gft.mobius.components.Screen
import com.gft.mobius.components.common.YearMonth
import com.gft.mobius.components.rememberDatePickerState
import com.gft.mobius.components.styles.DefaultScrollableContentStyle
import kotlinx.datetime.LocalDate

@Composable
fun MobiusDatePickerPresentation() {
    Mobius {
        Screen {
            Content(style = NoPaddingContentStyle()) {
                val simpleDatePickerState = rememberDatePickerState(YearMonth.now())
                DatePicker(state = simpleDatePickerState)

                ElementSpacer()

                val datePickerState = rememberDatePickerState(
                    initialDisplayedMonth = YearMonth(2022, 1),
                    initialSelectedDate = LocalDate(2022, 11, 30),
                    initialDisplayMode = DatePicker.DisplayMode.Input,
                    yearRange = 2000..2050,
                    yearFilter = { year -> year > 2021 },
                    dateFilter = { date -> date > LocalDate(2022, 11, 10) }
                )
                DatePicker(
                    state = datePickerState,
                    title = null,
                    headline = null,
                )
            }
        }
    }
}

private class NoPaddingContentStyle : DefaultScrollableContentStyle() {
    override val padding = Token(PaddingValues(0.dp))
}
