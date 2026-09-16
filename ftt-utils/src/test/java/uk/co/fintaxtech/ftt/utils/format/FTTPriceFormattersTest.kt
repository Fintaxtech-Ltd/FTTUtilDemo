package uk.co.fintaxtech.ftt.utils.format

import java.util.Locale
import org.junit.Assert.assertEquals
import org.junit.Test

class FTTPriceFormattersTest {

    @Test
    fun formatMonthlyEquivalentPrice_annualStoreMetadata_roundsHalfUp() {
        val monthlyPrice = formatMonthlyEquivalentPrice(
            annualPriceAmountMicros = 29_990_000L,
            currencyCode = "GBP",
            locale = Locale.UK
        )

        assertEquals("£2.50", monthlyPrice)
    }
}
