package com.fintrack.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import java.math.BigDecimal
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

/**
 * Created by fasil on 01/03/25.
 */
fun String.getColor() = this.removePrefix("0x").toLong(radix = 16)

@Composable
fun <T> NavBackStackEntry.getOnceResult(keyResult: String): T? {
    val valueScreenResult = savedStateHandle.get<T>(keyResult)
    savedStateHandle.remove<T>(keyResult)
    return valueScreenResult
}


fun getStartAndEndOfCurrentMonth(): Pair<Long, Long> {
    val currentTimeMillis = System.currentTimeMillis()

    val calendar = Calendar.getInstance().apply {
        timeInMillis = currentTimeMillis
    }

    calendar.set(Calendar.DAY_OF_MONTH, 1)
    calendar.set(Calendar.HOUR_OF_DAY, 0)
    calendar.set(Calendar.MINUTE, 0)
    calendar.set(Calendar.SECOND, 0)
    calendar.set(Calendar.MILLISECOND, 0)
    val startOfMonth = calendar.timeInMillis

    calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
    calendar.set(Calendar.HOUR_OF_DAY, 23)
    calendar.set(Calendar.MINUTE, 59)
    calendar.set(Calendar.SECOND, 59)
    calendar.set(Calendar.MILLISECOND, 999)
    val endOfMonth = calendar.timeInMillis

    return Pair(startOfMonth, endOfMonth)
}

fun Long.formatTimestamp(): String {
    val calendar = Calendar.getInstance()
    val today = calendar.apply {
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.timeInMillis

    val yesterday = today - 24 * 60 * 60 * 1000

    val timeFormat = SimpleDateFormat("h:mm a", Locale.getDefault())
    val dateFormat = SimpleDateFormat("MMM d", Locale.getDefault())

    return when {
        this >= today -> "Today ${timeFormat.format(this)}"
        this >= yesterday -> "Yesterday ${timeFormat.format(this)}"
        this >= today - 6 * 24 * 60 * 60 * 1000 -> {
            // Show day of week for dates within the last week
            SimpleDateFormat("EEEE", Locale.getDefault()).format(this) + " ${timeFormat.format(this)}"
        }
        else -> "${dateFormat.format(this)} ${timeFormat.format(this)}"
    }
}

fun Double.roundTo2Scale() = BigDecimal(this.toString()).setScale(2, RoundingMode.HALF_UP).toDouble()
