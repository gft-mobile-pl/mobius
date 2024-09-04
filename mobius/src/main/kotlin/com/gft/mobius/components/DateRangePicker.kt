package com.gft.mobius.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DateRangePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.gft.mobius.Mobius
import com.gft.mobius.components.DateRangePicker.DisplayMode
import com.gft.mobius.components.styles.DatePickerHeadlineStyle
import com.gft.mobius.components.styles.DatePickerTitleStyle
import com.gft.mobius.components.styles.DateRangePickerStyle
import com.gft.mobius.components.styles.DateRangePickerStyleValues
import com.gft.mobius.components.styles.ProvideTextStyle
import com.gft.mobius.components.styles.resolve
import com.gft.mobius.materialdesign.toTextFieldColors
import toLocalDate
import toUTCMillis
import java.time.LocalDate
import java.time.YearMonth

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
    @OptIn(ExperimentalMaterial3Api::class)
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
    initialDisplayedMonth: YearMonth = YearMonth.now(),
    initialSelectedStartDate: LocalDate? = null,
    initialSelectedEndDate: LocalDate? = null,
    initialDisplayMode: DatePicker.DisplayMode = DatePicker.DisplayMode.Picker,
    yearRange: IntRange = IntRange(1900, 2100),
    yearFilter: (year: Int) -> Boolean = { true },
    dateFilter: (LocalDate) -> Boolean = { true }
): DateRangePickerState {
    @OptIn(ExperimentalMaterial3Api::class)
    val state = androidx.compose.material3.rememberDateRangePickerState(
        initialSelectedStartDateMillis = initialSelectedStartDate?.toUTCMillis(),
        initialSelectedEndDateMillis = initialSelectedEndDate?.toUTCMillis(),
        initialDisplayedMonthMillis = initialDisplayedMonth.atEndOfMonth().toUTCMillis(),
        yearRange = yearRange,
        initialDisplayMode = initialDisplayMode.toMaterial3(),
        selectableDates = object : SelectableDates {
            override fun isSelectableYear(year: Int) = yearFilter(year)
            override fun isSelectableDate(utcTimeMillis: Long) = dateFilter(utcTimeMillis.toLocalDate())
        },
    )
    @OptIn(ExperimentalMaterial3Api::class)
    return remember(state) {
        DateRangePickerState(state)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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
    @OptIn(ExperimentalMaterial3Api::class)
    internal val state: androidx.compose.material3.DateRangePickerState
) {
    var displayedMonth: YearMonth
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return YearMonth.from(state.displayedMonthMillis.toLocalDate())
        }
        set(value) {
            @OptIn(ExperimentalMaterial3Api::class)
            state.displayedMonthMillis = value.atEndOfMonth().toUTCMillis()
        }

    var selectedStartDate: LocalDate?
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.selectedStartDateMillis?.toLocalDate()
        }
        set(value) {
            @OptIn(ExperimentalMaterial3Api::class)
            state.setSelection(
                startDateMillis = value?.toUTCMillis(),
                endDateMillis = state.selectedEndDateMillis
            )
        }

    var selectedEndDate: LocalDate?
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.selectedEndDateMillis?.toLocalDate()
        }
        set(value) {
            @OptIn(ExperimentalMaterial3Api::class)
            state.setSelection(
                startDateMillis = state.selectedStartDateMillis,
                endDateMillis = value?.toUTCMillis()
            )
        }

    var displayMode: DisplayMode
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.displayMode.toDisplayMode()
        }
        set(value) {
            @OptIn(ExperimentalMaterial3Api::class)
            state.displayMode = value.toMaterial3()
        }
}

open class DateRangePicker {
    enum class DisplayMode {
        Picker, Input;

        @OptIn(ExperimentalMaterial3Api::class)
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
            @OptIn(ExperimentalMaterial3Api::class)
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
            @OptIn(ExperimentalMaterial3Api::class)
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

@OptIn(ExperimentalMaterial3Api::class)
private fun androidx.compose.material3.DisplayMode.toDisplayMode() =
    when (this) {
        androidx.compose.material3.DisplayMode.Picker -> DisplayMode.Picker
        androidx.compose.material3.DisplayMode.Input -> DisplayMode.Input
        else -> DisplayMode.Picker
    }
