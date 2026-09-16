package uk.co.fintaxtech.ftt.utils.format

import java.math.BigDecimal
import java.text.NumberFormat
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Currency
import java.util.Locale

/** Formats persisted minor currency units using the currency's own fraction digits and locale. */
fun formatCurrencyMinorUnits(
    minorUnits: Long,
    currencyCode: String,
    locale: Locale = Locale.getDefault()
): String {
    val currency = Currency.getInstance(currencyCode)
    val amount = BigDecimal.valueOf(minorUnits)
        .movePointLeft(currency.defaultFractionDigits.coerceAtLeast(0))
    return NumberFormat.getCurrencyInstance(locale).apply {
        this.currency = currency
    }.format(amount)
}

/** Formats an epoch timestamp as a locale-correct date in the device's current time zone. */
fun formatLocalDate(
    epochMillis: Long,
    locale: Locale = Locale.getDefault(),
    zoneId: ZoneId = ZoneId.systemDefault()
): String = DateTimeFormatter
    .ofLocalizedDate(FormatStyle.MEDIUM)
    .withLocale(locale)
    .format(Instant.ofEpochMilli(epochMillis).atZone(zoneId).toLocalDate())
