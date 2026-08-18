/*
 * IOSBiometricStatusProvider.ios.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.platform.biometric

import kotlinx.cinterop.BetaInteropApi
import kotlinx.cinterop.ExperimentalForeignApi
import platform.LocalAuthentication.LAContext
import platform.LocalAuthentication.LAPolicyDeviceOwnerAuthenticationWithBiometrics
import kotlinx.cinterop.ObjCObjectVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import kotlinx.cinterop.value
import platform.Foundation.NSError
import platform.LocalAuthentication.LABiometryTypeFaceID
import platform.LocalAuthentication.LABiometryTypeTouchID
import platform.LocalAuthentication.LAErrorBiometryLockout
import platform.LocalAuthentication.LAErrorBiometryNotAvailable
import platform.LocalAuthentication.LAErrorBiometryNotEnrolled
import platform.LocalAuthentication.LAPolicyDeviceOwnerAuthentication

internal class IOSBiometricStatusProvider {

    @OptIn(ExperimentalForeignApi::class, BetaInteropApi::class)
    private fun availability(context: LAContext): BiometricAvailability {
        val error = memScoped {
            alloc<ObjCObjectVar<NSError?>>()
        }
        val canEvaluate = context.canEvaluatePolicy(
            LAPolicyDeviceOwnerAuthenticationWithBiometrics,
            error.ptr,
        )
        return if (canEvaluate) {
            BiometricAvailability.Available
        } else {
            when (error.value?.code) {
                LAErrorBiometryNotAvailable ->
                    BiometricAvailability.NoHardware
                LAErrorBiometryNotEnrolled ->
                    BiometricAvailability.NotEnrolled
                LAErrorBiometryLockout ->
                    BiometricAvailability.TemporarilyUnavailable
                else ->
                    BiometricAvailability.Unknown
            }
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun type(context: LAContext): BiometricType {
        return when (context.biometryType) {
            LABiometryTypeFaceID ->
                BiometricType.FACE
            LABiometryTypeTouchID ->
                BiometricType.FINGERPRINT
            else ->
                BiometricType.NONE
        }
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun supportsDeviceCredential(context: LAContext): Boolean {
        val error = memScoped {
            alloc<ObjCObjectVar<NSError?>>()
        }
        return context.canEvaluatePolicy(
            LAPolicyDeviceOwnerAuthentication,
            error.ptr,
        )
    }

    fun status(): BiometricStatus {
        val context = LAContext()
        return BiometricStatus(
            availability = availability(context),
            type = type(context),
            supportsDeviceCredential = supportsDeviceCredential(context),
        )
    }
}
