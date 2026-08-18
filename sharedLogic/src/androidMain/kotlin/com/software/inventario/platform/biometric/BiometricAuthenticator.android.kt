/*
 * BiometricAuthenticator.android.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.platform.biometric

actual fun getBiometricProvider(): BiometricProvider =
    AndroidBiometricAuthenticator()

internal class AndroidBiometricAuthenticator(
    private val biometricStatus: AndroidBiometricStatusProvider = AndroidBiometricStatusProvider(),
    private val authenticationProvider: AndroidBiometricAuthenticationProvider = AndroidBiometricAuthenticationProvider(),
) : BiometricProvider {

    override suspend fun status(): BiometricStatus =
        biometricStatus.status()

    override suspend fun authenticate(
        prompt: BiometricPrompt,
        options: BiometricOptions,
    ): BiometricResult = authenticationProvider.authenticate(prompt = prompt, options = options)
}
