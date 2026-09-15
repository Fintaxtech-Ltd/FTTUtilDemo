package uk.co.fintaxtech.ftt.utils.format

import java.time.ZoneId
import java.util.Locale
import org.junit.Assert.assertEquals
import org.junit.Test

class FTTDisplayFormattersTest {

    @Test
    fun formatCurrencyMinorUnits_gbpMinorUnits_ukLocale_returnsLocaleCorrectCurrency() {
        assertEquals(
            "£1,420.00",
            formatCurrencyMinorUnits(
                minorUnits = 142_000L,
                currencyCode = "GBP",
                locale = Locale.UK
            )
        )
    }

    @Test
    fun formatLocalDate_givenEpoch_localeAndZoneDetermineResult() {
        assertEquals(
            "2 Sept 2026",
            formatLocalDate(
                epochMillis = 1_788_304_400_000L,
                locale = Locale.UK,
                zoneId = ZoneId.of("Europe/London")
            )
        )
    }
}
