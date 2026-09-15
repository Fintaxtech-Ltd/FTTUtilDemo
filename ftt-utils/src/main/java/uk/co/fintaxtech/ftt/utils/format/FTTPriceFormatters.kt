package uk.co.fintaxtech.ftt.utils.format

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

private const val MONTHS_PER_YEAR = 12L
private const val PRICE_MICROS_SCALE = 6
private const val MONTHLY_PRICE_SCALE = 2

/** Derives a locale-formatted monthly equivalent solely from store price metadata. */
fun formatMonthlyEquivalentPrice(
    annualPriceAmountMicros: Long,
    currencyCode: String,
    locale: Locale = Locale.getDefault()
): String {
    val monthlyPrice = BigDecimal
        .valueOf(annualPriceAmountMicros, PRICE_MICROS_SCALE)
        .divide(BigDecimal.valueOf(MONTHS_PER_YEAR), MONTHLY_PRICE_SCALE, RoundingMode.HALF_UP)
    return NumberFormat.getCurrencyInstance(locale).apply {
        currency = Currency.getInstance(currencyCode)
        minimumFractionDigits = MONTHLY_PRICE_SCALE
        maximumFractionDigits = MONTHLY_PRICE_SCALE
    }.format(monthlyPrice)
}
