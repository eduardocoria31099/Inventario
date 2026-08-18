/*
 * KommonVersions.common.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.kommon.versions

import com.software.inventario.utils.enums.BuildTypes

expect object KommonVersions {
    val APPLICATION_ID: String
    val BUILD_TYPE: BuildTypes
    val VERSION_CODE: Int
    val VERSION_NAME: String
}
