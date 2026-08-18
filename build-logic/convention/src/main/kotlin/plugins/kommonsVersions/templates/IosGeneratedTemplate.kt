/*
 * IosGeneratedTemplate.kt
 * Copyright (c) 2026. All rights reserved
 */
package plugins.kommonsVersions.templates

val iosGeneratedTemplate = """
    /*
     * KommonVersions.ios.kt
     * Copyright (c) 2026. All rights reserved
     */
    package com.kommon.versions
    
    import platform.Foundation.NSBundle
    import platform.posix.gets
    import kotlin.experimental.ExperimentalNativeApi
    import com.software.inventario.utils.enums.BuildTypes

    @OptIn(ExperimentalNativeApi::class)
    actual object KommonVersions {

        private const val BUNDLE_IDENTIFIER = "CFBundleIdentifier"
        private const val CF_BUNDLE_VERSION_STRING = "CFBundleShortVersionString"
        private const val CF_BUNDLE_CODE = "CFBundleVersion"

        private val bundleMap = NSBundle.mainBundle.infoDictionary
        private fun getString(
            key: String,
            default: String = "",
        ): String = (bundleMap?.get(key) as? String) ?: default

        val isDebug = Platform.isDebugBinary

        actual val APPLICATION_ID   = getString(BUNDLE_IDENTIFIER)
        actual val BUILD_TYPE       = if(isDebug) BuildTypes.DEBUG else BuildTypes.RELEASE
        actual val VERSION_CODE     = getString(CF_BUNDLE_CODE).toIntOrNull() ?: 1
        actual val VERSION_NAME     = getString(CF_BUNDLE_VERSION_STRING)
    }

""".trimIndent()
