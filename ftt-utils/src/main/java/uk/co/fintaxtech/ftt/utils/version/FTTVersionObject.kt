package uk.co.fintaxtech.ftt.utils.version

/**
 * Data class representing a version with major, minor, and patch components,
 * and an optional pre-release tag (e.g., "RC1").
 */
data class FTTVersionObject(
    val major: Int,
    val minor: Int,
    val patch: Int,
    val preRelease: String? = null
) : Comparable<FTTVersionObject> {

    override fun compareTo(other: FTTVersionObject): Int {
        if (this.major != other.major) return this.major.compareTo(other.major)
        if (this.minor != other.minor) return this.minor.compareTo(other.minor)
        if (this.patch != other.patch) return this.patch.compareTo(other.patch)

        // Semantic versioning: a version with a pre-release tag is lower than the same version without one.
        // e.g., 1.0.0-RC1 < 1.0.0
        return when {
            this.preRelease == other.preRelease -> 0
            this.preRelease == null -> 1
            other.preRelease == null -> -1
            else -> this.preRelease.compareTo(other.preRelease)
        }
    }
}

/**
 * Converts a string to an [FTTVersionObject].
 * Expected formats: "1.0.0", "1.0.1-RC1", "2.1".
 * Missing components default to 0.
 */
fun String.toFTTVersionObject(): FTTVersionObject {
    val parts = this.split("-", limit = 2)
    val versionNumbers = parts[0].split(".")
    
    val major = versionNumbers.getOrNull(0)?.toIntOrNull() ?: 0
    val minor = versionNumbers.getOrNull(1)?.toIntOrNull() ?: 0
    val patch = versionNumbers.getOrNull(2)?.toIntOrNull() ?: 0
    val preRelease = parts.getOrNull(1)

    return FTTVersionObject(major, minor, patch, preRelease)
}
