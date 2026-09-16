package uk.co.fintaxtech.ftt.utils.format

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale
import java.util.concurrent.ConcurrentHashMap

/**
 * Renders an epoch-millisecond timestamp with a caller-supplied [DateTimeFormatter] pattern.
 *
 * The **pattern stays with the caller** — a date's shape is the screen's own presentation
 * decision, so this does not offer a fixed set of "the" date formats. What it removes is the
 * repeated `Instant` -> `ZoneId` -> `DateTimeFormatter` boilerplate every screen otherwise
 * writes out by hand.
 */
public object FTTEpochDateFormat {

    /**
     * The formatters are cached because this typically runs per row inside a lazy list, and
     * [DateTimeFormatter.ofPattern] re-parses its pattern string on every call.
     *
     * Keyed by locale as well as pattern, so a device language change does not keep serving
     * dates formatted for the old one.
     */
    private val formatters = ConcurrentHashMap<CacheKey, DateTimeFormatter>()

    /** [pattern] is a [DateTimeFormatter] pattern, e.g. `"MMM d"` or `"EEE d MMM . HH:mm"`. */
    public fun format(
        timestampMillis: Long,
        pattern: String,
        locale: Locale = Locale.getDefault()
    ): String {
        val formatter = formatters.computeIfAbsent(CacheKey(pattern, locale)) { key ->
            DateTimeFormatter.ofPattern(key.pattern, key.locale)
        }
        // The zone is read per call rather than baked into the cached formatter: a device
        // that changes time zone must not keep rendering timestamps in the old one.
        return formatter.format(Instant.ofEpochMilli(timestampMillis).atZone(ZoneId.systemDefault()))
    }

    private data class CacheKey(
        val pattern: String,
        val locale: Locale
    )
}
