/*
 * BiometricOptions.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.platform.biometric

data class BiometricOptions(
    val allowDeviceCredential: Boolean = true,
    val requireConfirmation: Boolean = false,
)
