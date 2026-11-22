package com.gft.mobius.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DateRangePickerDefaults
import androidx.compose.material3.SelectableDates
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.DateRangePicker.DisplayMode
import com.gft.mobius.components.common.YearMonth
import com.gft.mobius.components.common.toLocalDate
import com.gft.mobius.components.common.toUTCMillis
import com.gft.mobius.components.styles.DatePickerHeadlineStyle
import com.gft.mobius.components.styles.DatePickerTitleStyle
import com.gft.mobius.components.styles.DateRangePickerStyle
import com.gft.mobius.components.styles.DateRangePickerStyleValues
import com.gft.mobius.components.styles.ProvideTextStyle
import com.gft.mobius.components.styles.resolve
import com.gft.mobius.materialdesign.toTextFieldColors
import kotlinx.datetime.LocalDate

@Suppress("NAME_SHADOWING")
@Composable
fun DateRangePicker(
    state: DateRangePickerState,
    modifier: Modifier = Modifier,
    title: @Composable ((DateRangePickerState) -> Unit)? = { state ->
        DateRangePicker.Title(displayMode = state.displayMode)
    },
    headline: @Composable ((DateRangePickerState) -> Unit)? = { state ->
        DateRangePicker.Headline(
            selectedStartDate = state.selectedStartDate,
            selectedEndDate = state.selectedEndDate,
            displayMode = state.displayMode
        )
    },
    style: DateRangePickerStyle = Mobius.styles.dateRangePickerStyle
) {
    val styleValues = style.resolve()
    androidx.compose.material3.DateRangePicker(
        state = state.state,
        modifier = modifier,
        dateFormatter = styleValues.dateFormatter.toMaterial3(),
        showModeToggle = styleValues.modeToggleVisible,
        title = title?.let {
            {
                ProvideTextStyle(styleValues.titleTextStyle) {
                    title(state)
                }
            }
        },
        headline = headline?.let {
            {
                ProvideTextStyle(styleValues.headlineTextStyle) {
                    headline(state)
                }
            }
        },
        colors = datePickerColors(styleValues)
    )
}

@Composable
fun rememberDateRangePickerState(
    initialDisplayedMonth: YearMonth? = null,
    initialSelectedStartDate: LocalDate? = null,
    initialSelectedEndDate: LocalDate? = null,
    initialDisplayMode: DatePicker.DisplayMode = DatePicker.DisplayMode.Picker,
    yearRange: IntRange = IntRange(1900, 2100),
    yearFilter: (year: Int) -> Boolean = { true },
    dateFilter: (LocalDate) -> Boolean = { true },
): DateRangePickerState {
    val state = androidx.compose.material3.rememberDateRangePickerState(
        initialSelectedStartDateMillis = initialSelectedStartDate?.toUTCMillis(),
        initialSelectedEndDateMillis = initialSelectedEndDate?.toUTCMillis() ?: initialSelectedStartDate?.toUTCMillis(),
        initialDisplayedMonthMillis = initialDisplayedMonth?.toUTCMillis(),
        yearRange = yearRange,
        initialDisplayMode = initialDisplayMode.toMaterial3(),
        selectableDates = object : SelectableDates {
            override fun isSelectableYear(year: Int) = yearFilter(year)
            override fun isSelectableDate(utcTimeMillis: Long) = dateFilter(utcTimeMillis.toLocalDate())
        },
    )
    return remember(state) {
        DateRangePickerState(state)
    }
}

@Composable
private fun datePickerColors(
    styleValues: DateRangePickerStyleValues
) = DatePickerColors(
    containerColor = styleValues.containerColor,
    titleContentColor = styleValues.titleColor,
    headlineContentColor = styleValues.headlineContentColor,
    weekdayContentColor = styleValues.weekdayContentColor,
    subheadContentColor = styleValues.subheadContentColor,
    navigationContentColor = styleValues.navigationContentColor,
    yearContentColor = styleValues.yearContentColor,
    disabledYearContentColor = styleValues.disabledYearContentColor,
    currentYearContentColor = styleValues.currentYearContentColor,
    selectedYearContentColor = styleValues.selectedYearContentColor,
    disabledSelectedYearContentColor = styleValues.disabledSelectedYearContentColor,
    selectedYearContainerColor = styleValues.selectedYearContainerColor,
    disabledSelectedYearContainerColor = styleValues.disabledSelectedYearContainerColor,
    dayContentColor = styleValues.dayContentColor,
    disabledDayContentColor = styleValues.disabledDayContentColor,
    selectedDayContentColor = styleValues.selectedDayContentColor,
    disabledSelectedDayContentColor = styleValues.disabledSelectedDayContentColor,
    selectedDayContainerColor = styleValues.selectedDayContainerColor,
    disabledSelectedDayContainerColor = styleValues.disabledSelectedDayContainerColor,
    todayContentColor = styleValues.todayContentColor,
    todayDateBorderColor = styleValues.todayDateBorderColor,
    dayInSelectionRangeContentColor = styleValues.dayInSelectionRangeContentColor,
    dayInSelectionRangeContainerColor = styleValues.dayInSelectionRangeContainerColor,
    dividerColor = styleValues.dividerColor,
    dateTextFieldColors = styleValues.dateTextFieldColors.toTextFieldColors()
)

@Stable
class DateRangePickerState(
    internal val state: androidx.compose.material3.DateRangePickerState
) {
    var displayedMonth: YearMonth
        get() {
            return YearMonth.of(state.displayedMonthMillis)
        }
        set(value) {
            state.displayedMonthMillis = value.toUTCMillis()
        }

    var selectedStartDate: LocalDate?
        get() {
            return state.selectedStartDateMillis?.toLocalDate()
        }
        set(value) {
            state.setSelection(
                startDateMillis = value?.toUTCMillis(),
                endDateMillis = state.selectedEndDateMillis
            )
        }

    var selectedEndDate: LocalDate?
        get() {
            return state.selectedEndDateMillis?.toLocalDate()
        }
        set(value) {
            state.setSelection(
                startDateMillis = state.selectedStartDateMillis,
                endDateMillis = value?.toUTCMillis()
            )
        }

    var displayMode: DisplayMode
        get() {
            return state.displayMode.toDisplayMode()
        }
        set(value) {
            state.displayMode = value.toMaterial3()
        }
}

open class DateRangePicker {
    enum class DisplayMode {
        Picker, Input;

        internal fun toMaterial3() =
            when (this) {
                Picker -> androidx.compose.material3.DisplayMode.Picker
                Input -> androidx.compose.material3.DisplayMode.Input
            }
    }

    @Composable
    fun Title(
        modifier: Modifier = Modifier,
        displayMode: DisplayMode,
        style: DatePickerTitleStyle = Mobius.styles.dateRangePickerTitleStyle
    ) {
        val styleValues = style.resolve()
        ProvideTextStyle(styleValues.textStyle) {
            DateRangePickerDefaults.DateRangePickerTitle(
                modifier = modifier.padding(styleValues.padding),
                displayMode = displayMode.toMaterial3()
            )
        }
    }

    @Composable
    fun Headline(
        modifier: Modifier = Modifier,
        selectedStartDate: LocalDate?,
        selectedEndDate: LocalDate?,
        displayMode: DisplayMode,
        style: DatePickerHeadlineStyle = Mobius.styles.dateRangePickerHeadlineStyle
    ) {
        val styleValues = style.resolve()
        ProvideTextStyle(styleValues.textStyle) {
            DateRangePickerDefaults.DateRangePickerHeadline(
                selectedStartDateMillis = selectedStartDate?.toUTCMillis(),
                selectedEndDateMillis = selectedEndDate?.toUTCMillis(),
                displayMode = displayMode.toMaterial3(),
                dateFormatter = styleValues.dateFormatter.toMaterial3(),
                modifier = modifier.padding(styleValues.padding)
            )
        }
    }

    companion object : DateRangePicker()
}

private fun androidx.compose.material3.DisplayMode.toDisplayMode() =
    when (this) {
        androidx.compose.material3.DisplayMode.Picker -> DisplayMode.Picker
        androidx.compose.material3.DisplayMode.Input -> DisplayMode.Input
        else -> DisplayMode.Picker
    }
