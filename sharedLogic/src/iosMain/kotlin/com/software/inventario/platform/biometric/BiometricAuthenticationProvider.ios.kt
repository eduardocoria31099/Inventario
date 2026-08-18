/*
 * IOSBiometricAuthenticationProvider.ios.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.platform.biometric

import platform.LocalAuthentication.LAContext
import platform.LocalAuthentication.LAPolicyDeviceOwnerAuthenticationWithBiometrics
import kotlinx.coroutines.suspendCancellableCoroutine
import platform.LocalAuthentication.LAErrorBiometryLockout
import platform.LocalAuthentication.LAErrorBiometryNotEnrolled
import platform.LocalAuthentication.LAErrorSystemCancel
import platform.LocalAuthentication.LAErrorUserCancel
import platform.LocalAuthentication.LAPolicyDeviceOwnerAuthentication
import kotlin.coroutines.resume
import platform.Foundation.NSError
import platform.darwin.NSInteger

internal class IOSBiometricAuthenticationProvider {

    suspend fun authenticate(
        prompt: BiometricPrompt,
        options: BiometricOptions,
    ): BiometricResult = suspendCancellableCoroutine { continuation ->
        val context = LAContext()
        context.evaluatePolicy(
            policy = authenticationPolicy(options),
            localizedReason = prompt.title,
        ) { success, error ->
            if (success) {
                continuation.resume(BiometricResult.Success)
            } else {
                continuation.resume(
                    mapAuthenticationResult(error)
                )
            }
        }
    }

    private fun authenticationPolicy(options: BiometricOptions): NSInteger =
        if (options.allowDeviceCredential) {
            LAPolicyDeviceOwnerAuthentication
        } else {
            LAPolicyDeviceOwnerAuthenticationWithBiometrics
        }

    private fun mapAuthenticationResult(error: NSError?): BiometricResult =
        when (error?.code) {
            LAErrorUserCancel, LAErrorSystemCancel ->
                BiometricResult.Failure.Cancelled
            LAErrorBiometryLockout ->
                BiometricResult.Failure.Lockout
            LAErrorBiometryNotEnrolled ->
                BiometricResult.Failure.Error("Biometric not enrolled")
            else ->
                BiometricResult.Failure.Error(error?.localizedDescription ?: "Biometric authentication failed")
        }
}
