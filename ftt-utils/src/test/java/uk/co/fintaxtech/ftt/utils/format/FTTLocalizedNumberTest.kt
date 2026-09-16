package uk.co.fintaxtech.ftt.utils.format

import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.Locale

class FTTLocalizedNumberTest {

    @Test
    fun `groups a whole number for the given locale`() {
        assertEquals("42,300", FTTLocalizedNumber.wholeNumber(42300.0, Locale.UK))
    }

    @Test
    fun `rounds a fractional value before grouping`() {
        assertEquals("42,300", FTTLocalizedNumber.wholeNumber(42300.4, Locale.UK))
        assertEquals("42,301", FTTLocalizedNumber.wholeNumber(42300.5, Locale.UK))
    }

    @Test
    fun `uses the locale's own grouping separator`() {
        assertEquals("42.300", FTTLocalizedNumber.wholeNumber(42300.0, Locale.GERMANY))
    }
}
