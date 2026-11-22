package com.gft.mobius.components.common

import kotlinx.datetime.LocalDate
import kotlinx.datetime.number
import kotlin.time.Clock

data class YearMonth(val year: Int, val month: Int) {

    init {
        require(month in 1..12) { "Month must be between 1 and 12" }
    }

    fun toUTCMillis(): Long = LocalDate(year, month, 15).toUTCMillis()

    companion object {
        fun now(): YearMonth = of(Clock.System.now().toEpochMilliseconds())

        fun of(timeInUTCMilliseconds: Long): YearMonth {
            val date = timeInUTCMilliseconds.toLocalDate()
            return YearMonth(date.year, date.month.number)
        }
    }
}
