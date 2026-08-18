/*
 * ActivityProvider.android.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.utils.biometric

import androidx.fragment.app.FragmentActivity

object ActivityProvider {
    private var activity: FragmentActivity? = null

    fun set(activity: FragmentActivity) {
        this.activity = activity
    }

    fun get(): FragmentActivity {
        return activity ?: error("FragmentActivity not initialized")
    }
}
