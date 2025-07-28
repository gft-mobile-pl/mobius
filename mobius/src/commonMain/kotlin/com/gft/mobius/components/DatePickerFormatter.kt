@file:OptIn(ExperimentalMaterial3Api::class)

package com.gft.mobius.components

import androidx.compose.material3.CalendarLocale
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.ExperimentalMaterial3Api

interface DatePickerFormatter {
    fun formatMonthYear(monthMillis: Long?, locale: CalendarLocale): String?

    fun formatDate(dateMillis: Long?, locale: CalendarLocale): String?

    fun formatDateForContentDescription(dateMillis: Long?, locale: CalendarLocale): String?
}

class DefaultDatePickerFormatter(
    yearSelectionPattern: String = DEFAULT_YEAR_SELECTION_PATTERN,
    selectedDatePattern: String = DEFAULT_SELECTED_DATE_PATTERN,
    selectedDateDescriptionPattern: String = DEFAULT_SELECTED_DATE_DESCRIPTION_PATTERN
) : DatePickerFormatter {
    @OptIn(ExperimentalMaterial3Api::class)
    private val formatter = DatePickerDefaults.dateFormatter(
        yearSelectionSkeleton = yearSelectionPattern,
        selectedDateSkeleton = selectedDatePattern,
        selectedDateDescriptionSkeleton = selectedDateDescriptionPattern
    )

    override fun formatMonthYear(monthMillis: Long?, locale: CalendarLocale): String? {
        @OptIn(ExperimentalMaterial3Api::class)
        return formatter.formatMonthYear(monthMillis, locale)
    }

    override fun formatDate(dateMillis: Long?, locale: CalendarLocale): String? {
        @OptIn(ExperimentalMaterial3Api::class)
        return formatter.formatDate(dateMillis, locale, false)
    }

    override fun formatDateForContentDescription(dateMillis: Long?, locale: CalendarLocale): String? {
        @OptIn(ExperimentalMaterial3Api::class)
        return formatter.formatDate(dateMillis, locale, true)
    }

    companion object {
        const val DEFAULT_YEAR_SELECTION_PATTERN = "yMMMM"
        const val DEFAULT_SELECTED_DATE_PATTERN = "yMMMd"
        const val DEFAULT_SELECTED_DATE_DESCRIPTION_PATTERN = "yMMMMEEEEd"
    }
}

@OptIn(ExperimentalMaterial3Api::class)
internal fun DatePickerFormatter.toMaterial3(): androidx.compose.material3.DatePickerFormatter =
    object : androidx.compose.material3.DatePickerFormatter {
        override fun formatMonthYear(monthMillis: Long?, locale: CalendarLocale) =
            this@toMaterial3.formatMonthYear(monthMillis, locale)

        override fun formatDate(dateMillis: Long?, locale: CalendarLocale, forContentDescription: Boolean) =
            if (forContentDescription) {
                this@toMaterial3.formatDateForContentDescription(dateMillis, locale)
            } else {
                this@toMaterial3.formatDate(dateMillis, locale)
            }
    }
