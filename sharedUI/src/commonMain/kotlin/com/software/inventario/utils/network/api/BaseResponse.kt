/*
 * BaseResponse.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.utils.network.api

import kotlinx.serialization.Serializable

@Serializable
open class BaseResponse(
    val success: Boolean? = false,
    val message: String? = "",
)
