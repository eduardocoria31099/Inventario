import org.jetbrains.kotlin.gradle.dsl.JvmTarget

/**
 * Base convention for a Kotlin Multiplatform library module targeting Android and iOS.
 * Holds everything that every shared module repeats: SDK levels, JVM target, test wiring
 * and the list of iOS targets.
 */
plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun version(alias: String): String = libs.findVersion(alias).get().requiredVersion

kotlin {
    android {
        namespace = "com.software.inventario." + project.name.lowercase()
        compileSdk = version("android-compileSdk").toInt()
        minSdk = version("android-minSdk").toInt()

        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
        androidResources {
            enable = true
        }
        withHostTest {
            isIncludeAndroidResources = true
        }
        withDeviceTestBuilder {
            sourceSetTreeName = "test"
        }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    iosArm64()
    iosSimulatorArm64()

    sourceSets.commonTest.dependencies {
        implementation(libs.findLibrary("kotlin-test").get())
    }
}
