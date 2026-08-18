/*
 * BiometricAvailability.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.platform.biometric

sealed interface BiometricAvailability {
    data object Available: BiometricAvailability
    data object NoHardware: BiometricAvailability
    data object NotEnrolled: BiometricAvailability
    data object TemporarilyUnavailable: BiometricAvailability
    data object Unknown: BiometricAvailability
}
