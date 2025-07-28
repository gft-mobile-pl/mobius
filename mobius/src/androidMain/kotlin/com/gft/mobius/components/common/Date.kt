@file:JvmName("DateAndroid")

import java.time.Instant
import java.time.LocalDate
import java.time.ZoneOffset

internal fun LocalDate.toUTCMillis() = atStartOfDay(ZoneOffset.UTC.normalized()).toInstant().toEpochMilli()

internal fun Long.toJVMLocalDate() = Instant.ofEpochMilli(this).atZone(ZoneOffset.UTC.normalized()).toLocalDate()
