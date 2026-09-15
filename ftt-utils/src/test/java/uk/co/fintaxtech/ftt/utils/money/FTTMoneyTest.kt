package uk.co.fintaxtech.ftt.utils.money

import java.math.BigDecimal
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class FTTMoneyTest {

    @Test
    fun plus_sameCurrency_addsMinorUnits() {
        val total = FTTMoney(1_000L, "GBP") + FTTMoney(500L, "GBP")

        assertEquals(1_500L, total.minorUnits)
    }

    @Test
    fun plus_differentCurrency_throws() {
        assertThrows(IllegalArgumentException::class.java) {
            FTTMoney(1_000L, "GBP") + FTTMoney(500L, "USD")
        }
    }

    @Test
    fun minus_sameCurrency_subtractsMinorUnits() {
        val remaining = FTTMoney(1_000L, "GBP") - FTTMoney(400L, "GBP")

        assertEquals(600L, remaining.minorUnits)
    }

    @Test
    fun multiply_byQuantity_roundsHalfUp() {
        val result = FTTMoney(333L, "GBP").multiply(BigDecimal("1.5"))

        assertEquals(500L, result.minorUnits)
    }

    @Test
    fun multiply_negativeQuantity_throws() {
        assertThrows(IllegalArgumentException::class.java) {
            FTTMoney(1_000L, "GBP").multiply(BigDecimal("-1"))
        }
    }

    @Test
    fun applyRate_withMultiplier_roundsHalfUp() {
        val tax = FTTMoney(999L, "GBP").applyRate(BigDecimal("0.2"))

        assertEquals(200L, tax.minorUnits)
    }

    @Test
    fun zero_givenCurrencyCode_returnsZeroMinorUnits() {
        val zero = FTTMoney.zero("GBP")

        assertEquals(0L, zero.minorUnits)
        assertEquals("GBP", zero.currencyCode)
    }

    @Test
    fun constructor_invalidCurrencyCodeLength_throws() {
        assertThrows(IllegalArgumentException::class.java) {
            FTTMoney(0L, "GB")
        }
    }
}
