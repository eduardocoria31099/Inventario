/*
 * BiometricProvider.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.platform.biometric

interface BiometricProvider {
    suspend fun status(): BiometricStatus
    suspend fun authenticate(
        prompt: BiometricPrompt,
        options: BiometricOptions,
    ): BiometricResult
}

expect fun getBiometricProvider(): BiometricProvider
