package uk.co.fintaxtech.ftt.utils.money

import java.math.BigDecimal
import java.math.RoundingMode

private const val CURRENCY_CODE_LENGTH = 3

/**
 * Represents currency using minor units so persisted and calculated values never use floating point.
 */
data class FTTMoney(
    val minorUnits: Long,
    val currencyCode: String
) {
    init {
        require(currencyCode.length == CURRENCY_CODE_LENGTH) {
            "Currency code must contain three characters"
        }
    }

    operator fun plus(other: FTTMoney): FTTMoney {
        requireSameCurrency(other)
        return copy(minorUnits = Math.addExact(minorUnits, other.minorUnits))
    }

    operator fun minus(other: FTTMoney): FTTMoney {
        requireSameCurrency(other)
        return copy(minorUnits = Math.subtractExact(minorUnits, other.minorUnits))
    }

    fun multiply(quantity: BigDecimal): FTTMoney {
        require(quantity >= BigDecimal.ZERO) { "Quantity cannot be negative" }
        val result = BigDecimal.valueOf(minorUnits)
            .multiply(quantity)
            .setScale(0, RoundingMode.HALF_UP)
            .longValueExact()
        return copy(minorUnits = result)
    }

    /** Applies a rate expressed as a multiplier, e.g. 0.2 for a 20% rate. */
    fun applyRate(multiplier: BigDecimal): FTTMoney {
        val result = BigDecimal.valueOf(minorUnits)
            .multiply(multiplier)
            .setScale(0, RoundingMode.HALF_UP)
            .longValueExact()
        return copy(minorUnits = result)
    }

    private fun requireSameCurrency(other: FTTMoney) {
        require(currencyCode == other.currencyCode) { "Currency codes must match" }
    }

    companion object {
        fun zero(currencyCode: String): FTTMoney = FTTMoney(
            minorUnits = 0L,
            currencyCode = currencyCode
        )
    }
}
