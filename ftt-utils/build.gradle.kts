import java.util.Properties
import java.io.FileInputStream
plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    namespace = "uk.co.fintaxtech.ftt.utils"
    compileSdk = 36

    defaultConfig {
        minSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    testImplementation(libs.junit.jupiter)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

afterEvaluate {
    publishing {
        publications {
            register<MavenPublication>("release") {
                from(components["release"])

                groupId = "uk.co.fintaxtech"
                artifactId = "ftt-utils"
                version = "0.0.2"
            }
        }
        repositories {
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/Fintaxtech-Ltd/FTTUtilDemo")
                credentials {
                    // This reads from your local.properties or System Env
                    val localProperties = Properties()
                    val localPropertiesFile = rootProject.file("local.properties")
                    if (localPropertiesFile.exists()) {
                        localProperties.load(localPropertiesFile.inputStream())
                    }

                    username = localProperties.getProperty("gpr.usr") ?: System.getenv("GPR_USER")
                    password = localProperties.getProperty("gpr.key") ?: System.getenv("PERSONAL_ACCESS_TOKEN")
                }
            }
        }
    }
} // :ftt-utils:publishAllPublicationsToGitHubPackagesRepository