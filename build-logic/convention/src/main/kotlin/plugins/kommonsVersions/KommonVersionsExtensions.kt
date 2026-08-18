/*
 * KommonVersionsExtensions.kt
 * Copyright (c) 2026. All rights reserved
 */
package plugins.kommonsVersions

import org.gradle.api.Project
import org.gradle.api.model.ObjectFactory
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Internal
import plugins.kommonsVersions.model.AndroidConfig
import plugins.kommonsVersions.model.IosConfig
import javax.inject.Inject

/**
 * Clase que define el bloque 'kommonVersions { ... }' en los archivos build.gradle.kts.
 */
abstract class KommonVersionsExtension @Inject constructor(
    objects: ObjectFactory,
    @get:Internal internal val project: Project,
) {
    /** Determina si este módulo debe generar los archivos físicos de constantes .kt */
    val generateFileVersions: Property<Boolean> = objects.property(Boolean::class.java)
    val ios: Property<IosConfig> = objects.property(IosConfig::class.java)
    val android: Property<AndroidConfig> = objects.property(AndroidConfig::class.java)
}
