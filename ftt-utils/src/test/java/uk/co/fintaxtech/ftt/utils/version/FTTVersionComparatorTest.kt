package uk.co.fintaxtech.ftt.utils.version

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class FTTVersionComparatorTest {

    @Test
    fun isLatestAndUpdated_appVersionHigherThanLatest_returnsTrue() {
        val appVersion = FTTVersionObject(2, 0, 0)
        val latestVersion = FTTVersionObject(1, 9, 9)
        assertTrue(FTTVersionComparator.isLatestAndUpdated(appVersion, latestVersion))
    }

    @Test
    fun isLatestAndUpdated_appVersionEqualToLatest_returnsTrue() {
        val appVersion = FTTVersionObject(1, 2, 3)
        val latestVersion = FTTVersionObject(1, 2, 3)
        assertTrue(FTTVersionComparator.isLatestAndUpdated(appVersion, latestVersion))
    }

    @Test
    fun isLatestAndUpdated_appVersionLowerThanLatest_returnsFalse() {
        val appVersion = FTTVersionObject(1, 1, 0)
        val latestVersion = FTTVersionObject(1, 2, 0)
        assertFalse(FTTVersionComparator.isLatestAndUpdated(appVersion, latestVersion))
    }

    @Test
    fun toFTTVersionObject_simpleVersion_parsesCorrectly() {
        val version = "1.2.3".toFTTVersionObject()
        assertEquals(1, version.major)
        assertEquals(2, version.minor)
        assertEquals(3, version.patch)
        assertEquals(null, version.preRelease)
    }

    @Test
    fun toFTTVersionObject_withPreRelease_parsesCorrectly() {
        val version = "1.0.1-RC1".toFTTVersionObject()
        assertEquals(1, version.major)
        assertEquals(0, version.minor)
        assertEquals(1, version.patch)
        assertEquals("RC1", version.preRelease)
    }

    @Test
    fun toFTTVersionObject_shortVersion_defaultsMissingParts() {
        val version = "2.1".toFTTVersionObject()
        assertEquals(2, version.major)
        assertEquals(1, version.minor)
        assertEquals(0, version.patch)
    }

    @Test
    fun compareTo_preReleaseIsLowerThanFinal_returnsExpectedResult() {
        val preRelease = "1.0.0-RC1".toFTTVersionObject()
        val finalRelease = "1.0.0".toFTTVersionObject()
        
        assertTrue(preRelease < finalRelease)
        assertFalse(FTTVersionComparator.isLatestAndUpdated(preRelease, finalRelease))
    }

    @Test
    fun isLatestAndUpdated_differentPreReleases_comparesLexicographically() {
        val rc1 = "1.0.0-RC1".toFTTVersionObject()
        val rc2 = "1.0.0-RC2".toFTTVersionObject()
        
        assertTrue(rc2 > rc1)
        assertTrue(FTTVersionComparator.isLatestAndUpdated(rc2, rc1))
    }
}
