/*
 * ConfigureAndroidApplication.kt
 * Copyright (c) 2026. All rights reserved
 */
package plugins.kommonsVersions.extensions

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import com.android.build.api.dsl.KotlinMultiplatformAndroidLibraryExtension
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import plugins.kommonsVersions.model.AndroidConfig

/**
 * Configura las propiedades de Android de forma inmediata al leer el DSL.
 *
 * Se evita el uso de 'afterEvaluate' para el 'namespace' porque AGP 8.0+
 * bloquea esta propiedad muy temprano en el ciclo de vida del build.
 */
fun Project.configureAndroidImmediately(config: AndroidConfig) {

    // Configuración para el módulo ejecutable (androidApp)
    pluginManager.withPlugin("com.android.application") {
        extensions.configure<ApplicationExtension> {
            namespace = config.namespace

            defaultConfig {
                versionCode = config.versionCode
                versionName = config.versionName
            }

            // 1. PRIMERO las dimensiones (Crucial)
            if (config.flavorDimensions.isNotEmpty()) {
                flavorDimensions.clear() // Limpiamos para evitar duplicados
                flavorDimensions.addAll(config.flavorDimensions)
            }

            // 2. SEGUNDO los flavors
            productFlavors {
                config.flavors.forEach { f ->
                    // Usamos create para forzar la aparición en Build Variants
                    create(f.name) {
                        dimension = f.dimension
                        applicationIdSuffix = f.applicationIdSuffix
                        versionNameSuffix = f.versionNameSuffix
                        f.appName?.let { manifestPlaceholders["app_name"] = it }
                        f.appNameSuffix?.let { manifestPlaceholders["app_name_suffix"] = it }
                    }
                }
            }
        }
    }

    // Configuración para módulos de librería KMP (ej. sharedUI, sharedLogic)
    // El plugin 'androidMultiplatformLibrary' registra su config dentro de la extensión 'kotlin'
    pluginManager.withPlugin("com.android.kotlin.multiplatform.library") {
        // En este plugin, 'android' es una extensión hija de 'kotlin'
        extensions.configure<KotlinMultiplatformExtension>("kotlin") {
            (this as ExtensionAware).extensions.configure<KotlinMultiplatformAndroidLibraryExtension>("android") {
                namespace = config.namespace
            }
        }
    }
}
