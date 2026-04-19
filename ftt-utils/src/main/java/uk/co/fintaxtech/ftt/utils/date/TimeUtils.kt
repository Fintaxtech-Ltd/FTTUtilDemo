package uk.co.fintaxtech.ftt.utils.date

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Long.toStringDate(): String {
    val date = Date(this)
    val format = SimpleDateFormat("dd-MM-yyyy HH:MM Z", Locale.getDefault())
    return format.format(date)
}
