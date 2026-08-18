/**
 * Adds Compose Multiplatform on top of [inventario.kmp.library].
 * Only UI modules apply this, so pure-logic modules never see Compose on their classpath.
 */
plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("com.android.kotlin.multiplatform.library")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

fun lib(alias: String) = libs.findLibrary(alias).get()

kotlin {
    sourceSets.commonMain.dependencies {
        implementation(lib("compose-runtime"))
        implementation(lib("compose-foundation"))
        implementation(lib("compose-material3"))
        implementation(lib("compose-ui"))
        implementation(lib("compose-components-resources"))
        implementation(lib("compose-uiToolingPreview"))
        implementation(lib("androidx-lifecycle-viewmodelCompose"))
        implementation(lib("androidx-lifecycle-runtimeCompose"))
    }
    sourceSets.androidMain.dependencies {
        implementation(lib("compose-uiToolingPreview"))
        implementation(lib("compose-uiTooling"))
    }
}

dependencies {
    "androidRuntimeClasspath"(lib("compose-uiTooling"))
}
