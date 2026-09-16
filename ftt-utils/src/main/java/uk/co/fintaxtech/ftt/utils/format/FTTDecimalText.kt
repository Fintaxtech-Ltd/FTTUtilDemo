package uk.co.fintaxtech.ftt.utils.format

import kotlin.math.abs
import kotlin.math.roundToInt


/**
 * Numbers rendered for entry fields, where a trailing `.0` is noise.
 *
 * Three screens carried this arithmetic — the workout logger as a private helper, the
 * planner and the session detail inlined into their weight formatters — which is how the
 * planner ended up rounding identically to the logger by coincidence rather than by
 * contract.
 *
 * Deliberately locale-free: the decimal separator is always `.`, because these strings go
 * into number-pad fields whose input is parsed back with [String.toDouble]. A locale-aware
 * `,` would round-trip to nothing. Grouped, human-facing numbers are a different job — see
 * `LocalizedNumber` in this module's Android source set.
 */
public object FTTDecimalText {

    /**
     * `"52.5"`, or `"115"` when the value is whole.
     *
     * Rounds to one decimal place first, so `52.47` reads as `52.5` rather than showing a
     * precision the field cannot accept.
     */
    public fun oneDecimal(value: Double): String {
        val rounded = (value * SCALE).roundToInt() / SCALE
        return if (abs(rounded % 1.0) < WHOLE_TOLERANCE) {
            rounded.toInt().toString()
        } else {
            rounded.toString()
        }
    }

    private const val SCALE = 10.0

    /**
     * How close to whole counts as whole. Generous rather than exact because the value has
     * already been rounded to a tenth, so nothing legitimate lands between this and zero.
     */
    private const val WHOLE_TOLERANCE = 0.05
}
