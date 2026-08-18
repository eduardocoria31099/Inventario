plugins {
    id("inventario.kmp.library")
    id("inventario.kmp.compose")
}

kotlin {
    // The framework the iOS app links against. Keeps the name `Shared` so
    // iosApp/ContentView.swift can keep doing `import Shared`.
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    sourceSets.commonMain.dependencies {
        implementation(project(":sharedLogic"))
    }
}

compose.resources {
    // Pin the generated Res class package so it does not follow the module name.
    packageOfResClass = "com.software.inventario.resources"
}
