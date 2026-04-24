package uk.co.fintaxtech.ftt.utils.validation

import java.util.regex.Pattern

/**
 * Utility for validating registration form fields.
 */
object RegistrationValidator {

    /**
     * Validates if the username is valid.
     * Rules: 3-20 characters, alphanumeric and underscores only.
     */
    fun isValidUsername(username: String?): Boolean {
        if (username.isNullOrBlank()) return false
        val usernamePattern = "^[a-zA-Z0-9_]{3,20}$"
        return Pattern.compile(usernamePattern).matcher(username).matches()
    }

    /**
     * Validates if the email address is valid.
     */
    fun isValidEmail(email: String?): Boolean {
        if (email.isNullOrBlank()) return false
        val emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"
        return Pattern.compile(emailPattern).matcher(email).matches()
    }

    /**
     * Validates if the password is strong enough.
     * Rules: Minimum 8 characters, at least one uppercase letter, one lowercase letter, and one digit.
     */
    fun isStrongPassword(password: String?): Boolean {
        if (password.isNullOrBlank()) return false
        val hasUpperCase = password.any { it.isUpperCase() }
        val hasLowerCase = password.any { it.isLowerCase() }
        val hasDigit = password.any { it.isDigit() }
        val isLongEnough = password.length >= 8
        return hasUpperCase && hasLowerCase && hasDigit && isLongEnough
    }

    /**
     * Validates if the phone number is valid (simple numeric check).
     * Rules: 10-15 digits.
     */
    fun isValidPhone(phone: String?): Boolean {
        if (phone.isNullOrBlank()) return false
        val phonePattern = "^[0-9]{10,15}$"
        return Pattern.compile(phonePattern).matcher(phone).matches()
    }

    /**
     * Validates if a field is not empty or blank.
     */
    fun isNotEmpty(value: String?): Boolean {
        return !value.isNullOrBlank()
    }
}
