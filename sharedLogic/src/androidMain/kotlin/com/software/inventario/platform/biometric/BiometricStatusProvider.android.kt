/*
 * AndroidBiometricStatusProvider.android.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.platform.biometric

import android.app.KeyguardManager
import android.content.Context
import android.content.pm.PackageManager
import androidx.biometric.BiometricManager
import org.koin.java.KoinJavaComponent.getKoin

internal class AndroidBiometricStatusProvider {

    private val context: Context = getKoin().get()

    private fun availability(): BiometricAvailability {
        val biometricManager = BiometricManager.from(context)

        val authenticators = BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.BIOMETRIC_WEAK

        val availability = when (biometricManager.canAuthenticate(authenticators)) {
            BiometricManager.BIOMETRIC_SUCCESS ->
                BiometricAvailability.Available
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->
                BiometricAvailability.NoHardware
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED ->
                BiometricAvailability.NotEnrolled
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE ->
                BiometricAvailability.TemporarilyUnavailable
            else ->
                BiometricAvailability.Unknown
        }

        return availability
    }

    private fun type(): BiometricType {
        val packageManager = context.packageManager

        val type = when {
            packageManager.hasSystemFeature(PackageManager.FEATURE_FACE) ->
                BiometricType.FACE
            packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT) ->
                BiometricType.FINGERPRINT
            packageManager.hasSystemFeature(PackageManager.FEATURE_IRIS) ->
                BiometricType.IRIS
            else ->
                BiometricType.NONE
        }

        return type
    }

    private fun supportsDeviceCredential(): Boolean {
        val keyguardManager = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        val supportsDeviceCredential = keyguardManager.isDeviceSecure
        return supportsDeviceCredential
    }

    fun status(): BiometricStatus =
        BiometricStatus(
            availability = availability(),
            type = type(),
            supportsDeviceCredential = supportsDeviceCredential(),
        )
}
