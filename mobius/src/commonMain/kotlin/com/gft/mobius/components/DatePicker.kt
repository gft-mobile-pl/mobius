package com.gft.mobius.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePickerColors
import androidx.compose.material3.DatePickerDefaults.DatePickerHeadline
import androidx.compose.material3.DatePickerDefaults.DatePickerTitle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.gft.mobius.Mobius
import com.gft.mobius.components.common.YearMonth
import com.gft.mobius.components.styles.DatePickerHeadlineStyle
import com.gft.mobius.components.styles.DatePickerStyle
import com.gft.mobius.components.styles.DatePickerStyleValues
import com.gft.mobius.components.styles.DatePickerTitleStyle
import com.gft.mobius.components.styles.ProvideTextStyle
import com.gft.mobius.components.styles.resolve
import com.gft.mobius.materialdesign.toTextFieldColors
import kotlinx.datetime.LocalDate
import toLocalDate
import toUTCMillis

@Suppress("NAME_SHADOWING")
@Composable
fun DatePicker(
    state: DatePickerState,
    modifier: Modifier = Modifier,
    title: @Composable ((DatePickerState) -> Unit)? = { state ->
        DatePicker.Title(displayMode = state.displayMode)
    },
    headline: @Composable ((DatePickerState) -> Unit)? = { state ->
        DatePicker.Headline(
            selectedDate = state.selectedDate,
            displayMode = state.displayMode
        )
    },
    style: DatePickerStyle = Mobius.styles.datePickerStyle
) {
    val styleValues = style.resolve()
    @OptIn(ExperimentalMaterial3Api::class)
    androidx.compose.material3.DatePicker(
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
fun rememberDatePickerState(
    initialDisplayedMonth: YearMonth? = null,
    initialSelectedDate: LocalDate? = null,
    initialDisplayMode: DatePicker.DisplayMode = DatePicker.DisplayMode.Picker,
    yearRange: IntRange = IntRange(1900, 2100),
    yearFilter: (year: Int) -> Boolean = { true },
    dateFilter: (LocalDate) -> Boolean = { true },
): DatePickerState {
    @OptIn(ExperimentalMaterial3Api::class)
    val state = androidx.compose.material3.rememberDatePickerState(
        initialSelectedDateMillis = initialSelectedDate?.toUTCMillis(),
        initialDisplayedMonthMillis = initialDisplayedMonth?.toUTCMillis() ?: initialSelectedDate?.toUTCMillis(),
        yearRange = yearRange,
        initialDisplayMode = initialDisplayMode.toMaterial3(),
        selectableDates = object : SelectableDates {
            override fun isSelectableYear(year: Int) = yearFilter(year)
            override fun isSelectableDate(utcTimeMillis: Long) = dateFilter(utcTimeMillis.toLocalDate())
        },
    )
    @OptIn(ExperimentalMaterial3Api::class)
    return remember(state) {
        DatePickerState(state)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun datePickerColors(
    styleValues: DatePickerStyleValues
) = DatePickerColors(
    containerColor = styleValues.containerColor,
    titleContentColor = styleValues.titleColor,
    headlineContentColor = styleValues.headlineContentColor,
    weekdayContentColor = styleValues.weekdayContentColor,
    subheadContentColor = Color.Unspecified,
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
    dayInSelectionRangeContentColor = Color.Unspecified,
    dayInSelectionRangeContainerColor = Color.Unspecified,
    dividerColor = styleValues.dividerColor,
    dateTextFieldColors = styleValues.dateTextFieldColors.toTextFieldColors()
)

@Stable
class DatePickerState(
    @OptIn(ExperimentalMaterial3Api::class)
    internal val state: androidx.compose.material3.DatePickerState
) {
    var displayedMonth: YearMonth
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return YearMonth.of(state.displayedMonthMillis)
        }
        set(value) {
            @OptIn(ExperimentalMaterial3Api::class)
            state.displayedMonthMillis = value.toUTCMillis()
        }

    var selectedDate: LocalDate?
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.selectedDateMillis?.toLocalDate()
        }
        set(value) {
            @OptIn(ExperimentalMaterial3Api::class)
            state.selectedDateMillis = value?.toUTCMillis()
        }

    var displayMode: DatePicker.DisplayMode
        get() {
            @OptIn(ExperimentalMaterial3Api::class)
            return state.displayMode.toDisplayMode()
        }
        set(value) {
            @OptIn(ExperimentalMaterial3Api::class)
            state.displayMode = value.toMaterial3()
        }
}

open class DatePicker {
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
        style: DatePickerTitleStyle = Mobius.styles.datePickerTitleStyle
    ) {
        val styleValues = style.resolve()
        ProvideTextStyle(styleValues.textStyle) {
            @OptIn(ExperimentalMaterial3Api::class)
            DatePickerTitle(
                modifier = modifier.padding(styleValues.padding),
                displayMode = displayMode.toMaterial3()
            )
        }
    }

    @Composable
    fun Headline(
        modifier: Modifier = Modifier,
        selectedDate: LocalDate?,
        displayMode: DisplayMode,
        style: DatePickerHeadlineStyle = Mobius.styles.datePickerHeadlineStyle
    ) {
        val styleValues = style.resolve()
        ProvideTextStyle(styleValues.textStyle) {
            @OptIn(ExperimentalMaterial3Api::class)
            DatePickerHeadline(
                selectedDateMillis = selectedDate?.toUTCMillis(),
                displayMode = displayMode.toMaterial3(),
                dateFormatter = styleValues.dateFormatter.toMaterial3(),
                modifier = modifier.padding(styleValues.padding)
            )
        }
    }

    companion object : DatePicker()
}

@OptIn(ExperimentalMaterial3Api::class)
private fun androidx.compose.material3.DisplayMode.toDisplayMode() =
    when (this) {
        androidx.compose.material3.DisplayMode.Picker -> DatePicker.DisplayMode.Picker
        androidx.compose.material3.DisplayMode.Input -> DatePicker.DisplayMode.Input
        else -> DatePicker.DisplayMode.Picker
    }
