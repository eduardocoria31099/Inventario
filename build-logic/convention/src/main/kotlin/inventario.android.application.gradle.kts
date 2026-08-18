/**
 * Convention for the Android application module: SDK levels, Java/Kotlin target
 * and the Compose compiler.
 */
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun version(alias: String): String = libs.findVersion(alias).get().requiredVersion

android {
    compileSdk = version("android-compileSdk").toInt()

    defaultConfig {
        minSdk = version("android-minSdk").toInt()
        targetSdk = version("android-targetSdk").toInt()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
}
