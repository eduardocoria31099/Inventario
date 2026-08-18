plugins {
    `kotlin-dsl`
}

group = "com.software.inventario.buildlogic"

dependencies {
    // Put the Gradle plugins on the compile classpath so the precompiled script
    // plugins in src/main/kotlin can apply and configure them.
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.compose.gradlePlugin)
    implementation(libs.composeCompiler.gradlePlugin)
}
