package uk.co.fintaxtech.ftt.utils.validation

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class FTTRegistrationValidatorTest {

    @Test
    fun isValidUsername_validUsername_returnsTrue() {
        assertTrue(FTTRegistrationValidator.isValidUsername("user_name123"))
    }

    @Test
    fun isValidEmail_validEmail_returnsTrue() {
        assertTrue(FTTRegistrationValidator.isValidEmail("test@example.com"))
    }

    @Test
    fun isStrongPassword_validStrongPassword_returnsTrue() {
        assertTrue(FTTRegistrationValidator.isStrongPassword("Password123"))
    }

    @Test
    fun isValidPhone_validPhone_returnsTrue() {
        assertTrue(FTTRegistrationValidator.isValidPhone("1234567890"))
    }

    @Test
    fun isNotEmpty_blank_returnsFalse() {
        assertFalse(FTTRegistrationValidator.isNotEmpty("   "))
    }
}
