import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.BOOLEAN
import plugins.kommonsVersions.model.android
import plugins.kommonsVersions.model.ios

// build.gradle - sharedUi
// Copyright (c) 2026. All rights reserved
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.kotlinx.serialization)
    alias(libs.plugins.buildKonfig)
    alias(libs.plugins.common.version)
}

kotlin {

    jvmToolchain(jdkVersion = 21)

    // Config for devices ios
    listOf(
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "SharedUI"
            isStatic = false
            export(dependency = project(":sharedLogic"))
        }
    }

    android {
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
        // SharedUI module
        // Android
        androidMain.dependencies {
            implementation(dependencyNotation = project.dependencies.platform(libs.firebase.bom))
            // Libs
            implementation(dependencyNotation = libs.bundles.sharedUI.android.libs)
        }
        commonMain.dependencies {
            // Es api para que se pueda exportar a iOS
            api(dependencyNotation = project(":sharedLogic"))
            // Bundle
            implementation(dependencyNotation = libs.bundles.sharedUI.commons.libs)
        }
        // Ios
        iosMain.dependencies {}
        // SharedUI test
        commonTest.dependencies {
            implementation(dependencyNotation = libs.bundles.sharedUI.commonsTest.libs)
        }
    }
}

buildkonfig {
    packageName = "${libs.versions.app.packg.name.get()}.sharedUI"

    // Debug configs
    defaultConfigs {
        buildConfigField(type = BOOLEAN, name = "IS_DEBUG", value = "true")
    }
    // Release configs
    defaultConfigs(flavor = "release") {
        buildConfigField(type = BOOLEAN, name = "IS_DEBUG", value = "false")
    }
    targetConfigs {
        create("android")
    }
}

kommonVersions {
    generateFileVersions = true

    android {
        namespace   = "${libs.versions.app.packg.name.get()}.sharedUI"
        versionCode = libs.versions.app.version.code.get().toInt()
        versionName = libs.versions.app.version.name.get()
    }

    ios {
        projectFolderName = "iosApp"
        appName = "KmpIos"
        bundleId = libs.versions.app.packg.name.get()
        marketingVersion = libs.versions.app.version.name.get()
        currentVersion = libs.versions.app.version.code.get()
        // Los valores no importan tanto aquí porque sharedLogic no configura Xcode
    }
}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}
