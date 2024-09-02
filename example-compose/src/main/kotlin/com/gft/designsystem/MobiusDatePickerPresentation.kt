package com.gft.designsystem

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.gft.mobius.Mobius
import com.gft.mobius.components.ContentElementsSpacer
import com.gft.mobius.components.DatePicker
import com.gft.mobius.components.Screen
import com.gft.mobius.components.ScrollableContent
import com.gft.mobius.components.rememberDatePickerState
import com.gft.mobius.components.styles.DefaultContentStyle
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun MobiusDatePickerPresentation() {
    Mobius {
        Screen {
            ScrollableContent(style = NoPaddingContentStyle()) {
                val simpleDatePickerState = rememberDatePickerState()
                DatePicker(state = simpleDatePickerState)

                ContentElementsSpacer()

                val datePickerState = rememberDatePickerState(
                    initialDisplayedMonth = YearMonth.of(2022, 1),
                    initialSelectedDate = LocalDate.of(2022, 11, 30),
                    initialDisplayMode = DatePicker.DisplayMode.Input,
                    yearRange = 2000..2050,
                    yearFilter = { year -> year > 2021 },
                    dateFilter = { date -> date.isAfter(LocalDate.of(2022, 11, 10)) }
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

private class NoPaddingContentStyle : DefaultContentStyle() {
    override val padding = Token(PaddingValues(0.dp))
}
