package com.gft.mobius.components.common

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import toLocalDate
import toUTCMillis

data class YearMonth(val year: Int, val month: Int) {

    init {
        require(month in 1..12) { "Month must be between 1 and 12" }
    }

    fun toUTCMillis(): Long = LocalDate(year, month, 15).toUTCMillis()

    companion object {
        fun now(): YearMonth {
            val now = Clock.System.now().toLocalDateTime(TimeZone.UTC).date
            return YearMonth(now.year, now.monthNumber)
        }

        fun of(timeInUTCMilliseconds: Long): YearMonth {
            val date = timeInUTCMilliseconds.toLocalDate()
            return YearMonth(date.year, date.monthNumber)
        }
    }
}
