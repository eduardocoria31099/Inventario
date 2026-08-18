/*
 * ActivityProvider.android.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.platform.biometric

import androidx.fragment.app.FragmentActivity

object ActivityProvider {
    private var activity: FragmentActivity? = null

    fun set(activity: FragmentActivity) {
        this.activity = activity
    }

    fun get(): FragmentActivity =
        activity ?: error("FragmentActivity not initialized")
}
