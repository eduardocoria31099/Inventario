/*
 * BiometricStatus.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.platform.biometric

data class BiometricStatus(
    val availability: BiometricAvailability,
    val type: BiometricType,
    val supportsDeviceCredential: Boolean,
)
