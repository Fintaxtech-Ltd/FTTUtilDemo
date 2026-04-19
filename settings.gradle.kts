import java.util.Properties
import java.io.FileInputStream

// 1. Load the properties file
val localProperties = Properties()
val localPropertiesFile = File(rootProject.projectDir, "local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(FileInputStream(localPropertiesFile))
}
pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/Fintaxtech-Ltd/FTTUtilDemo")
            credentials {
                // You need a GitHub PAT with 'read:packages' scope
                username = localProperties.getProperty("gpr.usr") ?: System.getenv("GPR_USER")
                password = localProperties.getProperty("gpr.key") ?: System.getenv("PERSONAL_ACCESS_TOKEN")
            }
        }
    }
}

rootProject.name = "FTT Util Demo"
include(":app")
include(":ftt-utils")
