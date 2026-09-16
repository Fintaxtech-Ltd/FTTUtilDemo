package uk.co.fintaxtech.ftt.utils.format

import org.junit.Assert.assertEquals
import org.junit.Test


class FTTDecimalTextTest {

    @Test
    fun `whole values drop the decimal point`() {
        assertEquals("0", FTTDecimalText.oneDecimal(0.0))
        assertEquals("115", FTTDecimalText.oneDecimal(115.0))
        assertEquals("115", FTTDecimalText.oneDecimal(115.001))
    }

    @Test
    fun `fractional values keep one decimal place`() {
        assertEquals("52.5", FTTDecimalText.oneDecimal(52.5))
        assertEquals("2.5", FTTDecimalText.oneDecimal(2.5))
    }

    @Test
    fun `values round to the nearest tenth`() {
        assertEquals("52.5", FTTDecimalText.oneDecimal(52.47))
        assertEquals("52.4", FTTDecimalText.oneDecimal(52.44))
        assertEquals("53", FTTDecimalText.oneDecimal(52.98))
    }

    @Test
    fun `negative values keep their sign`() {
        assertEquals("-2.5", FTTDecimalText.oneDecimal(-2.5))
        assertEquals("-3", FTTDecimalText.oneDecimal(-3.0))
    }
}