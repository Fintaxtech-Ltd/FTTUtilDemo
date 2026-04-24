package uk.co.fintaxtech.ftt.utils.validation

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class RegistrationValidatorTest {

    @Test
    fun isValidUsername_validUsername_returnsTrue() {
        assertTrue(RegistrationValidator.isValidUsername("user_name123"))
    }

    @Test
    fun isValidUsername_tooShort_returnsFalse() {
        assertFalse(RegistrationValidator.isValidUsername("ab"))
    }

    @Test
    fun isValidUsername_invalidCharacters_returnsFalse() {
        assertFalse(RegistrationValidator.isValidUsername("user!name"))
    }

    @Test
    fun isValidEmail_validEmail_returnsTrue() {
        assertTrue(RegistrationValidator.isValidEmail("test@example.com"))
    }

    @Test
    fun isValidEmail_noAtSymbol_returnsFalse() {
        assertFalse(RegistrationValidator.isValidEmail("testexample.com"))
    }

    @Test
    fun isValidEmail_noDomain_returnsFalse() {
        assertFalse(RegistrationValidator.isValidEmail("test@"))
    }

    @Test
    fun isStrongPassword_validStrongPassword_returnsTrue() {
        assertTrue(RegistrationValidator.isStrongPassword("Password123"))
    }

    @Test
    fun isStrongPassword_tooShort_returnsFalse() {
        assertFalse(RegistrationValidator.isStrongPassword("P123"))
    }

    @Test
    fun isStrongPassword_noDigit_returnsFalse() {
        assertFalse(RegistrationValidator.isStrongPassword("OnlyLetters"))
    }

    @Test
    fun isValidPhone_validPhone_returnsTrue() {
        assertTrue(RegistrationValidator.isValidPhone("1234567890"))
    }

    @Test
    fun isValidPhone_containsLetters_returnsFalse() {
        assertFalse(RegistrationValidator.isValidPhone("12345abcde"))
    }

    @Test
    fun isNotEmpty_notEmpty_returnsTrue() {
        assertTrue(RegistrationValidator.isNotEmpty("Content"))
    }

    @Test
    fun isNotEmpty_blank_returnsFalse() {
        assertFalse(RegistrationValidator.isNotEmpty("   "))
    }
}
