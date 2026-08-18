/*
 * AndroidConfig.kt
 * Copyright (c) 2026. All rights reserved
 */
package plugins.kommonsVersions.model

import plugins.kommonsVersions.KommonVersionsExtension
import plugins.kommonsVersions.extensions.configureAndroidImmediately

data class AndroidConfig(
    val namespace: String,
    val flavorDimensions: List<String>,
    val versionName: String,
    val versionCode: Int,
    val flavors: List<FlavorConfig>,
)

data class FlavorConfig(
    val name: String,
    val dimension: String,
    val applicationIdSuffix: String,
    val versionNameSuffix: String,
    val appName: String? = null,
    val appNameSuffix: String? = null,
)

class AndroidConfigBuilder {
    var namespace: String = ""
    var flavorDimensions: MutableList<String> = mutableListOf()
    var versionName: String = ""
    var versionCode: Int = 0
    val flavors: MutableList<FlavorConfig> = mutableListOf()

    // Función que añade el flavor a la lista automáticamente
    fun flavor(block: FlavorConfigBuilder.() -> Unit) {
        val builder = FlavorConfigBuilder().apply(block)
        flavors.add(
            FlavorConfig(
                name = builder.name,
                dimension = builder.dimension,
                applicationIdSuffix = builder.applicationIdSuffix,
                versionNameSuffix = builder.versionNameSuffix,
                appName = builder.appName,
                appNameSuffix = builder.appNameSuffix,
            )
        )
    }
}

class FlavorConfigBuilder {
    var name: String = ""
    var dimension: String = ""
    var applicationIdSuffix: String = ""
    var versionNameSuffix: String = ""
    var appName: String? = null
    var appNameSuffix: String? = null
}

fun KommonVersionsExtension.android(
    block: AndroidConfigBuilder.() -> Unit,
): AndroidConfig {
    val builder = AndroidConfigBuilder().apply(block)
    val config = AndroidConfig(
        namespace = builder.namespace,
        flavorDimensions = builder.flavorDimensions,
        versionName = builder.versionName,
        versionCode = builder.versionCode,
        flavors = builder.flavors,
    )
    // Seteamos la propiedad y configuramos el proyecto
    this.android.set(config)
    this.project.configureAndroidImmediately(config)
    return config
}
