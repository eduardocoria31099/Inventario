/*
 * AppDelegate.kt
 * Copyright (c) 2026. All rights reserved
 */
package com.software.inventario.base

import android.app.Application
import com.software.inventario.di.initKoin
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class AppDelegate : Application() {
    override fun onCreate() {
        super.onCreate()
        // LOGS KMP
        Napier.base(DebugAntilog())
        // DI KMP
        initKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@AppDelegate)
        }
    }
}
