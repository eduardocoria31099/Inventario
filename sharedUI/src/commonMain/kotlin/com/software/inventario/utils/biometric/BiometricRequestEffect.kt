/*
 * BiometricRequestEffect.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.utils.biometric

import com.software.inventario.platform.biometric.BiometricResult
import com.software.inventario.utils.logs.Log

fun biometricRequestEffect(
    biometricResult: BiometricResult,
    onResult: (Boolean) -> Unit = {},
) {
    when (biometricResult) {
        is BiometricResult.Success -> {
            Log.error(message = "Biometric authentication successful")
            onResult(true)
        }
        is BiometricResult.Failure.Cancelled -> {
            Log.error(message = "Biometric authentication was cancelled by the user")
            onResult(false)
        }
        is BiometricResult.Failure.Lockout -> {
            Log.error(message = "Biometric authentication is locked out")
            onResult(false)
        }
        is BiometricResult.Failure.Error -> {
            Log.error(message = "Biometric authentication failed with an unexpected error")
            onResult(false)
        }
    }
}
