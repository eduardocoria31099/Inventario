/*
 * BiometricResult.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.platform.biometric

sealed interface BiometricResult {
    data object Success : BiometricResult
    sealed interface Failure : BiometricResult {
        data object Cancelled: Failure
        data object Lockout: Failure
        data class Error(val message: String): Failure
    }
}
