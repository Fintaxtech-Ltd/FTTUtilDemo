package uk.co.fintaxtech.ftt.utils.format

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Test
import java.util.Locale

class FTTEpochDateFormatTest {

    // 2024-04-19T12:00:00Z — noon UTC, so the local date is 2024-04-19 in every real-world
    // time zone (UTC-11 through UTC+14) regardless of the machine running the test.
    private val noonUtcMillis = 1713528000000L

    @Test
    fun `formats using the caller's pattern`() {
        val result = FTTEpochDateFormat.format(noonUtcMillis, "yyyy-MM-dd", locale = Locale.UK)

        assertEquals("2024-04-19", result)
    }

    @Test
    fun `honours the caller's pattern rather than a fixed shape`() {
        val monthDay = FTTEpochDateFormat.format(noonUtcMillis, "MMM d", locale = Locale.UK)

        assertEquals("Apr 19", monthDay)
    }

    @Test
    fun `the same pattern can render differently per locale`() {
        val english = FTTEpochDateFormat.format(noonUtcMillis, "MMMM", locale = Locale.UK)
        val french = FTTEpochDateFormat.format(noonUtcMillis, "MMMM", locale = Locale.FRANCE)

        assertNotEquals(english, french)
    }
}
