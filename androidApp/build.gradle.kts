import org.gradle.kotlin.dsl.kommonVersions
import plugins.kommonsVersions.model.android
import plugins.kommonsVersions.model.ios
import plugins.kommonsVersions.model.schema

// build.gradle - androidApp
// Copyright (c) 2026. All rights reserved
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.firebase.crashlytics)
    alias(libs.plugins.common.version)
    // Estos plugins se configuran por flavor por lo cual solo se cargan al classpath pero no se implementan
    alias(libs.plugins.google.services) apply false
}

/** Se configura plugin GMS **/
val taskNames = gradle.startParameter.taskNames.joinToString(",")
logger.lifecycle("*******************************************")
logger.lifecycle("Task executed: $taskNames")
if (taskNames.contains("Gms", ignoreCase = true)) {
    logger.lifecycle("DEBUG: Apply plugin -> GOOGLE SERVICES")
    apply(plugin = libs.plugins.google.services.get().pluginId)
}
logger.lifecycle("*******************************************")

kotlin {
    jvmToolchain(jdkVersion = 21)
}

android {

    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = libs.versions.app.packg.name.get()
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

kommonVersions {
    generateFileVersions.set(false)

    android {
        namespace   = libs.versions.app.packg.name.get()
        versionCode = libs.versions.app.version.code.get().toInt()
        versionName = libs.versions.app.version.name.get()

        flavorDimensions += "version"

        flavor {
            name = "gms"
            dimension = "version"
            appName = "Software inventario"
        }
    }

    ios {
        projectFolderName = "iosApp"
        appName = "KmpIos"
        bundleId = libs.versions.app.packg.name.get()
        marketingVersion = libs.versions.app.version.name.get()
        currentVersion = libs.versions.app.version.code.get()

        schemas += schema {
            name = "development" // Debe coincidir con el nombre en Xcode
            nameSuffix = " Dev"  // Ej: "KmpIos Dev"
            bundleSuffix = "dev" // Ej: "com.kmp.dev"
        }
    }
}

dependencies {
    // Modules
    implementation(project(":sharedUI"))
    implementation(project(":sharedLogic"))
    // Bundle
    implementation(platform(libs.firebase.bom))
    // Libs
    implementation(libs.bundles.androidApp.libs)
    // Debug
    debugImplementation(libs.compose.uiTooling)
}
