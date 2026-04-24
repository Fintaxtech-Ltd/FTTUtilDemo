package uk.co.fintaxtech.ftt.utils.version

/**
 * Utility for comparing versions.
 */
object VersionComparator {

    /**
     * Checks if the current app version is the latest or newer.
     *
     * @param appVersion The current version of the application.
     * @param latestVersion The latest available version.
     * @return true if the app version is equal to or greater than the latest version.
     */
    fun isLatestAndUpdated(appVersion: FTTVersionObject, latestVersion: FTTVersionObject): Boolean {
        return appVersion >= latestVersion
    }
}
