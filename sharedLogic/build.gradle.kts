// build.gradle - sharedLogic
// Copyright (c) 2026. All rights reserved
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.BOOLEAN

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.androidx.room)
    alias(libs.plugins.buildKonfig)
}

kotlin {

    jvmToolchain(jdkVersion = 21)

    // Config for devices ios
    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "SharedLogic"
            isStatic = false
            linkerOpts.add("-lsqlite3")
        }
    }

    android {
        namespace = "${libs.versions.app.packg.name.get()}.sharedLogic"
        compileSdk = libs.versions.android.compileSdk.get().toInt()
        minSdk = libs.versions.android.minSdk.get().toInt()

        androidResources {
            enable = true
        }
        withHostTest {
            isIncludeAndroidResources = true
        }
    }

    sourceSets {
        // SharedLogic Module
        // Android
        androidMain.dependencies {
            // Bundle
            implementation(dependencyNotation = project.dependencies.platform(libs.firebase.bom))
            // Libs
            implementation(dependencyNotation = libs.bundles.sharedLogic.android.libs)
        }
        commonMain.dependencies {
            // Bundle
            api(dependencyNotation = libs.bundles.sharedLogic.commons.libs)
        }
        // iOS
        iosMain.dependencies {
            // Module
            // implementation(projects.utils)
            // Bundle
            implementation(dependencyNotation = libs.bundles.sharedLogic.ios.libs)
        }
        // SharedLogic test
        commonTest.dependencies {
            implementation(dependencyNotation = libs.bundles.sharedLogic.commonsTest.libs)
        }
    }
}

buildkonfig {
    packageName = "${libs.versions.app.packg.name.get()}.sharedLogic"

    // Debug configs
    defaultConfigs {
        buildConfigField(type = BOOLEAN, name = "IS_DEBUG", value = "true")
    }
    // Release configs
    defaultConfigs(flavor = "release") {
        buildConfigField(type = BOOLEAN, name = "IS_DEBUG", value = "false")
    }
    // Config value by type
    targetConfigs {
        create("android") {
            buildConfigField(type = BOOLEAN, name = "IS_ANDROID", value = "true")
        }
        listOf("iosArm64", "iosSimulatorArm64").forEach { targetName ->
            create(targetName) {
                buildConfigField(type = BOOLEAN, name = "IS_IOS", value = "true")
            }
        }
    }
}

dependencies {
    add(configurationName = "kspCommonMainMetadata", dependencyNotation = libs.androidx.room.compiler)
    add(configurationName = "kspIosArm64", dependencyNotation = libs.androidx.room.compiler)
    add(configurationName = "kspIosSimulatorArm64", dependencyNotation = libs.androidx.room.compiler)
    add(configurationName = "kspAndroid", dependencyNotation = libs.androidx.room.compiler)
}

room {
    schemaDirectory(path = "$projectDir/schemas")
}
