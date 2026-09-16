package uk.co.fintaxtech.ftt.utils.format

import java.text.NumberFormat
import java.util.Locale
import kotlin.math.roundToLong

/**
 * Numbers grouped for the reader's locale — `"42,300"`, or `"42.300"` in a locale that groups
 * with dots.
 *
 * The counterpart for values that go *into* an input field, where the string is parsed back
 * and a locale-specific separator would not round-trip, is [FTTDecimalText].
 */
public object FTTLocalizedNumber {

    /**
     * Rounds to a whole number and groups it.
     *
     * For totals large enough that the grouping earns its keep and a fractional part means
     * nothing to the reader.
     */
    public fun wholeNumber(value: Double, locale: Locale = Locale.getDefault()): String =
        NumberFormat.getIntegerInstance(locale).format(value.roundToLong())
}
