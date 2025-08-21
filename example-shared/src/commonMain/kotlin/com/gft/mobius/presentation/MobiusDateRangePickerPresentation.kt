package com.gft.mobius.presentation

import androidx.compose.runtime.Composable
import com.gft.mobius.Mobius
import com.gft.mobius.components.DatePicker
import com.gft.mobius.components.DateRangePicker
import com.gft.mobius.components.MobiusPresentationNavigationBar
import com.gft.mobius.components.Screen
import com.gft.mobius.components.common.YearMonth
import com.gft.mobius.components.rememberDateRangePickerState
import kotlinx.datetime.LocalDate

@Composable
internal fun MobiusDateRangePickerPresentation(
    onBack: () -> Unit,
) {
    Mobius {
        Screen {
            MobiusPresentationNavigationBar(
                title = "Date range picker",
                onBack = onBack,
            )
            val dateRangePickerState = rememberDateRangePickerState(
                initialDisplayedMonth = YearMonth(2022, 11),
                initialSelectedStartDate = LocalDate(2022, 11, 20),
                initialSelectedEndDate = LocalDate(2022, 11, 25),
                initialDisplayMode = DatePicker.DisplayMode.Picker,
                yearRange = 2000..2050,
                yearFilter = { year -> year > 2021 },
                dateFilter = { date -> date > LocalDate(2022, 11, 10) }
            )
            DateRangePicker(
                state = dateRangePickerState
            )
        }
    }
}
