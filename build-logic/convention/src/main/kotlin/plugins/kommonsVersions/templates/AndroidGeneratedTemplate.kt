/*
 * AndroidGeneratedTemplate.kt
 * Copyright (c) 2026. All rights reserved
 */
package plugins.kommonsVersions.templates

fun getAndroidGeneratedTemplate(
    applicationId: String,
    versionCode: Int,
    versionName: String,
) = """
    /*
     * KommonVersions.android.kt
     * Copyright (c) 2026. All rights reserved
     */
    package com.kommon.versions
    
    import com.software.inventario.sharedUI.BuildKonfig
    import com.software.inventario.utils.enums.BuildTypes
    
    actual object KommonVersions {
        actual val APPLICATION_ID: String = "$applicationId"
        actual val BUILD_TYPE: BuildTypes = if(BuildKonfig.IS_DEBUG) BuildTypes.DEBUG else BuildTypes.RELEASE 
        actual val VERSION_CODE: Int      = $versionCode
        actual val VERSION_NAME: String   = "$versionName"
    }
""".trimIndent()
