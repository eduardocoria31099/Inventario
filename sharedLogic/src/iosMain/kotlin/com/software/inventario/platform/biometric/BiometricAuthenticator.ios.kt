/*
 * BiometricAuthenticator.ios.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.platform.biometric

import kotlinx.cinterop.ExperimentalForeignApi

actual fun getBiometricProvider(): BiometricProvider =
    IOSBiometricAuthenticator()

internal class IOSBiometricAuthenticator(
    private val statusProvider: IOSBiometricStatusProvider = IOSBiometricStatusProvider(),
    private val authenticationProvider: IOSBiometricAuthenticationProvider = IOSBiometricAuthenticationProvider(),
) : BiometricProvider {

    @OptIn(ExperimentalForeignApi::class)
    override suspend fun status(): BiometricStatus {
        return statusProvider.status()
    }

    override suspend fun authenticate(
        prompt: BiometricPrompt,
        options: BiometricOptions,
    ): BiometricResult {
        return authenticationProvider.authenticate(
            prompt = prompt,
            options = options,
        )
    }
}
