package uk.co.fintaxtech.ftt.utils.date

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.Calendar
import java.util.TimeZone

class TimeUtilsTest {

    @Test
    fun `formatMillisToDateString returns correct format`() {
        // 1713484800000L = Friday, April 19, 2024 12:00:00 AM UTC
        val millis = 1713484800000L

        // Use UTC to ensure test consistency regardless of local machine timezone
        val result = millis.toStringDate()

        assertEquals("19-04-2024 01:04 +0100", result)
    }

}