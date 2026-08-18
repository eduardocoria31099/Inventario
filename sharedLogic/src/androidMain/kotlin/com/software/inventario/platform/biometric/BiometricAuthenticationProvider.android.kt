/*
 * AndroidBiometricAuthenticationProvider.android.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.platform.biometric

import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt.ERROR_LOCKOUT
import androidx.biometric.BiometricPrompt.ERROR_LOCKOUT_PERMANENT
import androidx.biometric.BiometricPrompt.ERROR_USER_CANCELED
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

internal class AndroidBiometricAuthenticationProvider {

    private val activity: FragmentActivity get() = ActivityProvider.get()

    suspend fun authenticate(
        prompt: BiometricPrompt,
        options: BiometricOptions,
    ): BiometricResult = suspendCancellableCoroutine { continuation ->
        val biometricPrompt = androidx.biometric.BiometricPrompt(
            activity,
            ContextCompat.getMainExecutor(activity),
            createAuthenticationCallback(continuation),
        )
        biometricPrompt.authenticate(createPromptInfo(prompt, options))
        continuation.invokeOnCancellation {
            biometricPrompt.cancelAuthentication()
        }
    }

    private fun createPromptInfo(
        prompt: BiometricPrompt,
        options: BiometricOptions,
    ): androidx.biometric.BiometricPrompt.PromptInfo =
        androidx.biometric.BiometricPrompt.PromptInfo
            .Builder()
            .setTitle(prompt.title)
            .apply {
                prompt.description?.let(::setDescription)
            }
            .setAllowedAuthenticators(
                options.toAndroidAuthenticators()
            )
            .setConfirmationRequired(
                options.requireConfirmation
            )
            .build()

    private fun createAuthenticationCallback(continuation: CancellableContinuation<BiometricResult>) =
        object : androidx.biometric.BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(
                result: androidx.biometric.BiometricPrompt.AuthenticationResult,
            ) {
                continuation.resume(BiometricResult.Success)
            }
            override fun onAuthenticationError(
                errorCode: Int,
                errString: CharSequence,
            ) {
                continuation.resume(
                    mapAuthenticationError(
                        errorCode,
                        errString,
                    )
                )
            }
            override fun onAuthenticationFailed() {
                // User can retry authentication.
            }
        }

    private fun mapAuthenticationError(
        errorCode: Int,
        errString: CharSequence,
    ): BiometricResult =
        when (errorCode) {
            ERROR_USER_CANCELED ->
                BiometricResult.Failure.Cancelled
            ERROR_LOCKOUT, ERROR_LOCKOUT_PERMANENT ->
                BiometricResult.Failure.Lockout
            else ->
                BiometricResult.Failure.Error("Biometric error: $errString")
        }

    private fun BiometricOptions.toAndroidAuthenticators(): Int {
        var authenticators = BiometricManager.Authenticators.BIOMETRIC_STRONG
        if (allowDeviceCredential) {
            authenticators = authenticators or BiometricManager.Authenticators.DEVICE_CREDENTIAL
        }
        return authenticators
    }
}
